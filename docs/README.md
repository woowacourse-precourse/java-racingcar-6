# 1. 경주할 자동차 이름 및 시도할 회수를 입력받는 기능
  - 게임 진행을 담당하는 RaceGame 클래스를 추가한다.
  - 입력을 담당하는 GameInput 클래스를 추가한다.
  - 출력을 담당하는 GamePrint 클래스를 추가한다.
  - RaceGame 클래스에 자동차의 이름을 저장하는 ArrayList carNames 인스턴스 변수와 시도 회수를 저장하는 trial 변수를 추가한다.
  - GameInput 클래스에 이름을 입력받는 getNames 메소드, 입력받은 자동차 이름을 파싱하는 parseNames 메소드, 시도회수를 입력받는 getTrial 메소드를 추가한다.
  - GamePrint 클래스에 이름 입력 안내 문구를 출력하는 printGetNames 메소드, 시도 회수 입력 안내 문구를 출력하는 printGetTrial 메소드를 추가한다.
  - RaceGame에 gamePlay 메소드와 getInput 메소드를 추가한다.
  - getInput 메소드에서 GameInput 클래스의 메소드와 GameOutput 클래스의 메소드를 호출하여 이름과 시도 회수를 입력받고 gamePlay 메소드에서 getInput 메소드를 호출한다.


# 2. 