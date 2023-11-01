# 미션 - 자동차경주

## 🔍 Class

|  Class  |        역할         | 속성                        |
|:-------:|:-----------------:|:--------------------------|
| 🚘 Car  |  게임에 직접 참가하는 요소   | name : 사용자 이름             |
|         |                   | position : 현재 위치를나타냄      |
| 🎮 Game | 게임을 전체적으로 총괄하는 역할 | playingCar : 게임에 참가하는 차량들 |
|         |                   | playTime : 게임진행 횟수        |

## 🚘 Car_Method

|          메서드명          |         역할         |  리턴  |
|:----------------------:|:------------------:|:----:|
|      Car(carName)      |        생성자         | void |
|          move          |  position 하나 증가시킴  | void |
| @override<br/>toString | 이름과 현재 position 출력 | void |

## 🎮 Game_Method

|            메서드명            |             역할              |                리턴                |
|:--------------------------:|:---------------------------:|:--------------------------------:|
|        startGame()         |    게임을 시작, 사용자에게 입력값을 받음    |               void               |
|         runGame()          | 게임 단계별 진행<br/>중간 결과 밑 결과 출력 |               void               |
| setPlayingCar(parsedInput) |        게임 시작시 차량을 세팅        |               void               |
|    parsingInput(Input)     |        사용자의 입력값을 파싱         |          List\<String\>          |
| validateInput(parsedInput) |       파싱된 데이터들의 유효성검사       |               void               |
|                            |                             | 🚨 IllegalArgumentException 발생가능 |
|    compareCarPosition()    |      어느 차가 가장 멀리있는지 확인      |               void               |


