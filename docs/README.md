# 기능 목록

---

## 1. Model
### 1.1. Model - Wrapper
#### 1.1.1. 이동거리 Distance

- 개요   
  차량의 이동거리를 표현하는 클래스로, 현재는 int 값을 감싸는 래퍼 클래스입니다.


- 생성자
    - 매개변수 없는 생성자  
      최초 생성 시 내부 값을 0으로 설정합니다.
    - (int nonNegativeInteger)  
      주어진 값으로 내부 값을 설정합니다. 만약, 주어진 값이 음수라면 `IllegalArgumentException` 을 발생시킵니다.

        - 성공 테스트  
          각각 0, 1, Integer.Max_VALUE로 초기화된 Distance 객체 d1, d2, d3에 대해,  
          객체가 성공적으로 생성되는가?

        - 실패 테스트1  
          음수로 초기화된 Distance 객체 d에 대해 `IllegalArgumentException`이 발생하는가?

        - 실패 테스트2  
          Integer.MAX_VALUE + 1 의 값을 가지는 long 타입 변수로 생성이 시도된 경우,  
          컴파일 에러가 발생하는가?


- 기능1: increaseByOne()  
  자신의 값을 1만큼 증가시키고 true를 반환합니다.  
  만약, 내부 값이 Integer.MAX_VALUE 이면 증가시키지 않고 false를 반환합니다.

    - 성공 테스트  
      각각 0, Integer.MAX_VALUE로 초기화된 두 Distance 객체 d1, d2에 대해,  
      d1.increaseByOne() 가 true이고, d2.increaseByOne()이 false인가?


- 기능2: compareTo(Distance)  
  Comparable<Distance> 인터페이스의 compareTo 메소드를 재정의합니다.  
  기준_Distance.compareTo(대상_Distance) 메소드는 두 Distance를 비교하여 기준_Distance 큰 경우 양의 정수를,  
  같은 경우 0을 , 작은 경우 음의 정수를 반환합니다.

    - 성공 테스트  
      각각 0, 1, 1, 2로 생성된 Distance 객체 d1, d2, d3, d4에 대해 다음의 조건을 모두 만족해야한다.
        - 자기 자신과 비교  
          d1.compareTo(d1) == 0,
        - 다른 객체와 동일성 비교  
          d2.compareTo(d3) == 0,
        - 대칭성  
          d1.compareTo(d2) == d2.compareTo(d1) * (-1)
        - 추이성  
          (d4.compareTo(d3) > 0 && d3.compareTo(d2) == 0 && d2.compareTo(d1) > 0)
          -> d4.compareTo(d2) > 0 && d4.compareTo(d1) > 0
        - 반사성  
          d2.compareTo(d3) == 0 -> ( sgn(d2.compareTo(d1)) == sgn(d3.compareTo(d1)) )


- 기능3: toString()  
  Object 클래스의 toString 메소드를 재정의합니다.  
  자신의 거리 만큼의 '-' 문자로 이루어진 문자열을 반환합니다.  
  예를 들어, 내부 값이 3인 Distance의 경우 "---"을 반환합니다.

    - 성공 테스트  
      0, 1, 2, 3, 4 로 초기화된 Distance 객체 d1, d2, d3, d4에 대해,  
      toString 메소드에서 반환되는 문자열이 각각 "", "-", "--", "---", "----" 인가?


#### 1.1.2. 차량이름 Name

- 개요  
  차량의 이름을 표현하는 클래스로, 현재는 String 값을 감싸는 래퍼 클래스입니다.


- 생성자(String unsure)  
  주어진 값으로 내부 값을 설정합니다.  
  만약, 주어진 문자열이 앞 또는 뒤에 1개 이상의 공백 문자를 포함하거나, 빈 문자열 이거나, 5글자를 초과하는 경우,  
  또는 unsure가 널인 경우에도 `IllegalArgumentException`을 발생시킵니다.

    - 성공 테스트  
      1이상 5이하의 길이를 가지고, 앞 또는 뒤에 공백 문자를 포함하지 않는 다양한 문자열을 이용하여  
      Name을 생성합니다.
      문자열의 중간에는 공백 문자가 올 수 있습니다.

    - 실패 테스트  
      널, 빈 문자열, 앞 또는 뒤에 공백 문자(' ', '\t', '\n', '\r')를 포함하는 일련의 문자열, 길이가 6자 이상인 문자열을 이용하여  
      Name 객체 생성을 시도합니다. 이 과정에서 `IllegalArgumentException`이 발생해야합니다.


- 기능1: equals(Object)  
  Object 클래스의 equals 메소드를 재정의하여 두 Name 객체를 비교합니다.  
  만약 두 Name 객체의 내부 문자열 값이 같다면, true를 아니라면 false를 반환합니다.

    - 성공 테스트  
      각각 "a", "a", "a", "b" 의 값을 가진 Name 객체 n1, n2, n3, n4에 대해 다음이 모두 true여야 한다.
        - 반사성  
          n1.equals(n1)
        - 대칭성  
          n1.equals(n2) -> n2.equals(n1)
        - 추이성  
          (n1.equals(n2) && n2.equals(n3)) -> n1.equals(n3)
        - n1.equals(null) == false
        - 일관성은 별도로 검사하지 않는다.


- 기능2: toString()  
  Object 클래스의 toString 메소드를 재정의합니다.  
  자신의 이름을 표현하는 문자열을 반환합니다. 현재는 자신의 이름을 그대로 반환합니다.

    - 성공 테스트  
      "픽업 트럭", "스포츠 카", "자전거"로 초기화 된 Name 객체에 대해  
      toString 메소드의 반환값이 각각 "픽업 트럭", "스포츠 카", "자전거"인가?


#### 1.1.3. 라운드수 Round

- 개요  
  라운드 수를 표현하는 클래스로, 현재는 int 값을 감싸는 래퍼 클래스입니다.  
  Distance와 전반적으로 유사하긴 하나 추후 변경 가능성을 고려하여 분리하였습니다.


- 생성자(int nonNegativeInteger)  
  주어진 값으로 내부 값을 설정합니다. 만약, 주어진 값이 음수라면 `IllegalArgumentException` 을 발생시킵니다.

    - 성공 테스트  
      각각 0, 1, Integer.Max_VALUE로 초기화된 Round 객체 r1, r2, r3에 대해,  
      객체가 성공적으로 생성되는가?

    - 실패 테스트1  
      음수로 초기화된 Round 객체 r에 대해 `IllegalArgumentException`이 발생하는가?

    - 실패 테스트2  
      Integer.MAX_VALUE + 1 의 값을 가지는 long 타입 변수로 생성이 시도된 경우,  
      컴파일 에러가 발생하는가?


- 기능1: decreaseByOne()  
  라운드 수를 한 단계 줄이고 true를 반환합니다.  
  만약, 내부 값이 0이라면 줄이지 않고 false를 반환합니다.

    - 성공 테스트  
      각각 0, 1로 초기화된 두 Round 객체 r1, r2에 대해,  
      r1.decreaseByOne()의 반환 값이 false 이고 r2.decreaseByOne() 반환 값이 true인가?


- 기능2: equals(Object)  
  Object 클래스의 equals 메소드를 재정의하여, 두 Round 객체를 비교합니다.  
  만약 두 Round 객체의 내부 값이 같다면, true를 아니라면 false를 반환합니다.

    - 성공 테스트  
      각각 0, 0", 0, 0 의 값을 가진 Round 객체 r1, r2, r3, r4에 대해 다음이 모두 true여야 한다.
        - 반사성  
          r1.equals(r1)
        - 대칭성  
          r1.equals(r2) -> r2.equals(r1)
        - 추이성  
          (r1.equals(r2) && r2.equals(r2)) -> r1.equals(r3)
        - r1.equals(null) == false
        - 일관성은 별도로 검사하지 않는다.


### 1.2. Model - Entity
#### 1.2.1. 차량 Car

- 개요  
  차량을 표현하는 클래스입니다. Name 과 Distance 객체를 가집니다.


- 생성자(Name)  
  주어진 이름으로 Car 객체를 생성합니다. 최초 Distance 객체는 원점(0)으로 생성합니다.
  만약 주어진 name이 널인경우 `IllegalArgumentException` 을 발생시킵니다.

    - 성공 테스트  
      1이상 5이하의 글자수를 가지고 앞 또는 뒤에 공백 문자를 포함하지 않는 문자열로 생성한, Name 객체를 이용하여  
      Car 객체를 생성합니다.


- 기능1: getMyName()  
  Name을 문자열로 변환하여 반환합니다.  
  꼭 필요한 getter이기 때문에 구현했습니다.

    - 성공 테스트  
      "픽업 트럭", "스포츠 카", "자전거"로 초기화 된 Name 객체로 생성한 세 Car 객체에 대해  
      toString 메소드의 반환값이 각각 "픽업 트럭", "스포츠 카", "자전거"인가?


- 기능2: isNameSake  
  두 Car의 이름이 동일한지의 여부를 반환합니다.

    - 성공 테스트  
      "a", "a", "b"로 초기화된 Name 객체로 생성한 세 Car 객체 c1, c2, c3에 대해,  
      다음 조건들이 모두 true인가?
        - c1.isNamesake(c1)
        - c1.isNamesake(c2)
        - c2.isNamesake(c3) == false
        - c3.isNamesake(c2) == false


- 기능3: toString()  
  Object 클래스의 toString 메소드를 재정의합니다.  
  문자열 (ame.toString() + " : " + Distance.toString()) 을 반환합니다.  
  이와 같이 출력의 형식에 맞는 문자열을 반환하는 것이 View의 역할을 일정 부분 침해하는 것이긴 하지만  
  getter를 최소화 하기 위해서 이와 같이 구현했습니다.

    - 성공 테스트  
      이름이 "픽업 트럭" 이고 3회 전진한 Car 객체 car에 대해,  
      car.toString()의 반환 값이 "픽업 트럭 : ---" 인가?


- 기능4: drive()  
  10번 중 6번 꼴로 전진합니다.  
  전진한 경우 true를, 그렇지 않은 경우 false를 반환합니다.  
  무작위 숫자를 뽑기 위해서 camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange() 메소드를 사용합니다.

    - 성공 테스트  
      1,000,000,000번 drive 했을 때 반환된 true의 개수가 600,000,000 ± 10,100,000 내외인가?  
      (즉, 590,000,000 ~ 610,000,000). 10 번 반복하여 모두 통과해야 한다.


- 기능5: isNotLoseTo(Car)  
  대상 차량이 주어진 차량에 지지 않은 경우 true를, 패배한 경우 false를 반환합니다.  
  차량 a가 차량 b에 대해 지지 않았다는 것은 차량 a의 Distance가 차량 b의 Distance 보다 크거나 같다는 것을 의미합니다.  
  즉, a.distance.compareTo(b.distance) >= 0 인 경우를 말합니다.

    - 성공 테스트  
      전진한 횟수가 각각 0, 1, 1인 Car 객체 c1, c2, c3에 대해서, 다음이 모두 true인가?
        - c2.isNotLoseTo(c1)
        - c2.isNotLoseTo(c3)
        - c3.isNotLoseTo(c2)


- 기능6: compareTo(Car car)  
  Comparable<Car> 인터페이스의 compareTo 메소드를 재정의합니다.  
  기준_Car.compareTo(대상_Car) 메소드는 두 Car를 비교하여 기준_Car 이긴 경우 양의 정수를,  
  비긴 경우 0을 , 진 경우 음의 정수를 반환합니다.

    - 성공 테스트  
      전진 거리가 각각 0, 1, 1, 2인 Car 객체c1, c2, c3, c4에 대해 다음의 조건을 모두 만족하는가?
        - 자기 자신과 비교  
          c1.compareTo(c1) == 0,
        - 다른 객체와 동일성 비교  
          c2.compareTo(c3) == 0,
        - 대칭성  
          c1.compareTo(d2) == c2.compareTo(c1) * (-1)
        - 추이성  
          (c4.compareTo(c3) > 0 && c3.compareTo(c2) == 0 && c2.compareTo(c1) > 0)
          -> c4.compareTo(c2) > 0 && c4.compareTo(c1) > 0
        - 반사성  
          c2.compareTo(c3) == 0 -> ( sgn(c2.compareTo(c1)) == sgn(c3.compareTo(c1)) )


#### 1.2.2. 엔트리 Entry

- 개요
  경주에 참여할 일련의 차량들을 의미합니다.  
  List<Car> 타입 객체를 감싸는 일급 컬렉션입니다.


- 생성자(): 디폴트 생성자

- 기능1: size()  
  참가한 차량 수를 반환합니다.

    - 성공 테스트  
      서로 다른 이름을 가진 3 차량을 join한 엔트리 객체에 대하여  
      size() 메소드 반환 값이 3인가?


- 기능2: join(Car)  
  주어진 차량을 엔트리에 추가합니다.  
  만약, 동일한 이름을 가진 차량이 이미 엔트리에 존재하는 경우 `IllegalArgumentException`을 발생시킵니다.

    - 성공 테스트  
      그 이름이 각각 "a", "bc", "d e f"인 세 차량을 성공적으로 join할 수 있는가?

    - 실패 테스트  
      그 이름이 "abc" 차량을 join한 엔트리 객체에 대해, 이름이 "abc"인 다른 차량을 join하면  
      `IllegalArgumentException`을 발생시키는가?


- 기능3: driveAll()  
  엔트리에 포함된 모든 Car객체가 drive하도록 합니다.


- 기능4: getWinners()  
  우승한 Car 객체로 구성된 리스트를 반환합니다. 공동 우승자가 있을 수 있습니다.  
  만약 엔트리가 비어있는 경우 null을 반환합니다.

    - 성공 테스트  
      각각 이름과 전진 횟수가 ("a", 1회), ("b", 2회), ("c", 2회) 인 세 Car 객체를 가지는 Entry 객체 entry에 대해,    
      getWinner() 의 반환 결과에는 2회 전진한 두 차량이 "b -> c의 순서로" 존재하는가?


- 기능5: toString()  
  Object 클래스의 toString() 를 재정의합니다.  
  엔트리에 포함된 모든 Car에 대한 toString()을 순서대로 다른 줄에 가지는 문자열을 반환합니다.    
  마지막에 개행 문자를 포함합니다.

    - 성공 테스트  
      각각 이름과 전진 횟수가 ("a", 1회), ("b", 2회), ("c", 3회)인 세 Car 객체를 포함하는  
      Entry 객체에 대한 toString()이

      "a : -\n"
      "b : --\n"
      "c : ---\n"

      위 문자열과 동일한가?


#### 1.2.3. 경주 Race

- 개요
  자동차 경주를 표현하는 클래스입니다.  
  남은 라운드 수를 표현하는 Round 객체와 참가할 Car 객체를 포함하는 Entry 객체를 가집니다.


- 생성자(Round totalRound, Entry entry)  
  주어진 전체 라운드 수를 표현하는 Round 객체와 참가할 Car 객체를 포함하고 있는 Entry 객체를 이용하여 Race 객체를 생성합니다.  
  만약, 참가자 엔트리의 크기가 Race.getMinEntrySize() 보다 작은 경우 `IllegalArgumentException` 예외를 발생시킵니다.

    - 성공 테스트  
      2이상의 크기를 가진 Entry 객체와, Round 객체를 이용하여 Race 객체를 생성할 수 있는가?

    - 실패 테스트  
      2미만의 크기를 가진 Entry 객체로 Race 객체 생성을 시도한 경우 `IllegalArgumentException`예외가 발생하는가?


- 기능1: isFinished()  
  만약 경기가 종료된(남은 라운드 수가 0인) 경우 true를, 아닌 경우 false를 반환합니다.

    - 성공 테스트  
      값이 1인 Round객체로 만든 Entry 객체로 만든 Race 객체에 대해 isFinished를 호출하면 false를 반환하고,  
      값이 0인 Round객체로 만든 Entry 객체로 만든 Race 객체에 대해 isFinished를 호출하면 true를 반환합니다.


- 기능2: next()  
  경주의 한 라운드를 진행하고, 남은 라운드 수를 감소시킵니다.

    - 성공 테스트
      값이 3인 Round객체로 만든 Entry 객체로 만든 Race 객체에 대해 next()  
      메소드를 1회, 2회 호출할 때 까지는 isFinished() 메소드가
      true를 반환하지만, 3회 호출하고 난 다음에 isFinished를 호출하면 false를 반환하는가?


- 기능3: toString()  
  Object 클래스의 toString 메소드를 재정의합니다.  
  기본적으로 (entry.toString() + 빈 줄)을 반환하지만,  
  만약 경주가 종료된 상태라면 최종 우승자 리스트를 포함하여 반환합니다.

    - 성공 테스트
      값이 3인 Round객체로 만든 Entry 객체로 만든 Race 객체에 대해  
      next() 메소드를 3회 호출하고 난 다음에 호출한 toString()에서 반환된 문자열이  
      마지막 줄에 "최종 우승자 : " 로 시작하는 문자열인가?


---


## 2. View
### 2.1. RaceView

- 개요  
  커맨드라인 환경에서의 안내문구 출력 메소드와 폼 메소드를 제공합니다.  
  이 과정에서 *사용자 입력의 형식*만을 검증합니다. (입력의 내용은 모델에서 검증합니다.)  
  한편, 폼 메소드는 사용자로부터 입력을 요청하고, 입력 받은 문자열을 적절한 형태로 가공하여 반환하는 메소드를 말합니다.  
  사용자로부터 문자열을 입력 받기 위해 camp.nextstep.edu.missionutils.Console의 readLine()을 활용합니다.


- 기능1: getCarNames()  
  사용자에게 공백 없는 쉼표(,)로 구분된 일련의 자동차 이름을 입력할 것을 요구합니다.  
  사용자 입력을 쉼표를 기준으로 토큰화하여 문자열 리스트를 반환합니다.  
  입력 과정에서 예외가 발생한 경우 `IllegalArgumentException`을 반환합니다.

    - 성공 테스트1  
      입력 "a,bc,def,ghij,klnmo,p q r,st u,v w,x yz" 에 대해  
      ["a", "bc", "def", "ghij", "klnmo", "p q r", "st u", "v w", "x yz"] 의  
      9개의 요소를 가진 List<String> 타입 객체가 반환되는가?

    - 성공 테스트2  
      입력 "abcd" 에 대해 ["abcd"] 의 1개의 요소를 가진 List<String> 타입 객체가 반환되는가?

    - 성공 테스트3  
      입력 ",,," 에 대해 ["", "", "", ""] 빈 문자열 4개를 가진 List<String> 타입 객체가 반환되는가?

    - 실패 테스트1  
      빈 문자열을 입력한 경우 `IllegalArgumentException` 예외를 발생시키는가?

    - 실패 테스트2  
      공백 문자열을 입력한 경우 `IllegalArgumentException` 예외를 발생시키는가?


- 기능2: getTotalRound()  
  사용자에게 라운드 수를 입력할 것을 요구합니다.  
  만약, 사용자 입력을 정수로 바꿀 수 없는 경우 `IllegalArgumentException` 예외를 발생시킵니다.

    - 성공 테스트
      공백 없이 숫자로만 구성되었으며, 그 평가 값이 Integer.MAX_VALUE 이하인 문자열에 대해  
      int 값이 잘 반환되는가?

    - 실패 테스트
      숫자로 변형할 수 없는 문자열(빈 문자열, 숫자외에 다른 문자를 포함한 문자열 등)을 입력한 경우  
      `IllegalArgumentException` 예외를 발생시키는가?


- 기능3: printCurrentState(Race race)  
  주어진 경주의 현재 라운드 상황을 출력합니다.


---


## 3. Controller
### 3.1. RaceController

- 개요
  정해진 일련의 순서로 자동차 경주를 진행하는 클래스입니다.


- 기능1: run()  
  자동차 경주를 진행합니다.

    - 테스트: 처음부터 제공된 테스트로 갈음


---

