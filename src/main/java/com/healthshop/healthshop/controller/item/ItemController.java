package com.healthshop.healthshop.controller.item;

import com.healthshop.healthshop.controller.dto.ItemDto;
import com.healthshop.healthshop.domain.item.Item;
import com.healthshop.healthshop.service.ItemService;
import com.healthshop.healthshop.util.ItemConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/shop")
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @GetMapping
    public String shop(@RequestParam(defaultValue = "0") int page,
                       @RequestParam(defaultValue = "") String keyword,
                       @RequestParam(defaultValue = "idDesc") String sort,
                       Model model) {
        PageRequest pageRequest = PageRequest.of(page, 12);
        Page<Item> itemsPage = itemService.findItems(keyword, sort, pageRequest);
        List<ItemDto> itemDtos = itemsPage.getContent().stream()
                .map(ItemConverter::toDto)
                .toList();

        model.addAttribute("items", itemDtos);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", itemsPage.getTotalPages());
        model.addAttribute("keyword", keyword);
        model.addAttribute("sort", sort);
        return "shop";
    }

    @GetMapping("/item/{itemId}")
    public String getItem(@PathVariable Long itemId, Model model) {
        Item item = itemService.findOne(itemId);
        ItemDto itemDto = ItemConverter.toDto(item);

        model.addAttribute("item", itemDto);
        return "item/item";
    }

}
