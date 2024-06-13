package com.healthshop.healthshop.controller;

import com.healthshop.healthshop.controller.dto.ItemDto;
import com.healthshop.healthshop.domain.item.Item;
import com.healthshop.healthshop.service.ItemService;
import com.healthshop.healthshop.util.ItemConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @GetMapping("/shop")
    public String shop(Model model) {
        List<Item> items = itemService.findItems();
        List<ItemDto> itemDtos = items.stream()
                .map(ItemConverter::toDto)
                .toList();
        model.addAttribute("items", itemDtos);
        return "shop";
    }

}
