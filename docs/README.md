# 기능 목록

## 게임 준비

- 경주 할 자동차 이름 입력 요청 메세지 출력
- 경주 할 자동차 이름 입력
  - 이름은 쉼표 기준으로 구분하며 5자 이하만 가능 
- 자동차 이름 입력에 따른 새로운 자동차 생성
  - 자동차는 이름, 현재 위치 정보를 가짐
- 시도할 횟수 입력 요청 메세지 출력
- 시도할 횟수 입력

## 게임 진행

- 자동차의 전진 조건 판단
  - 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4이상일 경우
- 자동차 전진 조건에 따른 자동차 위치 변화
- 자동차 각각의 실행 결과 출력 
  - 자동차 이름과 함께 출력, 주어진 시도 횟수만큼 반복

## 게임 종료

- 최종 우승자 결정
- 최종 우승자 출력
  - 우승자가 여러 명일 경우 쉼표를 이용하여 구분

# 클래스 설명

- config
  - GameConfig : 클래스 사이의 의존 관계 설정을 위한 클래스
- constant
  - NumberConstant : 숫자 관련 상수를 관리하기 위한 Enum 클래스
  - TextConstant : 문자열 관련 상수를 관리하기 위한 Enum 클래스
  - ExceptionConstant : 예외 처리 메세지 상수를 관리하기 위한 Enum 클래스
- domain
  - RacingCar : 자동차 정보(자동차 이름, 현재 위치, 현재 포인트)를 가지고 있고 상세 구현 로직을 담당하는 클래스
  - RacingCarRace : 경주 정보(경주에 참가한 자동차, 시도 횟수)를 가지고 있고 상세 구현 로직을 담당하는 클래스
- view
  - MessagePrinter : 메세지 출력을 담당하는 클래스
  - MessageReceiver : 메세지 입력을 담당하는 클래스
- GameManager : 전체적인 비즈니스 로직 흐름을 파악할 수 있는 클래스
- Application : 코드를 실행하는 main 클래스

# 예외 처리

- 자동차 이름
  - 아무것도 입력하지 않음 : READ_LINE_EXCEPTION
  - 쉼표만 입력 : CAR_NAME_NOT_EXIST_EXCEPTION
  - 1자 이상 5자 이하로 입력하지 않은 이름 : CAR_NAME_LENGTH_EXCEPTION 
  - 중복된 이름 : CAR_NAME_DUPLICATION_EXCEPTION

- 시도 횟수
  - 아무것도 입력하지 않음 : READ_LINE_EXCEPTION
  - 숫자를 입력하지 않음 : NUMBER_FORMAT_EXCEPTION
  - 1보다 작은 수 입력 : ATTEMPT_COUNT_EXCEPTION