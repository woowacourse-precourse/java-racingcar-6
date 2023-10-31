🚀 기능 요구 사항
- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.  
    1. 사용자가 몇 대의 자동차를 사용할 지 받아야한다.
    2. 자동차는 전진 또는 정지를 할 수 있다.  
    

- 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
    1. 각 자동차에 이름을 부여해야한다.
    2.  출력시에 자동차 이름을 같이 출력
  
  
- 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
  1. (,)를 기준으로 이름을 받는다.
  2. 자동차의 이름이 5자를 넘으면 안된다.  - 예외처리
    

- 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
  1. 사용자가 입력한 숫자로 반복 횟수를 정한다.
    

- 전진하는 조건은 0에서 9사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
    1. Random을 통해 0부터 9 사이의 값을 받은 후 4이상일 경우 한칸 전진한다.
  

- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
   1. 우승자가 한명일때와 여러명 일때를 고려한다.  
  
  
- 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.  
  1. 우승자가 한명일때와 다수 일때를 구분, n대의 자동차이기 때문에 반복문을 통해 출력
     

- 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException   
  [예외처리 상황]
  1.  사용자가 자동차 입력을 할 때 공백을 입력했을 경우
  2. 시도할 회수에서 숫자가 아닌 수를 입력했을 경우
  3. 쉼표로 구분하지 않고 공백만 있을 경우
  4. 차가 한 대 일 경우
  5. 자동차 이름이 중복일 경우
  6. 이름이 숫자인 경우
  
## [입력]  
- 사용자가 쉼표로 구분하여 자동차를 입력한다. [inputCarName]
- 사용자가 실행 회수를 입력한다. [inputFrequency]
  
## [기능]
-  random 수를 통해 Go or Stop을 정한다.
- Go가 나온 것들의 자동차 리스트들의 값 증가
- 마지막에 리스트 값을 비교하여 우승자 선정
  
## [출력]
- 시작할 때 "경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분"
- 회수 입력시 "시도할 회수는 몇회인가요?"
- 최초 게임 진행시 "실행 결과"
- 진행을 1번 할때마다 한번씩 진행결과를 출력
- 진행이 끝난 후 최종 우승자 출력

# MVC 패턴으로 분류하기  
## [View]

### InputView.java
- 자동차 이름을 입력 받는다.       (inputCarName)  
- 시도회수를 입력받는다.          (inputFrequency)

### OutputView.java   
- 자동차 입력문을 출력한다.       (printInputNameMessage)   
- 시도회수 입력문을 출력          (printInputFrequencyMessage)  
- 최초 실행시 출력문          (printFirstResultMessage)  
- selectAction을 실행시마다 결과 출력    (printResultMessage)  
- 우승자를 출력한다.         (printWinner)


## [Model]

### CarDistanceManager.java  
- 자동차 진행거리 배열 생성          (carDistance)  
- 랜덤 값 추출            (createRandomNumber)  
- 전진 혹은 정지             (selectAction)

### GameResultAnalyzer.java  
- 최대 값을 찾는다.          (findMaxDistance)  
- 우승자를 선별한다.         (selectWinner)

## [Controller]

### CarNameParser.java  
- 입력받은 문자열을 split          (carNameToArray)  
- 배열을 리스트로 변환         (carNameToList)

### RacingCarGame.java  
- 게임을 frequency번 진행         (runRacing)  
- 게임 총괄            (racingCarGame)

## [Validator]
### FrequencyValidator.java  
- 회수 입력시 숫자를 입력했는지 확인      (isCorrectFrequencyNumber)  
- 회수 입력시 0이하의 숫자를 입력했을 경우   (isNegativeNumber)

## CarNameValidator.java  
- 이름을 5자 초과입력         (isNameLengthValid)  
- 중복된 이름 확인            (isNameDuplicate)  
- 이름을 하나만 입력했을 경우      (isNumberOfCarsValid)  
- 공백을 입력했을 경우         (isNameVaild)
