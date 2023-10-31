<p align="center">
    <img src="./woowacourse_logo.jpg" alt="우아한테크코스" width="600px">
</p>

# 프리코스 미션 2주차 - 자동차 경주 🚗

## 프로젝트 구조 🌳

```
└─src
    ├─main
    │  └─java
    │      └─racingcar
    │          │  Application.java
    │          │
    │          ├─controller
    │          │      RaceController.java
    │          │
    │          ├─model
    │          │      Car.java
    │          │      CarList.java
    │          │      Race.java
    │          │
    │          ├─util
    │          │      Constants.java
    │          │      Convertor.java
    │          │      RandomNumberGenerator.java
    │          │      Validator.java
    │          │
    │          └─view
    │                  InputView.java
    │                  OutputView.java
    │
    └─test
        └─java
            ├─racingcar
            │      ApplicationSelfTest.java
            │      ApplicationTest.java
            │
            └─study
                    StringTest.java


```

## 기능 목록 📋

### RaceController

- [x] 경주를 시작부터 종료까지 경주 흐름을 제어합니다. - startRace(),endRace()
- [x] 경주를 생성합니다. - createRace()

### Car

- [x] 경주에 참여할 자동차를 생성합니다.

### CarList

- [x] 경주에 참여할 자동차 목록을 생성합니다.
- [x] 나누어진 이름별 자동차를 생성하여 자동차 목록에 추가합니다. - generateCar()

### Race

- [X] 무작위 추출 값이 4 이상인 경우의 자동차는 전진합니다. - moveForward()
- [X] 모든 전진 시도 횟수가 끝나면 최종 우승자를 선정합니다. - checkWinner()

### Convertor

- [x] 입력 받은 자동차 이름을 ,기준으로 나누어 줍니다. - splitCarNamesByComma()

### Validator

- [X] 입력한 자동차가 1개 이상인지 확인합니다. - checkCarNameListSize()
- [x] 자동차 이름이 빈 값인지 확인합니다. - checkCarNameEmpty()
- [x] 자동차 이름이 5자 이하 인지 확인합니다. - checkCarNameLength()
- [x] 전진 시도 횟수에 숫자만 입력하였는지 확인합니다. - containsOnlyNumbers()

### RandomNumberGenerator

- [X] 0~9사이의 무작위 숫자를 선택합니다. - randomNumber()

### InputView

- [x] 경주할 자동차 이름을 입력받습니다. - inputString()
- [x] 전진 시도 횟수를 입력받니다. - inputString()

### OutputView

- [x] 전진 시도 회차 마다 전진 결과를 출력합니다. - currentRacingView()
- [x] 최종 우승자를 출력합니다. -winnerView




