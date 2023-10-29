# 🚘 초간단 자동차 경주 게임

## 자동차(Car.java)
 - [ ] 자동차가 전진하는 조건은 0~9에서 무작위 값을 구한 후, 이 무작위 값이 4 이상인 경우이다.
 - [ ] 자동차가 전진할 때, 자동차 이름을 같이 출력한다.

## 사용자(User.java)
 - [ ] 자동차의 이름은 5자 이하로 부여한다.
 - [ ] 각 자동차는 쉼표(,)를 기준으로 구분한다.
 - [ ] 자동차에 대해 몇 번의 이동을 할 것인지 입력한다.
 - [ ] (Exception) 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료된다.

## 심판(Judgement.java)
 - [ ] 게임이 끝난 후, 누가 우승했는지 알려준다.
   - [ ] 우승자는 한 명 이상일 수 있다.
   - [ ] 우승자가 여러 명일 경우 쉼표(,)를 이용해 구분한다.

## 추가 요구사항
- indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다.
- 3항 연산자를 쓰지 않는다.
- 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.
- JUnit 5와 AssertJ를 이용하여 본인이 정리한 기능 목록이 정상 동작함을 테스트 코드로 확인한다.

## 라이브러리 제한
- camp.nextstep.edu.missionutils에서 제공하는 Randoms 및 Console API를 사용하여 구현한다.
- Random 값 추출은 camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()를 활용한다.
- 사용자가 입력하는 값은 camp.nextstep.edu.missionutils.Console의 readLine()을 활용한다.