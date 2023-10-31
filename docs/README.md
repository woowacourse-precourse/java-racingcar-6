<p align="center">
  <img src="./img/우테코.png" alt="우아한테크코스" width=300px">
</p>

# 프리코스 2주차 미션 - 자동차 경주

---
![Generic badge](https://img.shields.io/badge/precourse-week2-green.svg)
![Generic badge](https://img.shields.io/badge/test-1_passed-blue.svg)
![Generic badge](https://img.shields.io/badge/version-1.0.1-brightgreen.svg)

> 우아한테크코스 6기 프리코스 2주차 미션 <자동차 경주>를 구현한 저장소입니다.


# 목차
- [Model](#Model)
  - [Car](#Car)
    - [Car.java](#Car.java)
    - [CarList.java](#CarList.java)
    - [CarRegister.java](#CarRegister.java)
  - [Manager](#Manager)
    - [CarMoveManager.java](#CarMoveManager.java)
- [View](#view)
  - [InputView.java](#InputView.java)
  - [OutputView.java](#OutputView.java)
- [Controller](#Controller)
  - [MainController.java](#MainController.java)
- [Uitl](#Util)
  - [CarNameValidator.java](#CarNameValidator.java)
  - [RandomNumberGenerator.java](#RandomNumberGenerator.java)
  - [RandomNumberValidator.java](#RandomNumberValidator.java)
  - [CarListEditor.java](#CarListEditor.java)
  - [MoveCountValidator.java](#MoveCountValidator.java)
---
- [Test](#Test)
  - [ModelTest](#ModelTest)
    - [CarTest.java](#CarTest.java)
    - [CarListTest.java](#CarListTest.java)
    - [CarRegisterTest.java](#CarRegisterTest.java)
    - [CarMoveManagerTest.java](#CarMoveManagerTest.java)
    

---
# Application.java
- play()로 시작


---
# Model
## Car
### Car.java
- String name
- int position
- Car()
- move() : position + 1
- getName()
- getPosition()
- isSame() : position 비교


### CarList.java
- List<Car> carList
- CarList()
- validate()
- moveAllCarListOnce()
- getCurrentResult() : 리스트 불변 복사
- getMaxPosition()
- getWinners()


### CarRegister.java
- carNames
- CarRegister()
- registerCar()
- prepareCarList()


## Manager
### CarMoveManager.java
- CHECK_NUMBER = 4
- isMove() : 랜덤값이 4 이상인지 확인


---
# View
### InputView.java
- getInstance()
- readCarNames()
- readMoveCount()
- enum 정리


### OutputView.java
- getInstance()
- printResult()
- resultDisplay()
- printResultCarList()
- printWinners()
- printExceptionMessage()
- enum 정리


---
# Controller
### MainController.java
- inputView
- outputView
- gameGuide
- carMoveManager
- carRegister
- initializeGameGuide()
- play()
- race()
- progress()
- registerCarList()
- moveAllCarList()
- enum 정리 : GameStatus, isContinue()


---
# Util
### CarNameValidator.java
- MIN_CARLIST_NUMBER = 2
- MAX_CARNAME_LENGTH = 5
- validateCarNumber() : 자동차가 2대 이상인지 확인
- validateCarNameLength() : 자동차의 이름이 5자 이하인지 확인
- validateContainBlank() : 이름 공백 포함 확인
- validateNotSame() : 이름 중복 확인
- validate()
- enum 정리


### RandomNumberGenerator.java
- Randoms.pickNumberInRange(0, 9) 사용


### RandomNumberValidator.java
- MIN_NUMBER = 0
- MAX_NUMBER = 9
- validate() : 0 이상 9 이하 확인
- enum 정리


### CarListEditor.java
- splitByComma() : 콤마로 구분
- removeSpace() : 공백 제거
- enum 정리


### MoveCountValidator.java
- validateNumeric()
- validateNumberRange()
- validate()
- enum 정리


---
# Test
## ModelTest
### CarTest.java
- 초기 위치 검사
- move() 정상 작동 검사


### CarListTest.java
- 비정상 입력값 검사
  - 자동차의 수가 1대 이하
  - 자동차 이름 6자 이상
- 정상 입력값 검사
- 우승자 판단 검사


### CarRegisterTest.java
- 자동차 등록 검사


### CarMoveManagerTest.java