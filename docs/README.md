# 자동차 경주 게임

## 기능 목록
- [O] 사용자로부터 자동차 이름을 입력받는다 - Referee#readPlayer()
        - [O] 입력받은 이름의 길이가 5를 넘는지 확인한다 - Judgment#isOverFiveLength()
- [O] 레이스를 진행할 그룹에 사용자를 추가한다 - Referee#addGroup()

- [O] 사용자로부터 레이싱 진행 횟수를 입력받는다 - Referee#readGameCount()
        - [O] 사용자로부터 제대로 된 진행 횟수 값을 입력받았는지 확인한다 - Judgment#checkInteger()

- [] 자동차 경주를 시작한다 - Referee#run()
    - [O] 각 자동차의 경주를 N회 진행한다 - Judgment#cycle()
        - [O] 무작위 숫자를 생성하여 4를 넘을경우 자동차를 전진시킨다 - Racer#moveForward()
            - [O] 생성된 무작위 숫자가 4 이상인지를 판단한다 - Judgment#isOverFourDistance()
        - [O] 현재까지의 경주 결과를 출력한다 - Referee#printProgress()
            - [O] 현재까지 자신의 이동거리를 출력한다 - Racer#printDistance()

    - [O] 현재 가장 큰 전진값을 구한다 - Referee#findMaxDistance()
        - [O] 참가자의 전진값과 현재 최대 전진값을 비교한다  - Referee#compareMax()
    - [O] 우승자를 출력한다 - Referee#printWinner()
        - [O] 최대값과 비교하여 해당 선수를 우승자에 추가한다 - Referee#addMaxPlayer()

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