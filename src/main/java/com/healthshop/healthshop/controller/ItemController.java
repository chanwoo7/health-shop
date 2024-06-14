package com.healthshop.healthshop.controller;

import com.healthshop.healthshop.controller.dto.ItemDto;
import com.healthshop.healthshop.domain.item.Item;
import com.healthshop.healthshop.service.ItemService;
import com.healthshop.healthshop.util.ItemConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

//    @GetMapping("/shop")
//    public String shop(Model model) {
//        List<Item> items = itemService.findItems();
//        List<ItemDto> itemDtos = items.stream()
//                .map(ItemConverter::toDto)
//                .toList();
//        model.addAttribute("items", itemDtos);
//        return "shop";
//    }

    @GetMapping("/shop")
    public String shop(@RequestParam(defaultValue = "0") int page, Model model) {
        PageRequest pageRequest = PageRequest.of(page, 12);
        Page<Item> itemsPage = itemService.findItems(pageRequest);
        List<ItemDto> itemDtos = itemsPage.getContent().stream()
                .map(ItemConverter::toDto)
                .toList();

        model.addAttribute("items", itemDtos);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", itemsPage.getTotalPages());
        return "shop";
    }

}
