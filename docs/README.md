# 기능내역서

## Models
- ### CarRepository (Car를 리스트로 관리하는 클래스)
- [x] CarList 초기화 기능
- [x] CarList에 Car객체 추가 기능
- [x] CarList 각 객체의 go명령 기능
- [x] CarList 반환 기능
- [x] CarList의 우승 스코어를 계산 및 우승 CarList를 반환 기능
- ### Car
- [x] Car의 이름과 스코어 저장 기능
- [x] Random.pickNumber를 통한 go여부 판단 기능
- [x] getter (Name, Go) 기능

## View
- ### InputView
- [x] Car 이름을 입력받는 기능
- [x] 실행 횟수를 입력받는 기능
- ### OutputView
- [x] Car의 각 실행결과를 출력하는 기능
- [x] 최종 우승자를 출력하는 기능

## Controller
- ### RacingController
- [x] Model과 View를 중개하며 레이싱게임을 컨트롤하는 기능

## Util
- ### StringUtil
- [x] ','로 구분되는 Car이름을 List의 형태로 변환하는 기능
- [x] 전달받은 List를 ','로 구분되는 String형태로 변환하는 기능
- [x] 전달받은 String형의 숫자를 int형으로 변환하는 기능
- ### Validator
- [x] 입력받은 CarName에 대하여 5자 이하인지 판별하는 기능
- [x] 입력받은 String형의 숫자가 int형으로 변환 가능한지 판별하는 기능

## Constant
- ### Message
- [x] View를 통해 출력시 사용될 출력 멘트 저장