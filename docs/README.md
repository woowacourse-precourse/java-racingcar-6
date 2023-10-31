<p align="center">
    <img src="./woowacourse.png" alt="우아한테크코스" width="250px">
</p>

# 프리코스 2주차 미션 - 자동차 경주

---

![Generic badge](https://img.shields.io/badge/precourse-week2-green.svg)

> 우아한테크코스 6기 2주차 미션, 자동차 경주를 구현한 저장소입니다.
# 문제
- 초간단 자동차 경주 게임을 구현한다.
  
# 규칙
- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
- 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
- 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
- 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.
  
# 기능목록
- controller
  - RacingCarController : InputView의 startInfo를 통해 게임의 설정을 racingPreference에 저장
                          racingPreference에 저장된 자동차들을 RacingGameEvent로 전달 후 게임 진행
                          ResultView를 통해 게임 진행결과와 승자 출력
- model
  - MoveForward : 0에서 9까지의 난수를 생성하여 4 이상일 경우 전진을 뜻하는 true값 반환
  - RacingGameEvent : 자동차의 이름, 이동한 거리를 담기위한 positionhistory를 순서를 보장한 LinkedHashMap으로 생성
    - RacingGameEvent :　사용자가 입력한 자동차 이름의 문자열 배열인 cars를 받아 posigitionHistory에 string, List 형식으로 저장
    - startEvent : 시도 횟수만큼 전진을 하여 값 누적
    - getWinnerNames : 승자가 담긴 winners 리스트 반환
    - getMaxPosition : positionHistory에서 position의 최대값 반환
    - getWinnerName : position이 maxPosiiton인 자동차에 대해 winners 리스트에 추가
- view
  - InputView : startInfo 메서드를 통해 사용자에게 입력받는 자동차의 이름들을 “,” 구분자를 통해 cars 변수에 저장 시도횟수(attept)의 값을 문자형으로 입력받아 다음 3개의 메서드를 통해 유효값 검증
	  - validateCarName : 자동차 이름을 순회하여 이름이 5자 이상일 경우 예외 발생
	  - validateAttemptOnlyNumber : 시도 횟수가 숫자가 아닐 경우 예외 발생
    - validateAttemptNormalInput : 시도 횟수가 정상적인 숫자 입력이 아닐 경우 예외 발생
                이후 게임 설정을 담당하는 RacingPreference 클래스에 값 저장
  - ResultView : 생성자를 통해 실행결과 출력
	  - RacingResult : 메서드를 통해 자동차의 이름과 위치가 저장된 positionsHistory값을 시도횟수만큼 반복
	  - showRacingResult : 자동차별 이동거리를 자동차의 이름과 “-”로 표현
	  - showRacingWinners : 우승자의 결과를 담고있는 winners 배열을 매개변수로 받아 2명 이상일 경우 “,” 구분자를 추가해 반환
- vo
  - Car : 자동차의 이름(name) 과 위치(position)를 저장하는 클래스 MoveForward 메서드를 통해 전진
  - RacingPreference : 게임 설정을 위해 사용자로부터 입력받은(InputView) 자동차의 이름들(cars) 시도 횟수(attempt)를 저장하는 클래스
