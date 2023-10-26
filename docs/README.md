# ⏩ 실행 순서

1. 경주할 자동차들의 이름을 입력한다.
2. 시도할 횟수를 입력한다.
3. 자동차들의 전진 여부를 판단한다.
4. 시도 횟수마다 진행 여부를 출력한다.
5. 가장 많이 전진한 최종 우승자를 출력한다.

<br>

# ✅예외 체크

- 자동차 이름이 5자 이하인지 체크한다.
- String을 Integer로 변환 시, 숫자로 변환할 수 없는 입력인지 체크한다.

<br>

# ⚙️기능 목록

## InputView

- 경주할 자동차들의 이름을 입력한다.
    - 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
- 시도할 횟수를 입력한다.

## OutputView

- 경주할 자동차들의 이름 입력을 알리는 메시지를 출력한다.
- 시도할 횟수의 입력을 알리는 메시지를 출력한다.
- 각 시도별 실행 결과를 출력한다.
- 최종 우승자를 출력한다.

## Convert

- String을 List로 변환한다.
- String을 Integer로 변환한다.
    - 변환 과정에서 발생하는 NumberFormatException을 잡아 IllegalArgumentException을 발생시킨다.

## RacingNumberGenerator

- 전진 조건에 사용될 숫자를 0에서 9 사이에서 무작위로 구한다.

## RacingCar

- 자동차 이름의 유효성 검사를 한다.
    - 자동차 이름이 5자 이하인지 검사한다.

## GameService

- 자동차의 전진 여부를 판단한다.

## GameController

- 게임을 진행한다.
    - 입력받은 시도 횟수만큼 랜덤 숫자 발생과 전진 여부 판단을 진행한다.

<br>

# 💻테스트 목록

## Convert

- 변환 과정을 테스트한다.
    - String을 List로 변환하는 기능을 테스트한다.
    - String을 Integer로 변환하는 기능을 테스트한다.
    - 숫자로 변환할 수 없는 입력이 있을 때 발생하는 NumberFormatException을 잡아 IllegalArgumentException을 발생시킨다.

## RacingCar

- 자동차 이름의 예외 발생을 테스트한다.
    - 자동차 이름이 5자를 넘어가면 IllegalArgumentException이 발생한다.

## GameService

- 자동차의 전진 여부를 테스트한다.