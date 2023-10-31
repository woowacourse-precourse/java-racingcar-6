### 기능 요구 사항
✅ 주어진 횟수 동안 N대의 자동차는 전진 또는 멈출 수 있다.  
✅ 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.  
✅ 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.   
✅ 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.  
✅ 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.  
✅ 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.  
✅ 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.  
✅ 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.  


### 도메인 모델

```mermaid
classDiagram
    Application ..> CarGameController
    CarGameController ..> CarGameService
    CarGameController --> OutputView
    CarGameController --> InputView
    CarGameController --> Validator
    
    CarGameService --> CarDto
    CarGameService --> Parser
    CarGameService --> RandomMove

    CarDto --> Car
    
    class Application {
        + run()
    }
    %% controller 
    class CarGameController {
        + run()
    }
    %% util
    class CarGameService {
        + playGame()
        - round()
        - enrollCar()
        - MoveCar()
        - getWinningCar()
    }
    
    class CarDto {
        + enrollCar()
        + findCarByName()
        + findAll()
        + increaseCarPosition()
    }
    
    class InputView {
        + getInput()
    }
    
    class OutputView {
        + winnerMessage()
    }
    
    class Car {
        - carName : String
        - position : int
        - getPosition()
    }

    class RandomMove {
        + isMove()
    }
    
    class Parser {
        + parseUserInputToList()
        + ParseInt()
    }

    class Validator {
        + validParseInt()
        + validRangeNumber()
        + validName()
    }
    
```

    
### 주의사항

- TDD 지키자!

