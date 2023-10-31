1. 메인 애플리케이션 (Application.java)
   사용자로부터 차 이름과 시도할 횟수 입력 받기
   자동차 경주 게임 인스턴스 생성 및 실행
   경주 결과 출력
2. 자동차 클래스 (Car.java) <br>
   변수: **carName** <br>
   메서드: move(), getWinner() <br>
   move(): Randoms.pickNumberInRange(0,9)를 사용해 4 이상일 경우 전진

3. 경주 게임 클래스 (RacingGame.java) <br>
   변수: cars, rounds <br>
   메서드: race(), printRaceStatus(), getWinners() <br>
   race(): 각 차에 대해서 move() 호출 <br>
   printRaceStatus(): 각 차의 현재 위치를 출력 <br>
   getWinners(): 가장 멀리 간 차들을 반환 <br>
4. 입력 유효성 검사 (InputValidator.java) <br>
   입력된 차 이름이 5자 이하인지, 시도할 횟수가 양의 정수인지 등을 검사<br>
   유효하지 않은 값이 입력될 경우 IllegalArgumentException 발생 <br>

---
구현 흐름 <br>
사용자로부터 자동차 이름들과 시도할 횟수를 입력받는다.<br>
입력값의 유효성을 검사한다. <br>
입력받은 자동차 이름들로 Car 인스턴스들을 생성하고, RacingGame 인스턴스를 생성한다. <br>
RacingGame에서 지정된 횟수만큼 경주를 진행한다. <br>
각 라운드의 경주 결과를 출력한다. <br>
경주가 끝나면 우승자를 출력한다. <br>
주의 사항
RacingGame의 메서드나 다른 메서드들에서 로직이 복잡해지면 별도의 메서드나 클래스로 분리해 인덴트를 2 이하로 유지한다. <br>
자바 코드 컨벤션을 지키면서 프로그래밍한다.<br>
else 예약어를 쓰지 않는다.<br>