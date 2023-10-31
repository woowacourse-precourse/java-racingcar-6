# 1. 경주할 자동차 이름 및 시도할 회수를 입력받는 기능
  - 게임 진행을 담당하는 RaceGame 클래스를 추가한다.
  - 입력을 담당하는 GameInput 클래스를 추가한다.
  - 출력을 담당하는 GamePrint 클래스를 추가한다.
  - RaceGame 클래스에 자동차의 이름을 저장하는 List carNames 인스턴스 변수와 시도 회수를 저장하는 trial 변수를 추가한다.
  - GameInput 클래스에 이름을 입력받는 getNames 메소드, 입력받은 자동차 이름을 파싱하는 parseNames 메소드, 시도회수를 입력받는 getTrial 메소드를 추가한다.
  - GamePrint 클래스에 이름 입력 안내 문구를 출력하는 printGetNames 메소드, 시도 회수 입력 안내 문구를 출력하는 printGetTrial 메소드를 추가한다.
  - RaceGame에 gamePlay 메소드와 getInput 메소드를 추가한다.
  - getInput 메소드에서 GameInput 클래스의 메소드와 GameOutput 클래스의 메소드를 호출하여 이름과 시도 회수를 입력받고 gamePlay 메소드에서 getInput 메소드를 호출한다.
  - 구현한 기능에 대하여 단위 테스트를 수행한다.


# 2. 게임 플레이 기능
  - 게임 플레이 중 사용자별로 몇번 전진했는지 저장하고 정렬을 해야 하므로, Pair 클래스를 추가한 후 RaceGame 클래스와 GameInput 클래스의 자료구조와 메소드를 이에 맞게 수정한다. Pair 클래스는 자동차의 이름과 앞으로 나아간 회수를 저장한다.
  - carNames 인스턴스 변수의 이름을 carsInformation으로 바꾼다.
  - RaceGame 클래스에 0부터 9까지의 난수를 생성해 앞으로 나아갈지 판단하는 moveFoward 메소드를 추가한다.
  - RaceGame 클래스에 시도 한 번에 앞으로 나아갈 자동차를 정하는 doSingleTrial 메소드를 추가한다.
  - RaceGame 클래스에 총 시도 회수만큼 시뮬레이션하고 각 회차의 결과를 출력하는 race 메소드를 추가한다.
  - GamePrint 클래스에 레이스 시작 시 '실행 결과'를 출력하는 printStart 메소드를 추가한다.
  - GamePrint 클래스에 레이스의 각 회차 결과를 출력하는 printRace 메소드를 추가한다.
  - RaceGame 클래스의 playGame 메소드에서 printStart 메소드와 race 메소드를 추가적으로 호출한다.
  - 구현한 기능에 대하여 단위 테스트를 수행한다.
  
  
# 3. 게임 종료 및 승자를 정하는 기능
  - Pair 클래스에 내림차순 정렬을 위한 비교연산을 하는 compareTo 메소드를 재정의한다.
  - RaceGame 클래스에 승자를 구하는 getWinner 메소드를 추가한다.
  - GamePrint 클래스에 승자를 출력하는 printWinner 메소드를 추가한다.
  - 구현한 기능에 대하여 단위 테스트를 수행한다.
  
  
# 4. 리팩토링 및 수정사항
  - RaceGame의 getInput 메소드를 getNamesInput 메소드와 getTrialInput 메소드로 분리하고, 각각 결과를 반환하도록 하여 단위 테스트를 수행한다.
  - RaceGame의 getWinner 메소드의 단위 테스트를 추가한다.