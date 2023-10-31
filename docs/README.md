- 기능 요구사항

  - n대의 자동차는 전진 또는 멈출 수 있다. 
  - 각 자동차에 이름을 부여할 수 있다. 
  - 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다. 
  - 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야한다.
  - 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우다. 
  - 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.  
  - 우승자가 여러명일 경우 쉼표(,)를 이용하여 구분한다. #Race / printWinner
  - 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야한다.

## Class
### - Car 클래스
    - 멤버 변수 : name, position
    - 메서드 :
      - getName() : 차 이름 반환
      - setName() : 차 이름 설정
      - drive() : 전진 조건을 체크하고 전진하면 positon 증가
      - getPosition() : 현재 위치 반환
      - shouldMove() : 차가 움직일 수 있는지 판단
      - move() : 차가 움직임
      - calculationDistance() : 이동한 거리를 리턴
      - printPosition() : 현재 포지션 출력

### - UserInput 클래스 
    - 메서드 : 
      - inputMoveCount() : 사용자로부터 이동 횟수 입력 받기
      - inputCarNames() : 사용자에게 자동차 이름 입력 받는 함수
      - numValidation() : 숫자 입력 검증
      - carNamesSplitValidation() : 자동차 이름 입력 검증
      - validateNotNullOrEmpty() : 입력값이 비어있는지 검증
      - validateNameLength() : 입력한 이름의 길이 검증

### - RandomGenerator 클래스
    - 메서드 : 
      - generate() : 0-9 사이의 무작위 값을 반환

### - Race 클래스 (싱글톤 패턴 적용)
    - 멤버 변수 : cars, moveCount
    - 메서드 : 
      - getInstance() : Race에 등록된 차 반환
      - addCar() : 경주에 참가할 자동차 추가
      - start() : 경주 시작
        - inputRaceDetail() : start에서 입력 담당 메소드
        - inputCarNames() : 자동차 이름을 입력받는 메소드
        - initializeCars() : 입력받은 자동차들을 인스턴스화 시키는 메소드
        
        - inputMoveCount() : 시도할 회수를 사용자 입력 받는 메소드
        - runRace() : 실행 결과를 출력하는 메소드
            - moveCars() : 자동차들을 모두 drive 시키는 함수
            - printCarsPosition() : 자동차들의 위치를 출력
        - declareWinner() : 결과와 관련된 함수 기능 분리

      - checkWinner() : 우승자 확인
        - findMaxPosition() : 가장 멀리간 포지션을 찾는 함수
        - getWinners() : 최대 position을 가진 자동차들을 리스트로 반환
        - convertListToString() : 자동차 이름 리스트를 ','로 구분하는 문자열로 반환
      - printWinner() : 최종 우승자 출력
        

 - 규칙
   - [x] 기능 목록 생성
    - [x] 기능 단위로 커밋
   - [X] JDK 17버전에서 작동 가능
    - [X] 프로그램 실행의 시작점은 Application의 main()이다.
   - [X] build.gradle 파일을 변경할 수 없고, 외부 라이브러리를 사용하지 않는다.
    - [X] Java 코드 컨벤션 가이드를 준수하여 프로그래밍
   - [X] 프로그램 종료 시 System.exit()을 호출하지 않음
    - [x] 프로그램 구현이 완료되면 ApplicationTest의 모든 테스트가 성공해야 한다.
   - [x] 프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 이름을 수정하거나 이동하지 않는다.
    - [X] 들여쓰기 depth를 3이 넘지 않도록 구현한다.
   - [X] 3항 연산자 사용하지 않는다.
    - [X] 함수가 한 가지 일만 하도록 최대한 작게 만든다.
    - [x] Test Code로 정상 동작함을 확인한다.
