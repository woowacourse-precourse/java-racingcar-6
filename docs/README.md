# ✨ 기능 구현 목록 ✨

## 기능 목록
***
### 기능
- [x] 자동차 경주 게임 시작 멘트 출력 `경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)`
- [x] 자동차 이름 입력받기(이름은 쉼표 기준으로 구분하며 이름은 5자 이하만 가능)
- [x] 시도할 횟수 입력받기 `시도할 횟수는 몇회인가요?`
- [x] 자동차마다 각 차수에서 무작위 값을 생성해 전진 여부 결정
- [x] 단계별 실행 결과 출력 `carname : (- * n)`
- [x] 최종 우승자 판별 및 출력
### 예외
- [x] 자동차가 0대 입력된 경우
- [x] 자동차 이름에 공백이 포함될 경우
- [x] 자동차의 이름이 중복된 경우
- [x] 자동차 이름이 여섯 글자 이상일 경우
- [x] 시도 횟수가 숫자가 아닌 값으로 입력될 경우
- [x] 시도 횟수가 자연수가 아닐 경우

## Domain 구성
***
### Car(게임을 진행할 주체 - 자동차)
#### **Field**
    자동차가 이동한 거리(drivenDistance)
    자동차 이름(name)
#### **Method**
    현재 이동 거리와 이름 포함한 차수별 실행 결과 문자열 생성(generateNameAndDistanceMessage)
    자신의 이름을 WinnerStand에 추가(standAsWinner)
    자신이 이동한 거리가 인자로 받은 distance의 값과 일치하는지 판별(matchesDrivenDistance)
    가장 멀리 이동한 자동차의 거리 조회(getMaxDistanceAmongCars / static)

### WinnerStand(게임의 최종 우승자를 담은 객체)
#### **Field**
    최종 우승자의 이름을 담을 StringJoiner(winners)
#### **Method**
    인자로 받은 winner 이름을 winners에 추가(addWinner)

### RaceGame(경주 게임)
#### **Field** 
    자동차한테 기름 공급하는 객체(gasolineProvider)
    사용자 입력 관리(inputHandler)
    자동차 등록을 관리하는 접수처(carRegistration)
    경기 진행 상황을 출력하는 전광판(billboard)
#### **Method**
    게임 실행(play)

### CarRegistration(자동차의 등록을 담당)
#### **Method**
    CarRegistrationDTO들을 인자로 받아 유효성 검사 후 Car 생성(register)

### Billboard(게임 현황 출력을 담당 - 전광판)
#### **Method**
    자동차의 이동 상황 전달(displayRaceProgress)
    최종 우승자 출력(displayWinners)
    