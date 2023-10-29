# 기능 구현 목록

[ ] 자동차가 동작할 수 있다. Car
    [ ] 자동차가 전진할 수 있다. Car#move()
        [ ] StringBuilder에 "-"를 추가한다.
        [ ] "-"를 출력한다.
    [ ] 자동차가 정지할 수 있다. Car#stop()
        [ ] 기존 그대로 출력한다. 
[ ] 0~9 사이의 랜덤 숫자를 구할 수 있다. NumberGenerator#createRandomNumber()
[ ] 전진/정지 여부를 결정한다. Judgement
    [ ] 랜덤 숫자가 4 이상일 경우 전진, 미만일 경우 정지한다. Judgement#isGreaterThanFour()
[ ] 사용자가 값을 입력할 수 있다.
    [ ] 자동차의 이동 횟수를 입력할 수 있다. $int trial
    [ ] 자동차의 이름을 입력할 수 있다.
[ ] 사용자의 입력 값을 확인한다.InputCheck
    [ ] 자동차의 이름을 쉼표(,) 기준으로 구분할 수 있다. 
    [ ] 자동차의 이름은 5자 이하이다. InputCheck#countName $String.length()
    [ ] 잘못된 값을 입력할 경우, IllegalArgumentException을 발생시키고 종료한다. InputCheck#isValidName()
[ ] 주어진 횟수 동안 자동차가 움직인 횟수를 기록한다. Referee#countMoves()
[ ] 게임 종료 후 우승자를 발표할 수 있다. Judgement#announceWinner()
    [ ] 우승자는 한 명 이상일 수 있다.
    [ ] 우승자가 여러 명일 경우 쉼표(,)로 구분한다.
