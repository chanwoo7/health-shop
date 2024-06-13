package com.healthshop.healthshop.controller;

import com.healthshop.healthshop.domain.item.Item;
import com.healthshop.healthshop.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    // TODO: ItemDto 리스트로 반환하는 것 고려할 것
    @GetMapping("/shop")
    public String shop(Model model) {
        List<Item> items = itemService.findItems();
        model.addAttribute("items", items);
        return "shop";
    }

}
