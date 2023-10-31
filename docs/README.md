## Game.class
## Round.class

## Car
각 자동차에 부여된 이름
랜덤한 수 만큼 전진
자신의 이름을 출력하는 visualize를 가진다.

## Race
각 자동차의 위치를 관리
Map<String,Integer> CarDistance를 가진다.
순서보장을 위해 LinkedHashMap을 사용한다.
레이스가 시작되면 레이스에 참가한 차량들이 움직인다.
레이스 결과와 우승자에 대해 String으로 반환이 가능하다.

## GameController

### run()
1. 레이스 시도횟수를 입력받는다(View로 이동).
2. 해당 횟수만큼 레이스를 진행한뒤 결과를 반환한다(View로 이동).
3. 우승자를 반환한다.(View로 이동)
4. 
### gameInit()
1. GameView에서 경주할 자동차 이름들을 입력받는다.
2. 입력받은 값으로 생성된 Race를 가진 Controller를 반환한다.

## GameView
경주할 자동차 이름을 입력받는다.
이동을 시도하는 횟수를 입력받는다.
실행결과를 출력한다. 실행 결과는 RaceCourse
최종 우승자를 출력한다.

