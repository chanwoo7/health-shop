<p align="center">
  <img src="https://github.com/chanwoo7/health-shop/blob/main/src/main/resources/static/images/logo-with-text-darkmode.png?raw=true#gh-dark-mode-only" width="350">
  <img src="https://github.com/chanwoo7/health-shop/blob/main/src/main/resources/static/images/logo-with-text-lightmode.png?raw=true#gh-light-mode-only" width="350">
</p>
<h1 align="center">HealthShop - 프리미엄 헬스용품 쇼핑몰</h1>
<img width="1481" alt="image" src="https://github.com/chanwoo7/health-shop/assets/95745646/8a8b416f-1c3d-4686-bfa0-0d7d15052ed5">

## 🔗 목차
1. [프로젝트 개요](#1-프로젝트-개요)
    - [프로젝트 계기](#-프로젝트-계기)
2. [프로젝트 구조](#2-프로젝트-구조)
    - [ERD](#erd)
3. [사용된 기술 스택](#3-사용된-기술-스택)
4. [참고 자료](#4-참고-자료)

<hr>
<br>

## 1. 프로젝트 개요
이 프로젝트는 **Spring Boot**와 **Spring Data JPA**, **Spring Security** 등을 주요 기술 스택으로 사용하여 개발된 헬스용품 쇼핑몰 웹사이트입니다.<br>
<br>
### 📍 프로젝트 계기
저는 2024년 1월 경부터 2024년 4월까지 [인프런](https://www.inflearn.com/)을 통해 김영한님의 Spring 핵심 원리 및 Spring MVC, JPA 관련 강의를 들으며 Spring 프레임워크의 동작 방식과 활용에 대하여 깊이 있게 학습했습니다.<br>

이렇게 학습한 내용을 기반으로 실질적인 웹사이트를 스스로 구축함으로써, 백엔드-프론트엔드에 걸친 웹사이트의 전반적인 동작 방식을 이해하고, 웹사이트 구축에 필요한 여러 고려사항들을 직접 습득하고 싶었습니다.<br>

이 때문에, 향후 현업 및 실무 프로젝트에서 폭넓은 분야에서 기여하는 것을 목표로 아키텍처 설계, 데이터베이스 설계, 백엔드 API 개발, 프론트엔드 개발(단, 수정 가능한 일부 [무료 템플릿](#4-참고-자료)을 참고함), 보안 설계 등의 전 과정을 스스로 담당하여 프로젝트를 진행했습니다.<br>
<br>

## 2. 프로젝트 구조
### ERD
<img width="1562" alt="image" src="https://github.com/chanwoo7/health-shop/assets/95745646/dc6b5a85-2759-4c76-8596-b30c198e951f">

## 3. 사용된 기술 스택
### Backend
<img src="https://img.shields.io/badge/spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white"><nobr>
<img src="https://img.shields.io/badge/spring_data_jpa-6DB33F?style=for-the-badge&logo=spring&logoColor=white"><nobr>
<img src="https://img.shields.io/badge/spring_security-6DB33F?style=for-the-badge&logo=spring&logoColor=white"><nobr>
<img src="https://img.shields.io/badge/spring_boot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white"><nobr>
<img src="https://img.shields.io/badge/Junit5-25A162?style=for-the-badge&logo=Junit5&logoColor=white"><nobr>

- **Spring**
    - 전체적인 애플리케이션 프레임워크로 사용되었습니다.
    - 스프링 빈을 포함한 스프링이 제공하는 여러 기능을 활용하여 애플리케이션의 구성 요소를 관리하고 의존성 주입(DI)을 처리하였습니다.

- **Spring Data JPA**
    - 데이터베이스와의 상호작용을 단순화하기 위해 사용된 ORM입니다.
    - JPA를 기반으로 복잡한 SQL 쿼리를 작성할 필요 없이 데이터베이스 작업을 처리할 수 있도록 했습니다.
  
- **Spring Security**
    - 비밀번호 암호화와 사용자 인증 및 권한 부여를 관리하고, 보안 설정을 관리하기 위해 사용되었습니다.
  
- **Spring Boot**
    - 초기 설정을 최소화하여 빠르고 간편하게 애플리케이션을 개발하기 위해 사용되었습니다.
    - 또한 내장 서버인 Tomcat을 사용하기 위해 사용되었습니다. 
  
- **JUnit5**
    - 백엔드 코드(주로 Service 계층과 Repository 계층의 코드)에 대한 단위 테스트와 통합 테스트를 위해 사용되었습니다.
<br>

### Frontend
<img src="https://img.shields.io/badge/Thymeleaf-%23005C0F?style=for-the-badge&logo=Thymeleaf&logoColor=white"><nobr>
<img src="https://img.shields.io/badge/html5-E34F26?style=for-the-badge&logo=html5&logoColor=white"><nobr>
<img src="https://img.shields.io/badge/css3-1572B6?style=for-the-badge&logo=css3&logoColor=white"><nobr>
<img src="https://img.shields.io/badge/bootstrap5-7952B3?style=for-the-badge&logo=bootstrap&logoColor=white"><nobr>
<img src="https://img.shields.io/badge/javascript-F7DF1E?style=for-the-badge&logo=javascript&logoColor=black"><nobr>

- **Thymeleaf**
    - 서버 사이드 렌더링(SSR)을 위한 템플릿 엔진으로 사용되었습니다.
    - Thymeleaf를 통해 HTML을 동적으로 생성하고, Spring MVC와 통합하여 뷰를 렌더링하는 방식으로 사용했습니다.
  
- **HTML5**
    - 웹 페이지의 구조를 정의하는 데 사용되었습니다.
 
- **CSS3**
    - 웹 페이지의 스타일링(레이아웃, 색상, 폰트)을 위해 사용되었습니다.
  
- **Bootstrap5**
    - BootStrap에서 제공하는 여러 UI 컴포넌트와 그리드 시스템이 사용되었고, 반응형 웹 디자인을 위해 사용되었습니다.
  
- **JavaScript**
    - Alert 창, 할인율에 따른 실시간 가격 변동 등 여러 동적 기능을 추가하기 위해 사용되었습니다.
    - 필요한 곳에 이벤트 리스너를 정의하여 처리함으로써 클라이언트 측 로직을 구현하였습니다.
<br>

### Database
<img src="https://img.shields.io/badge/mysql-4479A1?style=for-the-badge&logo=mysql&logoColor=white"><nobr>
<img src="https://img.shields.io/badge/h2_DB-0302EC?style=for-the-badge&logo=h2&logoColor=white"><nobr>

- **MySQL**
    - 프로덕션 환경에서의 데이터 저장소로 사용되었습니다.
  
- **H2 DB**
    - 개발 및 테스트 환경에서의 임시 데이터 저장소로 사용되었습니다.
<br>

### Tools
<img src="https://img.shields.io/badge/github-181717?style=for-the-badge&logo=github&logoColor=white"><nobr>
<img src="https://img.shields.io/badge/IntelliJ_IDEA-000000?style=for-the-badge&logo=intellij-idea&logoColor=white"><nobr>
<img src="https://img.shields.io/badge/postman-FF6C37?style=for-the-badge&logo=Postman&logoColor=white"><nobr>
<img src="https://img.shields.io/badge/mysql_workbench-4479A1?style=for-the-badge&logo=mysql&logoColor=white"><nobr>

- **GitHub**
    - 소스 코드 버전 관리를 위해 사용되었습니다.
  
- **IntelliJ IDEA**
    - 주요 개발 환경(IDE)으로 사용되었습니다.
    - 백엔드 및 프론트엔드 코드를 수정하고, 개발 과정에서 Tomcat 서버를 실행하기 위해 사용했습니다.
  
- **Postman**
    - RESTful API를 테스트하고 디버깅하고 위해 사용했습니다.
  
- **MySQL WorkBench**
    - MySQL 데이터베이스를 관리하고 데이터베이스 상태를 시각적으로 모니터링하기 위해 사용했습니다.
<br>

## 4. 참고 자료
프론트엔드 개발 시작 단계에서, 무료로 변경 가능한 아래의 템플릿을 참고하여 변경했습니다.

- https://themewagon.com/themes/furni-online-store/ (CC BY 3.0 License)
- https://startbootstrap.com/template/shop-item (MIT License)
