# 출력

## 게임 상태에 대한 출력(OutputView)

- `경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)`
- `시도할 회수는 몇회인가요?`
- `실행 결과`
- 실행 과정
    - `car1.name : -`
    - `car2.name : --`
- `최종 우승자 : car1.name, car2.name`

## 입력에 대한 예외처리

- `경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)`  - `CarNameValidator.java`
- 문자열 초과 예외
    - 체크예외(OOM, Out Of Memory)
- 공백인 경우
- 5자 초과인 경우
    - 공백인 경우에서 예외를 통과하면 최소 1글자 이므로, 사실 5글자 초과인지에 대해서만 예외 처리를 하면된다. 하지만 나는 명시적으로 최소 글자수와 최대 글자수를 1과 5로 명시해서 체크했다.
- 쉼표 연속인 경우
    - ex) “pobi,woni,,ms” = [”pobi”,”woni”,””,”ms”]
    - 자바 `split` 매서드에 의해 공백인 경우에서 예외가 발생한다.
- 쉼표로 시작인 경우
    - ex) “,pobi,woni” = [””, “pobi”, “woni”]
    - 쉼표로 시작하는 경우, 자바 `split` 매서드에 의해 공백인 경우에서 예외가 발생한다.
- 쉼표로 끝나는 경우
    - ex) “pobi,woni,”  = [”pobi”,”woni”]
    - 위의 경우, 자바 `split` 매서드 동작 방식에 의해 예외가 걸리지 않는다.
    - ex) “pobi,woni, ms “ = [”pobi”,”woni”,” ms “]
    - 위의 경우, 예외가 걸리지 않는다.
- 중복 이름은 Id로 구분

<aside>
💡 쉼표로 시작 또는 끝나는 경우 자바의 `split` 매서드에 의존한다. 예를 들어, 자바 split 동작방식이 바뀐다면 프로젝트 코드도 수정해야 할 수 있다. 하지만 이런 논리라면 자바 콜렉션 또는 contains 같은 매서드도 사용하면 안된다.

</aside>

- `시도할 회수는 몇회인가요?` - `RoundCountValidator.java`
    - 문자열 초과 예외 - (OOM, 예외가 아닌 에러)
    - 공백 예외
    - 숫자가 아닌 경우 예외
        - Integer.ParseInt() 는 문자열을 int 형으로 변경하지 못할 경우, `NumberFormatException` 예외를 뱉는다.
        - `NumberForamtException` 의 조상은 `IllegalArgumentException`
    - 범위 예외
        - 음수인 경우 예외
        - 양수여도, 자료형 int 최대 값 넘으면 예외
            - Integer.ParseInt() 는 문자열을 int 형으로 변경하지 못할 경우, `NumberFormatException` 예외를 뱉는다.
            - 레이싱 경기에서 사실 int 형 최대값인 2^31 - 1 만큼 경기를 하지는 않겠지만, 우선 이렇게 범위를 설정 해두었음. *`ROUND_COUNT_MAX_INT_VALUE`,* *`ROUND_COUNT_MIN_INT_VALUE` 변경 시 최소 , 최대 레이싱 횟수를 조정할 수 있다.*
        - 0도 예외로 작성, 모두에게 우승 상을 줄 수는 없음
    - 소수 예외
        - Integer.ParseInt() 는 문자열을 int 형으로 변경하지 못할 경우, `NumberFormatException` 예외를 뱉는다.

---

# 시나리오

1. InputView 로 부터 자동차 이름들 입력을 받는다.
2. 검증 후, CarListGenerator() 을 이용해 이름을 가진 자동차들 생성 (List<Car>)
3. List<Car> 을 가지고, 같은 레이싱에 참가 할 자동차 집합 생성 (Cars) 
4. InputView 로 부터 라운드 횟수 입력을 받는다.
5. 라운드 횟수 검증 후, 라운드 횟수 만큼 같은 레이싱에 참가 할 Cars 을 Race 파라미터로 보낸다.
6. Race 는 1 라운드 씩 진행하며, 총 라운드 횟수 만큼 진행한다.
7. Camera 는 1 라운드를 할 때마다, Cars 을 찍으면서, Cars 의 위치 정보를 문자열로 반환한다.
8. 컨트롤러는 Camera 가 반환한 문자열을 OutputView 에 넘겨준다. 

---

# 클래스 구성

## controller

- **RacingCarController**
    - 도메인과 도메인. 도메안과 뷰를 상호작용 시키는 클래스

## domain

- **Car**
    - static **long**  *idAutoIncrement* = 0L - 자동차가 생길때마다 1찍 증가하는 변수, CarId 에 할당한다.
    - **CarId** id - 자동차 id, 이름이 같을 수 있으므로 구분한다.
    - **Name** name - 자동차 이름
    - **int** postion - 자동차 현재 위치
- **Cars**
    - **List<Car> cars  -** 같은 레이싱에 참여하는 자동차들 모음.
        - 한번 참여하면, 바뀌지 않음 → 불변 클래스, 객체→ java 17 record을 이용했다.
        - List.copyOf 를 이용해, 같은 Cars 참조에 대한 정보를 추가,삭제,클리어 시 `UnsupportedOperationException` 발생
            - `UnsupportedOperationException` 는 런타임 예외
- **Race**
    - 같은 레이싱에 참가하는 Cars 파라미터로 넘겨주면, 한 라운드의 레이싱 경기를 진행한다.
        - 레이싱 룰은, 각 자동차마다 랜덤 숫자를 생성하고, 그 숫자가 최소 임계값(4)를 넘으면 앞으로 한칸 전진한다.
    - **public** **void** **runOneRound(final Cars cars) - Cars 을 가지고, 1라운드 진행**
    - **private int generateRandomValue() - 랜덤 숫자 생성**
    - **private void** **forwardIfThresholdMet(Car car, int randomValue) - 랜덤 숫자가 최소 임계값 넘으면 차는 한칸 전진**
- **Camera**
    - 카메라에게 경기중인 Cars 을 넘겨주면, 그 Cars 들의 현재 position 을 생중계 해준다.
        - Race 를 넘겨줘도 되지만, 그러면 Race 에 getCars() 라는 매서드를 추가해야 한다.
    - **public String captureRaceState(final Cars cars) -** Race 중인 Cars 의 상태를 포착한다.
    - **private** **String generatePositionDashString(final int position) -** Cars 의 포지션 만큼 “-” 로 표현한다.
- **Judgement**
    - Race 를 RoundCount 만큼 진행하고, 끝난 Cars 들을 불러와 최종 우승자를 판단한다.
    - **public String determineWinners(final Cars cars)-** maxPosition 을 토대로 최종 우승자를 판단
        - 최종 우승자들을 Cars 로 표현하는게 아니라, 문자열로 만들어서 컨트롤러에 리턴해준다.
        - 컨트롤러는 이 String 을 OutputView 에게 message 형태로 보내준다.
        - OutputView 는 단순히 String message 를 출력한다.
    - **private int calculateMaxPosition(final Cars cars)** - 가장 큰 position 찾는 매서드

## utils

utils 는 모두 정적 매서드를 하나씩 가진다.

따라서 무분별한 생성자를 사용하지 못하도록 생성자를 private 으로 막아두었다.

- **CarListGenerator**
    - 사용자가 입력한 자동차 이름 “pobi,woni”을 토대로 List<Car> [new Car(”pobi”), new Car(”woni”) 을 생성해서 반환한다.
- **NumberGenerator**
    - 랜덤 숫자 0에서 9까지의 정수 중 한 개의 정수를 생성해서 반환한다.

## validator

- **CarNameValidator -** 자동차 이름 예외처리
- **RoundCountValidator -** 라운드 횟수 예외처리

## view

- **InputView** : 게임에 필요한 데이터를 가져온다. (입력)
    - 공백 예외를 처리 해준다.
- **OutputView** : 사용자에게 출력을 담당한다. (출력)
    - `경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)`
    - `시도할 회수는 몇회인가요?`
    - `실행 결과`
    - 실행 과정
        - `car1.name : -`
        - `car2.name : --`
    - `최종 우승자 : car1.name, car2.name`


## vo

vo 는 불변성을 가진다. 또한 객체내의 값이 같으면 동등성 + 동일성을 만족해야한다.

그래서 equals, hashcode 을 오버라이딩 해줬다.

- **CarId  - 각각의 자동차 Id (중복이름을 가진 예외처리)**
- **CarName - 각각의 자동차 name (중복이름을 가질 수 있다. 하지만 같은 이름을 가진다고 같은 자동차는 아니다. CarId 가 다름.)**
- **RoundCount - 자동차들이 레이싱 할 경기 횟수 (한번 정한 레이싱 횟수는 달라지지 않는다)**
- **int** position - 자동차 현재 위치 도 vo 로 나타낼까 했지만, position 은 불변하지도 않고, 자동차가 전진할때마다 새로운 vo Postion 객체를 생성하는 것은, 불필요한 객체 생성이라고 생각해서 우선 int 형으로 남겨뒀다.
