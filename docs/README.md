23.10.30
 
제출을 위한 git clone, push 환경 설정 완료
pull request 미 설정

기능 요구 사항 분석
        
        1. 사용자 입력으로 쉼표(,)를 기준으로 나눈다.
            - 각각의 이름은 5자 이내여야 하고 잘못된 값일 경우 IllegalArgumentException을 발생한다.

        2. 사용자 입력으로 시도할 횟수를 숫자로 입력받는다
            - 숫자가 아닐 경우 IllegalArgumentException을 발생한다.

        3. 각각의 자동차는 0~9사이의 무작위 값을 가지고, 그 수가 4 이상일 경우 전진하게 된다.
            - 전진하게되면 차수별 출력하게될 결과에 "-"가 추가된다.
        
        4. 입력받은 시도할 횟수만큼의 차수를 반복하면서 각각의 자동차의 진행 거리를 "-"로 보여준다.

        5. 최종 우승자의 이름을 출력한다.
            - 공동 우승이 가능하다.


- Controller
  - GameManager.java
    1. initGame
    2. playGame
    3. listUp
    4. playRound
    5. playUntilRound
    6. finishGame
- model
  - Car.java
    1. Car
    2. setDistance
    3. getDistance
    4. setName
    5. getName
    6. 
  - NumberGenerator.java
  