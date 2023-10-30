## 기능 목록
- [x] 자동차 클래스
    - 이름, 얼마 이동했는지 값을 갖고 있는 객체이다.
- [x]  쉼표를 기준으로 5글자 이하의 자동차 이름을 입력 받는 기능이다. -  `Ask/askPlayerName()`
    - [ ] 자동차의 갯수가 0개라면?
    - [ ] 01, 02 같은 이름도 가능한지
    - [ ] a, a, a같은 똑같은 이름이 여러개 일때
    - [x] 입력에 공백이 들어간다면? [a, b, c]
- [x]  시도할 횟수를 입력 받는 기능이다. - `Ask/askHowMany()`
    - [x] 숫자만 입력받도록, 숫자가 아니라면 에러 던지기
    - [ ] 0이라면?
- [ ]  자동차 경주 게임 진행하는 기능이다. - `playGame(how many에서 받은 숫자, 자동차 객체를 요소로 갖고 있는 리스트)`
    - [x]  무작위 값을 구하는 기능이다. - `generateRandomNumber()`
    - [x]  전진할지 말지 선택하는 기능이다. - `play/isGo(무작위 값)`
    - [ ]  사용자별로 경주를 진행한 값을 적용(update)하는 기능이다. - `play/updateData(자동차 객체 1개)`
    - updateData() 메소드에서 generateRandomNumber()와 isGo() 메소드를 호출해서 isGo() == true이면 값 업데이트하고 아니면 다음으로 넘어가고..
    - for문을 최대한 적게 써서 구현할 수 있을까?
- [x]  우승 결과 알려주는 기능이다. - `Referee/whoIsWinner(자동차 객체를 요소로 갖고 있는 리스트)`
- [x] 기능 결합
    - [ ]  시도한 결과는 시도 횟수만큼 콘솔에 출력된다.
    - 커밋 메시지에 얼레벌레 만듬이라 써도 되나?
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
- **JUnit4 AssertJ를 이용하여 본인이 정리한 기능 목록이 정상 동작함을 테스트 코드로 확인한다**
    - 테스트 도구 사용법이 익숙하지 않다면 `test/java/study`를 참고하여 학습한 후 테스트를 구현한다

## 시간 나면 해보세요
- [ ] Car 클래스 캡슐화 도전, 직접 값에 접근 못하게 하도록


## 구현 목록
### Model

- Car
    - [x]  name
    - [x]  distance
    - [x]  생성자(String name)
    - [x]  update Distance

        - distance 직접 업그레이드 → 1씩 증가함

    - [x]  여기서 toString 만들기 (1개)
    - [x]  int getDistance
        - 값 복사해서
- CarList
    - [x]  생성자(List<String> names)

        - controller/putCar에서 List<String> names 받으면 이걸로 CarList 생성하기

    - [x]  upgrade distance(List<Integer> distances)

        - 리스트별로 생성자에 업그레이드, 근데 이게 맞나? 이름에 맞춰서 해야 되지 않나? - update Distance 사용하기

    - [x]  List<String> getWinner()

        - 스트림을 돌면서 getDistance해서 값 같은 애들 getName해서 집어넣기

    - [x]  String toString (자동차 수만큼)

        - carList에서 car 하나의 tostring을 받아와서 다 붙이고 마지막에 \n 붙이기

    - [x]  getSize()
        - 자동차 갯수 리턴하는 함수
    - [x]  int getMaxDistance()
        - car 하나씩 비교해서 max가져오기 아님 모.. 스트림 만들어서 distance만 가져오고 거기에서 max를 구할 수 있는 간단한 함수가 있으면 그걸 쓰셈

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
    - [x]  putCarList(view에서 받은 List<String>)

        - validateName 실행시키고

        - CarList 생성자 만들기

    - ~~int howMany = view의 askHowMany에서 return한 값~~ → main에서 view에서 가져오고 play를 실행시키기로 함(main에서 실행할 때 inputView의 askNumber 실행해서 String으로 받아오고 validation 실행하기(그리고 main에서 parseInt 실행하자..
    - [x]  int getHowMany(String view에서 온 친구들)
        - 여기서 validateName 실행시키고 int 리턴하기
    - [x]  play(int howMany)
        - [x]  List <Integer> distances5개의 new Generator(); 해서 반복문 들어가게
        - updatedistance(List<Integer> distances) // 자동차 갯수만큼 넘김
        - play 윗단에서  while howMany만큼 실행하게 되고 play는 아닌가..? play만큼 해도 되려나?
        - view에게 carList에서 얻은 toString 넘기기 `중간결과toView` 이런거
            - 이거 어디서 받는데?
            - CarList의 toString 받아서 이걸 View에 전달할거임 그냥 바로 리턴하면 됨
    - whoWinner
        - CarList의 getWinner 호출
- validate
    - [x]  name가 제대로 들어왔는지 확인
    - [x]  number가 제대로 들어왔는지 확인
    - [x]  랜덤한 수가 4 이상이면 1, 4미만이면 0으로 바꾸기 → 스트림 어쩌구 바꿔서  매핑을 하거나 filter인가 머시기 쓰면 됨!
        - java stream mapping을 사용하는 것 같은데 아직 와닿지 않음

          https://futurecreator.github.io/2018/08/26/java-8-streams/

        - 람다식 안에서 리턴하면 될 듯

        - 그리고 collect?로 결과 리턴

            ```java
            // main에서 테스트
            Validate v = new Validate();
            List<Integer> arr = new ArrayList<>(Arrays.asList(1,2,3,4,5));
            List<Integer> result = v.replaceZeroAndOne(arr);
            System.out.println(result);
            ```

            ```java
            [0, 0, 0, 1, 1]
            ```

          https://www.slipp.net/questions/552

- Generator
    - 랜덤 숫자 리턴

### View

- inputView
    - [x]  List<String> getNames (”
        - 사용자의 입력 받아 리턴
    - [x]  String askHowMany
        - `시도할 회수는 몇회인가요?`
        - 사용자의 입력 받아 리턴
        - 유효한지는 controller에서 평가
- outputView
    - [x]  void askNames
        - `경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)`
    - [x]  void print”실행 결과”
        - ㄹㅇ sout (”실행 결고”)
    - [x]  void print중간과정

        - controller에서 받은 string 넘긴걸 sout 하기 `중간결과toView`에서 리턴받으세요

       ```
       pobi : -
       woni :
       jun : -
       ```

    - [ ]  void 최종우승자
        - controller의 whoWinnner 호출해서 sout
    - [x]  void printError()
        - 잘못된 값을 입력하셨습니다.

### Application

- [x]  구현하기
    - [view] 에서 입력 실행
    - controller: 이름 입력값 가져오기
    - [view]: 횟수 입력하세요 출력
    - [controller]: 횟수 가져오기
    - controller: put carlist
    - [view] 실행 결과 출력되게
    - [controller] play
        - [view] 중간 과정 실행
    - [view] 최종 우승자 실행