## 기능 명세

### Game
- [ ]  게임을 시작합니다. - startGame()
### GameManager
- [ ]  시도할 횟수를 입력 받습니다. - receiveRoundTryCount()
- [ ]  라운드를 진행합니다. - proceedRound()
### CarFactory
- [ ]  경주 자동차를 N개 생성합니다. - createCar()
    - [x]  자동차 이름 문자열을 리스트로 변환합니다. - stringToListByComma()
    - [ ]  예외) 같은 이름이 있는지 확인합니다. - hasDuplicatedName()
### Car
- [ ]  자동차 본인의 라운드 한번을 진행합니다 - proceedOwnRound()
- [ ]  4이상이면 전진합니다 - moveForward()
### NumberGenerator
- [ ]  0~9랜덤값을 생성합니다. - generateRandomNumber()
### CarName
- [ ]  이름이 Valid한지 확인합니다. - isValidCarName()
  - [ ]  예외) 5자 이내인지 확인합니다. - isBeyondLengthRange()
  - [ ]  예외) 길이가 0일 경우를 확인합니다. - isZeroLength()
  - [ ]  예외) 이름에 특수문자가 있는 지 확인합니다 - hasSpecialCharacter()
### RoundTryCount
- [ ]  입력받은 횟수가 valid한지 확인합니다 - isValidRoundTryCount()
  - [ ]  예외) Null인지 확인합니다. - isNull()
  - [ ]  예외) 숫자인지 확인합니다. - isNotNumber()
  - [ ]  예외) 마이너스인지 확인합니다 - isNegativeNumber()

   

    

    
        
        
- [ ]  우승자를 출력합니다 - printWinner() → GameManager