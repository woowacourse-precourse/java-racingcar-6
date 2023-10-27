# 기능 목록

## class

### Application
RacingCarGame을 실행시킴
- main : 프로그램을 실행하고 종료하는 클래스


### RacingCar
각각의 자동차를 나타내는 클래스로 필드는 이름과 이동량
생성자(이동량은 default:0)

### RacingCarGame
초기값을 입력받고 자동차를 만들고 게임 시작(필드로는 자동차 list,랜덤수생성기)

- playGame() : 게임시작
  - init() : 초기 자동차이름과 시도횟수 입력
    - inputCarNamesAndNumOfTimes() : 자동차이름과횟수를 입력받기
      - checkInputValid() : 입력한 것에 오류가 없는지 검증(5자리 이상의 이름이 있는지)
    - generateRacingCars() : 입력받은 값을 가지고 RacingCar 생성후 자동차 list에 넣기
      - StringToListOfString() : 입력받은 문자열을 가지고 ,로 구분하여 String을 list<String>로 변환
      - generateRacingCar() : List에서 하나의 이름을 꺼내 RacingCar 객체를 생성(이동량의 default:0)
  - 반복문으로 입력받은 시도횟수만큼 play
    - play(): 1회차마다 
      - decideToGoOrStop() : 리스트에서 자동차를 꺼내서 전진할지말지
        - 1회마다 RandomNumGenerator 이용해 랜덤 수 생성
        - 전진할지 말지를 결정하고 이동량을 올려줌
      - printCurrentResult() : 1회마다 현재의 이동량을 바꿔서을 이름과 함께 출력
  - printWinner() : 시도횟수가 종료되었을 시 
    - whoIsWinner() : 우승자 조회 (각각 이동량 비교)
    - 우승자 출력

### RandomNumGenerator
1~9사이의 무작위 숫자를 뽑아주는 역할

1. 전진하는 조건 확인하는 함수
2. 각 차수별 전진하는 조건을 확인하여 전진 혹은 멈추는 함수
3. 실행결과를 출력하는 함수
4. 우승자를 확인하는 함수
5. 우승자를 출력하는 함수
6. 자동차의 이름 입력이 잘못되었는지 확인하는 함수