# 시퀀스 기능
- [x] 자동차 이름을 입력받는다. - InputView$inputCarNames()
- [x] 자동차 이름을 검증한다. - CarNamesValidator$getValidatedCarNamesList(String inputtedString)
  - [x] 자동차 이름을 쉼표(,)를 기준으로 구분한다. - CarNamesValidator$validateSplit(String inputtedCarNames)
  - [x] 쉼표 앞뒤로 공백은 자동으로 없애서 입력받는다. - CarNamesValidator$trimInputtedString(String inputtedCarNames)
  - [x] 이름은 5자 이하만 가능하다. -> 아니면 `IllegalArgumentException` - CarNamesValidator$validateLessThanLength(String carName)
    - [x] 공백을 제거한 후의 길이가 5자 이하로 계산한다. - CarNamesValidator$validateLessThanLength(String carName)
- [x] 입력받은 자동차 이름을 보관한다. - CarsDto -> RacingCars -> Car
  - [x] 각 자동차는 처음은 이동 거리가 0으로 세팅돼야한다. Car$createCar(String name)
- [x] 사용자로부터 몇 번의 이동을 할 것인지 입력받는다. - InputView$inputTryNumber()
  - [x] 숫자로 입력받아야 한다. -> 아니면 `IllegalArgumentException` - ClientValidator$getValidatedBigIntegerValue(String inputtedStringTryNumber)
- [x] 입력받은 시도 횟수만큼 0~9 사이의 무작위 값을 구한 후 4 이상인 경우 전진한다. - Car$raceOneRound()
  - [x] 4 이상의 결과가 나온 수만큼 이동 거리가 1씩 증가된다. - Car$raceOneRound()
  - [x] 자동차 결과는 DTO로 포장해서 반환한다. - Car$createCarResultDto()
- [x] 자동차들은 리포지토리에 의해 관리된다.
  - [x] 자동차 이름이 중복되더라도 id 식별자에 의해 관리된다.
- [x] 리포지토리는 결과를 DTO 형식으로 반환한다.
  - [x] 결과 DTO는 내부에 각 라운드 별 DTO를 담고 있다.
  - [x] 라운드 별 DTO는 자동차별 결과 DTO를 담고 있다.
- [ ] 각 차수별로 전진한 양을 출력한다.
  - [ ] 첫 차수 출력하기 전에는 "\n실행 결과"도 출력한다. 
  - [ ] 전진한 양이 없으면 "[$자동차 이름] : "으로 공백으로 출력한다.
  - [ ] 한 차수의 출력이 끝나면 공백을 만들어준다.
- [x] 누가 우승했는지 계산 후 출력한다.
  - [x] 우승자는 한 명 이상일 수 있다.
  - [ ] 모두 한 칸도 전진 안 한 상태면 우승했다고 할 수 없다고 (스스로) 판단한다. => 공백으로 출력!
  - [ ] 출력 형식 : "\n최종 우승자 : [$자동차 이름][, [$자동차 이름]].."


# 객체 모델

## 1. RacingController
### State
- RacingService
- InputView
- OutputView

### Behavior
- run()
- `private` CarsDto createCarsDto()
- `private` Client createClientDto()

## 2. RacingService
### State
- CarRepository
- currentRound

### Behavior
- `construct` (CarsDto carsDto, Client client)
- ResultDto playCarRacing()

## 3. InputView
### State
- `Enum` Sentence
- OutputView

### Behavior
- String inputCarNames()
- String inputTryNumber()

## 4. OutputView
### State
- `Enum` Sentence

### Behavior
- void beforeInputCarNames()
- void beforeInputTryNumber()
- void printResult(ResultDto)
- `private` void printRacingDistanceResults(ResultDto)
- `private` void printFinalWinners(ResultDto)

## 5. CarRepository
### State
- ResultDto result
- List<Car> cars
- BigInteger currentRacingRound
- BigInteger idProvider

### Behavior
- `construct`(CarsDto, Client)
  - `private` void idGenerate()
- void race() 
  - `private` List<Car.CarResultDto> generateCarResults()
- ResultDto finishFinalRound()
  - `private` long calculateMaxDistance()
- boolean isFinalRound()

## 6. Car
### State
- BigInteger id
- String name
- BigInteger distance
- CarResultDto
  - String name
  - long distance

### Behavior
- Car createCar(BigInteger id, String name)
- void raceOneRound()
- CarResultDto createCarResultDto()

## 7. Client
### State
- BigInteger tryNumber

### Behavior
- construct(String inputtedTryNumber)
- BigInteger getTotalRounds()

## 8. CarsDto
### State
- List<String> carNames

### Behavior
- `construct`(String inputtedCarNames)
- `private` List<String> validateInputtedCarNames(String inputtedCarNames)
- String getSingleCarName(int index)
- int getNumberOfCars() 

## 9. ResultDto
### State
- Map<BigInteger, SingleRoundResultDto> resultDtoByRound
- BigInteger finalRound
- List<String> finalWinners

### Behavior
- `construct`(BigInteger finalRound)
- void addSingleRoundResult(BigInteger round, SingleRoundResultDto singleRoundResultDto)
- int getFinalRound
- SingleRoundResultDto getSingleRoundResult(BigInteger round)
- void addFinalWinner(String winnerName)
- List<String> getFinalWinners()

## 10. SingleRoundResultDto
### State
- List<Car.CarResultDto> carResultDtoList

### Behavior
- void addCarResultDto(Car.CarResultDto carResultDto)
- Car.CarResultDto getCarResultDto(int index)

## 11. Validator
### Behavior
- void throwIllegalArgumentException(String message)
- void throwIllegalArgumentException(String message, Throwable t)

## 12. CarNamesValidator extends Validator
### Behavior
- `private` List<String> validateSplit(String inputtedCarNames)
- `private` String trimInputtedString(String inputtedCarNames)
- `private` void validateLessThanLength(String carName)
- String getValidatedCarNamesList(String inputtedString)

## 13. ClientValidator extends Validator
### Behavior
- BigInteger getValidatedBigIntegerValue(String inputtedStringTryNumber)
- `private` BigInteger validateCastToBigInteger(String inputtedString)
- `private` void validateNaturalNumber(BigInteger value)

## 14. `Enum` Sentence
- INPUT_CAR_NAMES("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
- INPUT_TRY_NUMBERS("시도할 횟수는 몇회인가요?")
- RACING_RESULT_START("실행 결과")
- SINGLE_CAR_WITHOUT_DISTANCE("%s : ")
- FINAL_WINNERS("최종 우승자 :")

## 15. `Enum` Error
- LONG_CAR_NAME_ERROR("자동차 이름이 5자를 초과했습니다.")
- BLANK_CAR_NAME_ERROR("자동차 이름을 공백으로 입력하였습니다.")
- NOT_NUMBER_INPUTTED("숫자로 입력하셔야합니다.")
- CANNOT_CAST_TO_INT("int형으로 변환할 수 없습니다.")
- NOT_NATURAL_NUMBER("입력한 숫자가 자연수가 아닙니다.")