#구현할 기능 목록

-[x] 숫자 생성기 NumberGenerator 인터페이스 구현
  -[x] 0~9 랜덤 숫자 생성기 RandomNumberGenerator 클래스 구현


-[x] 자동차의 이름(name)과 위치(position)를 담고있는 Car 클래스 구현
  - 생성자에서 validateInput 메소드로 검증
    - 자동차 이름은 5자 이하여야한다. 실패시 IllegalArgumentException 반환
  - RandomNumberGenerator를 통해 나온값으로 전진 가능을 반환하는 boolean 반환 메소드 구현
  - 포지션값을 1 증가시키는 메소드 구현
  - Car의 상태를 출력하는 메소드 구현


-[x] List<Car>을 가지고있는 일급 컬렉션 Cars 클래스 구현
  - List<Car>를 순회하며 자동차가 움직일수있을때 움직이는 메서드 구현
  - List<Car>를 순회하며 포지션이 가장 큰 자동차 이름 리스트를 반환하는 메서드 구현
  - List<Car>를 순회하며 Car의 상태를 출력하는 메소드 구현


-[x] 경주게임을 시도할 숫자를 가지고있는 RaceRound 클래스 구현
  - 생성자에서 validateInput 메소드로 검증
    - 경주게임을 시도할 숫자는 int여야 한다. int로 변환 실패시 IllegalArgumentException 반환


-[x] 입력값을 파싱하는 Parser 인터페이스 구현
  -[x] 자동차의 이름을 파싱하는 InputCarNameParser 클래스 구현


-[x] 사용자로부터 자동차이름과 경주게임을 시도할 숫자를 입력받는 InputReader 클래스 구현
  - 값을 읽고 파싱한뒤 자동차 이름 리스트를 반환하는 메서드 구현
  - 값을 읽고 경주게임을 시도할값을 반환하는 메서드 구현


-[x] 사용자에게 값 입력을 유도하는 대사와 함께 InputReader를 통해 값을 입력받는 InputView 클래스 구현
  - 자동차 이름을 입력해달라는 대사와 함께 InputReader를 통해 값을 입력받는 메서드 구현
  - 게임을 시도할 회수를 입력해달라는 대사와 함께 InputReader를 통해 값을 입력받는 메서드 구현


-[x] 사용자에게 게임결과와 우승자를 반환하는 OutputView 클래스 구현
  - 게임의 실행결과를 반환하는 메서드 구현
  - 게임의 최종 우승자를 반환하는 메서드 구현


-[x] 여러 클래스를 조합하여 실제 게임을 실행하는 GameController 클래스 구현
