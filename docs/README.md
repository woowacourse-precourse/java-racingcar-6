# 자동차 경주 게임 - 구현할 기능 목록
## 개요
- Java Spring을 이용한 자동차 경주 게임
- MVC 구조 설명에서 F는 Field를, M은 Method를 의미한다.
---
## MVC 구조
### [Model]
### 🚘 Car (n대)
- (F) 이름
- (M) 자동차 생성
- (M) 전진
- (M) 멈춤
### 🙋‍♀️ User
- (M) 이동 횟수 입력

### [View]
### 🎮 GameView
- (M) 자동차 이름 5자 이하로 제한
- (M) 전진하는 조건 확인 (0에서 9 사이의 무작위값이 4 이상일 경우에만 전진)
- (M) 게임 완료 후 우승자 출력 (한 명 또는 그 이상, 우승자가 여러 명일 경우 쉼표로 구분)
- (M) 잘못된 값 입력 시 IllegalArgumentException 발생

### [Controller]
### 🎮 GameController
- (M) 게임의 시작과 종료
---
## 클래스 다이어그램
