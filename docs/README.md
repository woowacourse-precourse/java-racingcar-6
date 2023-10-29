# 구현할 기능 목록

## **💡View**

### **입력**

- **경주 할 자동차 이름**
    - 자동차 이름은 쉼표(,)를 기분으로 구분
    - 각 자동차의 이름은 5자 이하 (비즈니스 검증)
    - 자동차의 이름은 빈 값이 될 수 없다. (비즈니스 검증)
    - 자동차의 이름은 중복이 없어야 함 (비즈니스 검증)
    - 빈 값을 입력할 수 없음 (유효성 검증)
- **시도할 회수**
    - 1 이상의 숫자 (비즈니스 검증)
    - 문자 불가능 (유효성 검증)

### 출력

- 자동차 이름 입력 안내 메시지
    - “경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)”
- 시도횟수 입력 안내 메시지
    - “시도할 회수는 몇회인가요?”
- 실행 결과 안내 메시지
    - “실행 결과”
- 실행 결과 메시지
    - *carName* + “ : “ + *전진 횟수만큼 “-”*
    - pobi : -
      woni :
      jun : -

  pobi : --
  woni : -
  jun : --
- 최종 우승자 안내 문구 메시지
    - 단독우승 case : “최종 우승자 : “ + carName
    - 공동우승 case : “최종 우승자 : “ + carName1 + “, “ + carName2

## **💡Model**

- Car : 실제 경주를 하는 객체
    - 이름과 전진한 횟수를 **필드**로 가진다.
    - Car 이름이 5자 이하면 예외를 던진다. (비즈니스 검증)
    - 전진한 횟수를 변경하는 메소드를 가진다.
- Cars : 실제 경주를 하는 객체인 Car의 일급 컬렉션
    - Car을 컬렉션 형태로서, 필드로 가진다.
    - 자동차 이름들 중 빈 값이 있으면 예외를 던진다. (비즈니스 검증)
    - 자동차 이름들 중 중복이 있으면 예외를 던진다. (비즈니스 검증)
    - 컬렉션 필드를 순회하여 Car들의 전진한 횟수를 변경하는 메소드를 가진다.
- Status : 두 개의 열거 상수(GO와 STOP)를 가지는 Enum 클래스
    - 자동차의 step을 올릴 지 말 지 결정하는 메소드를 가진다.
        - 1~9사이의 숫자를 랜덤하게 골라 4이상인 경우 GO(1)을 리턴, 그렇지 않으면 STOP(0)을 리턴
- Referee : 우승자를 결정하는 객체
    - 우승자의 이름들을 컬렉션 형태로서, 필드로 가진다.
    - 우승자의 이름들을 리턴하는 메소드를 가진다.
    - 승자를 결정하여 우승자의 이름들에 대한 필드값을 저장하는 메소드를 가진다.
- RacingGame : 레이싱 게임을 주관하는 객체로 Cars와 Refree를 의존한다.
    - Cars를 한 1 세션 움직이도록 하는 메소드를 가진다.
    - Cars를 한 1 세션 움직인 후 결과를 받아와 컨트롤러에게 넘기는 메소드를 가진다.
    - Referee에서 우승자를 결정하여 우승자들의 이름을 받아와 컨트롤러에게 넘기는 메소드를 가진다.

## 💡 입력값에 대한 유효성 검증 Validator

- 자동차 이름 입력
    - 사용자가 빈 값을 입력한 경우 IllegalArgumentException을 던진다.
- 시도 횟수 입력
    - 사용자가 빈 값을 입력한 경우 IllegalArgumentException을 던진다.
    - 사용자가 문자를 입력한 경우 IllegalArgumentException을 던진다.

## 💡 입력값에 대한 비즈니스 검증 Validator

- 자동차 이름 하나에 대한 검증
    - 자동차 이름이 5자 이하인 경우 IllegalArgumentException을 던진다.
- 전체 자동차 이름에 대한 검증
    - 입력한 자동차이름에 빈 값이 포함되어 있는 경우 IllegalArgumentException을 던진다.
        - ex) “,pobi,doni” → “”, “pobi”, “doni” → 빈 값 포함
- 시도횟수에 대한 검증
    - 시도 횟수가 1보다 작은 경우 IllegalArgumentException을 던진다.

## **💡 입력한 값(String)을 처리하기 쉽게 변환해주는 Converter**

- 사용자가 입력한 자동차 이름을 List<String> 형태로 변환해주는 기능
- 사용자가 입력한 시도횟수를 Integer로 변환해주는 기능

## 💡Controller

- Model과 View 사이에 존재하여 두 계층간의 상호작용을 돕는다.
- 자동차들의 이름과, 시도 횟수를 View로부터 받는다.
- View로부터 받은 값을 유효성 검증한다.
- 검증된 값을 변환하여 RacingGame에게 넘겨준다.
- RacingGame으로부터 받은 실행 결과를 DTO로 변환한다.
- DTO로 변환한 데이터를 View에게 넘겨준다.
- 사용자의 입력값을 받은 후, Model에게 넘겨준다.
    - (InputView → Controller → Model)
- Model에서 수행한 결과를 DTO형태로 받아 View에게 넘긴다.
    - (Model —(DTO) → OutputView)

## 💡VO(Value Object)

- TryNumber : 시도횟수에 대한 VO
    - Integer number 필드
- CarName : 자동차 이름에 대한 VO
    - String carName 필드
- CarDistance : 자동차가 움직인 거리에 대한 VO
    - Integer distance 필드

## 💡DTO(Data-Transfer-Object)

- CarDto : Cars를 DTO로 변환 후 리스트 형태로 리턴하는 메소드를 가진다.