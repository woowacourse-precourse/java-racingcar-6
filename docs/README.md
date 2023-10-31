# *기능 목록
- - -
## Car 클래스
- [ o ]자동차는 이름을 가지고 있다. name
- [ o ]자동차는 이동한 거리를 가지고 있다. distance
- [ o ]자동차는 전진한다. go()

## Game 클래스
- [ o ]자동차 리스트를 가지고 있다.
- [ o ]자동차 이름을 입력받아 쉼표를 기준으로 저장한다. saveCarNames()
  -[ o ]자동차 이름은 5자 이하이다.
  -[ o ]자동차 이름에는 숫자가 있으면 안된다. 
- [ o ]경주를 시작한다. play()
  - [ o ]자동차에게 랜덤번호를 부여한다. giveRandomNumber()
  - [ o ]사용자는 이동 거리(게임 횟수)를 입력한다.

## Narrator 클래스
- [ o ]자동차를 출력할 때 이름을 같이 출력한다. showEachRound()

## NumberGenerator 클래스
- [ o ]무작위 값을 만든다. makeRandomNumber()

## Referee 클래스
- [ o ]게임 우승자를 알려준다. announceWinners()