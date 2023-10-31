# RacingCarGame

## 기능 구현 규칙

---

#### 1. APP은 컨트롤러만을 실행한다
#### 2. 컨트롤러는 GameService의 구현체를 실행하며, Start-Progress-End 순으로 실행한다
#### 3. GameService 구현체는 EventHandler를 실행한다.
#### 4. EventHandler에는 주 기능과, 주 기능안의 세부 기능이 담기도록 구성한다.
#### 5. EventHandler는 각 도메인 클래스들과 Exception, Validation을 객체로 생성해서 사용한다
#### 6. 도메인 클래스에는 각 필드와 값을 저장하고 반환하는 Getter,Setter 또는 생성자로만 구성한다
#### 7. Exception은 발생할 수 있는 예외에 대해서 처리하는 메소드들로만 구성한다
#### 8. Validation은 게임의 진행과 결과를 위한 검증에 대해서 처리하는 메소드들로만 구성한다.


## 패키지별 구성 클래스

---

### Controller
- Controller
### Domain
- Cars
- GameProgress
- Tries
- Winner
### Events
- EventHandler
- Exception
- Validation
### Service
- GameService(인터페이스)
- RacingCarGameService(인터페이스 구현체)

## 패키지별 기능

---

#### - Controller: 여러 게임 서비스를 실행할 수 있는 컨트롤러 역할
#### - Service: 인터페이스를 구현한 게임별 서비스 로직 구현
#### - Events: 게임의 여러 이벤트 처리 로직과 예외 및 검증 이벤트 로직을 처리
#### - Domain: 각 게임의 진행 등을 위한 정보를 가지고 있는 필드 집합

## 테스트케이스

--- 

### 기본제공
- 전진_정지
- 이름에_대한_예외_처리

### 추가 테스트케이스
#### - canNameSplitTest: 이름이 ","로 구분되어있을 경우 구분해서 저장할 수 있는가
#### - blankNameCheckTest: 이름이 공백으로 입력되었을 경우 예외를 터트릴 수 있는가
#### - justOneInputNameTest: 이름이 구분자 없이 하나로만 들어올 경우 하나의 이름만 저장되는가
#### - areTriesPositiveNumberTest: 양수 이외의 숫자가 시도 횟수로 들어왔을 경우 예외를 터트리는가
#### - manyWinnerPrintTest: 다수의 우승자를 잘 출력하는가
#### - SameNameCheckTest: 중복 이름을 입력했는지 확인하고 예외를 터트릴 수 있는가