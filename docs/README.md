# 미션 - 숫자 야구


## 🔍 기능 구현 목록

- n 개의 자동차 이름을 쉼표(,) 기준으로 입력 받는다.
  - 입력 검증 (5자 이하, 2자 이상, notNull)
- 시도될 회수를 입력 받는다.
  - 입력 검증 (숫자, 10번 이하, 1번 이상, notNull)
- 랜덤한 숫자를 만든다. 
  - 랜덤한 숫자가 4 이상인지 판단한다.
- 판단된 결과를 기준으로 차의 움직인다.  
- 실행결과를 차량마다 출력한다.
- 움직인 결과를 바탕으로 우승자를 구한다.
- 우승자를 출력한다.
  - 복수의 우승자는 쉼표(,)를 이용하여 구분 후, 출력한다. 
  
## 📒 클래스 설계
- InputView, OutputView
    - 입력과 출력
- RacingCarInputValidator
    - 검증을 위한 함수형 인터페이스
      - CarNameValidator, TryNumberValidator
          - 입력 값에 대한 검증 구현체
- TryNumberException
  - 시도 회수 입력 예외
- CarNameException
  - 자동차 이름 입력 예외
  #
- Car, Cars
    - 자동차, 자동차 묶음행위에 대한 책임
- RacingCarService
    - domain 패키지에 속한 클레스에게 의존하여 비즈니스 로직을 기반한 서비스를 제공
    - WinnerDto
      - 승리한 사람들의 이름을 전달
    - RunningCarDto
      - 진행중인 차의 상황을 전달 
    - DtoConverter
      - car에서 Dto로 변환해주는 책임
- RacingCarController
  - 입력에 따른 비즈니스 로직 호출
#
- Configuration
    - RacingCarService와 RacingCarController클레스의 의존성을 관리
- StringManipulatro
  - 문자열을 분리하고 병합하는 책임

## 🤔 요구 사항에 대한 분석 (공부 및 적용할 것)
- JDK 17버전의 바른 사용 
- 함수형 프로그래밍을 통해 반복되는 코드 줄이기 
- domain 영역의 모델들의 기능 Test Code 작성
- indent depth 최소화 
- 깃 커밋 컨벤션
- 자바 코드 컨벤션
- 자바 예외 처리


## 🏋️ 적용해보고자 하는 것
- 일급 컬렉션 사용 
- JDK 17버전의 Java Record 목적에 맞는 사용 ( DTO 목적으로 활용한다.)
- 함수형 프로그래밍을 통해  Validator 의 범용성 있는 코드작성 
- RacingCarService 에서 최대한 변경에 열린 코드로 비즈니스 로직 수행하도록 작성