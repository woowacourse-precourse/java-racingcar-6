# 🚗 2주차 자동차 경주 미션

---
# Model
비즈니스 로직을 수행하고, 데이터와 관련된 책임을 담당한다.

## 클래스 
### Car
- 💡 getHashMap() : 자동차들의 이동 거리가 담겨 있는 HashMap을 반환한다.
- 💡 move() : 자동차를 움직인다.


### 고려 사항 ✅
- Model은 Controller와 View에 의존하지 않아야 한다.

---

# View
사용자에게 보일 사용자 인터페이스, 즉 해당 미션에서 입출력을 담당한다.

## 클래스
### Input
- 💡 getCarNames() : 경주를 할 자동차 이름을 입력받고, 올바른 입력인지 검증을 실행한다.
- 💡 getTryNumber() : 시도할 횟수를 입력받고, 올바른 입력인지 검증을 실행한다.

### Output
- 💡 outputGameProgress() : 각 시도 횟수마다 자동차가 움직인 결과를 출력한다.
- 💡 outputFinalSoloWinner() : 최종 단독 우승자의 이름을 출력한다.
- 💡 outputFinalJointWinners() : 최종 공동 우승자의 이름을 출력한다.

### InputMessage
- 💡 inputCarNames() : 자동차 이름을 입력하라는 안내 메세지를 출력한다.
- 💡 inputTryNumber() : 시도할 횟수를 물어보는 안내 메세지를 출력한다.

### OutputMessage
- 💡 outputResultText() : "실행 결과" 텍스트를 출력한다.
- 💡 outputFinalWinner() : "최종 우승자 : " 텍스트를 출력한다.

### ErrorMessage
- 💡 isNotNullError() : 빈 문자열일 때 에러 메세지를 출력한다.
- 💡 separatorError() : 구분자가 ',' 1개만으로 이루어져있지 않을 때 에러 메세지를 출력한다.
- 💡 carNumberError() : 입력 받은 자동차의 대수가 1이상이 아닐 때 에러 메세지를 출력한다.
- 💡 carNameLengthError() : 입력 받은 자동차 이름의 길이가 5이하가 아닐 때 에러 메세지를 출력한다.
- 💡 carNamesNotDuplicateError() : 입력 받은 자동차의 이름이 중복일 때 에러 메세지를 출력한다.
- 💡 isDigitError() : 입력 받은 시도 횟수가 숫자로만 이루어지지 않았을 때 에러 메세지를 출력한다.
- 💡 tryNumberError() : 입력 받은 시도 횟수가 0이상이 아닐 때 에러 메세지를 출력한다.


### 고려 사항 ✅
- View는 Model에만 의존해야 하고, Controller에는 의존하면 안 된다.
- Model로부터 데이터를 받을 때, 사용자마다 다르게 보여주어야 하는 데이터만 받아야 한다.
  - 또한, 반드시 Controller에서 받아야 한다.

---

# Controller
Model과 View를 연결해주는 역할로, 사용자 요청에 맞는 서비스를 실행한다.

## 클래스
### Controller
- 💡 run() : 전체 비즈니스 로직을 실행한다.
- 💡 tryOne() : 시도 횟수 내에서 1번 실행한다.
- 💡 judgeFinalWinner() : 최종 우승자를 판별하는 로직을 실행한다.
- 💡 judgeEachCar() : 각 자동차가 최종 우승자인지 판별한다. 
- 💡 showFinalWinner() : 최종 우승자를 단독, 공동으로 구분하여 출력한다.

### 고려 사항 ✅
- Model과 View에 의존할 수 있다.

---

# Utils
문자열 관련, 랜덤값 생성 등 프로젝트 전역에서 사용되는 특정 로직이나 독립적인 기능을 담당한다.

## 클래스
### Utils
- 💡 generateRandomNumber() : 0~9 사이의 랜덤한 값을 생성한다.
- 💡 measureMaxNumInHashMapValues() : HashMap의 Values 중 최대값을 반환한다.
- 💡 splitByComma() : 콤마 ','를 기준으로 문자열을 나누어 배열에 저장한다.
- 💡 splitByCommaAndBlank() : 콤마 ','와 공백을 기준으로 문자열을 나누어 배열에 저장한다.
- 💡 isEqualArray() : 두 배열이 동일한지 판단한다.
- 💡 joinByComma() : 콤마 ','를 기준으로 배열의 원소들을 결합한다.
- 💡 stringToInt() : String 타입을 int 타입으로 변환한다.
- 💡 replaceCommaToBlank() : 콤마 ','를 공백으로 대체한다.
- 💡 arrayToHashMap() : 배열을 HashMap으로 변환한다.

### 고려 사항 ✅
- util로 만들어서 따로 관리해야 할만한 기능인지 고민한다.
- 수정을 최소화하는 방향으로 구현한다.

---

# Validation
입력값이 유효한지 검증하는 기능을 담당한다.

## 클래스
### Validation
- 💡 validateIsNotNull() : 입력 받은 문자열이 null이 아닌지 검증한다.
- 💡 validateSeparator() : 구분자가 콤마 ',' 1개만으로 이루어져있는지 검증한다.
- 💡 validateCarNumber() : 입력 받은 자동차의 대수가 1이상인지 검증한다.
- 💡 validateCarNameLength() : 자동차 이름의 길이가 5이하인지 검증한다.
- 💡 validateCarNamesNotDuplicate() : 자동차의 이름이 중복이 아닌지 검증한다.
- 💡 validateIsDigit() : 입력 받은 시도 횟수가 숫자인지 검증한다.
- 💡 validateTryNumber() : 입력 받은 시도 횟수가 0이상인지 검증한다.

### 고려 사항 ✅
- Validation 클래스에서 만든 메소드들은 View 혹은 Utils 내에서만 사용한다.

---

# Test

## 클래스

### UtilsTest
Utils 클래스에 있는 메소드들을 검증한다.

### ValidationTest
Validation 클래스에 있는 메소드들을 검증한다.