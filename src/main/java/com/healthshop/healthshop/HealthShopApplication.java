package com.healthshop.healthshop;

import com.healthshop.healthshop.util.ExecuteSQLFile;
import com.healthshop.healthshop.util.GenerateDummyData;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HealthShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(HealthShopApplication.class, args);

		// 페이지네이션 테스트용 더미 데이터 생성
		GenerateDummyData.main(null);

		// 더미 데이터 DB에 적용
		ExecuteSQLFile.main(null);
	}

}
