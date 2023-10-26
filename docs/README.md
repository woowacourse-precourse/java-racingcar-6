## 구현할 기능 목록
- 사용자로부터 이동 횟수를 입력 받는다.
  - 잘못된 입력(숫자가 아님)이면 `IllegalArgumentException`을 발생 후 종료한다.
- 자동차에게 이름을 부여할 수 있다.
  - 사용자로부터 이름(들)을 입력 받는다. - 
  - 입력 데이터를 쉼표를 기준으로 분리할 수 있다. - 문자관리자#seperate
  - 잘못된 입력 (5자 초과, null)이면 `IllegalArgumentException`을 발생 후 종료한다.
  - 자동차를 이름과 함께 생성한다. CarGenerator#create

- 이동횟수만큼 게임을 진행한다.
  - 자동차를 전진시킨다.
  - 차수마다 자동차들의 전진 결과를 출력한다. 게임관리자#print차수Restult
    - 자동차의 이름과 전진 상황을 출력한다. - Car#printForwardResult

- 자동차에게 전진할 기회를 준다. - 게임지배자#
  - 무작위 수(0~9)를 구한다. -NumberGenerator#createRandomNumber
  - 4이상이면 전진 한다. - Car#forward




- 우승자를 출력한다.- Judge
  - 자동차 중 가장 많이 전진한 차(단수, 복수)를 알아낸다.Judge#compare
  - 우승자가 몇 명인지 알아낸다.
  - 여러 명이면 쉼표로 구분한다.

