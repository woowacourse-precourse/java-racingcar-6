# 📚 기능 목록
## 🚗 자동차 - Car
> 자동차와 관련된 정보 및 기능이 있는 도메인 클래스
- [x] 자동차 이름이 공백인지 검증한다. ``Car - validateBlankName``
- [x] 자동차 이름이 5자 이하인지 검증한다. ``Car - validateNameLength``
- [x] 자동차가 이동한다. ``Car - move``
- [x] 자동차가 전진하는지 판단한다. ``Car - isMoveForward``
- [x] 자동차가 전진한다. ``Car - moveForward``
</br>

## 🎲 숫자 생성자 - NumberGenerator
> 숫자를 생성하는 기능이 있는 도메인 클래스 
- [x] 0에서 9 사이의 무작위 값을 구한다. ``NumberGenerator - createRandomNumber``
</br>

## 👪 참여자들 - Players
> 참여자들과 관련된 정보 및 기능이 있는 도메인 클래스
- [x] 중복된 자동차 이름이 있는지 검증한다. ``Players - validateDuplicateName``
- [x] 우승자가 누구인지 확인한다. ``Players - findWinner``
</br>

## 🎮 경주 프로그램 - GameController
> 경주를 진행하는 컨트롤러 클래스
- [x] 경주을 시작한다. ``GameController - startRace``
- [x] 자동차 리스트를 생성한다. ``GameController - createCarList``
- [x] 경주 횟수 입력값이 1 이상인지 검증한다. ``GameController - validateRaceCount``
- [x] 경주를 진행한다. ``GameController - race``
- [x] 우승자를 안내한다. ``GameController - announceWinner``

## 🖥️ 경주 입력 화면 - InputView
> 사용자의 입력을 받기위한 화면을 출력하면서 입력을 받는 뷰 클래스
- [x] 자동차의 이름들을 입력받는다. ``InputView - readCarsName``
- [x] 자동차가 몇 번 이동할 지 입력받는다.  ``InputView - readCarMoveCount``
- [x] 입력값이 숫자인지 검증한다. ``InputView - validateDigit``

## 🖥️ 경주 출력 화면 - OutputView
> 경주 화면을 출력하는 뷰 클래스
- [x] 실행 결과 문구를 출력한다. ``OutputView - printRaceStart``
- [x] 자동차들의 경주 진행 상황을 출력한다. ``OutputView - printRacePlayers``
- [x] 자동차의 이름을 출력한다. ``OutputView - printCarName``
- [x] 자동차의 전진 상황을 출력한다. ``OutputView - printCarProgress``
- [x] 우승자를 출력한다. ``OutputView - printWinner``
