# 🏎️️ 자동차 경주 🏎️️

---

## ✏️ 개요

- 랜덤하게 진행되는 자동차 경주 게임입니다
    - 사용자로부터 자동차 개수, 이름, 게임 턴 횟수를 입력받습니다.
    - 주어진 턴 내에서 각 자동차는 60% 확률로 전진, 40% 확률로 정지 합니다.
    - 모든 턴이 끝났을 때 가장 앞에 있는 자동차가 승리합니다.

---

## 🗓️ 구현 할 기능 목록

- [x] Car 클래스
    - fields
        - name: 자동차의 이름
        - position: 자동차의 현재 위치
    - functions
        - [x] Car(): 생성자
        - [x] forward(): 전진하는 함수
        - [x] getName()
        - [x] getPosition()


- [x] Game 클래스
    - fields
        - cars: 자동차 인스턴스 리스트
        - totalTurn: 총 이동 횟수
        - currentTurn: 현재 이동 횟수
    - functions
        - [x] Game(): 생성자
        - [x] play(): 전체 게임을 진행하는 함수
        - [x] turn(): 게임의 한 턴을 진행하는 함수


- [x] GameUtils 클래스
    - fields
    - functions
        - [x] isForward(): 전진 여부를 결정하는 함수
        - [x] carFactory(): Car 리스트를 생성하는 함수


- [x] Validation 클래스
    - fields
    - functions
        - [x] names(): 입력받은 이름을 검증하는 함수


- [x] InputView 클래스
    - fields
    - functions
        - [x] getInput(): 사용자로부터 이름, 게임 횟수를 입력받는 함수


- [x] OutputView 클래스
    - fields
    - functions
        - [x] printWinner(): 게임 우승자를 형식에 맞추어 출력하는 함수
        - [x] printStatus(): 차량 위치를 형식에 맞추어 출력하는 함수


- [x] Message Enum : 게임에 사용할 문자열을 관리하는 enum


- [x] DTO
    - GameInput Record: 차 이름과 전체 턴 수를 저장하는 레코드
    - GameResult Record: 게임 우승자를 저장하는 레코드
    - GameStatus Record: 차량별 위치를 저장하는 레코드

---

# ❗️예외 처리 (IllegalArgumentException)

- Car Name
    - 이름에 중복이 있는 경우
    - 이름이 비어있는 경우 (빈 문자열, 공백 문자로만 이루어진 이름 등)
    - 이름의 길이가 5글자를 초과하는 경우

- Turn Count
    - 숫자 형식이 아닌 경우
    - 음수가 입력된 경우
