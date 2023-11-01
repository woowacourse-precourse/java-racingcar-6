## 자동차 기능 목록

-----------------

### 자동차 경주 게임을 관리하는 기능 (controller.GameSystem)

- [x] 전체 게임 시스템을 동작하게 하는 기능(start)
- [x] 자동차의 정보를 저장하는 과정 실행 (saveCarInputs)
- [x] 시도 회수 정보를 저장하는 과정 실행 (saveTryInput)
- [x] 게임 실행결과를 만드는 과정 실행 기능 (runGame)
- [x] 최종 우승자를 보여주게 하는 과정 실행 기능 (showWinner)

### 사용자에게 게임의 입력 값을 받는 기능 모음 (view.InputView)

- [x] 사용자에게 차들의 이름을 입력 받는 기능 (readCarNames)
- [x] 사용자에게 시도 횟수를 입력 받는 기능 (readTryNumber)
- [x] 이름 유효성 검사를 실행시키는 기능 (runNameVallidator)
- [x] 숫자 유효성 검사를 실행시키는 기능 (runTryValidator)

### 사용자에게 게임의 출력 값을 보여주는 기능 모음 (view.OutputView)

- [x] 문자열 값을 변수로 받으면 출력해주는 기능 (write)
- [x] 자동차의 이동을 출력하는 기능 (showMove)

### 사용자의 이름 입력값의 유효성을 검사하는 기능 모음 (validator.NameValidation)

- 자동차 이름에 예외가 발생할 수 있는지 확인하는 기능을 실행 (validate)
- [x] 입력 값에 영어, 쉼표만 포함되고 영어 글자수가 1이상5이하인 조건을 만족하는지 확인하는 기능 (checkWord)
- [x] 자동차의 이름에서 중복된 이름이 있는지 확인하는 기능 (checkDuplicate)
- [x] 자동차 입력 개수가 2개이상 인지 확인하는 기능 (checkCount)

### 사용자의 시도 회수 유효성 검사하는 기능 모음 (validator.TryValidation)

- [x] 입력 값이 시작이 0이아닌 숫자인지 아닌지 확인하는 기능 (checkTryNumber)

### 사용자의 입력 값을 가공하는 기능 모음 (util.InputManufacture)

- [x] 입력 값을 쉼표로 분리해서 배열로 만들어주는 기능 (makeNameList)
- [x] 입력 값을 숫자로 만들어 주는 기능 (changeIntegerNumber)

### 모든 자동차들의 정보를 관리하는 기능(domain.TotalCar)

- [x] 차의 정보가 있는 클래스를 받아서 저장하는 기능 (saveNewCar)
- [x] 차의 이동 거리를 업데이트해주는 기능 (moveDistance)
- [x] 차의 이름 목록을 주는 기능 (nameList)
- [x] 차의 이동 거리들을 주는 기능 (distanceList)

### 자동차의 정보를 저장하는 기능 (domain.Car)

- [x] 자동차의 이름을 전달하는 기능 (getName)
- [x] 자동차의 전진 거리를 업데이트하는 기능 (updateDistance)
- [x] 자동차의 전진 거리를 전달하는 기능 (getDistance)

### 자동차의 전진 조건 확인 기능 (util.CarCondition)

- [x] 4이상이면 true를 아니면 false를 전달하는 기능 (isMove)
- [x] 0~ 9까지의 랜덤 숫자를 하나 만드는 기능 (makeRandom)

### 자동차의 전진 결과를 만드는 기능(service.CarGame)

- [x] 시도 회수만큼 게임을 한다 (run)
- [x] 게임을 한번 시도하여 이동거리를 변화 시키는 기능을 실행한다 (saveResult)
- [x] 자동차 게임 실행 결과를 보여준다 (showResult)

### 자동차 정보의 집합 리스트를 생성하는 기능(service.CarsInputManage)

- [x] 자동차 이름을 저장한 클래스의 리스트를 전달하는 기능 (makeCars)
- [x] 자동차 이름의 유효성을 평가하여 이름 리스트를 전달하는 기능 (makeCarNames)
- [x] 자동차 이름별로 하나의 클래스를 생성하여 클래스 리스트를 만드는 기능 (saveCarList)

### 시도 회수의 값을 만들어내는 기능(service.TryInputManage)

- [x] 사용자에게 시도 회수를 입력 받아 전달하는 기능 (makeTryNumber)

### 최종 우승자를 보여주는 기능(service.FinalWinner)

- [x] 최종 우승자의 출력하는 기능을 실행하는 기능 (showCars)
- [x] 최종 우승자를 출력하는 기능 (showCarList)
- [x] 최종 우승자 목록을 만드는 기능 (makeWinnerList)

### 우승자를 찾는 기능 (service.Winner)

- [x] '차의 전진 거리'를 입력 받아 maxDistance의 값을 구한다 (carCompare)
- [x] 거리가 maxDistance와 같은 거리를 찾으면 그 거리의 순서인 자동차 이름을 리스트로 저장한다 (findWinner)
-
    - [x] 'max' 값과 '차의 전진 거리'를 비교해서 'max'가 큰 수면 'false'를 반하고 아니면'true'를 반환 (distanceCompare)

### 상수 데이터 집합 (util,Message)

- [x] 출력에 사용되는 상수들을 저장