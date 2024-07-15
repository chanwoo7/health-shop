<p align="center">
  <img src="https://github.com/chanwoo7/health-shop/blob/main/src/main/resources/static/images/logo-with-text-darkmode.png?raw=true#gh-dark-mode-only" width="350">
  <img src="https://github.com/chanwoo7/health-shop/blob/main/src/main/resources/static/images/logo-with-text-lightmode.png?raw=true#gh-light-mode-only" width="350">
</p>
<h1 align="center">HealthShop - 프리미엄 헬스용품 쇼핑몰</h1>
<img width="1481" alt="image" src="https://github.com/chanwoo7/health-shop/assets/95745646/8a8b416f-1c3d-4686-bfa0-0d7d15052ed5">

<hr>

### 🔗 목차
1. [프로젝트 개요](#1-프로젝트-개요)
    - [프로젝트 목적](#-프로젝트-목적)
2. [개발 과정](#2-개발-과정)
    - [개발 기간](#-개발-기간)
    - [커밋 컨벤션](#-커밋-컨벤션)
3. [프로젝트 구조](#3-프로젝트-구조)
    - [아키텍처 구성](#-아키텍처-구성)
    - [ERD](#-erd)
4. [사용된 기술 스택](#4-사용된-기술-스택)
5. [참고 자료](#5-참고-자료)

<hr>
<br>

## 1. 프로젝트 개요
이 프로젝트는 **Spring Boot**와 **Spring Data JPA**, **Spring Security** 등을 주요 기술 스택으로 사용하여 개발된 헬스용품 쇼핑몰 웹사이트입니다.<br>
<br>
### 📍 프로젝트 목적
저는 2024년 1월 경부터 2024년 4월까지 [인프런](https://www.inflearn.com/)을 통해 김영한님의 Spring 핵심 원리 및 Spring MVC, JPA 관련 강의를 들으며 Spring 프레임워크의 동작 방식과 활용에 대하여 깊이 있게 학습했습니다.<br>

이렇게 학습한 내용을 기반으로 실전적인 웹사이트를 스스로 구축함으로써, 아래와 같은 목표를 성취하고자 했습니다.

- 이론과 강의로만 배워두었던 Spring 프레임워크와 관련된 지식을 적용함으로써 더욱 빠르게 습득하는 것
- 유저 관리 및 보안 등 웹 사이트 구축에 필요한 여러 고려사항들을 생각해보면서, 어떻게 해결해야 할지 스스로 부딪히고 해결하는 능력을 기르는 것
- 백엔드-프론트엔드에 걸친 전반적인 웹 사이트의 동작 방식을 이해하는 것
- MVC 패턴과 레이어드 아키텍처 패턴을 적용하고 각 계층을 철저히 분리함으로써 코드의 단일 책임 원칙(SRP)을 지키는 것

이 때문에, 아키텍처 설계, 데이터베이스 설계, 백엔드 API 개발, 프론트엔드 개발(단, 수정 가능한 일부 [무료 템플릿](#5-참고-자료)을 참고함), 보안 설계 등의 전 과정을 스스로 담당하여 프로젝트를 진행했습니다.
<br>
<br>

## 2. 개발 과정
### 📍 개발 기간
- 2024년 5월 3일 ~ 진행 중

### 📍 커밋 컨벤션
코드 변경 이력을 원활히 추적하기 위해, **커밋 메시지의 맨 앞**에 아래와 같은 종류의 태그를 붙여 관리했습니다.

- **[feat]**: 새로운 기능 추가
- **[refactor]**: 코드 리팩토링
- **[fix]**: 버그 수정
- **[style]**: 스타일 변경
- **[chore]**: 자잘한 작업, 또는 빌드나 설정 관련 작업
- **[docs]**: README.md 문서 수정
<br>

## 3. 프로젝트 구조
### 📍 아키텍처 구성
'**MVC 패턴**'과 '**레이어드 아키텍처 패턴**'을 통합하여 본 프로젝트에 적용했습니다.
<br>

#### ⭐️ MVC 패턴 (Model - View - Controller Pattern)
- **Model**
  - 순수 비즈니스 로직과 데이터 처리를 담당합니다.
  - `domain` 패키지에 위치하며, MySQL 데이터베이스 테이블에 매핑되는 엔티티 클래스들을 포함합니다.
- **View**
  - 사용자 인터페이스를 담당합니다.
  - `resources/templates` 디렉토리에 위치하며, Thymeleaf 템플릿 파일들을 포함합니다.
- **Controller**
  - 사용자 요청을 처리하고 적절한 뷰를 반환합니다.
  - `controller` 패키지에 위치하며, RESTful API 엔드포인트가 정의되어 있어 RESTful API 요청을 처리할 수 있는 컨트롤러 클래스들을 포함합니다.
<br>

#### ⭐️ 레이어드 아키텍처 패턴 (Layered Architecture Pattern)
애플리케이션을 `domain`, `repository`, `service`, `controller`로 계층화하여, 각 계층이 명확한 역할을 가질 수 있도록 함으로써 유지보수와 확장에 용이하도록 구성했습니다.
<br>

- **도메인 계층 (Domain Layer)**
  - 순수 비즈니스 로직 및 엔티티 클래스를 포함합니다.
  - MVC 패턴의 'Model'에 해당합니다.
  - `domain` 패키지에 위치해 있습니다.
- **리포지토리 계층 (Repository Layer)**
  - 데이터 접근(조회 및 저장 등) 로직을 담당합니다.
  - 전반적으로 `JpaRepository`를 상속한 인터페이스 형태로 구현했습니다.
  - `repository` 패키지에 위치해 있습니다.
- **서비스 계층 (Service Layer)**
  - 비즈니스 로직 및 트랜잭션을 처리하고, 도메인 객체와 리포지토리 계층을 사용하여 데이터를 조회하거나 변경합니다.
  - `service` 패키지에 위치해 있습니다.
- **컨트롤러 계층 (Controller Layer)**
  - 사용자 요청을 처리하고, 서비스 계층을 호출하여 응답을 생성합니다.
  - MVC 패턴의 'Controller'에 해당합니다.
  - `controller` 패키지에 위치해 있습니다.
<br>

### 📍 ERD
<img width="1562" alt="image" src="https://github.com/chanwoo7/health-shop/assets/95745646/dc6b5a85-2759-4c76-8596-b30c198e951f">
<br>

## 4. 사용된 기술 스택
### 📍 Backend
<img src="https://img.shields.io/badge/spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white"><nobr>
<img src="https://img.shields.io/badge/spring_data_jpa-6DB33F?style=for-the-badge&logo=spring&logoColor=white"><nobr>
<img src="https://img.shields.io/badge/spring_security-6DB33F?style=for-the-badge&logo=spring&logoColor=white"><nobr>
<img src="https://img.shields.io/badge/spring_boot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white"><nobr>
<img src="https://img.shields.io/badge/Junit5-25A162?style=for-the-badge&logo=Junit5&logoColor=white"><nobr>

#### **Spring**
- 전체적인 애플리케이션 프레임워크로 사용했습니다.
- 스프링 빈을 포함한 스프링이 제공하는 여러 기능을 활용하여 애플리케이션의 구성 요소를 관리하고 의존성 주입(DI)을 처리했습니다.

#### **Spring Data JPA**
- 데이터베이스와의 상호작용을 단순화하기 위해 사용한 ORM입니다.
- JPA를 기반으로 복잡한 SQL 쿼리를 작성할 필요 없이 데이터베이스 작업을 처리할 수 있도록 했습니다.
- 각 테이블마다 Entity 클래스를 설계하고, Entity간 연관관계를 설정했습니다.
  
#### **Spring Security**
- 비밀번호 암호화와 사용자 인증 및 권한 부여를 관리하고, 보안 설정을 관리하기 위해 사용했습니다.
  
#### **Spring Boot**
- 초기 설정을 최소화하여 빠르고 간편하게 애플리케이션을 개발하기 위해 사용했습니다.
- 또한 내장 서버인 Tomcat을 사용하기 위해 사용했습니다.
  
#### **JUnit5**
- 백엔드 코드(주로 Service 계층과 Repository 계층의 코드)에 대한 단위 테스트와 통합 테스트를 위해 사용했습니다.
<br>

### 📍 Frontend
<img src="https://img.shields.io/badge/Thymeleaf-%23005C0F?style=for-the-badge&logo=Thymeleaf&logoColor=white"><nobr>
<img src="https://img.shields.io/badge/html5-E34F26?style=for-the-badge&logo=html5&logoColor=white"><nobr>
<img src="https://img.shields.io/badge/css3-1572B6?style=for-the-badge&logo=css3&logoColor=white"><nobr>
<img src="https://img.shields.io/badge/bootstrap5-7952B3?style=for-the-badge&logo=bootstrap&logoColor=white"><nobr>
<img src="https://img.shields.io/badge/javascript-F7DF1E?style=for-the-badge&logo=javascript&logoColor=black"><nobr>

#### **Thymeleaf**
- 서버 사이드 렌더링(SSR)을 위한 템플릿 엔진으로 사용했습니다.
- Thymeleaf를 통해 HTML을 동적으로 생성하고, Spring MVC와 통합하여 뷰를 렌더링하는 방식으로 사용했습니다.
  
#### **HTML5**
- 웹 페이지의 구조를 정의하는 데 사용했습니다.
 
#### **CSS3**
- 웹 페이지의 스타일링(레이아웃, 색상, 폰트)을 위해 사용했습니다.
  
#### **Bootstrap5**
- BootStrap에서 제공하는 여러 UI 컴포넌트와 그리드 시스템을 사용했고, 반응형 웹 디자인을 위해 사용했습니다.
  
#### **JavaScript**
- Alert 창, 할인율에 따른 실시간 가격 변동 등 여러 동적 기능을 추가하기 위해 사용했습니다.
- 필요한 곳에 이벤트 리스너를 정의하여 처리함으로써 클라이언트 측 로직을 구현했습니다.
<br>

### 📍 Database
<img src="https://img.shields.io/badge/mysql-4479A1?style=for-the-badge&logo=mysql&logoColor=white"><nobr>
<img src="https://img.shields.io/badge/h2_DB-0302EC?style=for-the-badge&logo=h2&logoColor=white"><nobr>

#### **MySQL**
- 프로덕션 환경에서의 데이터 저장소로 사용했습니다.
  
#### **H2 DB**
- 개발 및 테스트 환경에서의 임시 데이터 저장소로 사용했습니다.
<br>

### 📍 Tools
<img src="https://img.shields.io/badge/github-181717?style=for-the-badge&logo=github&logoColor=white"><nobr>
<img src="https://img.shields.io/badge/IntelliJ_IDEA-000000?style=for-the-badge&logo=intellij-idea&logoColor=white"><nobr>
<img src="https://img.shields.io/badge/postman-FF6C37?style=for-the-badge&logo=Postman&logoColor=white"><nobr>
<img src="https://img.shields.io/badge/mysql_workbench-4479A1?style=for-the-badge&logo=mysql&logoColor=white"><nobr>

#### **GitHub**
- 소스 코드 버전 관리를 위해 사용되었습니다.
  
#### **IntelliJ IDEA**
- 주요 개발 환경(IDE)으로 사용되었습니다.
- 백엔드 및 프론트엔드 코드를 수정하고, 개발 과정에서 Tomcat 서버를 실행하기 위해 사용했습니다.
  
#### **Postman**
- RESTful API를 테스트하고 디버깅하고 위해 사용했습니다.
  
#### **MySQL WorkBench**
- MySQL 데이터베이스를 관리하고 데이터베이스 상태를 시각적으로 모니터링하기 위해 사용했습니다.
<br>

## 5. 참고 자료
- 프론트엔드 개발 시작 단계에서, 무료로 변경 가능한 아래의 템플릿을 참고하여 변경했습니다.
    - https://themewagon.com/themes/furni-online-store/ (CC BY 3.0 License)
    - https://startbootstrap.com/template/shop-item (MIT License)

- 또한 이미지 관련 저작권 문제를 피하기 위해, 본 프로젝트에 포함된 모든 .webp 이미지(상품 이미지 포함), 로고, 파비콘은 **ChatGPT의 image generator**를 통해 생성하여 사용했고, 나머지 이미지는 CC0 License의 이미지를 사용했습니다.
