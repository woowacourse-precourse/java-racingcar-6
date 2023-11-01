# 2주차 메소드 README.md

## Car.class

- Car라는 객체에 name과 position을 저장할 수 있게 했습니다.

- `move()`

  아래의 generateRandomNumber() 에서 받은 랜덤 숫자가 기준값인 4 이상이면 해당 Car의 position을 1씩 증가시키는 기능입니다.


- `generateRandomNumber()`

  0과 9 사이의 랜덤 숫자를 받는 기능입니다.


- `getName()`

  해당 Car의 name을 가져오는 기능입니다.


- `getPosition()`

  해당 Car의 position을 가져오는 기능입니다.



## Cars.class

- `convertStringToList()`

  사용자에게 받은 String형태의 입력을 “,” 단위로 잘라 List로 변환시켜주는 기능입니다.


- `makeCarList()`

  위의 변환한 List의 원소들을 하나씩 Car라는 객체에 넣는 기능입니다.



## Validation.class

- `validateNameInput()`

  validateNameNull(),validateNameLength(),validateNameLength() <br>

  입력된 이름(String)과 관련한 3가지의 validation 기능을 하나의 메서드에서 진행할 수 있도록 종합한 기능입니다. 
public static으로 설정해 Control 클래스에서는 이 한 메서드만 호출해도 이름과 관련한 validation을 모두 진행할 수 있습니다.
  

- `validateNameNull()`

  입력된 이름이 빈칸인지 검증하는 기능입니다. 빈칸인 경우 예외를 줍니다.


- `validateNameLength()`

  입력된 이름의 길이를 검증하는 기능입니다. 5글자를 초과하면 예외를 줍니다.


- `validateNameDuplicate()`

  입력된 이름이 중복될 경우 예외를 주는 기능입니다.


<br>

- `validateNumberInput()`

  validateNumberNull(),validateNumberRange(),validateNumberFormat() <br>

  입력된 숫자(int)와 관련한 3가지의 validation 기능을 하나의 메서드에서 진행할 수 있도록 종합한 기능입니다. 
public static으로 설정해 Control 클래스에서는 이 한 메서드만 호출해도 숫자(rounds)와 관련한 validation을 모두 진행할 수 있습니다.


- `validateNumberNull()`

  입력된 숫자가 빈칸인지 검증하는 기능입니다. 빈칸인 경우 예외를 줍니다.


- `validateNumberRange()`

  입력된 숫자의 범위가 0 밑으로 내려가면 예외를 주는 기능입니다.


- `validateNumberFormat()`

  입력값이 숫자값인지 검사하고 숫자가 아닌 경우 예외를 주는 기능입니다.




## InputView.class

- `requestCarName()`

  경주할 자동차 입력 요청 메세지를 출력하고 입력 받는 기능입니다.


- `requestRoundNumber()`

  경주 라운드(몇 번 경주를 진행할 것인지) 숫자 입력 요청 메세지를 출력하고 입력 받는 기능입니다.



## OutputView.class

- `printRacingProcess()`

  “-”인 RACING_ROAD를 출력하는 기능입니다. 해당 차에 저장된 position만큼 RACING_ROAD를 출력합니다.


- `printWinner()`

  findWinner()와 addWinner(), 두 개의 기능을 이 기능 안에서 진행할 수 있도록 종합하고, winners 리스트에 저장된 승리한 차의 이름을 출력하는 기능입니다.


- `findWinner()`

  이 기능은 maxPosition 값을 정의하는 기능입니다. maxPosition이라는 변수를 두어 Cars 리스트에서 각 car의 position과 비교합니다. 
for문을 순환하다가 해당 car의 position이 현재 maxPosition보다 크다면 maxPosition을 해당값(position)으로 변경합니다. 
승자를 찾는 과정이기 때문에 findWinner()라는 이름을 붙였습니다.


- `addWinner()`

  만약 isWinner()에서 true값을 받는다면 해당 차의 이름을 winners라는 리스트에 추가합니다.


- `isWinner()`

  만약 maxPosition값과 현재 차의 position 숫자가 같다면 true를 출력합니다.




## Control.class

- `playGame()`

  startGame(), raceProcess(), OutputView.printWinner()를 종합한 기능으로, 메인 메서드입니다.


- `startGame()`

  readyCarName()과 readyRound()를 종합한 기능으로, Game을 시작하기 위한 기본 입력, 검증을 완료합니다.


- `readyCarName()`

  사용자로부터 입력받은 차 이름을 검증하고, 입력값(String)을 리스트로 변환하는 메서드들을 종합한 기능입니다.


- `readyRound()`

  사용자로부터 입력받은 숫자값을 검증하고, 입력값(String)을 int형으로 변환하는 메서드들을 종합한 기능입니다.


- `raceProcess()`

  전체적인 rounds를 진행시키는 기능입니다. 한 라운드마다 반복되는 아래의 기능, movePosition()을 사용자가 입력한 rounds만큼 반복하는 기능입니다.


- `movePosition()`

  차들이 움직이는 것을 관리하고, OutputView.printWinner()를 통해 “-”를 출력하는 메서드입니다. 이 기능은 한 라운드마다 반복됩니다.



## Application.java

- Control 클래스를 RacingcarGame으로 받아 메인 메서드인 playGame()을 실행합니다.



## ApplicationTest.java (추가한 테스트)

- `숫자가_음수일_때에_대한_예외_처리()` : 입력한 숫자가 음수일 경우의 예외 처리를 테스트합니다.
- `숫자_입력이_문자일_때에_대한_예외_처리()` : 숫자를 입력해야 하는데 문자를 입력했을 경우의 예외처리를 테스트합니다.
- `빈칸에_대한_예외_처리()` : 입력칸에 빈칸을 입력했을 경우의 예외처리를 테스트합니다.
- `printWinner_메서드_테스트()` : 지난주 테스트 코드를 보고 새롭게 만든 테스트입니다. 이름 입력값과 숫자(rounds) 입력값, 랜덤값까지 지정해주었을 때 정답이 나오는지, 전체적인 과정을 확인하기 위한 테스트입니다.