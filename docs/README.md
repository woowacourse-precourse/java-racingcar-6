# RacingCar 과제

## 📌 2주차 과제 목표

**1주차에 받았던 코드리뷰를 생각하며 과제 수행해 보기**
  - [X] MVC 패턴 -> 모듈 형식의 개발 방식으로 진행해 보기
  - [X] Stream을 사용한 코드 가독성 올리기
  - [X] View 영역에 특정 객체 보내서 출력하지 않기(그냥 값을 출력만 하는 역할)
  - [X] 테스트 기능 구현하기
  - [X] 추가적인 예외상황 추가 및 예외 세부화

### ⛓️필수 기능 요구 사항
    → 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.   
    → 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
    → 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
    → 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
    → 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
    → 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
    → 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
    → 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.
    
## 📄설계 명세서

> 이번 2주차 과제에서는 **모듈 형식**으로 설계하는 것을 목표로 하였습니다.

**Domain**
    
- cars : Car 객체들을 전반적으로 관리하는 도메인
  - createCars() : Car[]을 생성하는 기능
  - moveCars() : Car[] 배열의 recordDistance()를 전부 실행 기능
  - getCars() : Car[] 출력하는 기능  
    - car : 래이싱에 필요한 기능을 갖고 있는 모델
      - recordDistance() : 랜덤 수의 조건이 맞을 경우 Car 내부의 Mileage 객체에 +1하는 기능
      - isMoveCar() : 랜덤수를 생성하고 조전을 비교하여 Boolean 타입으로 결과를 리턴하는 기능
      - getName() : Car의 참가자 이름을 리턴한다.
      - getMileage() : Mileage를 int로 리턴하는 함수
    


- RacingCarDrivers : 선수 명단을 String을 받아 RacingCarDrivers로 관리
  - 입력한 선수 명단의 이름이 ***5를 초과 할 때 오류 발생***
- Round : 입력한 String 형태를 받아 Round 객체로 생성하여 관리
  - 입력한 라운드의 수가 ***숫자가 아닐때, 1보다 작을 때*** 오류 발생


- RoundResult : 라운드별 중간결과를 관리하는 도메인
  - getRoundResult() : 추력형식에 맞추어 이름과 결과를 리턴하는 메서드
  - getMileageResult() : Mileage 수만큼 "-"으로 변환하는 메서드
  - getMaxMoveCount() : 가장 수가 큰 수를 리턴하는 메서드


- Racing : view 와 RacingService 를 이용한 래이싱 실행 도메인 

**Service**
- RacingCarService
  - createCars() : Cars 객체 내용 생성
  - updateRacingResult() : 래이싱 라운드 진행
  - getRoundResults() : 라운드 결과를 출력 형식에 맞게 변환 후 리턴
  - getChampionResult() : 가장 큰 수를 갖고 있는 우승자 명단 리턴

**View**
  - 출력 형식에 맞는 형태로 내용을 출력하는 영역

**error**
- 입력에 대한 에러 세분화한 영역
  >INPUT_UNDER_ONE_EXCEPTION("0 이하의 수가 입력되었습니다."),
  >NAME_INPUT_NULL_EXCEPTION("이름 입력값이 비어있습니다."),
  >INVALID_NUMBER_FORMAT_EXCEPTION("올바른 숫자 입력 형식이 맞지 않습니다."),
  >ROUND_INPUT_NULL_EXCEPTION("라운드 숫자 입력값이 비어있습니다."),
  >NAME_LENGTH_EXCEEDED_EXCEPTION("입력한 이름이 5글자 이상 입니다."),