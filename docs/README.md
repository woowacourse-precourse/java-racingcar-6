# 자동차 경주 게임

## 기능 목록
- [O] 입력받은 사용자의 이름으로 자동차를 생성한다 - racer#create()
- [O] 자동차를 전진시킨다 - racer#moveForward()
- [O] 현재까지 자신의 이동거리를 출력한다 - racer#printDistance()


- [] 자동차를 전진시키기 위한 무작위 숫자를 생성한다 - pickNumberInRange()
- [] 생성된 무작위 숫자가 4 이상인지를 판단한다 - Judgment#isGreaterThanFour()
- [] 각각의 자동차가 전진한 거리를 비교한다 - Judgment#compareDistances()


- [] 자동차 경주를 시작한다 - Referee#run()
- [O] 레이스를 진행할 그룹에 사용자를 추가한다 - Referee#addGroup()
- [O] 현재까지의 경주 결과를 출력한다 - Referee#printProgress()
- [O] 현재 가장 큰 전진값을 구한다 - Referee#findMaxDistance(), Referee#compareMax()
- [O] 우승자를 출력한다 - Referee#printWinner()
- [O] 해당 플레이어의 젅진 횟수가 최대일경우 우승자 명단에 추가한다 - Referee#addMaxPlayer()

Judgment 판단
Referee 심판

## 기능 요구 사항

    주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
    각 자동차에 이름을 부여할 수 있다.
    전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
    자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
    사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
    전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
    자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다.
    우승자는 한 명 이상일 수 있다.
    우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
    사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.

## 입력
- #### 경주 할 자동차 이름(이름은 쉼표(,) 기준으로 구분)
        pobi,woni,jun
- #### 시도할 회수
        5

## 출력
- #### 각 차수별 실행 결과
        pobi : --
        woni : ----
        jun : ---

- #### 단독 우승자 안내 문구
        최종 우승자 : pobi

- #### 공동 우승자 안내 문구
        최종 우승자 : pobi, jun