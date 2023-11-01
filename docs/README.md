## 구현 기능 목록
1. 입력 자동차 이름들의 유효성 검사
   - isNameAllCorrect(List&lt;String&gt; names)
2. 각 자동차 별 전진 혹은 멈춤
   - forwardOrStop(List&lt;Car&gt; cars)
3. 차수 별 실행 결과 출력
   - cars(List&lt;Car&gt; cars)
4. 우승자 판별 메소드
   - judgeWinners(List&lt;Car&gt; cars)
5. 우승자 출력 메소드
   - winners(List&lt;String&gt; winners)
6. 메인 함수 내부 로직 구현
   - main(String[] args)


## 클래스 설계
1. Car 클래스
   - Property
     - name : String
     - score : Integer
   - Method
     - addScore() : void
     - getName() : String
     - getScore() : Integer
2. Checker 클래스
   - Method
     - isNameAllCorrect(List&lt;String&gt; names) : static Boolean
     - judgeWinners(List&lt;Car&gt; cars) : static List&lt;String&gt;
3. Printer 클래스
   - Method
     - cars(List&lt;Car&gt; cars) : static void
     - winners(List&lt;String&gt; winners) : static void
4. Game 클래스
   - Method
     - forwardOrStop(List&lt;Car&gt; cars) : static void
5. Application 클래스
   - Method
     - main(String[] args) : static void