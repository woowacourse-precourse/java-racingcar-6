1.  InputView 구현하기
    1. 경주할 자동차 이름 입력 getCarNames 구현
       1. 이름은 5자 이하만 가능하다.
    2. 시도할 횟수 입력 getNumberOfAttempts
    3. 잘못된 값을 입력할 경우 IllegalArgumentException를 발생 시킨다.
2. OutputView 구현하기
   1. 실행 결과를 출력하는 printGameResult 구현
   2. 최종 우승자를 출력하는 printWinner 구현
      1. 우승자가 여러명일 경우 쉼표(,)를 이용해서 구분
3. 자동차 객체 구현
   1. 0~9 사이의 무작위 값을 구해 4 이상일 경우 전진시키는 함수 구현