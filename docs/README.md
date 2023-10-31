# 🚀 기능 요구 사항 - 자동차 경주 게임

# 📍MVC 모델
## Model
### Car
- [x] 자동차의 전체 상태를 관리함
- [x] Random값을 통한 자동차의 움직임 기능

### Race
- [x] 여러 대의 자동차를 관리
- [x] 라운드를 진행하며 자동차를 움직이는 기능
- [x] 우승자를 결정하는 기능

## View
### InputView
- [x] 사용자로부터 자동차 이름을 입력 받음
- [x] 사용자로부터 시도 횟수를 입력 받음

### OutputView
- [x] 게임 시작 메시지 출력
- [x] 각 턴의 결과를 출력
- [x] 최종 우승자를 출력

## Controller
- [ ] 게임을 시작하고 종료
- [ ] Car 객체를 초기화
- [ ] 게임의 전체 진행을 컨트롤함

## Validator
### CarNameValidator
- [x] 자동차 이름의 유효성을 검증
    - [x] 이름 길이 검증
    - [x] 중복 검증
    - [x] 공백 검증
    - [x] 알파벳 형식 검증

### NumberValidator
- [ ] 시도 횟수의 유효성을 검증
    - [x] 숫자 인지 검증
    - [ ] 양수 여부 검증
    - [ ] 공백 검증

## Constant
- [x] 게임 내에서 사용되는 메시지 문자열 상수 관리
    - [x] 에러 메시지 관리
    - [x] 게임 관련 메시지 관리
    - [x] 숫자 관리

## 예외 처리
- [ ] CAR_NAME_LENGTH_ERROR: 자동차 이름은 1~5자 이하만 가능
- [ ] CAR_NAME_DUPLICATE_ERROR: 자동차 이름은 중복될 수 없음
- [ ] CAR_NAME_EMPTY_ERROR: 자동차 이름은 공백일 수 없음
- [ ] CAR_NAME_FORMAT_ERROR: 자동차 이름은 알파벳만 가능
- [ ] ATTEMPTS_FORMAT_ERROR: 시도 횟수는 숫자만 가능
- [ ] ATTEMPTS_EMPTY_ERROR: 시도 횟수는 공백일 수 없음
- [ ] INVALID_ATTEMPTS_ERROR: 유효하지 않은 시도 횟수

## 프로그래밍 요구 사항
- [ ] JDK 17 버전에서 실행 가능한지 확인
- [ ] 프로그램 시작점은 Application의 main() 메서드인지 확인
- [ ] build.gradle 파일을 변경하지 않았는지 확인
- [ ] 외부 라이브러리를 사용하지 않았는지 확인
- [ ] Java 코드 컨벤션 가이드를 준수했는지 확인
- [ ] 프로그램 종료 시 System.exit()를 호출하지 않았는지 확인
- [ ] ApplicationTest의 모든 테스트가 성공하는지 확인

## 추가된 요구 사항
- [ ] indent(들여쓰기) depth가 3을 넘지 않았는지 확인
- [ ] 3항 연산자를 사용하지 않았는지 확인
- [ ] 함수(또는 메서드)가 한 가지 일만 하도록 작게 만들었는지 확인
- [ ] 기능 목록이 정상 동작하는 테스트 코드를 작성했는지 확인