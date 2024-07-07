package com.healthshop.healthshop.service;

import com.healthshop.healthshop.domain.item.Category;
import com.healthshop.healthshop.domain.item.Item;
import com.healthshop.healthshop.repository.CategoryRepository;
import com.healthshop.healthshop.repository.ItemRepository;
import com.healthshop.healthshop.repository.ItemSpecifications;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;
    private final CategoryRepository categoryRepository;

    @Value("${image.upload.dir}")
    private String uploadDir;

    private static final String RELATIVE_PATH_PREFIX = "/images/items/";

    @Transactional
    public void saveItem(Item item) {
        itemRepository.save(item);
    }

    @Transactional
    public void deleteItem(Long itemId) {
        itemRepository.deleteById(itemId);
    }

    public List<Item> findItems() {
        return itemRepository.findAll();
    }

    public Item findOne(Long id) {
        return itemRepository.findById(id).orElse(null);
    }

    public Page<Item> findItems(String keyword, String sort, PageRequest pageRequest) {
        // 주어진 키워드로 Item의 name 필드 검색하는 조건 생성
        Specification<Item> spec = Specification.where(ItemSpecifications.hasKeyword(keyword));

        spec = switch (sort) {
            case "priceDesc" -> spec.and(ItemSpecifications.sortByPriceDesc());
            case "priceAsc" -> spec.and(ItemSpecifications.sortByPriceAsc());
            case "discountRateDesc" -> spec.and(ItemSpecifications.sortByDiscountRateDesc());
            case "idDesc" -> spec.and(ItemSpecifications.sortByIdDesc());
            default -> spec;
        };

        return itemRepository.findAll(spec, pageRequest);
    }

    @Transactional
    public String saveImage(MultipartFile file) throws IOException {
        // 경로 존재하지 않으면 디렉토리 생성
        if (!Files.exists(Paths.get(uploadDir))) {
            Files.createDirectories(Paths.get(uploadDir));
        }

        // 중복 방지를 위해 파일명에 밀리초를 붙여서 저장
        String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
        Path filePath = Paths.get(uploadDir, fileName);

        // 저장
        Files.write(filePath, file.getBytes());

        return RELATIVE_PATH_PREFIX + fileName;
    }

    @Transactional
    public void setItemCategoryById(Long itemId, Long categoryId) {
        Item item = itemRepository.findById(itemId).orElseThrow(() ->
                new IllegalArgumentException("Invalid item Id: " + itemId));
        Category category = categoryRepository.findById(categoryId).orElseThrow(() ->
                new IllegalArgumentException("Invalid category Id: " + categoryId));
        item.setCategory(category);
        itemRepository.save(item);
    }
}
