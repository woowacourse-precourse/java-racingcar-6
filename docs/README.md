# 🚀 기능 목록
1. 사용자로부터 자동차 이름을 입력받는 기능
- 예외 1-1) 이름의 길이가 5자를 초과하는 경우
- 예외 1-2) 이름에 중복이 존재하는 경우
- 예외 1-3) 자동차의 수가 2대 미만인 경우


2. 사용자로부터 각 자동차의 이동 횟수를 입력받는 기능
  - 예외 1-1) 숫자 이외의 값이 포함되어 있는 경우


3. 0에서 9 사이의 무작위 값을 생성하는 기능


4. 게임 우승자를 반환하는 기능
- 가장 많이 앞선 자동차를 판별
- 우승자는 1명 이상일 수 있음


5. 게임 진행 기능
- 입력 메시지 출력하기
- 우승자 출력하기


6. 게임 반복 기능
-  현재 경주 상황(자동차 이름, 경주 상황) 출력하기

# 📚 클래스 설계
## verification
- InputVerification : 주어진 입력이 올바른지 검증하는 객체
  - checkAll() : 전체 검증을 실시하는 함수
  - checkNameLength() :  입력값의 길이가 5자 이하인지 검증하는 함수
  - checkNameDuplicate() : 입력값 중 중복된 값이 있는지 검증하는 함수
  - checkCarCount() : 입력한 자동차의 수가 2대 이상인지 검증하는 함수
  - checkInputType() 입력값이 숫자로만 이루어져 있는지 검증하는 함수

## view
- InputView : 사용자로부터 입력을 받는 객체
  - carNames() : 자동차의 이름을 입력받는 함수
  - moveCount() : 이동 횟수를 입력받는 함수

- OutputView : 메시지를 출력하는 객체
  - printInputNameMessage() : 자동차 이름 입력 메시지를 출력하는 함수
  - printInputCountMessage() : 시도 횟수 입력 메시지를 출력하는 함수
  - printCarName() : 자동차의 이름을 출력하는 함수
  - printRaceStatus() : 자동차의 현재 경주 상황을 출력하는 함수
  - printWinner() : 우승자를 출력하는 함수

## domain
- Car : 자동차 객체
  - move() : 자동차가 전진하는 함수
### dto
- CarDTO : Car의 현재 데이터를 저장하는 객체
  - getName() : 자동차의 이름을 저장하는 함수
  - getRaceStatus() : 자동차의 현재 경주 상황을 저장하는 함수

## service
- RaceService : 게임 진행을 돕는 객체
  - createRandomNumber() : 0에서 9 사이의 랜덤 값을 생성하는 함수
  - isMoreThanFour() : 랜덤 값이 4 이상인지 판별하는 함수


- GameManageService : 게임을 진행하는 객체
  - getFinalResult() : 함수
  - getBestCar() : 함수

## controller
- GameManageController : 전반적인 게임을 진행하는 객체
  - start() : 게임을 시작하는 함수
  - gameProgress() : 게임을 진행하는 함수
  - finish() : 게임을 종료하는 함수