## 🎯️ 구현할 기능 목록 정리하기

### ✅ 기능 목록 (❗한 가지 기능만 수행 해야 한다❗)

##

#### 게임 환경설정 상수 관리 역할(ConfigurationConstants)

- [x] 자동차 최소 개수
- [x] 자동차 최대 개수
- [x] 자동차 최대 이름 길이
- [x] 최소 시도 횟수
- [x] 최대 시도 횟수

##

#### 게임 관리자 역할 (GameController)

- [x] 자동차 게임을 순서에 맞게 실행하는 기능 `public`
- [x] 자동차들을 경주 준비하는 기능 `private`
- [x] 레이싱 게임을 진행하는 기능 `private`
- [x] 1회 레이싱 게임 결과를 OutputView에게 전달하는 기능 `private`
- [x] 최종 우승자 결과를 OutputView에게 전달하는 기능 `private`

##

#### 자동차 역할 (Car)

- [x] 전진 하는 기능 `public`
- [x] 위치 getter `public`
- [x] 이름 getter `public`
- [x] 최대 위치인지 학인하는 기능 `public`
- [x] 전진 가능한지 확인하는 기능 (엔진 시동 결과가 4 이상이다) `private`
- [x] 엔진 시동을 거는 기능 `private`

##

#### 자동차 이름 역할 (CarName)

- [x] 자동차 이름의 유효성 검증 기능 `private`
    - [x] 콤마가 존재해선 안된다
    - [x] 공백으로만 존재해선 안된다
    - [x] 길이 1 ~ 5 사이여야 한다

##

#### 엔진 역할 (WootecoCarEngine) `Engine 인터페이스를 구현한 구현체`

- [x] 0 ~ 9 사이에서 무작위 값을 생성한다 `public`

##

#### 자동차들을 리스트로 관리하는 역할 (RacingCars)

- [x] 경주를 진행하는 기능 `public`
- [x] 우승자를 찾는 기능 `public`
- [x] 자동차 리스트로 변환하는 기능 `private`
- [x] 최대 이동 횟수를 계산하는 기능 `private`
- [x] 자동차 중복 검증 기능 `private`
- [x] 자동차 개수 검증 기능 `private`

##

#### 게임 서비스 역할 (RacingGameService)

- [x] 경주 1회를 진행하는 기능 `public`
    - RacingCars에게 경주를 요청하여 결과 DTO를 반환한다
- [x] 최종 우승자를 찾는 기능 `public`
    - RacingCars에게 우승자 찾기를 요청하여 우승자 이름 리스트를 반환한다

##

#### 경주 1회 결과들을 담고 있는 역할 (OneGameResultsDto)

- [x] 필드: List< ResultDto > results
- [x] ResultDto 리스트 getter `public`
- [x] 움직임 횟수 리스트 getter `public`
- [x] 자동차들을 ResultDto 리스트로 변환하는 기능 `private`

##

#### 경주 1회 결과를 담고 있는 역할 (ResultDto)

- [x] 필드: String name, int position
- [x] 이름 getter `public`
- [x] 움직임 횟수 getter `public`

##

#### 게임 유틸 역할 (GameUtil)

- [x] 입력 받은 자동차의 이름을 쉼표로 구분하는 기능 `public`

##

#### 출력 화면 역할 (OutputView)

- [x] 실행 결과 텍스트 출력 기능 `public`
    - 실행 결과
- [x] 경주 1회 결과 출력 기능 `public`
    - 이름A : -
    - 이름B : --
- [x] 최종 우승자 출력 기능 `public`
    - 최종 우승자 : 이름B

##

#### 입력 화면 역할 (InputView)

- [x] 경주할 자동차 이름 입력 화면 기능 `public`
    - 경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)
- [x] 시도 횟수를 입력 화면 기능 `public`
    - 시도할 회수는 몇회인가요?

##

#### 시도 횟수 입력 검증 역할 (TotalRoundInputValidator)

```
1️⃣ 추정할 수 있는 예외
1. 문자가 아닌 숫자만 입력 가능
2. 음수는 불가
3. 0도 불가
   ∵ 일반적으로 0회 시도하려고 게임을 진행하진 않는다

2️⃣ 추정하기 어려운 예외
1. 자동차 경주 최대 시도 횟수
- Long, Integer 최대 값으로 경주를 시도하는 것은 무리가 있다
   ∵ 일반적으로 1억 연산을 1초로 가정한다. 경주 1회를 수행하는데만 20초 x 자동차 수 만큼 소요될 것이다
-> 임의의 범위(1회 ~ 10회 시도) 를 정해서 방어적인 코드를 짤 것
```

- [x] 검증 기능 `public`
- [x] 숫자가 아닌 문자 검증 기능 `private`
- [x] 정수형 숫자 검증 기능 `private`
- [x] 유효한 범위 1 ~ 10회 검증 기능 `private`
- [x] 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨다

##

#### 자동차 이름 입력 검증 역할 (CarNamesInputValidator)

```
1️⃣ 파악할 수 있는 예외
1. 이름에 쉼표가 있으면 안된다
   ∵ 쉼표로 이름을 구분
2. 이름은 5자 이하만 가능하다

2️⃣ 추정할 수 있는 예외
1. 특수문자와 공백이 포함돼도 좋다
2. 단, 공백만으로 이루어져선 안된다
   ∵ 콘솔창에서 자동차 이름이 구분이 안됨

3️⃣ 추정하기 어려운 예외
1. 자동차 이름 중복 가능 여부
   ∵ 기획자와 상의해야할 영역
-> 중복이 불가하도록 방어적인 코드를 짤 것

2. 자동차의 최대 개수
   ∵ 기획자와 상의해야할 영역
-> 최대 개수를 10개로 제한해서 방어적인 코드를 짤 것
```

- [x] 검증 기능 `public`
- [x] 입력이 공백인지 검증 기능 `private`
- [x] 입력의 맨 처음 글자가 콤마(,) 인지 검증 기능 `private`
- [x] 입력의 맨 마지막 글자가 콤마(,) 인지 검증 기능 `private`
- [x] 공백 이름 검증 기능 `private`
- [x] 길이 5 초과 이름 검증 기능 `private`
- [x] 중복 이름 검증 기능 `private`
- [x] 자동차 개수 1 ~ 10개 검증 기능 `private`
- [x] 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨다

##

#### 자동차 관련 예외 메시지 관리 역할 (CarExceptionMessage)

- [x] 자동차 관련 예외 메시지
    - 공백 입력을 해선 안됩니다
    - "자동차 이름은 공백으로만 이루어져선 안됩니다
    - "중복된 자동차 이름이 존재합니다
    - "자동차 이름에 콤마(,)가 있으면 안됩니다
    - "자동차 이름 길이는 1 ~ 5 자리 이어야 합니다
    - "자동차 이름은 1 ~ 5 개만 입력 가능합니다
- [x] 예외 메시지 getter `public`

##

#### 시도횟수 관련 예외 메시지 관리 역할 (TotalRoundInputExceptionMessage)

- [x] 경주 시도횟수 입력 예외 메시지
    - 숫자만 입력해야 합니다
    - 정수 범위 숫자만 입력해야 합니다
    - 1 ~ 10 사이의 수만 입력 가능합니다
- [x] 예외 메시지 getter `public`

<br>  </br>

##

### ✅ TODO: 테스트할 기능 목록 정리

#### 자동차 역할 (Car)

- [x] 자동차 전진 기능 `public`

##

#### 자동차 이름 입력 검증 역할 (CarNamesInputValidator)

- [x] 자동차 이름 입력 검증 기능 `public`

##

#### 게임 유틸 역할 (GameUtil)

- [x] 자동차 이름 쉽표 구분 유틸 기능 `public`

##

#### 게임 서비스 역할 (RacingGameService)

- [x] 경주 1회를 진행하는 기능 `public`
- [x] 최종 우승자를 계산하는 기능 `public`