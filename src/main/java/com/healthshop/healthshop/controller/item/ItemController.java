package com.healthshop.healthshop.controller.item;

import com.healthshop.healthshop.controller.dto.ItemDto;
import com.healthshop.healthshop.domain.item.Category;
import com.healthshop.healthshop.domain.item.Item;
import com.healthshop.healthshop.service.CategoryService;
import com.healthshop.healthshop.service.ItemService;
import com.healthshop.healthshop.util.ItemConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/shop")
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;
    private final CategoryService categoryService;

    @GetMapping
    public String shop(@RequestParam(defaultValue = "0") int page,
                       @RequestParam(defaultValue = "") String category,
                       @RequestParam(defaultValue = "") String keyword,
                       @RequestParam(defaultValue = "idDesc") String sort,
                       Model model) {
        PageRequest pageRequest = PageRequest.of(page, 12);
        Page<Item> itemsPage = itemService.findItems(category, keyword, sort, pageRequest);
        List<ItemDto> itemDtos = itemsPage.getContent().stream()
                .map(ItemConverter::toDto)
                .toList();
        List<Category> categories = categoryService.findCategories();

        model.addAttribute("items", itemDtos);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", itemsPage.getTotalPages());

        model.addAttribute("categories", categories);
        model.addAttribute("category", category);
        model.addAttribute("keyword", keyword);
        model.addAttribute("sort", sort);

        return "shop";
    }

    @GetMapping("/item/{itemId}")
    public String getItem(@PathVariable Long itemId, Model model) {
        Item item = itemService.findOne(itemId);
        ItemDto itemDto = ItemConverter.toDto(item);

        // 연관 상품: 동일 카테고리 내에서 할인율이 가장 높은 상품 4개
        // TODO: 추후 동일 카테고리 내에서 인기도(like)가 가장 높은 상품 4개로 변경 고려할 것
        List<ItemDto> relatedItems = itemService.findTopDiscountedItemsByCategory(item.getCategory().getName(), 4).stream()
                        .map(ItemConverter::toDto)
                        .toList();

        model.addAttribute("item", itemDto);
        model.addAttribute("relatedItems", relatedItems);

        return "item/item";
    }

}
