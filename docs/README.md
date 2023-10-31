# 기능 구현 목록

[x] 자동차가 동작할 수 있다. Car
    [x] 주어진 시도 중 자동차가 움직인 거리를 기록한다. Car#$distance
    [x] 자동차가 전진할 수 있다. Car#move()
        [x] StringBuilder에 "-"를 추가한다.
        [x] "-"를 출력한다.
    [x] 자동차가 정지할 수 있다. Car#stop()
        [x] 기존 그대로 출력한다. 

[x] 0~9 사이의 랜덤 숫자를 구할 수 있다. NumberGenerator#createRandomNumber()

[x] 경주를 시작한다. Race#startRace()
    [x] 랜덤 숫자가 4 이상인지 판별한다. Race#isAbleToMove()

[x] 사용자가 값을 입력할 수 있다. Race
    [x] 자동차의 이동 횟수를 입력할 수 있다. Race#$trial
    [x] 자동차의 이름을 입력할 수 있다. Race#$carName
        [x] 자동차의 이름을 쉼표(,) 기준으로 구분할 수 있다. Race#$carName[].split(",") 

[x] 사용자의 입력 값을 확인한다. InputValidation
    [x] 자동차의 이름은 5자 이하이다. InputValidation#checkName()
    [x] 입력값이 있어야 한다. InputValidation#checkName()
    [x] 중복된 입력값이 없어야 한다. InputValidation#checkDuplicate()
    [x] 잘못된 값을 입력할 경우, IllegalArgumentException을 발생시키고 종료한다.

[x] 점수를 가장 많이 획득한 자동차를 찾는다. ScoreBoard#findWinners()
    [x] HashMap에 자동차 이름과 점수를 입력한다. ScoreBoard#write()
    [x] 최대 점수를 찾는다. ScoreBoard#findWinners()
    [x] 최대 점수를 획득한 자동차가 2대 이상일 때, 배열에 담는다. ScoreBoard#findWinners()

[x] 게임 종료 후 우승자를 발표할 수 있다. Referee#announceWinner()
    [x] 우승자가 여러 명일 경우 쉼표(,)로 구분한다. String.join(",", List)