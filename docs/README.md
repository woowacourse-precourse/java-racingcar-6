## 구현 기능 목록
1. 입력 자동차 이름들의 유효성 검사
   - isNameAllCorrect(Array<String> names) : Boolean
2. 각 자동차 별 전진 혹은 멈춤
   - forwardOrStop(Array<Car> cars) : void
3. 차수 별 실행 결과 출력
   - printCars(Array<Car> cars) : void
4. 우승자 판별 메소드
   - judgeWinners(Array<Car> cars) : Array<String>
5. 우승자 출력 메소드
   - printWinners(Array<String> winners) : void
6. 메인 함수 내부 로직 구현
   - main() : void


## 클래스 설계
1. Car 클래스
   - Property
     - name : String
     - score : Integer
   - Method
     - addScore() : void
2. Checker 클래스
   - Method
     - isNameAllCorrect(Array<String> names) : static Boolean
     - judgeWinners(Array<Car> cars) : static void
3. Printer 클래스
   - Method
     - printCars(Array<Car> cars) : static void
     - printWinners(Array<String> winners) : static void
4. Game 클래스
   - Method
     - forwardOrStop(Array<Car> cars) : static void