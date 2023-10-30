# 기능 구현 목록

[ ] 자동차가 동작할 수 있다. Car
    [ ] 주어진 시도 중 자동차가 움직인 거리를 기록한다. Car#$distance
    [ ] 자동차가 전진할 수 있다. Car#move()
        [ ] StringBuilder에 "-"를 추가한다.
        [ ] "-"를 출력한다.
    [ ] 자동차가 정지할 수 있다. Car#stop()
        [ ] 기존 그대로 출력한다. 

[x] 0~9 사이의 랜덤 숫자를 구할 수 있다. NumberGenerator#createRandomNumber()

[ ] 경주를 시작한다. Race#startRace()
    [ ] 랜덤 숫자가 4 이상인지 판별한다. Race#isAbleToMove()

[ ] 사용자가 값을 입력할 수 있다. Race
    [ ] 자동차의 이동 횟수를 입력할 수 있다. Race#$trial
    [ ] 자동차의 이름을 입력할 수 있다. Race#$carName
        [ ] 자동차의 이름을 쉼표(,) 기준으로 구분할 수 있다. Race#$carName[].split(",") 

[ ] 사용자의 입력 값을 확인한다. InputValidation
    [ ] 자동차의 이름은 5자 이하이다. InputValidation#isValidName
    [ ] 잘못된 값을 입력할 경우, IllegalArgumentException을 발생시키고 종료한다.

[ ] 점수를 가장 많이 획득한 자동차를 찾는다. ScoreBoard#findWinners()
    [ ] 자동차 이름과 점수를 담는 HashMap을 생성한다. ScoreBoard#write()
    [ ] 최대 점수를 찾는다. ScoreBoard#findMaxScore()
    [ ] 최대 점수를 획득한 자동차가 2대 이상일 때, 배열에 담는다. ScoreBoard#MaxScore()

[ ] 게임 종료 후 우승자를 발표할 수 있다. Referee#announceWinner()
    [ ] 우승자가 여러 명일 경우 쉼표(,)로 구분한다. String.join(",", List)