기능 요구 사항 분석
        
        1. 사용자 입력으로 쉼표(,)를 기준으로 나눈다.
            - 각각의 이름은 5자 이내여야 하고 잘못된 값일 경우 IllegalArgumentException을 발생한다.

        2. 사용자 입력으로 시도할 횟수를 숫자로 입력받는다
            - 숫자가 아닐 경우 IllegalArgumentException을 발생한다.

        3. 각각의 자동차는 0~9사이의 무작위 값을 가지고, 그 수가 4 이상일 경우 전진하게 된다.
            - 전진하게되면 차수별 출력하게될 결과에 "-"가 추가된다.
        
        4. 입력받은 시도할 횟수만큼의 차수를 반복하면서 각각의 자동차의 진행 거리를 "-"로 보여준다.

        5. 최종 우승자의 이름을 출력한다.
            - 공동 우승이 가능하다.


- Controller


    - GameManager.java
      1. initGame : 게임 시적
      2. playGame : 게임 시작 시 사동차 이름과 반복 횟수를 입력받음. Car 클래스를 List 자료구조로 저장함. round만큼 게임을 진행함. 게임 마무리 함.
      3. listUp : 입력받은 문자열 자동차 이름과 진행 거리(=0)을 Car 클래스 List에 담음
      4. playRound : 한 개의 라운드 실행. 각 자동차에 대해 난수로 발행한 숫자가 4 이상이면 거리 원래 거리의 +1
      5. playUntilRound : 입력받은 라운드만큼 반복, 중간 결과 출력
      6. finishGame : 최종 우승자 출력

- model


    - Car.java
    1. Car : 경주에 사용되는 자동차의 이름과 거리(=0)를 포함한 생성자 
    2. setDistance
    3. getDistance
    4. setName
    5. getName
    - NumberGenerator.java
    1. generateNumber : 각 라운드에서 각 사용자마다 0~9의 숫자 발생하기 위한 메서드



- util


    - Constant.java
    1. MAX_NAME_LENGTH : 자동차 이름의 길이가 5글자까지 가능하도록 상수 설정
    - InputValidator
    1. isValidInteger : 입력받은 문자열이 숫자로 변환할 시 발생할 수 있는 오류 처리
    2. isValidNameLength : 이름 길이가 5글자를 넘어가면 오류 처리
    - Message
    1. NAME_INPUT_MESSAGE : 게임 시작 시 경주할 자동차 이름을 입력 받을 때 사용하는 메세지
    2. COUNT_INPUT_MESSAGE : 게임 시작 후 자동차가 이동할 횟수 (라운드)를 입력 받을 때 사용하는 메세지
    3. ROUND_RESULT : 각 라운드가 끝날 때마다 라운드 결과를 출력할 때 사용하는 메세지
    4. FINAL_WINNER : 모든 라운드가 끝나고 최종 우승자를 출력할 때 사용하는 메세지
    5. MOVE_PRINT : 자동차가 이동한 거리를 표시하기 위해 사용하는 메세지
    6. INPUT_ERROR_MESSAGE : 에러가 발생하였을 때, 사용하는 메세지


- view


    -InputView
    1. userInputName : 사용자로부터 자동차 이름을 입력 받고 split 함수로 ","를 기준으로 나누어 배열에 담음. 배열에 있는 문자열들에 대해 유효성 검사를 해준다. 
    2. userInputCount : 사용자로부터 반복한 라운드 수를 입력받고 유효성 검사 실시
    - OutputView
    1. printMessage : 사용자가 확인하게 되는 출력을 담당하는 메서드
    2. printGameStartMessage : 게임 시작 후 자동차의 이름 입력 요구 메세지를 출력하는 메서드
    3. printInputNumberMessage : 게임 시작 후 라운드 수 입력 요구 메세지를 출력하는 메서드
    4. printRoundResultMessage : 각 라운드가 끝났을 때 중간 결과를 출력하는 메서드
    5. printGameResultMessage : 모든 라운드가 끝났을 때 우승자를 출력하는 메서드

