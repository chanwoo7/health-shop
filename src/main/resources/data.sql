-- 관리자 계정 (아이디: admin, 비밀번호: admin)
INSERT INTO member (is_active, member_id, reg_date, login_id, name, password)
VALUES (TRUE, 1, '2024-01-01 00:00:00.000000', 'admin', '관리자', '$2a$10$2HytlCWentHkzOtTeb2z5.GUbAsmuBdhlJ/aPOQNtYhfCOOGDzR7O');

-- 상품 카테고리
INSERT INTO category (category_id, name)
VALUES (1, '무산소');
INSERT INTO category (category_id, name)
VALUES (2, '유산소');
INSERT INTO category (category_id, name)
VALUES (3, '보조용품');
INSERT INTO category (category_id, name)
VALUES (4, '의류');
INSERT INTO category (category_id, name)
VALUES (5, '기타');

-- 초기 상품
INSERT INTO item (item_id, category_id, name, price, discount_rate, brand, stock_quantity, img_path, description)
VALUES (1, 1, 'AB 롤아웃 휠', 15000, 10, '찬우짐', 100,
        '/images/items/ab-roller-wheel.webp',
        CONCAT('AB 롤아웃 휠은 핵심 근육과 상체를 강화하는 데 최적화된 피트니스 도구입니다.\n',
            '이 휠은 사용자의 체력을 향상시키고, 균형감과 안정성을 높이는 데 도움을 줍니다.\n',
            '간단하지만 효과적인 운동을 통해 빠르게 원하는 몸매를 만들 수 있습니다.'));
INSERT INTO item (item_id, category_id, name, price, discount_rate, brand, stock_quantity, img_path, description)
VALUES (2, 1, '1kg 덤벨, 2개', 9000, 7, '찬우짐', 100,
        '/images/items/dumbbell-1kg.webp',
        CONCAT('초보자 및 재활 운동에 최적화된 1kg 덤벨입니다.\n',
            '덤벨은 다양한 운동 루틴에 활용할 수 있는 다목적 헬스용품입니다.\n',
            '편안한 그립감으로 운동 시 안정적으로 사용할 수 있으며, 근력 강화와 체력 증진에 효과적입니다.\n',
            '덤벨을 통해 집에서도 간편하게 전신 운동을 할 수 있습니다.'));
INSERT INTO item (item_id, category_id, name, price, discount_rate, brand, stock_quantity, img_path, description)
VALUES (3, 1, '3kg 덤벨, 2개', 15000, 3, '찬우짐', 100,
        '/images/items/dumbbell-3kg.webp',
        CONCAT('일상적인 피트니스 루틴에 적합한 중량으로, 근력 향상에 효과적인 3kg 덤벨입니다.\n',
            '덤벨은 다양한 운동 루틴에 활용할 수 있는 다목적 헬스용품입니다.\n',
            '편안한 그립감으로 운동 시 안정적으로 사용할 수 있으며, 근력 강화와 체력 증진에 효과적입니다.\n',
            '덤벨을 통해 집에서도 간편하게 전신 운동을 할 수 있습니다.'));
INSERT INTO item (item_id, category_id, name, price, discount_rate, brand, stock_quantity, img_path, description)
VALUES (4, 1, '5kg 덤벨, 2개', 18000, 3, '찬우짐', 100,
        '/images/items/dumbbell-5kg.webp',
        CONCAT('전신 근력 운동을 위한 표준 중량 덤벨로, 균형 잡힌 근육 발달을 도와주는 5kg 덤벨입니다.\n',
            '덤벨은 다양한 운동 루틴에 활용할 수 있는 다목적 헬스용품입니다.\n',
            '편안한 그립감으로 운동 시 안정적으로 사용할 수 있으며, 근력 강화와 체력 증진에 효과적입니다.\n',
            '덤벨을 통해 집에서도 간편하게 전신 운동을 할 수 있습니다.'));
INSERT INTO item (item_id, category_id, name, price, discount_rate, brand, stock_quantity, img_path, description)
VALUES (5, 1, '7kg 덤벨, 2개', 21000, 5, '찬우짐', 100,
        '/images/items/dumbbell-7kg.webp',
        CONCAT('중급자용 덤벨로 근력 강화와 체력 증진에 탁월한 7kg 덤벨입니다.\n',
            '덤벨은 다양한 운동 루틴에 활용할 수 있는 다목적 헬스용품입니다.\n',
            '편안한 그립감으로 운동 시 안정적으로 사용할 수 있으며, 근력 강화와 체력 증진에 효과적입니다.\n',
            '덤벨을 통해 집에서도 간편하게 전신 운동을 할 수 있습니다.'));
INSERT INTO item (item_id, category_id, name, price, discount_rate, brand, stock_quantity, img_path, description)
VALUES (6, 1, '10kg 덤벨, 2개', 24000, 5, '찬우짐', 100,
        '/images/items/dumbbell-10kg.webp',
        CONCAT('고강도 운동을 위한 무거운 덤벨로 근육 성장과 힘을 극대화하는 10kg 덤벨입니다.\n',
            '덤벨은 다양한 운동 루틴에 활용할 수 있는 다목적 헬스용품입니다.\n',
            '편안한 그립감으로 운동 시 안정적으로 사용할 수 있으며, 근력 강화와 체력 증진에 효과적입니다.\n',
            '덤벨을 통해 집에서도 간편하게 전신 운동을 할 수 있습니다.'));
INSERT INTO item (item_id, category_id, name, price, discount_rate, brand, stock_quantity, img_path, description)
VALUES (7, 3, '폼 롤러', 9000, 8, '찬우짐', 100,
        '/images/items/foam-roller.webp',
        CONCAT('폼 롤러는 근육의 긴장을 풀고 회복을 돕는 필수적인 피트니스 도구입니다.\n',
            '셀프 마사지와 근막 이완에 탁월하며, 운동 전후의 스트레칭과 유연성 향상에 큰 도움을 줍니다.\n',
            '초보자부터 전문가까지 모두 사용할 수 있습니다.'));
INSERT INTO item (item_id, category_id, name, price, discount_rate, brand, stock_quantity, img_path, description)
VALUES (8, 3, '헬스 장갑', 13000, 12, '찬우짐', 100,
        '/images/items/gloves.webp',
        CONCAT('헬스 장갑은 운동 중 손을 보호하고 그립감을 향상시키기 위한 필수 액세서리입니다.\n',
            '다양한 운동 기구를 사용할 때 손의 피로와 부상을 줄여주며, 땀을 흡수하여 미끄러짐을 방지합니다.\n',
            '내구성이 뛰어나고 편안한 착용감을 제공하는 헬스 장갑은 운동 효율을 극대화해줍니다.'));
INSERT INTO item (item_id, category_id, name, price, discount_rate, brand, stock_quantity, img_path, description)
VALUES (9, 1, '악력기', 9000, 6, '찬우짐', 100,
        '/images/items/gripper.webp',
        CONCAT('악력기는 손의 근력과 지구력을 강화하는 데 도움을 주는 작은 피트니스 도구입니다.\n',
            '손과 손목, 전완근을 효과적으로 단련할 수 있으며, 일상생활에서의 그립력을 향상시키고, 다양한 스포츠 및 운동 수행 능력을 높이는 데 유용합니다.'));
INSERT INTO item (item_id, category_id, name, price, discount_rate, brand, stock_quantity, img_path, description)
VALUES (10, 2, '실내 사이클 머신', 170000, 15, '찬우짐', 100,
        '/images/items/indoor-cycling-device.webp',
        CONCAT('실내 사이클 머신은 집에서 편리하게 유산소 운동을 할 수 있는 최적의 기구입니다.\n',
            '정교한 설계와 다양한 기능으로 사용자의 피트니스 목표를 달성할 수 있도록 돕습니다.\n',
            '강도 조절이 가능하여 초보자부터 고급 사용자까지 모두 사용할 수 있으며, 심혈관 건강 증진과 체중 감량에 효과적입니다.'));
INSERT INTO item (item_id, category_id, name, price, discount_rate, brand, stock_quantity, img_path, description)
VALUES (11, 3, '무릎 보호대, 2개', 18000, 7, '찬우짐', 100,
        '/images/items/knee-guards.webp',
        CONCAT('무릎 보호대는 무릎 관절을 안정화하고 부상을 예방하는 데 도움을 주는 필수적인 피트니스 도구입니다.\n',
            '운동 중 또는 일상생활에서 무릎의 부담을 줄이고, 통증을 완화하여 안전하고 효과적인 활동을 지원합니다.\n',
            '인체공학적 디자인과 고품질 소재로 제작된 무릎 보호대는 편안한 착용감을 제공합니다.'));
INSERT INTO item (item_id, category_id, name, price, discount_rate, brand, stock_quantity, img_path, description)
VALUES (12, 3, '리프팅 벨트', 32000, 2, '찬우짐', 100,
        '/images/items/lifting-belt.webp',
        CONCAT('리프팅 벨트는 중량 운동 시 허리와 복부를 안정화하여 부상을 예방하고, 리프팅 능력을 향상시키는 피트니스 도구입니다.\n',
            '강력한 지지력과 편안한 착용감으로 데드리프트, 스쿼트 등 고강도 운동을 보다 안전하게 수행할 수 있습니다.\n',
            '내구성이 뛰어나며, 조절 가능한 디자인으로 다양한 체형에 맞춰 사용할 수 있습니다.'));
INSERT INTO item (item_id, category_id, name, price, discount_rate, brand, stock_quantity, img_path, description)
VALUES (13, 3, '헬스 매트', 11000, 10, '찬우짐', 100,
        '/images/items/mat.webp',
        CONCAT('헬스 매트는 다양한 운동을 안전하고 편안하게 수행할 수 있도록 도와주는 필수적인 피트니스 도구입니다.\n',
            '고품질의 소재로 제작되어 내구성이 뛰어나며, 쿠션감이 좋아 관절을 보호하고 운동 시 충격을 흡수해줍니다.\n',
            '요가, 필라테스, 스트레칭, 근력 운동 등 여러 종류의 운동에 적합합니다.'));
INSERT INTO item (item_id, category_id, name, price, discount_rate, brand, stock_quantity, img_path, description)
VALUES (14, 3, '32mm 풀업 밴드', 15000, 5, '찬우짐', 100,
        '/images/items/pull-up-band-thick.webp',
        CONCAT('32mm의 두께로 높은 장력을 가지고 있어, 저강도 풀업 운동에 활용할 수 있는 풀업 밴드입니다.\n',
            '풀업 밴드는 다양한 운동 루틴에 활용할 수 있는 다목적 피트니스 도구로, 특히 풀업과 같은 상체 운동을 보조하는 데 유용합니다.\n',
            '고무 소재로 제작된 이 밴드는 저항력을 제공하여 근력을 강화하고, 운동의 난이도를 조절할 수 있게 해줍니다.'));
INSERT INTO item (item_id, category_id, name, price, discount_rate, brand, stock_quantity, img_path, description)
VALUES (15, 3, '16mm 풀업 밴드', 8000, 5, '찬우짐', 100,
        '/images/items/pull-up-band-thin.webp',
        CONCAT('16mm의 두께로 낮은 장력을 가지고 있어, 고강도 풀업 운동에 활용할 수 있는 풀업 밴드입니다.\n',
            '풀업 밴드는 다양한 운동 루틴에 활용할 수 있는 다목적 피트니스 도구로, 특히 풀업과 같은 상체 운동을 보조하는 데 유용합니다.\n',
            '고무 소재로 제작된 이 밴드는 저항력을 제공하여 근력을 강화하고, 운동의 난이도를 조절할 수 있게 해줍니다.'));
INSERT INTO item (item_id, category_id, name, price, discount_rate, brand, stock_quantity, img_path, description)
VALUES (16, 1, '스탠드형 풀업 바', 86000, 13, '찬우짐', 100,
        '/images/items/pull-up-bar-stand.webp',
        CONCAT('스탠드형 풀업 바는 집에서 편리하게 상체 운동을 할 수 있도록 설계된 다목적 피트니스 도구입니다.\n',
            '강력한 스틸 프레임과 안정적인 베이스로 안전하고 효과적인 운동 환경을 제공하며, 다양한 그립 포지션을 통해 여러 부위의 근육을 고루 단련할 수 있습니다.\n',
            '스탠드형 디자인으로 별도의 벽 고정이 필요 없어 설치와 이동이 간편합니다.'));
INSERT INTO item (item_id, category_id, name, price, discount_rate, brand, stock_quantity, img_path, description)
VALUES (17, 1, '벽걸이형 풀업 바', 34000, 15, '찬우짐', 100,
        '/images/items/pull-up-bar-wall-mounted.webp',
        CONCAT('벽걸이형 풀업 바는 공간을 효율적으로 활용하면서 상체 운동을 효과적으로 할 수 있도록 설계된 피트니스 도구입니다.\n',
            '튼튼한 벽 고정 방식과 다양한 그립 옵션을 제공하여 여러 부위의 근육을 강화할 수 있으며, 실내에서 편리하게 운동할 수 있습니다.\n',
            '고강도 스틸 소재와 견고한 구조로 안전하고 안정적인 운동 환경을 제공합니다.'));
INSERT INTO item (item_id, category_id, name, price, discount_rate, brand, stock_quantity, img_path, description)
VALUES (18, 1, '푸시업 바, 2개', 16000, 10, '찬우짐', 100,
        '/images/items/push-up-bars.webp',
        CONCAT('푸시업 바는 푸시업(팔굽혀펴기) 운동을 보다 효과적이고 편안하게 할 수 있도록 도와주는 피트니스 도구입니다.\n',
            '손목에 가해지는 부담을 줄이고, 다양한 각도로 푸시업을 수행할 수 있어 상체 근육을 고루 발달시킬 수 있습니다.\n',
            '가볍고 휴대하기 쉬운 디자인으로 어디서나 간편하게 운동할 수 있습니다.'));
INSERT INTO item (item_id, category_id, name, price, discount_rate, brand, stock_quantity, img_path, description)
VALUES (19, 3, '쉐이커, 700mL', 5000, 3, '찬우짐', 100,
        '/images/items/shaker.webp',
        CONCAT('쉐이커는 프로틴 쉐이크, 스무디, 그리고 기타 보충제 음료를 간편하게 만들고 섭취할 수 있도록 설계된 피트니스 도구입니다.\n',
            '견고한 재질과 실용적인 디자인으로 운동 전후에 필요한 영양을 빠르고 효율적으로 공급할 수 있습니다.\n',
            '700mL의 넉넉한 용량으로 제공되어 충분한 영양 보충이 가능합니다.'));
INSERT INTO item (item_id, category_id, name, price, discount_rate, brand, stock_quantity, img_path, description)
VALUES (20, 4, '트레이닝 티셔츠', 15000, 20, '찬우짐', 100,
        '/images/items/t-shirt.webp',
        CONCAT('트레이닝 티셔츠는 운동 중 편안함과 성능을 극대화하기 위해 설계된 고품질 의류입니다.\n',
            '통기성이 뛰어나고 땀을 빠르게 흡수하여 운동 중 쾌적함을 유지하며, 다양한 운동 환경에서 최상의 퍼포먼스를 발휘할 수 있도록 도와줍니다.\n',
            '가벼운 소재와 인체공학적 디자인으로 모든 운동 애호가에게 적합한 필수 아이템입니다.'));
INSERT INTO item (item_id, category_id, name, price, discount_rate, brand, stock_quantity, img_path, description)
VALUES (21, 3, '손목 보호대', 13000, 6, '찬우짐', 100,
        '/images/items/wrist-guards.webp',
        CONCAT('손목 보호대는 다양한 운동 및 일상 활동 중 손목을 보호하고 안정감을 제공하는 필수 피트니스 도구입니다.\n',
            '손목 부상의 예방과 회복을 돕기 위해 설계되었으며, 인체공학적 디자인과 고품질 소재로 제작되어 편안한 착용감을 제공합니다.\n',
            '손목 보호대는 무게 운동, 크로스핏, 테니스, 골프 등 다양한 스포츠와 활동에 적합합니다.'));
INSERT INTO item (item_id, category_id, name, price, discount_rate, brand, stock_quantity, img_path, description)
VALUES (22, 3, '리프팅 스트랩', 15000, 11, '찬우짐', 100,
        '/images/items/wrist-straps.webp',
        CONCAT('리프팅 스트랩은 중량 운동 시 손목과 손의 부담을 줄여 주고, 그립력을 향상시켜 더 안전하고 효과적으로 운동할 수 있도록 도와주는 피트니스 도구입니다.\n',
            '특히 데드리프트, 로우, 풀업 등 무거운 중량을 다루는 운동에 최적화되어 있으며, 높은 내구성과 편안한 착용감을 제공합니다.'));
INSERT INTO item (item_id, category_id, name, price, discount_rate, brand, stock_quantity, img_path, description)
VALUES (23, 1, '플랫 벤치', 75000, 19, '찬우짐', 100,
        '/images/items/flat-bench.webp',
        CONCAT('플랫 벤치는 다양한 근력 운동을 효과적으로 수행할 수 있는 기본적인 피트니스 도구입니다.\n',
            '주로 벤치 프레스, 덤벨 운동, 코어 운동 등에 사용되며, 안정적이고 견고한 디자인으로 안전한 운동 환경을 제공합니다.\n',
            '초보자부터 전문가까지 모두 사용할 수 있으며, 홈짐이나 체육관에 필수적인 장비입니다.'));
INSERT INTO item (item_id, category_id, name, price, discount_rate, brand, stock_quantity, img_path, description)
VALUES (24, 3, '짐볼', 13000, 18, '찬우짐', 100,
        '/images/items/gym-ball.webp',
        CONCAT('짐볼은 코어 근육 강화, 균형 감각 향상, 유연성 증진을 위한 다목적 피트니스 도구입니다.\n',
            '다양한 운동 동작을 통해 전신을 효과적으로 단련할 수 있으며, 재활 운동과 스트레칭에도 유용합니다.\n',
            '초보자부터 전문가까지 모두 사용할 수 있으며, 집이나 체육관에서 간편하게 사용할 수 있습니다.'));
INSERT INTO item (item_id, category_id, name, price, discount_rate, brand, stock_quantity, img_path, description)
VALUES (25, 1, '인클라인 벤치', 84000, 21, '찬우짐', 100,
        '/images/items/incline-bench.webp',
        CONCAT('인클라인 벤치는 다양한 각도로 조절 가능한 디자인으로, 상체 근력 운동에 효과적인 피트니스 도구입니다.\n',
            '벤치 프레스, 덤벨 운동, 코어 운동 등 다양한 운동을 수행할 수 있으며, 각도 조절 기능을 통해 운동 강도를 조절하고, 다양한 근육 부위를 타겟팅할 수 있습니다.\n',
            '홈짐이나 체육관에서 필수적인 장비로, 초보자부터 전문가까지 모두 사용할 수 있습니다.'));
INSERT INTO item (item_id, category_id, name, price, discount_rate, brand, stock_quantity, img_path, description)
VALUES (26, 2, '훌라후프', 18000, 9, '찬우짐', 100,
        '/images/items/hula-hoop.webp',
        CONCAT('훌라후프는 재미있고 효과적인 전신 유산소 운동 도구로, 특히 허리와 복부 근육을 강화하는 데 탁월합니다.\n',
            '운동 중 신체의 균형을 유지하고, 심혈관 건강을 증진시키며, 체중 감량에 도움을 줍니다.\n',
            '다양한 크기와 무게로 제공되어 초보자부터 전문가까지 모두 사용할 수 있습니다.'));
INSERT INTO item (item_id, category_id, name, price, discount_rate, brand, stock_quantity, img_path, description)
VALUES (27, 2, '5kg 케틀벨', 12000, 7, '찬우짐', 100,
        '/images/items/kettlebell-5kg.webp',
        CONCAT('일반적인 유산소 운동에 적합한 5kg 무게의 케틀벨입니다.\n',
            '케틀벨은 전신 근력 강화와 유산소 운동을 동시에 할 수 있는 다목적 피트니스 도구입니다.\n',
            '손잡이가 달린 구형의 무게로 다양한 운동 동작을 통해 근력, 지구력, 유연성을 향상시키는 데 효과적이며, 집이나 체육관에서 간편하게 운동할 수 있습니다.'));
INSERT INTO item (item_id, category_id, name, price, discount_rate, brand, stock_quantity, img_path, description)
VALUES (28, 2, '10kg 케틀벨', 19000, 7, '찬우짐', 100,
        '/images/items/kettlebell-10kg.webp',
        CONCAT('고강도의 유산소 운동에 적합한 10kg 무게의 케틀벨입니다.\n',
            '케틀벨은 전신 근력 강화와 유산소 운동을 동시에 할 수 있는 다목적 피트니스 도구입니다.\n',
            '손잡이가 달린 구형의 무게로 다양한 운동 동작을 통해 근력, 지구력, 유연성을 향상시키는 데 효과적이며, 집이나 체육관에서 간편하게 운동할 수 있습니다.'));
INSERT INTO item (item_id, category_id, name, price, discount_rate, brand, stock_quantity, img_path, description)
VALUES (29, 4, '트레이닝 반바지', 14000, 18, '찬우짐', 100,
        '/images/items/training-shorts.webp',
        CONCAT('트레이닝 반바지는 다양한 운동과 활동에 적합한 기능성 의류로, 편안함과 자유로운 움직임을 제공합니다.\n',
            '가벼운 소재와 통기성 좋은 디자인으로 땀을 빠르게 흡수하고 건조시켜 운동 중 쾌적함을 유지합니다.\n',
            '깔끔한 디자인과 기능성을 겸비한 트레이닝 반바지는 운동 애호가들에게 필수적인 아이템입니다.'));
INSERT INTO item (item_id, category_id, name, price, discount_rate, brand, stock_quantity, img_path, description)
VALUES (30, 2, '트레드밀', 360000, 27, '찬우짐', 100,
        '/images/items/treadmill.webp',
        CONCAT('트레드밀은 실내에서 걷기, 달리기 등의 유산소 운동을 할 수 있도록 도와주는 피트니스 기구입니다.\n',
            '다양한 속도와 경사 조절 기능을 통해 사용자 맞춤형 운동을 제공하며, 심혈관 건강 증진, 체중 감량, 체력 향상에 효과적입니다.\n',
            '고품질의 내구성 있는 디자인과 편리한 기능들로 구성되어 누구나 손쉽게 사용할 수 있습니다.'));