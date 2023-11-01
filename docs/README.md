## 전체 흐름

- 사용자에게 자동차 이름을 입력받습니다.
- 사용자에게 진행할 횟수를 입력받습니다.
- 한 라운드마다 각각의 자동차가 랜덤값에 의해 전진하거나 멈춰있습니다.
- 입력 받은 횟수만큼 라운드를 반복합니다.
- 가장 전진을 많이한 자동차들의 이름을 출력합니다.

## 구현할 기능 목록

### Ver.1

- 사용자에게 자동차 이름을 입력받아 ',' 단위로 나누는 기능
  - 나눠진 문자열의 개수를 검사하는 기능 (최소 2개, 최대 5개)
  - 나눠진 문자열의 중복 여부를 검사하는 기능
- 입력받은 이름으로 자동차를 생성하는 기능
  - 자동차 이름의 공백 여부와 길이 유효성을 검사하는 기능 (공백 불가, 최대 5글자)
- 사용자에게 시도 횟수를 입력받는 기능
  - 시도 횟수의 최소값과 최대값을 검사하는 기능 (최소 1, 최대 30)
- 자동차와 시도 횟수로 게임 초기 세팅을 하는 기능


- 게임 설정에 따라 라운드를 반복하는 기능
- 모든 자동차의 라운드를 1회 진행하는 기능
- 자동차가 전진하는 기능
- 자동차가 전진할지 결정하는 기능
- 우승 자동차를 결정하는 기능
- 우승 자동차의 이름을 문자열로 만드는 기능

- 게임 메세지를 출력하는 기능

### Ver.2
- 시간을 지연시키는 기능 (전략 패턴 적용)

## 구현할 클래스 목록

### Ver.1 
- 자동차 경주 게임 컨트롤러 (RacingCarGameController)
  - -[RacingCarGameMachine] 자동차 경주 게임 머신
- 자동차 경주 게임 머신 (RacingCarGameMachine)
  - -[List] 참여 자동차 저장 리스트
  - -[int] 시도 횟수
- 자동차 경주 게임 머신 유효성 검사기 (RacingCarGameMachineValidator)
  - -[int] 자동차 최소 개수
  - -[int] 자동차 최대 개수
  - -[int] 라운드 최소 진행 횟수
  - -[int] 라운드 최대 진행 횟수
- 자동차 (RacingCar)
  - -[String] 자동차 이름
  - -[int] 현재 전진 횟수
  - -[String] 전진 횟수에 따른 문자열
- 자동차 유효성 검사기 (RacingCarValidator)
  - -[int] 자동차 이름 최소 길이
  - -[int] 자동차 이름 최대 길이
- 출력기 (OutputView)
- 출력 메세지 문자열 모음 enum (OutputMessage)
  - -[String] 메세지
- 에러 메세지 문자열 모음 enum (ErrorMessage)
  - -[String] 메세지

### Ver.2
#### 추가사항
- 랜덤 숫자 생성기 (RandomNumberGenerator)
- 시간 지연기 (TimeSleepStrategy)
- 고정 숫자 상수 모음 enum (FixedNumber)

#### 수정사항
- 자동차 경주 게임 컨트롤러 (RacingCarGameController)
  - -[RacingCarGameMachine] 자동차 경주 게임 머신
  - **-[TimeSleepStrategy] 시간 지연기**
  - **-[OutputView] 출력기**
  - **-[InputView] 입력기**
- 자동차 경주 게임 머신 (RacingCarGameMachine)
  - -[List] 참여 자동차 저장 리스트
  - -[int] 시도 횟수
  - -[int] 현재 라운드
  - **[RandomNumberGenerator]랜덤 숫자 생성기**
- 자동차 유효성 검사기 (RacingCarValidator)
  - ~~-[int] 자동차 이름 최소 길이~~
  - ~~-[int] 자동차 이름 최대 길이~~
- 자동차 경주 게임 머신 유효성 검사기 (RacingCarGameMachineValidator)
  - ~~-[int] 자동차 최소 개수~~
  - ~~-[int] 자동차 최대 개수~~
  - ~~-[int] 라운드 최소 진행 횟수~~
  - ~~-[int] 라운드 최대 진행 횟수~~