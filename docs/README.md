## 📝 구현 대상

### 자동차 경주

### - 클래스 다이어그램 예상 및 고안

<img src="img/Initial_ClassDiagram.png">

### - 기능 목록 정리

- SystemConstant 클래스
    1. 시스템 관련 상수를 저장하는 기능
       <br> <br>
- ExceptionMessage 클래스
    1. 시스템 관련 에러 메시지를 저장하는 기능
       <br><br>
- CarNameVerifier 클래스
    1. 길이기 1자 이상 5자 이하만 가능한지 체크하는 기능
       <br><br>
- AttemptsVerifier 클래스
    1. 시도 횟수가 숫자로 입력되었는지 체크하는 기능
    2. 시도 횟수가 양의 정수로 입력되었는지 체크하는 기능
       <br><br>
- InputView 클래스
    1. 경주할 자동차의 이름들 입력받는 기능
    2. 시도할 회수 입력 받는 기능
       <br><br>
- OutputView 클래스
    1. 게임 시작 메시지를 출력하는 기능
    2. 라운드마다 출력 메시지를 만드는 기능
    3. 최종 우승자 출력 메시지를 만드는 기능
    4. 구간(라운드)마다 실행 결과를 출력하는 기능
    5. 최종 우승자들을 출력하는 기능
       <br><br>
- Car 클래스
    1. 자동차(자신) 이름을 반환하는 기능
    2. 이동한 총 거리 반환하는 기능
    3. 전진하는 기능
    4. 멈춰있는 기능
       <br><br>
- Referee 클래스
    1. 가장 큰 총 이동 거리를 찾아 반환하는 기능
    2. 우승자를 판단하여 이름을 반환하는 기능
       <br><br>
- RoundManager 클래스
    1. 자동차들의 전진 여부를 랜덤 값을 바탕으로 결정
    2. 전진 여부를 바탕으로 자동차를 이동/정지시키는 기능
       <br><br>
- RandomNumberGenerator
    1. 각 자동차에 대해 전진 여부 결정하는 (0~9) 무작위 값 생성
       <br><br>
- GameManager 클래스
    1. 게임 초기화 기능
    2. 게임 실행(run) 기능
        1. gameStart 기능
        2. gameRunning 기능
        3. gameEnd 기능
           <br><br>

### 최종 구현 후 클래스 다이어그램
<img src = "img/Final_ClassDiagram.png">