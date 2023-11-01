# 미션 - 자동차 경주

## 🎯 프로그래밍 요구 사항

- JDK 17 버전에서 실행 가능해야 한다. **JDK 17에서 정상적으로 동작하지 않을 경우 0점 처리한다.**
- 프로그램 실행의 시작점은 `Application`의 `main()`이다.
- `build.gradle` 파일을 변경할 수 없고, 외부 라이브러리를 사용하지 않는다.
- [Java 코드 컨벤션](https://github.com/woowacourse/woowacourse-docs/tree/master/styleguide/java) 가이드를 준수하며 프로그래밍한다.
- 프로그램 종료 시 `System.exit()`를 호출하지 않는다.
- 프로그램 구현이 완료되면 `ApplicationTest`의 모든 테스트가 성공해야 한다. **테스트가 실패할 경우 0점 처리한다.**
- 프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 이름을 수정하거나 이동하지 않는다.

### 추가된 요구 사항

- indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
    - 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
    - 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메서드)를 분리하면 된다.
- 3항 연산자를 쓰지 않는다.
- 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.
- JUnit 5와 AssertJ를 이용하여 본인이 정리한 기능 목록이 정상 동작함을 테스트 코드로 확인한다.
    - 테스트 도구 사용법이 익숙하지 않다면 `test/java/study`를 참고하여 학습한 후 테스트를 구현한다.

## 🚀 기능 요구 사항

초간단 자동차 경주 게임을 구현한다.

- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
- 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
- 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
- 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료되어야 한다.

### 입출력 요구 사항

#### 입력

- 경주 할 자동차 이름(이름은 쉼표(,) 기준으로 구분)

```
pobi,woni,jun
```

- 시도할 회수

```
5
```

#### 출력

- 각 차수별 실행 결과

```
pobi : --
woni : ----
jun : ---
```

- 단독 우승자 안내 문구

```
최종 우승자 : pobi
```

- 공동 우승자 안내 문구

```
최종 우승자 : pobi, jun
```

## 🚨️  필요기능
1. 사용자가 n대의 자동차 이름을 입력하는 기능
2. 사용자가 입력한 자동차 이름을 검증하는 기능 (제약조건: 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능, 검증에 실패하면 IllegalArgumentException을 발생 후 애플리케이션을 종료한다.)
3. 사용자가 입력한 n대의 자동차의 이름을 부여하는 기능 
4. 사용자가 n번 이동할지 입력하는 기능
5. 사용자가 입력한 이동 횟수를 검증하는 기능 (제약조건: 숫자만 입력 가능, 검증에 실패하면 IllegalArgumentException을 발생 후 애플리케이션을 종료한다.)
6. 각각의 자동차의 0에서 9 사이 정수의 무작위 값을 구하는 기능
7. 각각의 자동차의 무작위 값이 4이상일 경우 카운트를 증가시키는 기능
8. n번 동안 각각의 자동차의 카운트의 수만큼 "-"로 사용자에게 표시하는 기능  
9. n번 실행 후 각각의 자동차의 카운트중 가장 많은 카운트를 갖는 자동차의 이름을 사용자에게 표시하는 기능 (제약조건: 우승자는 한 명 이상일 수 있고, 승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.)

## 📮 필요기능 구현
### 프로그램 구현
#### 검색의 도움 없이 내가 구현 할 수 있는 방법으로 구현을 해 보았습니다. 
````
    public static void main(String[] args) {
          String inputCarName = inputCarName();                               <=== 1
          String[] carNameSplit = inputCarNameSplit(inputCarName);            <=== 2
          Map<String, Integer> cars = inputCarNameValidation(carNameSplit);   <=== 3
    
          String inputAttempts = inputAttempts();                             <=== 4 
          int attempts = inputAttemptsValidation(inputAttempts);              <=== 5
    
          for(int count = 1 ; count <= attempts ; count++){
            cars = movementCount(cars);                                       <=== 6
            progressDisplay(cars);                                            <=== 7
          }
          winnerDisplay(cars);                                                <=== 8
    }
````
### 1. inputCarName()
* 필요기능 1. 사용자가 n대의 자동차 이름을 입력하는 기능
  ````
      public static String inputCarName(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        return input;
      }
  ````
  * inputCarName() 메서드에서 사용자가 자동차의 이름을 n대 입력하도록 구현하였습니다.
  * Console.readLine() 라이브러리를 사용하여 콘솔에서 값을 입력 받도록 하였습니다.

### 2. inputCarNameSplit()
* 필요기능 2. 사용자가 입력한 자동차 이름을 검증하는 기능 (제약조건: 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능, 검증에 실패하면 IllegalArgumentException을 발생 후 애플리케이션을 종료한다.) 
  ````
      public static String[] inputCarNameSplit(String inputCarName){
        String[] cars = inputCarName.split(",");
  
        if(cars.length<2){
          throw new IllegalArgumentException("자동차는 최소 2대 이상 이어야 합니다. 이름은 쉼표(,) 기준으로 구분합니다.");
        }
        return cars;
      }
  ````
  * inputCarNameSplit() 메서드에서 사용자가 입력한 자동차의 이름을 , 구분자로 나누도록 구현하였습니다.
  * 레이싱 게임이기 때문에 최소 경주 할 자동차의 대수는 2대 이상으로 제약조건을 걸었고, 자동차 가 1대 이면 IllegalArgumentException 발생하도록 예외처리 하였습니다.
  * **"함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라."** 의 조건이 있기 때문에 자동차 이름 검증 메서드를 inputCarNameSplit(), inputCarNameValidation() 2개로 더욱 세분화 하여 나눴습니다. 

### 3. inputCarNameValidation()
* 필요기능 2. 사용자가 입력한 자동차 이름을 검증하는 기능 (제약조건: 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능, 검증에 실패하면 IllegalArgumentException을 발생 후 애플리케이션을 종료한다.)
* 필요기능 3. 사용자가 입력한 n대의 자동차의 이름을 부여하는 기능
  ````
    public static Map<String,Integer> inputCarNameValidation(String[] inputCarNameSplit){
      Map<String,Integer> cars = new HashMap<>();

      for (String car : inputCarNameSplit){
        if(car.length()>5){
          throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }

        cars.put(car,0);
      }

      return cars;
    }
  ````
  * inputCarNameValidation() 메서드에서는 inputCarNameSplit()에서 나뉜 자동차 이름들을 **"이름은 5자 이하만 가능하다."** 제약조건에 맞게 car.length()>5로 검증하도록 구현하였습니다.  
  * 자동차 이름이 5자를 초과하면  IllegalArgumentException 예외를 발생시킵니다.
  * 게임에 필요한 자동차 이름과 움직임은 한쌍을 이루기 때문에 Map 자료구조를 활용하여 검증된 자동차 이름을 부여하여 자동차를 생성하였습니다.
  * 이름 검증 메서드와 이름 부여 메서드로 더욱 나눌수 있을 것 같아 리펙터링에서 나누도록 하겠습니다.

### 4. inputAttempts()
* 필요기능 4. 사용자가 n번 이동할지 입력하는 기능
  ````
    public static String inputAttempts(){
      System.out.println("시도할 회수는 몇회인가요?");
      String input = Console.readLine();
      return input;
    }
  ````
  * inputAttempts() 메서드에서 사용자가 몇번 시도 할 지 입력하도록 구현하였습니다.
  * Console.readLine() 라이브러리를 사용하여 콘솔에서 값을 입력 받도록 하였습니다.

### 5. inputAttemptsValidation()
* 필요기능 5. 사용자가 입력한 이동 횟수를 검증하는 기능 (제약조건: 숫자만 입력 가능, 검증에 실패하면 IllegalArgumentException을 발생 후 애플리케이션을 종료한다.)
  ````
    public static int inputAttemptsValidation(String inputAttempts){
      try {
        int attempts = Integer.parseInt(inputAttempts);
        return attempts;

      } catch (NumberFormatException e){
        throw new IllegalArgumentException("숫자만 입력해 주세요.");
      }
    }
  ````
  * inputAttemptsValidation() 메서드에서 사용자가 입력한 횟수가 제약조건에 맞는지 검증하도록 구현하였습니다.
  * 숫자만 입력받도록 해야하기 때문에 Integer.parseInt(inputAttempts) int 타입으로 변환 과정 중 문자타입이면 NumberFormatException이 발생하는데 catch에서 예외를 받아 IllegalArgumentException로 발생하도록 구현하였습니다.  

### 6. movementCount()
* 필요기능 6. 각각의 자동차의 0에서 9 사이 정수의 무작위 값을 구하는 기능
* 필요기능 7. 각각의 자동차의 무작위 값이 4이상일 경우 카운트를 증가시키는 기능
  ````
    public static Map<String,Integer> movementCount(Map<String,Integer> cars){
      cars.forEach((carName, movement) -> {
        int number = Randoms.pickNumberInRange(1, 9);

        if(number>=4){
          movement = movement.intValue();
          movement++;
          cars.replace(carName,movement);
        }
      });
      return cars;
    }
  ````
  * movementCount() 메서드에서 Map에 담겨있는 각각의 자동차의 움직임을 계산하도록 구현하였습니다.
  * cars의 Map을 순회하며 사용 가능한 Randoms.pickNumberInRange(1, 9) 라이브러리를 사용하여 1~9사이의 정수를 랜덤으로 받아와 그 수가 4이상이면 카운트를 증가 시키도록 하였습니다.
  * cars.replace(carName,movement)를 활용하여 기존의 movement를 증가된 movement로 변경하였습니다.

### 7. progressDisplay()
* 필요기능 8. n번 동안 각각의 자동차의 카운트의 수만큼 "-"로 사용자에게 표시하는 기능
  ````
    public static void progressDisplay(Map<String,Integer> cars){
      cars.forEach((carName, movement) -> {
        String result = "";
        for(int i =  1; i<=movement ; i++){
          result+="-";
        }
        System.out.println(carName + " : " + result);
      });
      System.out.println("");
    }
  ````
  * progressDisplay() 메서드에서 Map에 담겨있는 각각의 자동차의 움직임의 카운트 1당  "-"로 사용자에게 현재 진행 상황을 표시하도록 구현하였습니다.
  * cars의 Map을 순회하며 각각의 자동차의 movement의 숫자만큼 result에 "-"의 문자열을 합하여 사용자에게 현재 진행상황을 알수 있도록 구현하였습니다.

### 8. winnerDisplay()
* 필요기능 9. n번 실행 후 각각의 자동차의 카운트중 가장 많은 카운트를 갖는 자동차의 이름을 사용자에게 표시하는 기능 (제약조건: 우승자는 한 명 이상일 수 있고, 승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.)
  ````
    public static void winnerDisplay(Map<String,Integer> cars){
      String winner = "";
      Integer maxValue = Collections.max(cars.values());
      Set<Map.Entry<String, Integer>> entrySet = cars.entrySet();
      for(Map.Entry<String,Integer> entry: entrySet){
        if(entry.getValue() == maxValue){
          winner+=",";
          winner+=entry.getKey();
        }
      }
      winner = winner.replaceFirst(",","");
      System.out.println("최종 우승자 : " + winner);
    }
  ````
  * winnerDisplay() 메서드에서 사용자가 입력한 횟수만큼 계산된 각각의 자동차의 움직임 중 가장 많은 움직임을 갖는 자동차를 우승 자동차로 사용자에게 표시하도록 구현하였습니다.
  * Collections.max(cars.values())를 활용하여 Map<String,Integer> cars 중 가장 큰 values를 가져와 가장 많은 전진을 한 횟수로 지정하였습니다.
  * 중복 우승자가 있을 수도 있기 떄문에 cars.entrySet()을 활용하여 Map<String,Integer> cars의 key갑과 value값을 모두 가져오도록 하였고, 각각의 entry의 value값과 maxValue의 값이 같다면 우승자로 지정하여  winner에 key값을 추가하였습니다.
  * 중복 우승자를 "," 구분자로 표시하기 위해 winner+=","를 사용하였지만 결과 값이 ,테스트1,테스트2의 값을 확인하였고, winner.replaceFirst(",","")을 활용하여 처음 "," 구분자를 "" 빈 문자열로 변환하여 보완하였습니다.


## ✏️  리펙터링
#### 검색의 도움을 받아 **"함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라"** 요구사항에 맞게 리펙터링하여 학습해 보았습니다..
````
    public static void main(String[] args) {
      String inputCarName = inputCarName();
      String[] carNameSplit = inputCarNameSplit(inputCarName);
      inputCarNameValidation(carNameSplit);                     <=== 1
      Map<String, Integer> cars = createCars(carNameSplit);     

      String inputAttempts = inputAttempts();
      int attempts = inputAttemptsValidation(inputAttempts);

      for(int count = 1 ; count <= attempts ; count++){
        cars = movementCount(cars);
        progressDisplay(cars);
      }
      winnerDisplay(cars);                                      <=== 2
    }
````

### 1. inputCarNameValidation()
  ````
    public static Map<String,Integer> inputCarNameValidation(String[] inputCarNameSplit){
      Map<String,Integer> cars = new HashMap<>();

      for (String car : inputCarNameSplit){
        if(car.length()>5){
          throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }

        cars.put(car,0);
      }

      return cars;
    }
  ````
  * inputCarNameValidation 메서드에서는 자동차이름을 검증하는 일과 검증된 이름을 Map에 저장하는 일, 2가지 일을 하기 떄문에 분리하기로 하였습니다.
  ````
    public static void inputCarNameValidation(String[] inputCarNameSplit){
      for (String car : inputCarNameSplit){
        if(car.length()>5){
          throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
      }
    }
  ````
  * inputCarNameValidation 메서드에서는 자동차 이름을 검증하는 일 한가지 일만 하도록 구현하였습니다.
  ````
    public static Map<String,Integer> createCars(String[] inputCarNameSplit){
      Map<String,Integer> cars = new HashMap<>();
      for (String car : inputCarNameSplit){
        cars.put(car,0);
      }
      return cars;
    }
  ````
  * createCars 메서드를 추가하여 자동차의 이름을 Map에 저장하는 일 한가지 일만 하도록 구현하였습니다.
  #### 1-1 createCars() 테스트 코드 리펙터링
  ````
    @Test
    void createCars() {
      String input = "테스트1,테스트2,테스트3";
      String[] inputCarNameSplit = input.split(",");
      Map<String,Integer> cars = new HashMap<>();

      for (String car : inputCarNameSplit){
        cars.put(car,0);
      }

      assertThat(cars).hasSize(3)
          .contains(entry("테스트1", 0), entry("테스트2", 0), entry("테스트3", 0))
          .doesNotContainEntry("테스트4", 0);
    } 
  ````
  * createCars() 메서드의 기능을 테스트 하기위해 검증된 자동차의 이름을 정확하게 잘 저장하는지 테스트하였습니다.
  * 사용자가 입력한 자동차이름을 "테스트1,테스트2,테스트3"로 설정하였고 "," 구분자로 구분하면 3대의 자동차를 예측할 수 있다. 이것을 테스트하기 위해  hasSize(3)을 활용하여 cars에 저장된 자동차의 대수가 3대인지 테스트하였습니다.
  * contains()을 활용하여 cars에 예측한 키와 값이(entry) 저장 되어 있는지 테스트 하였습니다.
  * doesNotContainEntry()을 활용하여 예측하지 않은 키와 값이(entry) 저장 되어 있지 않은지 테스트하였습니다.
  ### 1-2 inputCarNameValidation() 테스트 코드 리펙터링
  ````
    @Test
    void inputCarNameValidation_정상케이스() {
      assertThatCode(() -> inputCarNameValidation("테스트1,테스트2,테스트3"))
          .doesNotThrowAnyException();
    }
  ````
  * inputCarNameValidation() 메서드의 정상케이스를 테스트 하기 위해 assertThatCode()를 활용하여 inputCarNameValidation() 메서드에 파라미터를 "테스트1,테스트2,테스트3"로 설정하여 실행하고 doesNotThrowAnyException() 예외가 없어야지 테스트 성공 하도록 구현하였습니다.

  ````
    @Test
    void inputCarNameValidation_예외케이스() {
      assertThatThrownBy(() -> inputCarNameValidation("123456,테스트2,테스트3"))
          .isInstanceOf(IllegalArgumentException.class)
          .hasMessageContaining("자동차 이름은 5자 이하만 가능합니다.");
    }
  ````
  * inputCarNameValidation() 메서드의 예와케이스를 테스트 하기 위해 assertThatThrownBy()를 활용하여 inputCarNameValidation() 메서드에 파라미터를 "123456,테스트2,테스트3"로 설정하여 예외를 발생하도록 하였습니다. 
  * 발생한 예외가 내가 의도한 예외인지 테스트하기 위해 isInstanceOf(IllegalArgumentException.class)을 활용하여 IllegalArgumentException 예외가 발생하는지 테스트 하였습니다.  
  * 발생한 예외 메세지가 내가 설정한 예외 메세지인지 테스트 하기 위해 hasMessageContaining()을 활용하여 테스트 하였습니다.
### 2. winnerDisplay()
  ````
      public static void winnerDisplay(Map<String,Integer> cars){
        StringJoiner winner = new StringJoiner(",");
        Integer maxValue = Collections.max(cars.values());
        Set<Map.Entry<String, Integer>> entrySet = cars.entrySet();
        for(Map.Entry<String,Integer> entry: entrySet){
          if(entry.getValue() == maxValue){
            winner.add(entry.getKey());
          }
        }
        System.out.println("최종 우승자 : " + winner);
      }
  ````
*  Java 8 에 추가된 StringJoiner 라는 클래스는 여러 문자들을 연결할 때 붙일 구분자(delimiter) 를 지정해줄 수 있어 활용하도록 하였습니다.
*  StringJoiner winner = new StringJoiner(",") 생성자에 구분자를 입력하여 인스턴스를 생상합니다.
*  winner.add(entry.getKey())를 활용하여 winner에 값을 추가하면 StringJoiner가 값을 자동으로 구분자를 사이사이에 붙여주었습니다.
*  StringJoiner는 prefix 와 suffix 도 붙여줄 수 있습니다.
*  StringJoiner sj = new StringJoiner("-", "[", "]")를 입력하여 인스턴스를 만들고, sj.add("우"), sj.add("테"), sj.add("코")를 추가하면 [우-테-코]의 값을 확인 할 수있습니다.
*  StringJoiner를 활용하여  winner+="," 와  winner = winner.replaceFirst(",","") 의 코드를 줄일 수 있었고 더욱 직관적이고 읽기 쉬운 코드로 리펙터링 하였습니다.

## ✏️  학습내용
1. Map을 테스트하기 위해 assertj의 assertThat.hasSize(), assertThat.contains(), assertThat.doesNotContainEntry() 활용
2. 정상 케이스를 테스트 하기 위해 assertThatCode() 활용
3. 예외 케이스를 테스트 하기 위해 assertThatThrownBy() 활용
4. 문자열에 구분자 넣기 위해 StringJoiner 활용  