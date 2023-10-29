# 🚗 자동차 경주

## ☑️기능 목록

☑️ : 구현 완료 <BR>
✅ : 테스트 완료

- [☑️✅] 자동차 이름을 쉼표(,)를 기준으로 구분하여 입력받는다. - inputCarNames() 🍏
    - [☑️✅] 입력받은 자동차 이름을 검증한다. - validateCarNames() 
        - [☑️] 이름으로 빈 문자열이 들어왔을 경우 예외 발생 - checkCarNameValidity() 
        - [☑️] 자동차 이름에 공백 문자가 있을 경우 예외 발생 - checkCarNameForBlank() 
        - [☑️] 자동차 이름 길이가 0자이거나 6자 이상일 경우 예외 발생 - validateNameLength() 
        - [☑️] 자동차 이름 중 중복된 이름이 있을 경우 예외 발생 - validateDuplicateName() 
- [☑️✅] 시도 횟수를 입력받는다. - inputAttemptCount()
- [☑️✅] 입력받은 시도 횟수를 검증한다. - validateAttemptNumber()
    - [☑️] 사용자가 공백을 입력했을 경우 예외 발생 - checkNonBlank
    - [☑️] 사용자가 숫자가 아닌 문자를 입력했을 경우 예외 발생 - checkInteger()
    - [☑️] 사용자가 소수를 입력했을 경우 예외 발생 - checkNonDecimal()
    - [☑️] 사용자가 0 이하의 수(음수 포함)를 입력했을 경우 예외 발생 - checkPositiveNumber()
- [☑️] 0에서 9사이의 무작위 값을 구한다. - createRandomNumber()
- [☑️] 무작위 값이 4 이상일 경우 앞으로 움직인다. - moveCar()
- [☑️] 위 과정을 시도할 횟수 동안 반복한다. - playRacing()
    - [☑️] 각 차수별 실행 결과를 출력한다.
- [☑️] 게임이 끝나면 우승자를 알려준다. - showWinner()
    - [☑️] 가장 앞에 있는 차를 찾는다. - findWinner()
    - [☑️] 우승자의 이름을 String 으로 반환한다. - listWinner()