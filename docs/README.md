## 미션 - 자동차 경주
## 기능 목록
### RacingGameController
- 도메인과 뷰 사이의 흐름을 관리한다.
- [x] 자동차 이름들, 횟수를 입력 받는다.
- [x] 입력받은 이름들의 검증을 거쳐 객체 생성을 요청한다.
- [x] 입력받은 횟수의 검증을 거쳐 게임을 진행한다.
- [x] 게임이 종료되면 우승자를 판별한다.
- [x] 우승자를 출력한다.
### Car
- 이름과 위치를 가진 객체이다.
  - [x] 랜덤으로 생성된 값을 바탕으로 이동한다.
    - 값이 4 이상이면 전진한다.
### Cars
- 자동차 리스트를 가진 객체이다.
  - [x] 자동차들을 움직이게 한다.
  - [x] 우승자를 판별한다.
### Converter
- 입력받은 자동차 이름들의 문자열을 List로 변환 한다.
### RandomNumberGenerator
- 0 ~ 9 까지 숫자 중 한 개의 무작위 번호를 만들어낸다.
### InputValidator
- 아래의 경우 `IllegalArgumentException` 을 발생시킨다.
  - [x] 횟수가 정수가 아닐경우
  - [x] 횟수가 1이상이 아닐경우
  - [x] 이름이 1글자 이상 5글자 이하가 아닐경우
### InputView
- [x] 쉼표(,)를 기준으로 자동차의 이름을 입력한다.
- [x] 몇 번의 이동을 할 것인지 횟수를 입력한다.
### OutputView
- [x] 횟수마다 자동차들을 움직인 결과를 출력한다.
- [x] 우승자를 출력한다.

## 상수 목록 (Enum Class)
### CarConstant
자동차 객체에 사용 되는 상수들을 모아놓은 Enum 클래스   
`MIN_NAME_LENGTH` = 1   
`MAX_NAME_LENGTH` = 5  
`CAN_FORWARD_NUMBER` = 4
### ConverterConstant
`DELIMITER` = ","   
### ExceptionMessage
`IllegalArgumentException` 발생시 출력되는 메시지를 모아놓은 Enum 클래스
`INVALID_NAME_LENGTH_EXCEPTION_MESSAGE` = "자동차의 이름 길이는 1이상 5이하입니다."  
`INVALID_ATTEMPT_NUMBER_RANGE_EXCEPTION_MESSAGE` = "시도 횟수는 1이상입니다."
`INVALID_NUMBER_EXCEPTION_MESSAGE` = "숫자만 입력 가능합니다."
### InputMessage
`INPUT_CAR_NAMES_MESSAGE` = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"   
`INPUT_ATTEMPT_NUMBER_MESSAGE` = "시도할 회수는 몇회인가요?"
### OutputMessage
`WINNER_MESSAGE` = "최종 우승자 : "   
`RESULT_MESSAGE` = "\n실행 결과"   
`COLON` = " : "   
`DASH` = "-"   
`JOIN_DELIMITER` = ", "
### RaceConstant
자동차 경주 게임 진행에 필요한 상수들을 모아놓은 Enum 클래스   
`MIN_ATTEMPT_NUMBER` = 1      
`MIN_RANDOM_NUMBER` = 0   
`MAX_RANDOM_NUMBER` = 9
### RegexConstant
`DIGIT` = "^[0-9]+$"

## 주의 할 점 !
- 우승자는 1명 이상일 수 있다.
- `indent depth` 은 최대 2로 유지한다.
- 함수가 한 가지 일만 하도록 작게 만든다.
- 테스트 코드로 기능을 확인하자!