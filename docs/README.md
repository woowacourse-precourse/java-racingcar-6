## 기능 목록
- 자동차 이름 사용자 입력을 받는 기능

- 사용자가 입력한 자동차 이름을 가공하는 기능

      구현) 쉼표(,)를 기준으로 구분
      예외) 5자를 초과한 경우 IllegalArgumentException 발생

- 자동차를 생성하고 이름을 부여하는 기능

      구현) 자동차 이름 좌우 공백 제거
      예외) 이름이 중복되는 경우 IllegalArgumentException 발생
      예외) 이름이 빈칸인 경우 IllegalArgumentException 발생(10.30 추가)
~~구현) 자동차 전진 횟수에 따라 순위 나열 추가(10.29)~~ -> 우선순위 큐를 사용하는 방식에서 Collection의 sort로 변경

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
- ~~사용자가 입력한 자동차 이름 UserInputCarName~~

        Input 클래스에 static 변수로 저장하기로 변경(10.27) -> 중복되는 객체를 생성할 필요가 없다 
- UserInputCarName을 가공하는 객체 UserInputCarNameFactory
- 자동차 객체 Car
- n 대의 Car을 List Collection 형태로 저장하는 객체 Cars
- 사용자가 입력한 이동 횟수 UserInputCarMoveCountDto
- 사용자가 입력한 이동 횟수를 가공하는 객체 UserInputCarMoveCountService 추가(10.29)
- 자동차 전진 기능을 구현하는 CarMoveService
- 우승자를 알려주는 기능을 구현하는 ~~CarWinnerService~~ CarRacingWinnerService(10.28 변경)
- 함수의 순서를 정의하는 ~~CarGame~~ RacingCarGameController(Class 이름이 구체적이지 않다 -> 10.28 변경)
- 객체를 관리하는 BeanFactory(Singleton 패턴을 위해 10.30 추가)
- Car List Collection을 저장하는 CarList 객체 추가(ArrayList 상속, contains method @Overrid, 10.29 추가)


## 리팩토링

- 중복처리 로직 Stream -> Enhanced For Loop 방식으로 변경(오버라이딩 한 contains 메소드로 구현)
- 객체를 Singleton 패턴으로 관리하기
- RacingCarGameController에 4개 이상의 인스턴스가 존재한다 -> 줄이기
