# 자동차 경주

## 기능 목록

- [X] n대의 자동차이름을 입력받는다. - UserInputer#inputCarString()
    - [x] 자동차 이름은 쉼표(,)를 기준으로 구분한다. - Splitter#carNameSpliter()
    - [x] 각 자동차의 이름이 5자 이하인지 확인한다. - Validator#checkCarNameLength()
    - [x] 각 자동차를 관리하기 위한 Map구조로 나누어 관리한다. - Splitter#listToMap()
- [ ] 게임을 시작한다. Racing#gameStart();
- [x] 사용자에게서 몇 번의 이동을 할 것인지 입력받는다. UserInputer#inputTryCount()
- [x] 0부터 9사이에서 무작위 값을 생성한다. - NumberGenerator#createRandomNumber()
- [x] 전진인지 판단한다.(무작위 값이 4이상이면 전진 4미만이면 정지) - Validator#isForward()
    - [ ] 현재 자동차의 위치를 이름과 같이 출력한다. -Output#printCarLocation()
- [ ] 잘못된 값을 입력할 경우 IllegalArugumentException을 발생후 종료한다.
- [ ] 우승자를 선정한다
    - [ ] 우승자가 여러 명일 경우 쉼표(,) 구분
-

## 기능 요구 사항

    초간단 자동차 경주 게임을 구현한다.
    
    주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.<br>
    각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.<br>
    자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.<br>
    사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.<br>
    전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.<br>
    자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.<br>
    우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.<br>
    사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.