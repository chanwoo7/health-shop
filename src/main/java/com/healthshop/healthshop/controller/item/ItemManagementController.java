package com.healthshop.healthshop.controller.item;

import com.healthshop.healthshop.controller.form.ItemForm;
import com.healthshop.healthshop.domain.item.Category;
import com.healthshop.healthshop.domain.item.Item;
import com.healthshop.healthshop.service.CategoryService;
import com.healthshop.healthshop.service.ItemService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/shop/item/manage")
@RequiredArgsConstructor
public class ItemManagementController {

    public final ItemService itemService;
    public final CategoryService categoryService;

    @GetMapping("/{itemId}")
    public String showEditItemForm(@PathVariable Long itemId, Model model) {
        Item item = itemService.findOne(itemId);

        ItemForm itemForm = new ItemForm();
        itemForm.setItemId(itemId);  // 입력 불가
        itemForm.setName(item.getName());
        itemForm.setCategoryId(item.getCategoryId());
        itemForm.setPrice(item.getPrice());
        itemForm.setDiscountRate(item.getDiscountRate());
        itemForm.setBrand(item.getBrand());
        itemForm.setImgPath(item.getImgPath());
        itemForm.setDescription(item.getDescription());
        itemForm.setStockQuantity(item.getStockQuantity());  // 직접 입력은 불가, 수량 증가 버튼으로 늘리도록

        List<Category> categories = categoryService.findCategories();
        model.addAttribute("itemForm", itemForm);
        model.addAttribute("categories", categories);
        return "item/manage";
    }

    @PutMapping("/{itemId}")
    public String editItemForm(@ModelAttribute("itemForm") @Valid ItemForm form,
                               BindingResult bindingResult,
                               @PathVariable Long itemId,
                               @RequestParam("imgFile") MultipartFile imgFile,
                               Model model) throws IOException {
        if (bindingResult.hasErrors()) {
            List<Category> categories = categoryService.findCategories();

            Item item = itemService.findOne(itemId);
            reinitializeForm(form, item);
            model.addAttribute("itemForm", form);
            model.addAttribute("categories", categories);
            return "item/manage";
        }
        Item item = itemService.findOne(itemId);
        item.setName(form.getName());
        itemService.setItemCategoryById(itemId, form.getCategoryId());
        item.setPrice(form.getPrice());
        item.setDiscountRate(form.getDiscountRate());
        item.setBrand(form.getBrand());
        if (!imgFile.isEmpty()) {
            String imgPath = itemService.saveImage(imgFile);
            item.setImgPath(imgPath);
        }
        item.setDescription(form.getDescription());
        item.setStockQuantity(item.getStockQuantity());
        itemService.saveItem(item);

        return "redirect:/shop/item/{itemId}";
    }

    @DeleteMapping("/delete/{itemId}")
    public String deleteItem(@PathVariable Long itemId) {
        itemService.deleteItem(itemId);
        return "redirect:/shop";
    }

    // 상품 정보 잘못 입력 시, 폼 제출에 포함되지 않는 요소들 재초기화
    private void reinitializeForm(ItemForm form, Item item) {
        form.setName(item.getName());
        form.setStockQuantity(item.getStockQuantity());
    }

}
