# 🚀 기능 목록

1. 사용자로부터 자동차 이름을 입력받는 기능

- 예외 1-1) 이름의 길이가 1자 미만, 5자 초과 경우
- 예외 1-2) 자동차의 수가 1대 미만인 경우


2. 사용자로부터 각 자동차의 이동 횟수를 입력받는 기능

- 예외 1-1) 숫자 이외의 값이 포함되어 있는 경우


3. 0에서 9 사이의 무작위 값을 생성하는 기능


4. 게임 우승자를 반환하는 기능

- 가장 많이 앞선 자동차를 판별
- 우승자는 1명 이상일 수 있음


5. 게임 진행 기능

- 입력 메시지 출력하기
- 우승자 출력하기


6. 게임 반복 기능

- 현재 경주 상황(자동차 이름, 자동차 현재 위치) 출력하기


# 📚 클래스 설계

## domain

- Car : 자동차 객체
  - of() : Car의 name을 반환하기 위한 함수
  - move() :  랜덤 숫자가 4 이상일 때 position을 1 증가시키는 함수
  - isSamePosition() : 자동차가 같은 위치에 있는지 확인하는 함수

### dto

- CarDTO : 데이터를 전송하는 객체
  - getName() : 자동차의 이름을 저장하는 함수
    - getPosition() : 자동차의 위치를 저장하는 함수

## service

- CarService : 게임 진행을 돕는 객체
  - saveCar() : Car 리스트에 객체 타입을 저장하는 함수
  - findCars() : Car 리스트를 반환하는 함수
  - getMaxPosition() : 가장 앞서있는 자동차의 위치를 반환하는 함수

- GameManageService : 게임을 진행하는 객체
  - saveCars() : Car 리스트에 객체 타입을 저장하는 함수
  - race() : 랜덤 숫자를 생성해 move에게 메시지를 전달하는 함수
  - getWinner() : 우승한 자동차의 이름을 리스트로 반환하는 함수
  - winnerToString() : 리스트를 문자열로 변환하는 함수
  - convertToCarList() : 문자열을 Car 타입 리스트로 변환하는 함수

## view

- InputView : 사용자로부터 입력을 받는 객체
  - input() : 사용자로부터 입력을 받는 함수

- OutputView : 메시지를 출력하는 객체
  - inputNameMessage() : 자동차 이름 입력 메시지를 출력하는 함수
  - inputCountMessage() : 이동 횟수 입력 메시지를 출력하는 함수
  - executionResultMessage() : 실행 결과 메시지를 출력하는 함수
  - carResult() : 각 자동차의 이름과 위치를 출력하는 함수
  - printPosition() : 자동차의 위치를 (-)으로 출력하는 함수
  - winner() : 최종 우승자를 출력하는 함수

## controller

- GameManageController : 전반적인 게임을 진행하는 객체
  - startGame() : 게임을 시작하는 함수
  - repeatRace() : 레이스를 주어진 이동 횟수만큼 반복하는 함수
  - inputCar() : 자동차 이름을 입력받고 이를 검증하는 함수
  - getCars() : String을 Car 타입 리스트로 변환한 값을 반환하는 함수
  - inputCount() : 이동 횟수를 입력받고 이를 검증하는 함수

## verification

- InputVerification : 주어진 입력이 올바른지 검증하는 객체
  - checkAll() : 전체 검증을 실시하는 함수
  - checkCarNameLength() :  입력값의 길이가 1자 이상 5자 이하인지 검증하는 함수
  - checkCarCount() : 입력한 자동차의 수가 1대 이상인지 검증하는 함수
  - checkInputType() 입력값이 숫자로만 이루어져 있는지 검증하는 함수