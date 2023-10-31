## 기능 명세

- [ ]  게임을 시작합니다. - startGame() → Game
- [ ]  경주 자동차를 N개 생성합니다. - createCar() → CarFactory
    - [ ]  자동차 이름 문자열을 리스트로 변환합니다. - stringToListByComma()→ CarFactory
    - [ ]  예외) 같은 이름이 있는지 확인합니다. - hasDuplicatedName() → CarFactory
    - [ ]  이름이 Valid한지 확인합니다. - isValidCarName() →CarName
        - [ ]  예외) 5자 이내인지 확인합니다. - isBeyondLengthRange() → CarName
        - [ ]  예외) 길이가 0일 경우를 확인합니다. - isZeroLength() → CarName
        - [ ]  예외) 이름에 특수문자가 있는 지 확인합니다 - hasSpecialCharacter() → CarName
- [ ]  시도할 횟수를 입력 받습니다. - receiveRoundTryCount() → GameManager
    - [ ]  입력받은 횟수가 valid한지 확인합니다 - isValidRoundTryCount() → RoundTryCount
        - [ ]  예외) Null인지 확인합니다. - isNull() → RoundTryCount
        - [ ]  예외) 숫자인지 확인합니다. - isNotNumber() → RoundTryCount
        - [ ]  예외) 마이너스인지 확인합니다 - isNegativeNumber() → RoundTryCount
- [ ]  횟수만큼 각 자동차 별로 0~9 랜덤 값을 받아 전진합니다. - proceedRound() → GameManager
    - [ ]  자동차 하나의 라운드를 진행합니다 - proceedOwnRound() → Car
        - [ ]  0~9랜덤값을 생성합니다. - generateRandomNumber() → NumberGenerater
        - [ ]  4이상이면 전진합니다 - moveForward() → Car
- [ ]  우승자를 출력합니다 - printWinner() → GameManager