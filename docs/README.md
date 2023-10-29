# 자동차 경주 - 6기
기본적으로 1부터 9까지 서로 다른 수로 이루어진 3자리의 수를 맞추는 게임이다.
<br>
## 😀기능
### - 입력
- 자동차 이름을 입력 받아 Controller에게 전송
- 시도할 횟수를 입력 받아 Controller에게 전송
### - 입력에 대한 예외처리
- 빈 문자 입력
- 자동차 이름 1글자 미만, 5글자 초과
- 자동차이름 공백포함
- 자동차이름 중복
- 시도횟수 문자 입력

### 출력
- 입력 안내 문구
- 각 차수별 실행 결과
- 우승자 안내 문구

### 객체 생성
- Car 객체 생성 -> 자동차 이름(class), 현재 포지션(class), move(method)
- Race 객체 생성 -> 시도 횟수(Instance), isRunning(method)

### 객체 기능
- RaceNumberGenerator -> 랜덤 넘버 생성

### Data 관련
- 차에 대한 DTO, DAO
- Race에 대한 DTO, DAO

### Service 관련
- 시도할 횟수를 Controller -> DTO -> DAO를 거쳐 DB에 저장
- 자동차 이름을 Controller -> DTO -> DAO를 거쳐 DB에 저장
- Controller가 View 에게 보낼 UI 정보(결과, 우승자)를 업데이트

### 게임 도메인 로직 관련
- 차 객체의 포지션 이동
- 무작위 값을 받아서 결과에 대한 판단
- 시도 횟수가 끝나면 우승자를 판단


## 😀구조
### Root
Application
### Domain
- JudgeMoveCar
- JudgeWinner
- MoveCarPosition
- NumberGenerate -> RandomNumberGenerator
- DecisionWinner
### DTO
- CarResponse
- RaceResponse
### Domain -> DB
- CarsData
- RaceData
### Domain -> DAO
- CarDAO
- RaceDAO
### Controller
- GameController
### Service
- GameService
### View
- InputAboutGame
- OutputAboutGame
### Common
### Common -> Exception
- EmptyInputException
- CarNameLengthException
- CarNameHavingEmptyException
- CarNameDuplicationException
- AttemptNotNumberException
### Common -> Constant
- GuidePhrases


## 😀Flow
1. Application에서 Game생성 후 GameController 호출
2. View.InputAboutGame, View.OutputAboutGame 호출
3. 입력 내용 Controller에 전달
4. Controller는 입력 받은 자동차 이름, 시도 횟수를 Service에 보냄
5. Service는 DTO, DAO를 거쳐 Data를 DB에 저장(car -> CarsData)
6. Controller는 Domain.NumberGenerate를 호출
7. RandomNumberGenerator를 사용해서 랜덤 넘버 생성
8. Controller는 랜덤 넘버를 Domain.JudgeMoveCar에게 보냄
9. 움직일 차를 결정하여 Move
10. Domain.JudgeWinner, Domain.DecisionWinner는 우승자 결정
11. 그 정보를 Controller -> DB -> Controller -> View 단계로 출력