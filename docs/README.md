# 자동차 경주 - 구현 기능 목록

- 사용자가 각 자동차의 이름을 입력하는 기능
  - 사용자로부터 camp.nextstep.edu.missionutils.Console의 readLine()을 활용하여 입력받기
  - 입력할때 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능
  - 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션 종료
  


- 경주에서 몇 번의 이동을 할 것인지 사용자가 입력하는 기능
  - 사용자로부터 camp.nextstep.edu.missionutils.Console의 readLine()을 활용하여 입력받기
  - 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션 종료


- 경주의 이동 차수마다 자동차가 전진하도록 하는 기능
  - 주어진 횟수 동안 n대의 자동차는 전진하거나 멈춰있어야함
  - camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()을 활용하여 
    자동차마다 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우 전진
  - 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력


- 자동차 경주 게임을 완료한 후 누가 우승했는지를 출력
  - 우승자는 한명 이상일 수 있음
  - 여러명일때는 쉽표(,)를 이용하여 구분

