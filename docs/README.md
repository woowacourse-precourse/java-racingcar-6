## 기능 요구 사항

- 주어진 횟수 동안 n대의 자동차는 **전진 또는 멈출 수 있다**
- **각 자동차에 이름 부여 가능**. 전진하는 자동차 출력 시 이름도 같이 출력
- 자동차 이름은 **쉼표를 기준으로 구분**(입력), **이름은 5자 이하만 가능**
- **전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우**
- 자동차 경주 게임 완료 후 누가 우승했는지 알려준다. 우승자는 1명 이상 가능
    - 우승자가 여러명일 경우 쉼표를 이용하여 구분
- 사용자가 잘못된 값 입력할 경우 `IllegalArgumentException` 을 발생시킨 후 애플리케이션이 종료되도록 한다

## 추가된 요구 사항

- indent(들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다
    - 예: while문 안에 if문 있으면 들여쓰기는 2이다
    - 힌트: indent(들여쓰기) depth를 줄이는 좋은 방법은 함수(or 메서드)를 분리하면 된다.

      [이유와 솔루션으로 정리하는 객체지향 생활체조 원칙](https://hudi.blog/thoughtworks-anthology-object-calisthenics/)

- 3항 연산자를 쓰지 않는다
- 함수(메서드)가 한 가지 일만 하도록 최대한 작게 만들어라
- **JUnit5 AssertJ를 이용하여 본인이 정리한 기능 목록이 정상 동작함을 테스트 코드로 확인한다**
    - 테스트 도구 사용법이 익숙하지 않다면 `test/java/study`를 참고하여 학습한 후 테스트를 구현한다

### Model

- Car
    - [x]  name
    - [x]  distance
    - [x]  생성자(String name)
    - [x] bar(이동거리를 나타냄 "---")
    - [x]  update Distance

        - 외부에서 호출하면 Car에서 업그레이드 → 1씩 증가함

    - [x]  여기서 toString 만들기 "이름 : ---"
    - [x]  int getDistance
    - [x]  String getName

        - 우승자 이름 가져올 때 사용하기 위해

- CarList
    - [x]  생성자(List<String> names)

        - controller/putCar에서 List<String> names 받으면 이걸로 CarList 생성하기

    - [x] UpdateDistancee(List<Integer> distances)

    - [x]  List<String> getWinner()

        - distacance가 max인 List<String> names 반환하기

    - [x]  String toString (자동차 수만큼)

        - carList에서 car 하나의 tostring을 받아와서 다 붙이고 마지막에 \n 붙이기

    - [x]  getSize()
        - 자동차 갯수 리턴하는 함수
    - [x]  int getMaxDistance()
        - 각 자동차의 distance 값 중 제일 큰 값 리턴

      ```java
      List<Car> cars = new ArrayList<>();
      cars.add(new Car("a", 3));
      cars.add(new Car("b", 5));
      cars.add(new Car("c", 6));
      cars.add(new Car("d", 6));
      
      System.out.println(cars.stream().max(Comparator.comparingInt(Car::getDistance)).get().getDistance());
      ```

### Controller

- controller
    - [x]  makeCarList
        - 입력받은 이름들로 CarList 객체 만들기
    - [x] getAttemptNumber
    - [x] getEnteredNames
        - 5글자 이하 이름 입력 받고 쉼표를 기준으로 구분하기
        - seperateNames
        - validateOverorZero
        - validateDuplicate
    - [x] seperateNames
    - [x] makeRandomNumberList
    - [x]  play(int howMany)
        - 입력된 수 만큼 반복하며 게임 진행
    - [x]  whoisWinner
        - 우승한 사람들 리턴
    - [x]  replaceZeroAndOne
        - 4 이상이면 1, 아니면 0으로 바꾼 리스트를 리턴
- validate
    - [x]  name가 제대로 들어왔는지 확인
        - [x]  validateOverorZero 이름이 5글자 이상인지 아님 ""이 들어왔는지 확인
        - [x]  validateDuplicate 중복인 이름이 있는지 확인
    - [x]  number가 제대로 들어왔는지 확인
        - [x] validateInteger
- Generator
    - [x]  랜덤한 숫자 리턴

### View

- inputView
    - [x]  String getLine

        - 사용자의 입력 받아 리턴


- outputView
    - [x]  void printAskName

        - `경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)`

    - [x]  void printAskNumber()

        - `시도할 회수는 몇회인가요?`

    - [x]  void printResult()

        - `실행 결과`

    - [x]  void printInterm

        - controller에서 받은 string 그대로 출력

      ```
      pobi : -
      woni :
      jun : -
      ```

    - [x]  void printWinner
        - controller의 whoWinnner 호출 받아서 출력

### Application

- [x]  구현하기
    - 이름 입력 받기
    - 숫자 입력받기
    - 이름에 따른 CarList 생성
    - 게임 진행
    - 우승자 출력

### 목표

- 기능 목록을 상세히 작성한다.
- 기능 요구사항, 프로그래밍 요구 사항, 과제 진행 요구사항을 정확히 준수한다.
- 이름을 통해 의도를 드러내고 축약하지 않는다.
- 의미 없는 주석을 달지 않는다.
- 배열 대신 Java Collection을 사용한다.
- 읽기 쉬운 코드를 작성하려 노력한다.
- 객체에 메시지를 보내 객체 내에서 일을 하도록 한다.
- 함수가 한 가지 일만 하도록 최대한 작게 만든다.