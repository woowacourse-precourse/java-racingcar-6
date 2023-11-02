## 기능 명세

### Game
- [x]  게임을 시작합니다. - startGame()
### GameManager
- [x]  시도할 횟수를 입력 받습니다. - receiveRoundTryCount()
- [x]  라운드를 진행합니다. - proceedRound()
- [x]  우승자를 출력합니다 - printWinner()
### CarFactory
- [x]  경주 자동차를 N개 생성합니다. - createCar()
    - [x]  자동차 이름 문자열을 리스트로 변환합니다. - stringToListByComma()
    - [x]  예외) 같은 이름이 있는지 확인합니다. - hasDuplicatedName()
### Car
- [x]  자동차 본인의 라운드 한번을 진행합니다 - proceedOwnRound()
  - [x]  4이상이면 전진합니다 - updatePosition()
- [x]  본인의 position을 String형태로 반환합니다. - getFormattedPosition()
### NumberGenerator
- [x]  0~9랜덤값을 생성합니다. - generateRandomNumber()
### CarName
- [x]  이름이 Valid한지 확인합니다. - checkValidCarName()
  - [x]  예외) 5자 이내인지 확인합니다. - checkBeyondLengthRange()
  - [x]  예외) 길이가 0일 경우를 확인합니다. - checkZeroLength()
  - [x]  예외) 이름에 한글, 영어, 숫자를 제외한 문자가 있는 지 확인합니다 - checkHasSpecialCharacter()
### RoundTryCount
- [x]  입력받은 횟수가 valid한지 확인합니다 - isValidRoundTryCount()
  - [x]  예외) Null인지 확인합니다. - isNull()
  - [x]  예외) 마이너스인지 확인합니다 - isNegativeNumber()
- [x]  라운드가 남아있는 지 확인합니다 - isRemainRound()
- [x]  라운드 하나를 소모합니다. - consumeRound()

