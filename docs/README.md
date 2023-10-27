초간단 자동차 경주

## 규칙
1. 함수가 한 가지 일만 하도록 초대한 작게 만들기
2. System.exit(0) 쓰지않기
3. Commit 메세지 의미있게 작성하기
4. 3항 연산자 쓰지 않기
5. indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
     - 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.

** 사용자에게 자동차 이름을 입력받는다. **
- camp.nextstep.edu.missionutils.Console의 readLine() 활용
- 이름은 다섯 글자 이하
- trim()을 사용해서 앞뒤로 쓸데없는 공백을 제거한다.
- , 로 구분한다.
- 위의 두 조건을 지키지 않을시 IllegalArgumentException 오류 발생
- Map을 이용해 자동차 이름을 key로 지정한다. value는 일단 0으로 초기화.

** 사용자에게 몇 번 이동할 것인지 입력받는다.**
- camp.nextstep.edu.missionutils.Console의 readLine() 활용
- 자동차마다 입력받은 숫자만큼 0 ~ 9사이의 무작위 값을 구한다.
- Random 값 추출은 camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()를 활용
- 무작위 값이 4이상이면 전진하는 것이므로 해당 자동차의 value값을 1 증가시킨다.

  ** 결과를 표시한다. **
  - 전진한만큼 '-' 를 표시하고 이동할 때마다 결과를 표시한다.
  - 우승자는 1명 이상일 수도 있다.
