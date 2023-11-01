# 기능 목록

## 1. domain

### model

- **Car.java**
    - 자동차의 도메인 객체입니다. 이름과 위치 정보를 관리합니다.

### service

- **RacingGame.java**
    - 자동차 경주 게임의 핵심 로직을 담당하는 도메인 객체입니다. 게임의 규칙, 동작 및 데이터를 관리합니다.

## 2. application

- **RacingService.java**
    - 자동차 경주 게임의 핵심 비즈니스 로직을 담당합니다. RacingGame의 기능을 활용하여 게임의 진행과 결과를 관리합니다.

## 3. presentation

- **RacingController.java**
    - 사용자 입력을 받아 입력값을 검증하고, RacingService를 호출하여 게임을 진행합니다. 그리고 게임의 진행 상황 및 결과를 출력합니다.

- **InputValidator.java**
    - 사용자의 입력값을 검증합니다. 올바르지 않은 입력을 방지하며, 유효성 검사를 수행합니다.

- **RacingGameOutputHandler.java**
    - 게임 진행 중과 게임 종료 시의 결과를 출력하는 기능을 관리합니다.

## 4. constant

- **RacingGameConstant.java**
    - 게임 전체에서 사용되는 상수와 설정값을 중앙에서 관리합니다.

## 5. utils

- **IOHandler.java**
    - 사용자의 입력 및 출력을 처리하는 유틸리티 클래스입니다. 사용자로부터 입력을 받고, 화면에 결과를 출력합니다.