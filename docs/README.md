## 구현 기능

### Input 객체
- inputString 함수
    - 메시지를 받아 출력 후 콘솔에서 입력 값을 받아오는 메소드

- inputCarName 함수
    - ,로 구분된 자동차 이름을 입력 받아 검증 후 문자열 리스트로 변환

- inputTotalTurn 함수
    - 0을 제외한 양의 정수를 입력 받아 검증 후 int로 변환


### Validator 객체
- validateCarNameInput 함수
    - 자동차 이름 입력 받은 값을 split하기 전 유효한 값인 지 확인하는 함수
        - 중복된 이름이 포함되어 있는가?
        - 1대 이상 입력되었는가?

- validateCheckCarName 함수
    - 자동차 이름 입력 받은 값이 유효한 지 확인하는 함수
        - 1자 이상 5자 이하인가?
        - 공백이 포함되어 있는가?

- validateTotalTurnInput 함수
    - 라운드 입력 받은 값이 유효한 지 확인하는 함수
        - 0을 제외한 양의 정수인가?


### Car 객체
- carName 변수
    - 자동차 이름을 저장하는 변수
    - String

- forward 변수
    - 전진 횟수를 저장하는 변수
    - StringBuilder
        - "-"의 개수로 관리
        - 사용 이유 "-"의 출력 간편화


- isForward 함수
    - 전진 확인 하는 함수
    - 0~9 난수 발 생 후 4이상일 시 전진

- toString 함수
    - Car 정보를 출력하는 함수

- getForwardSize 함수
    - 몇 번 전진했는지 반환 하는 함수

- getCarName 함수
    - 자동차의 이름을 반환하는 함수


### GameUtil
- carList 변수
    - 자동차의 정보를 관리하는 List
    - List

- totalRound 변수
    - 전체 라운드 저장
    - int

- nowRound 변수
    - 현재 라운드 저장
    - int



- initGame 함수
    - 게임을 생성하는 함수

- initRound 함수
    - 라운드 입력 및 설정하는 함수

- initCar 함수
    - 자동차 이름 입력 및 생성하는 함수

- checkGameOver 함수
    - 게임이 종료되는지 확인하는 함수

- startRound 함수
    - 라운드 시작하는 함수

- showResults 함수
    - 라운드가 끝난 후 결과를 출력하는 함수

- showWinners 함수
    - 게임이 종료된 후 우승자를 출력하는 함수

- findMax 함수
    - 자동차 배열에서 최대 전진 횟수 찾는 함수

- findWinner 함수
    - 최대 전진 횟수를 바탕으로 우승자를 찾는 함수


### RacingCarGame 객체
- run 함수
    - 게임의 전반적인 진행하는 함수


## 진행 사항
- [X] Validator 객체
- [ ] Input 객체
- [ ] Car 객체
- [ ] GameUtil 객체
- [ ] RacingCarGame 객체