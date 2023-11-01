# 기능 목록

## class

### Application
RacingCarGame을 실행시킴
- main : 프로그램을 실행하고 종료하는 클래스


### RacingCar
각각의 자동차를 나타내는 클래스로 필드는 이름과 이동량
생성자(이동량은 default:0)
- plusDistance() : 이동량 증가

### RacingCarGame
초기값을 입력받고 자동차를 만들고 게임 시작(필드로는 자동차 list,랜덤수생성기,실행횟수)

- playGame() : 게임시작
  - init() : 초기 자동차이름과 시도횟수 입력
    - 자동차입력 받기
    - generateListOfRacingCars() : 입력받은 값을 가지고 RacingCar 생성후 자동차 list에 넣기
      - StringToListOfString() : 입력받은 문자열을 가지고 ,로 구분하여 String을 list<String>로 변환
      - checkCarNameValid() : 5자 이하인지 확인, 아니면 IllegalArgumentException 예외 발생
      - generateRacingCar() : List에서 하나의 이름을 꺼내 RacingCar 객체를 생성(이동량의 default:0)
    - 횟수 입력받기
    - checkInputNumValid() : 입력한 것에 오류가 없는지 검증(5자리 이상의 이름이 있는지)
    - setNumOfPlaying() : 실행횟수 setter함수 실행

  - 반복문으로 입력받은 시도횟수만큼 play
    - play(): 1회차마다 
      - decideToGoOrStop() : 리스트에서 자동차를 꺼내서 전진할지말지
        - 1회마다 RandomNumGenerator의 generateNum() 이용해 랜덤 수 생성
        - checkNum() : 랜덤수를 확인해서 전진할지 말지를 결정
        - go() : checkNum이 true라면 해당 자동차의 이동량을 1 증가
      - printCurrentResult() : 1회마다 현재의 이동량을 바꿔서을 이름과 함께 출력
  - printWinner() : 시도횟수가 종료되었을 시 
    - whoIsWinner() : 우승자 조회 (각각 이동량 비교)
    - 우승자 출력

### RandomNumGenerator
1~9사이의 무작위 숫자를 뽑아주는 역할
- generateNum() : 랜덤수 생성