# 🏁 컨트롤러

## 📘 RacingGame

`Game`를 구현

- [x] `차의 이름들` 요구 및 입력
    - `차의 이름들` 요구 메시지 출력
    - `차의 이름들` 입력
    - 입력값을 기반으로 `Cars` 객체를 생성
- [x] `라운드 횟수` 요구 및 입력
    - `라운드 횟수` 요구 메시지 출력
    - `라운드 횟수` 입력
    - 입력값을 기반으로 `Round` 객체를 생성
- [x] `실행 결과 메시지` 출력
- [x] `Round`의 횟수만큼 레이스를 반복
    - [x] `Cars`의 진행
    - [x] 라운드 결과 출력
- [x] 우승자들을 출력 : `CarNameDto`

## 📖 Game

게임이라는 **인터페이스**

---

# 🚗 차

## 📚 Cars

`List<Car>` 일급 컬렉션

- [x] `Car`들의 이름과 위치들을 담는 `CarsInformationDto` 반환
- [x] 선두의 `Car`들을 `CarNamesDto`으로 반환
- [x] `Car`들의 이동을 명령

## 📘 Car

차라는 클래스

- [x] 이름과 위치를 담는 `CarInformationDto` 반환
- [x] 차를 이동 (`CarMovementStrategy` 전략 사용)
- [x] `equals()` 오버라이딩

### 📄 CarName

`Car`의 이름

- [x] 이름의 길이 검증

### 📄 CarPosition

`Car`의 위치

- [x] 위치값을 증감

## 📒 CarsGenerator

`Cars`를 만드는 클래스

- [x] `List<String>`을 `Cars`로 변환
    - [x] `String`을 `CarMovementStrategy`전략을 적용하여 `Car`로 변환

## 📖 CarMovementStrategy

`Car`의 움직임에 대한 전략 **인터페이스**

- 증감값을 반환

## 📘 MoveForwardOnceRandomlyStrategy

`CarMovementStrategy`를 구현

- [x] 랜덤값에 대해 증감값을 반환
    - 4 이상 일 경우 `1` 반환
    - 아니라면 `0` 반환

---

# 🔴 라운드

## 📕 Round

라운드 횟수에 대한 클래스

- [x] 라운드 값이 양수인지 검증
- [x] 라운드를 더 진행하는가를 반환
    - [x] 현재 라운드 횟수 증가

---

# ✉️ 메시지

## 📝 Messenger

메시지를 반환하는 클래스

- [x] 자동차 이름 입력 요구 메시지 반환
- [x] 시도할 회수 요구 메시지 반환
- [x] 실행 결과 메시지 반환
- [x] 라운드 결과 반환
- [x] 최종 우승자 메시지 반환

## 📝 MessengerConstants

`Messenger` 관련 상수

  - `REQUEST_CAR_NAMES_FORMAT` : 차 이름 조건 메시지 포맷 : `경주할 자동차 이름을 입력하세요.(이름은 %s(%s) 기준으로 구분)`
  - `CAR_NAMES_DELIMITER_DESCRIPTION` : 차 이름들 구분자 설명
  - `CAR_NAMES_DELIMITER` : 차 이름들 구분자
  - `REQUEST_ROUND_COUNT` : `시도할 회수는 몇회인가요?`
  - `PLAY_RESULT_MESSAGE` : `\n실행결과`
  - `CAR_INFORMATION_FORMAT` : 차 정보 메시지 : `%s : %s`
  - `CAR_POSITION_PRESENTER` : 차 위치 표현자 : `-`
  - `WINNER_FORMAT` : `최종 우승자 : %s`
  - `WINNERS_DELIMITER` :  : `, `

---

# 📚 DTO

## 🗂️ CarsInformationDto

- `List<CarInformationDto>`

## 🗂️ CarInformationDto

- `String name`
- `int position`

## 🗂️ CarNamesDto

- `List<String> name`

---

# 💻 뷰

## 📘 ConsoleInputView

`InputView` 구현

- 문자열 입력 구현

## 📖 InputView

입력 **인터페이스**

- 문자열 입력

## 📘 ConsoleOutputView

`OutputView` 구현

- 문자열 출력 구현

## 📖 OutputView

출력 **인터페이스**

- 문자열 출력

---

# 🧰 유틸리티

## 🛠️ Convertor

- `String` -> `int`
- `String` -> `List<String>` : 구분자 사용
- `List<String>` -> `trim` 수행
