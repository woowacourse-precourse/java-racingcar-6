# 구현 기능 정리
<hr>

## view
### InputView

- requestCarNames
  
  - 사용자로부터 자동차 이름 입력 요청 메시지를 출력하는 메서드
  
- requestTrialNumber
  
  - 사용자로부터 시도할 횟수 입력 요청 메시지를 출력하는 메서드
  
### OutputView

- showHead

    - 실행 결과 메시지를 출력하는 메서드 

- showScores

    - 자동차 리스트 속 자동차들의 자동차 스코어를 확인하는 메서드

- showCarScore

    - 자동차 별 위치를 출력하는 메서드

- showPosition

    - 자동차들의 위치를 나타내는 메서드

- showWinners

    - 최종 우승자를 출력하는 메서드 

- isSoloWin

    - 우승자가 혼자 우승한 것인지 확인하기 위한 메서드 

<hr>

## validator
### CarNameValidator

- checkCarNamesInput

    - 자동차 이름의 입력 유효성 확인 메서드

- checkEmpty

    - 자동차 이름이 제대로 입력되지 않았다면 예외 처리하는 메서드 

- checkLastIndex

    - 자동차 이름 리스트의 마지막 인덱스가 이름이 아닐 경우 예외 처리하는 메서드 

- checkAllDuplicate

    - 자동차 이름 리스트에 중복된 이름이 있는지 확인하는 메서드

- checkDuplicate

    - 자동차 이름이 중복된다면 예외 처리하는 메서드 

- checkEachLengthAndBlank
    
    - 자동차 이름의 길이를 확인하고, 이름에 공백이 있는지 확인하는 메서드

- checkLength

    - 자동차 이름이 1글자 미만이거나 5글자 초과일 경우 예외 처리하는 메서드 

- checkBlank

    - 자동차의 이름 속에 공백이 있다면 예외 처리하는 메서드 

- throwCarNameInputException

    - 자동차 이름의 입력이 잘못되었을 경우 예외 메시지를 출력하는 메서드 


### TrialNumberValidator

- checkTrialNumberInput

    - 시도할 횟수의 입력 유효성 확인 메서드

- checkEmpty

    - 시도 횟수가 제대로 입력되지 않았다면 예외 처리하는 메서드

- checkInputType

    - 입력된 값이 정수가 아니라면 예외 처리하는 메서드 

<hr>

## util
### ReturnElementUtil

- extractCarNames

    - 자동차 이름 리스트에서 자동차 이름들만 추출해 반환하는 메서드 

- convertTrialNumber

    - 시도할 횟수를 정수로 변환해 반환하는 메서드

### RandomUtil

- getRandomNumbers

  - 0부터 9사이의 정수 중에 난수를 발생시켜 반환하는 메서드 

<hr>

## domain
### Car

- getName

  - 자동차 이름 반환 메서드

- getPosition

  - 위치 정수 반환 메서드

- moveForward

  - 위치 만큼 전진하도록 하는 메서드 

### Game

- getCars

  - 자동차 리스트를 반환하는 메서드 

- increaseTrialNumber

  - 시도 횟수를 증가시키는 메서드 

- checkTrialEnd

  - 시도 횟수가 남아있는지 확인하는 메서드 

<hr>

## repository
### CarRepository

- save

  - 자동차의 id 값과 자동차 객체를 저장하는 메서드 

- findAll

  - 저장한 리스트에 있는 값을 모두 조회하는 메서드   

### GameRepository

- save

  - 게임의 id 값과 게임 객체를 저장하는 메서드 

- isEnd

  - 게암이 종료되었는지 확인하는 메서드 

<hr>

## service
### GameService

- play

  - 자동차 경주 게임을 진행하는 메서드

- getWinners

  - 우승자 리스트를 반환하는 메서드

- getMaxPositionCars

  - 자동차들의 위치에 따라 가장 위치가 큰 자동차 이름을 반환하는 메서드 

- getMaxPosition

  - 자동차의 위치를 반환해 가장 큰 위치를 반환하는 메서드 

- moveForwardByRandomNumber

  - 생성된 난수가 전진 조건을 만족한다면 자동차의 위치를 한 칸 전진하도록 하는 메서드

<hr>

## controller
### RacingController

- racingCar
  
  - 자동차 경주 게임 진행을 위한 메서드
  - 사용자에게 입력받은 자동차 정보를 저장하고 게임 시작 및 플레이하기

- getCarNamesInput

  - 입력 요청 메시지를 출력하고 사용자로부터 입력받아 유효성 검사 후 반환하는 메서드

- checkValidationCarNames
  
  - 입력된 자동차 이름의 유효성을 검사하여 반환하고 예외 처리하는 메서드 

- saveCars

  - 자동차 객체에 자동차 이름을 저장하는 메서드 

- startGame

  - 게임 객체에 자동차 리스트와 시도할 횟수를 저장하고 반환하는 메서드

- playGame

  - 게임이 끝난 것을 확인해 결과를 출력하고 점수와 우승자를 출력하는 메서드

- getTrialNumber

  - 사용자에게 시도할 횟수를 입력받아 정수로 변환하여 반환하는 메서드 

- getTrialNumberInput

  - 사용자에게 시도할 횟수를 입력을 요청하고 유효성을 검사한 입력값을 반환하는 메서드 

- checkValidationTrialNumber

  - 입력된 시도 횟수의 유효성을 검사하여 반환하고 예외 처리하는 메서드

- getCarList

  - 자동차 리스트를 조회하여 반환하는 메서드 

<hr>

## constant
### ValidatorConstant

- 예외 처리에 대한 메시지 상수를 저장

### ViewConstant

- view에 필요한 상수 저장

### SystemConstant

- 시스템에 필요한 모든 상수값 저장 