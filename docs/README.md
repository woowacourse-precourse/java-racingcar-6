## Game.class

## Round.class

## Car
각 자동차에 부여된 이름
랜덤한 수 만큼 전진
자신의 이름을 출력하는 visualize를 가진다.

## RaceCourse
각 자동차의 위치를 관리
Map<String,Integer> cars를 가진다.
순서보장을 위해 LinkedHashMap을 사용한다.
RaceCourse의 생성자는 자동차들의 이름을 받아서 생성한다.

## GameController
### gameInit()
1. GameView에서 경주할 자동차 이름들을 입력받는다.
2. 입력받은 값으로 생성된 Dto를 RaceCourse Entity로 반환한다.
2. 입력 받은 String으로 경주할 자동차들을 생성한다.
3. 생성한 자동차를 통해 RaceTrack을 생성한다.
4. 생성된 자동차와 RaceTrack를 통해 Game을 반환한다.


## GameManager
1.

### MoveAndPrint()
1. RaceCourse의 저장된 cars를 통해 움직인 값을 저장한다.
2. 현재 모든 자동차의 위치를 RaceCourse를 통해 GameView에 출력한다.


## GameView
경주할 자동차 이름을 입력받는다.
이동을 시도하는 횟수를 입력받는다.
실행결과를 출력한다. 실행 결과는 RaceCourse
최종 우승자를 출력한다.

