## 기능 목록
- 자동차 이름 사용자 입력을 받는 기능

- 사용자가 입력한 자동차 이름을 가공하는 기능

      구현) 쉼표(,)를 기준으로 구분
      예외) 5자를 초과한 경우 IllegalArgumentException 발생

- 자동차를 생성하고 이름을 부여하는 기능

      구현) 자동차 이름 좌우 공백 제거
      예외) 이름이 중복되는 경우 IllegalArgumentException 발생

- 몇 번 이동할 것인지 사용자 입력을 받는 기능

      예외) 숫자 이외의 값을 입력한 경우 InvalidTypeException 발생
      예외) Integer보다 큰 값을 입력한 경우 StackOverFlow 발생 우려-> InvalidInputException Wrapping

- 자동차 전진 기능

      구현) 0~9의 랜덤값 생성
      구현) 4이상인지 판단
      구현) 전진

- 우승자 알려주는 기능

      구현) 가장 많이 전진한 차량이름 출력
      구현) 공동우승일 경우 쉼표(,)로 구분
      구현) 전진한 차량이 없는 경우 우승자가 없다는 메시지 출력


## 객체 설계

- 사용자 UI를 구현하는 Input, Output 객체
- 사용자가 입력한 자동차 이름 UserInputCarName
- UserInputCarName을 가공하는 객체 UserInputCarNameFactory
- 자동차 객체 Car
- n 대의 Car을 List Collection 형태로 저장하는 객체 Cars
- 사용자가 입력한 이동 횟수 UserInputCarMoveCount
- 자동차 전진 기능을 구현하는 CarMoveService
- 우승자를 알려주는 기능을 구현하는 CarWinnerService
- 함수의 순서를 정의하는 CarGame
