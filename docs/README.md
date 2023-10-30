
# 구현 해야 하는 기능 목록

1. ValueGenerator(RandomValueGenerator,ValueGenerateStrategy)
   - 자동차를 전진하기 위해 0과 9사이의 랜덤한 값을 받는다.
   
2. InputView
   - 자동차 x대를 y변의 횟수만큼 동안 전진 or 멈출 수 있도록 각 x,y 값을 입력받는다.

3. OutputView
    - 추적한 거리를 이용하여 레이싱 게임의 결과를 출력한다.

4. CarGroup
    - 자동차의 개수는 음수이면 안된다.
    - 자동차 전진을 위한 시도 회수는 음수여서는 안된다.
    - 자동차 그룹은 자동차의 개수만큼 자동차를 만들어 가질 수 있다.

5. Car
    - 자동차가 전진하는 조건은 하나의 랜덤값 중, 그 값이 4 이상일때 움직인다.
    - 값이 4미만일 경우 움직이지 않는다.
    - 자동차가 움직인 거리를 매번 추적하여 저장한다.

6. Name
   - 자동차 이름의 유효성 검사 (1~5 글자 범위)

7. PositiveNumber
   - 양수에 대한 유효성 검사

8. RacingGameApp
   - 전체 게임의 흐름을 제어하는 메인 로직 구현

9. RacingGameController
   - 게임 시작 및 각 단계별 로직을 제어하는 기능
   - gameStart() 자동차 경주 게임을 시작합니다.
   - moveCars() 자동차를 이동시킵니다.
   - getWinners() 우승한 자동차 목록을 반환합니다.

10. SplitString
    - 문자열을 구분하는 역활

11. RacingGame