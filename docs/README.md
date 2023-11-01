# 간단한 자동차 경주 게임

## 기능 목록
- [O] 각 자동차에 이름을 입력한다. - CarGenerator#inputCarNames()
    - [O] Null 입력 예외처리    - CarGenerator#validateCarNameNull()
    - [O] 중복 입력 예외처리    - CarGenerator#validateCarNamedistint()
    - [O] 길이 초과 예외처리    - CarGenerator#validateCarNamelength()
    - [O] 공백 입력 예외처리    - CarGenerator#validateCarNameblank()
- [O] 몇 회 이동할 것인지 입력한다. - NumberGenerator#goChance()
    - [O]숫자인가? 예외처리 진행.   - NumberGenerator#validateGameChanceNumbers()
- [O] 0에서 9 사이의 임의의 수를 생성한다. - NumberGenerator#createRandomNumbers()
    - [O] 숫자가 4 이상인 경우 전진 - ActionCars#goCar()

- [O] 결과 출력 변수 초기화 -ActionCars#resetCountResult()
- [O] 결과 최대값 변수 반환 기능 - ActionCars#winnerGoCount()

- [ ] 입력에 대한 출력.
    - 차 이름 입력 안내문 - InputView#printCarNamesInformation()
    - 회수 입력 안내문  - InputView#printGameChanceInformation()
- [O] 결과에 대한 출력.
    - [O] 실행 결과 안내문 - OutputView#printInformation()
    - [O] 각 실행 결과 출력 - OutputView#printResultGame()
    - [O] 우승자 결과 출력 - OutputView#printWinner()

## 기능 요구 사항

초간단 자동차 경주 게임을 구현한다.

주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.