# < 기능 목록 정의 >

## 💻 Domain 정의

------------------

### Player

#### : 플레이어의 정보가 담긴 클래스

| 이름        | 설명                      | 구분 (타입)  | I / O                                    |
|:----------|:------------------------|:---------|:-----------------------------------------|
| firstNum  | 플레이어의 첫 번째 숫자           | 필드 (int) |                                          |
| secondNum | 플레이어의 두 번째 숫자           | 필드 (int) |                                          |
| thirdNum  | 플레이어의 세 번째 숫자           | 필드 (int) |                                          |
| Player    | AllArgumentsConstructor | 생성자      | firstNum, secondNum, thirdNum / －        |
| Getter    | 플레이어의 각 숫자를 가져온다.       | Getter   |                                          |
| Setter    | 플레이어의 각 숫자를 설정한다.       | Setter   | firstNum / －, secondNum/ －, thirdNum / － |
| setAllNum | 플레이어의 모든 숫자를 설정한다.      | 메서드      | firstNum, secondNum, thirdNum / －        |

### Computer

#### : 컴퓨터의 정보가 담긴 클래스

| 이름        | 설명                      | 구분 (타입)  | I / O                                    |
|:----------|:------------------------|:---------|:-----------------------------------------|
| firstNum  | 컴퓨터의 첫 번째 숫자            | 필드 (int) |                                          |
| secondNum | 컴퓨터의 두 번째 숫자            | 필드 (int) |                                          |
| thirdNum  | 컴퓨터의 세 번째 숫자            | 필드 (int) |                                          |
| Computer  | AllArgumentsConstructor | 생성자      | firstNum, secondNum, thirdNum / －        |
| Getter    | 컴퓨터의 각 숫자를 가져온다.        | Getter   |                                          |
| Setter    | 컴퓨터의 각 숫자를 설정한다.        | Setter   | firstNum / －, secondNum/ －, thirdNum / － |
| setAllNum | 플레이어의 모든 숫자를 설정한다.      | 메서드      | firstNum, secondNum, thirdNum / －        |

<br></br>

## 💻 Service 정의

------------------

### PlayerService

#### : 플레이어가 행하는 서비스

| 이름                      | 설명                                  | 구분 (타입) | I / O                                                |
|:------------------------|:------------------------------------|:--------|:-----------------------------------------------------|
| inputPlayerNumber       | 플레이어에게 숫자 3개를 입력 받아, 유효성 검사 후 리턴한다. | 메서드     | － / Player                                           |
| getPlayerNumber         | 플레이어의 숫자 리스트를 리턴한다.                 | 메서드     | Player / ArrayList\<Integer> playerNumberList        |
| checkInputPlayerNumber  | 플레이어가 입력한 숫자가 유효한지 확인하는 메서드를 실행한다.  | 메서드     | String inputPlayerNumbers / IllegalArgumentException |
| checkCharacterExistence | 문자를 포함하지 않는지 확인한다.                  | 메서드     | String inputPlayerNumbers / IllegalArgumentException |
| checkLength             | 숫자의 개수를 확인한다.                       | 메서드     | String inputPlayerNumbers / IllegalArgumentException |
| checkDuplicateNumber    | 중복된 숫자가 없는지 확인한다.                   | 메서드     | String inputPlayerNumbers / IllegalArgumentException |
| checkPresenceOfZeros    | 0을 포함하는지 확인한다.                      | 메서드     | String inputPlayerNumbers / IllegalArgumentException |

### ComputerService

#### : 컴퓨터가 행하는 서비스

| 이름                | 설명                  | 구분 (타입) | I / O                          |
|:------------------|:--------------------|:--------|:-------------------------------|
| setComputerNumber | 컴퓨터의 숫자를 랜덤으로 설정한다. | 메서드     | － / Computer                   |
| getComputerNumber | 컴퓨터의 숫자를 리스트로 반환한다. | 메서드     | Computer / ArrayList\<Integer> |

### MessageService

#### : 메세지를 보여주는 서비스

| 이름             | 설명                        | 구분 (타입) | I / O                   |
|:---------------|:--------------------------|:--------|:------------------------|
| startMessage   | 게임을 시작할 때 메세지를 출력한다.      | 메서드     |                         |
| inputMessage   | 플레이어의 숫자를 입력받는 메세지를 출력한다. | 메서드     |                         |
| endMessage     | 게임을 종료하는 메시지를 출력한다.       | 메서드     |                         |
| restartMessage | 게임 재시작 여부를 묻는 메세지를 출력한다.  | 메서드     |                         |
| resultMessage  | 게임 결과 메세지를 출력한다.          | 메서드     | ArrayList\<Integer> / － |

### GameService

#### : 서비스를 통합하는 서비스이자 게임을 수행하는 서비스

| 이름                 | 설명                                                | 구분 (타입)              | I / O                                                            |
|:-------------------|:--------------------------------------------------|:---------------------|:-----------------------------------------------------------------|
| computerService    | ComputerService 객체                                | 필드 (ComputerService) |                                                                  |
| playerService      | PlayerService 객체                                  | 필드 (PlayerService)   |                                                                  |
| messageService     | MessageService 객체                                 | 필드 (MessageService)  |                                                                  |
| initComputer       | 게임 시작 메세지를 출력하고 setComputer() 을 호출한다.             | 메서드                  | － / Computer                                                     |
| setComputer        | 컴퓨터의 숫자를 설정한다.                                    | 메서드                  | － / Computer                                                     |
| initPlayer         | 플레이어의 숫자를 설정한다.                                   | 메서드                  | － / Player                                                       |
| getResult          | checkBallCount() 에 맞는 인자를 계산해서 넣어주어 호출한다.         | 메서드                  | (Computer, Player) / ArrayList\<Integer>                         |
| checkBallCount     | 컴퓨터와 플레이어의 숫자를 비교해 결과를 도출한다.                      | 메서드                  | (ArrayList\<Integer>, ArrayList\<Integer>) / ArrayList\<Integer> |
| showResult         | 게임 결과 메세지를 출력한다.                                  | 메서드                  | ArrayList\<Integer> / －                                          |
| confirmGameRestart | 정답을 맞췄을 때 메세지를 출력하고, inputRestartAnswer() 를 호출한다. | 메서드                  | － / Boolean                                                      |
| inputRestartAnswer | 게임 재시작 여부를 입력받는다.                                 | 메서드                  | － / Boolean                                                      |

<br></br>

## 💻 Controller 정의

------------------

### Controller

#### : 숫자 야구 게임 전체 로직 클래스

| 이름          | 설명                         | 구분 (타입)          | I / O |
|:------------|:---------------------------|:-----------------|:------|
| gameService | 게임을 실제 수행하는 GameService 객체 | 필드 (GameService) |       |
| playGame    | 게임 메인 로직                   | 메서드              |       |

<br></br>

---

# < 클래스 다이어그램 >

![img.png](img.png)
