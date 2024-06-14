package com.healthshop.healthshop.util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class GenerateDummyData {
    public static void main(String[] args) {
        String fileName = "dummy_data.sql";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write("-- 페이지네이션 테스트용 무의미한 상품 데이터 삽입\n");

            for (int i = 1; i <= 1000; i++) {
                writer.write(String.format(
                        "INSERT INTO item (item_id, category_id, name, price, discount_rate, brand, stock_quantity, img_path, description)\n" +
                                "VALUES (%d, 3, '무의미한 상품 %d', %d, 0, '무의미한 브랜드', 100, '/images/items/dummy%d.webp', '이것은 테스트용 무의미한 상품 %d의 설명입니다.');\n",
                        1000 + i, i, 1000 + i, i, i
                ));
            }

            System.out.println(fileName + " 파일 생성 완료");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
