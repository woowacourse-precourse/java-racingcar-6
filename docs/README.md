### 목차
패키지 구조
기능 구현 목록
리팩터링 목록
피드백 및 새로운 적용
아쉬운 점

<br />

### 패키지 구조
<table>
    <thead>
        <tr>
            <th>Package</th>
            <th>Class</th>
            <th>Description</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td rowspan="5">input</td>
            <td>Car</td>
            <td>자동차 이름과 운전 거리를 관리하는 클래스입니다.</td>
        </tr>
        <tr>
            <td>CarList</td>
            <td>Car 클래스를 관리하는 클래스입니다.</td>
        </tr>
        <tr>
            <td>RacingCount</td>
            <td>자동차 경주 횟수를 관리하는 클래스입니다.</td>
        </tr>
        <tr>
            <td>InputValidator</td>
            <td>입력 클래스들의 유효성을 검증하는 클래스입니다.</td>
        </tr>
        <tr>
            <td>Winner</td>
            <td>최종 우승자들을 출력하는 기능을 담당하는 클래스입니다.</td>
        </tr>
        <tr>
            <td rowspan="2">output</td>
            <td>MessageType</td>
            <td>출력과 관련된 메시지를 관리하는 ENUM 클래스입니다.</td>
        </tr>
        <tr>
            <td>OutputCarRace</td>
            <td>출력과 관련된 모든 기능을 담당하는 클래스입니다.</td>
        </tr>
        <tr>
            <td rowspan="2">racingcar</td>
            <td>CheckMoveAndStop</td>
            <td>자동차의 전진과 멈춤을 관리하는 클래스입니다.</td>
        </tr>
        <tr>
            <td>RacingCar</td>
            <td>자동차 경주를 위해 실행 인터페이스를 정리한 클래스입니다.</td>
        </tr>
    </tbody>
</table>

<br />

### 기능 구현 목록
1. 자동차 이름 입력 멘트 출력
```text
   ● 이름 출력: "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"
```

2. 사용자는 자동차 이름을 입력
```text
   ● 이름 쉼표(,) 기준으로 구분
   ● 자동차는 n대까지 등록(범위: 1 <= n <= 100)
   ● 이름 6자 이상 입력시 예외 처리
   ● 공백으로 이름을 입력하면 예외 처리
   ● 중복된 이름 입력시 예외 처리
```

3. 자동차 경주 횟수 입력 멘트 출력
```text
   ● 횟수 출력: "시도할 회수는 몇회인가요?"
```

4. 경주 횟수 입력
```text
   ● 사용자는 n번의 경주 회수를 입력(범위: 1 <= n <= 1,000)
   ● 숫자를 제외한 문자/특수문자는 예외 처리
```

5. n회 동안 자동차 전진 또는 멈춤 체크
```text
   ● 자동차 대수 만큼 무작위 값을 선택
   ● 전진 조건의 경우 0 ~ 9사이 무작위 값 중 4 이상 선택
   ● 멈춤 조건의 경우 0 ~ 9사이 무작위 값 중 3 이하 선택
```

6. 실행 결과 출력
```text
   ● 실행 결과
   ● 전진했을 경우 출력: "자동차1 이름 : -"
   ● 멈추었을 경우 출력: "자동차2 이름 : "
   ● 이동 횟수 n회 동안 5번 반복
```

7. 우승한 사람 출력
```text
   ● 우승한 사람이 n명인 경우 n명을 출력(쉼표로 구분)
   ● n명 출력: "최종 우승자 : 자동차1, 자동차2"
   ● 1명 출력: "최종 우승자 : 자동차1"
```

<br />

### 리팩터링 목록
1. 전체 입력 관리 클래스 > 각 기능별 입력 클래스 추가
```text
   ● 기존 입력 기능을 한 클래스에서 관리했으나 클래스별 구분하는 작업 진행 
   ● 입력 클래스를 Car, CarList, RacingCount로 구분
   ● 입력 메서드는 정적 메서드 팩터리로 설정 
   ● 입력 메서드는 input~ 으로 시작
   ● 입력 후 사용할 메서드는 get~으로 호출하여 사용
```

2. 차량 클래스 전진 기능 추가
```text
   ● 4이상일 경우 전진할 수 있도록 기능 추가
```

3. 입력 유효성 검증 클래스 추가
```text
   ● 모든 입력에 대한 유효성 검사를 관리
   ● Exception 처리 메서드는 validate~로 시작
   ● boolean 처리 메서드는 is~로 시작
   ● 관련 메서드 static으로 사용
```

4. 출력 기능 클래스 간소화
```text
   ● 복잡하거나 중복이 되는 소스를 변경
```

5. 우승자 출력 클래스 추가
```text
   ● 우승자 출력 기능을 별도로 처리하는 것이 좋다 판단해 분리
   ● 차량 목록의 거리와 최대 거리를 비교해 가장 많이 이동한 대상자 출력
   ● 입력 메서드는 정적 메서드 패턴으로 설정
   ● 출력 메서드는 print~로 시작
```

6. 자동차 전진&멈춤 기능 추가
```text
   ● 경주 횟수만큼 차량들의 전진&멈춤을 관리
   ● 회차별 경주한 자동차들의 움직임을 기록
   ● 경주 결과를 StringBuilder에 추가해 모아 찍을 수 있도록 추가
```

7. 자동차 경주 실행 메서드 변경
```text
   ● 의미를 명확하게 전달할 수 있도록 실행시 정적 메서드로 변경
```

<br />

### 새로운 도입 및 피드백
#### 1. README 작성 방식 변경: @h-beeen님 
1차 과제를 진행하며 @h-beeen님의 README가 너무 직관적이고 깔끔했습니다.

그래서 이번 2차 과제를 진행하며 @h-beeen님의 README와 비슷한 구조로 가져왔습니다. 

<br />

#### 2. ENUM 메시지 및 Output 기능: @h-beeen님, @wooteco-daram님
##### 1차 과제: 인상적인 기능
@h-beeen님이 **ENUM으로 에러 메시지를 처리**하는 것을 보고 직관적으로 메시지가 정리되었음을 확인했습니다. 

또한 @wooteco-daram님의 **출력 Output 기능** 또한 다양한 출력을 처리함에 있어 같은 구조로 가면 좋은 것 같다는 생각을 했습니다.

<br />

##### 2차 과제 적용
제가 구현한 기능은 @h-beeen님과 @wooteco-daram님의 기능을 참고하여 Output 기능을 담당하는 클래스를 만들었습니다.

**Enum Class: MessageType**
```java
public enum MessageType {
    INPUT_..._PRINT("메시지"), OUTPUT_..._PRINT("메시지");
    ...
}
```
MessageType은 INPUT_PRINT와 OUTPUT_PRINT로 분리되어 메시지를 출력합니다.

INPUT_PRINT는 입력시 보여주는 메시지이고, OUTPUT_PRINT는 출력시 보여주는 메시지를 말합니다.

**Class: OutputCarRace**
```java
public class OutputCarRace {
    public static void print(final MessageType messageType) {
        printMessage(messageType.getValue());
    }

    public static void printf(final MessageType messageType, final Object... inputNames) {
        printMessage(format(messageType.getValue(), inputNames));
    }

    private static void printMessage(String message) {
        System.out.print(message);
    }
}
```
OutputCarRace는 출력(print), 형식 출력(printf)을 관리하는 메서드입니다. 

모든 클래스의 출력 기능은 해당 클래스를 통해 진행하게 됩니다. 

또한 추후 System.out.print 말고 다른 방식으로 출력을 해볼 수도 있지 않을까? 라는 의문으로 printMessage 메서드를 만들었습니다. 

당장은 적용을 못했지만 다음엔 다른 방식으로 적용하고 싶은 부분입니다.

<br />

#### 3. 입력은 정적 팩터리 메서드(input~): @h-beeen님
>프로그래머가 찾기 힘들다는 말도 동의하지만, 이 부분은 팀의 네이밍 컨벤션이나, 기타 명세화 방법을 통해 정리할 수 있을 것 같아요!

이펙티브 자바를 보면서 입력은 정적 팩터리 메서드는 네이밍 컨벤션을 지켜주는게 추후 헷갈리지 않을 것이란 배웠습니다.

하지만 @h-beeen님에게 리뷰를 작성하면서 정적 팩터리 메서드도 팀의 네이밍 컨벤션이나, 기타 명세화 방법을 통해 잘 정리될 수 있다는 것을 배울 수 있었습니다.

그래서 이번엔 네이밍 컨벤션을 따르진 않고 입력에 관한 모든 작업을 input~으로 처리하도록 만들었습니다.
```java 
public class Car {
    public static Car inputCarname(String carName) {
        return new Car(carName);
    }

    private Car(String carName) {
        InputValidator.validateCarname(carName);
        this.carName = carName;
        this.driving = new StringBuilder();
    }
}
```

<br />

#### 4. 정적 메서드 사용
##### 1차 과제 피드백: @h-beeen 님
> 멤버변수가 없는 NumberBaseball이라는 클래스는 리턴형이 없는 생성자 사용보다는, static method 사용이 좋아보여요!
```java
    new NumberBaseball().play();
    -> (변경) NumberBaseball.play();
```
1차 과제에 NumberBaseball은 숫자 야구 진행을 담당하던 클래스였습니다.

그리고 주요 기능은 실행밖에 없어 리턴형이 없는 생성자 사용보다는, static 메서드의 사용을 피드백 해주셨습니다.

<br />

##### 2차 과제 적용
```java
public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        RacingCar.play();
    }
}
```
피드백 주신 내용을 토대로 적용한 내용입니다. 

RacingCar를 생성자로 선언해 play 메서드를 호출하는 방식이 아닌, 정적 메서드로 play를 호출했습니다.

이 과정을 **인스턴스 없이 호출**이 가능해졌고, **간결한 소스**를 얻을 수 있게 되었습니다.  

<br />

#### 5. validate~/get~ 외 메서드명 적용
##### 1차 과제 피드백: @jongmyeongbak
> validate는 언제나 right한지 검증하는 것이므로 이름을 구체적으로 써주시면 좋습니다.
```java
private void validateRight(String command) {}
```
숫자 야구에서 명령의 사용이 올바른지 체크하는 메서드였습니다. 

해당 메서드를 풀이하면 `validateRight: 올바른 검증인가요?` `command: 명령어`라는 의미를 가집니다.

이전 cleanCode를 보며 메서드명뿐 아니라 파라미터를 통해서도 메서드의 의미를 적용할 수 있다는 것을 배웠습니다.

하지만 파라미터로 명령을 구분할 경우 추후 메서드가 어떻게 사용되는지 확인해야 하는 번거로움이 있다는 단점도 있었습니다.

그래서 이번엔 메서드 명을 좀 더 명확히 만들도록 변경하였습니다.

<br />

##### 2차 과제 적용
```java
public class InputValidator {
    public static void validateRaceCount(String stringRaceCount) {
        validateOnlyNumber(stringRaceCount);
        validatePositiveNumber(stringRaceCount);
    }
    // ...
}

public class Car {
    // ...
    public String getCarName() {
        return this.carName;
    }
}

public class CheckMoveAndStop{
    // ... 
    private void UpdateMaxDistance(Car car) {
        StringBuilder driving = car.getDriving();

        if(this.maxDistance < driving.length()){
            this.maxDistance = driving.length();
        }
    }
}
```
InputValidator, Car 클래스에서 확인할 수 있듯이 어떤 상황에서 어떤 의미로 사용되는지 명확히 구분하였습니다. 

또한 CheckMoveAndStop 클래스에서는 내부 로직 구현이 있음으로 setMaxDistance 대신 UpdateMaxDistance으로 수정하였습니다.

<br />

### 아쉬운 점
1. **input 패키지 보단 domain 패키지**

    처음 설계를 했을 당시엔 input 패키지로 구현하는 것이 맞다고 생각했는데 점점 구현을 할 수록 input 패키지 보단
    domain 패키지에 더 어울리는 것 같다는 생각이 들었습니다.

    다음 과제엔 domain 패키지와 output 패키지로 구분하는 것이 좋겠단 생각이 들었습니다. 

2. **아쉬운 CheckMoveAndStop 클래스**

   CheckMoveAndStop에 있는 구현 내용을 도메인으로 풀었으면 좀더 좋았을 것 같습니다. 
    
   현재는 조금 애매한 클래스 포지션으로 남게 된 것 같습니다.

   다음 과제엔 좀 더 의미있는 클래스로 만들어 봐야할 것 같습니다. 

3. **java 최신 기능의 활용**

   현재까지 java 최신 기능과 관련된 것을 사용해보지 못했던 것 같습니다.
   
   최근에 제가 관심있게 본 것은 Record인데 이는 최근 블로그에서 DTO로 대체될 수 있다는 글을 봤던 것 같아서 참고해볼 예정입니다. 
    
    **출처**  
    [자바 record를 entity로?](https://velog.io/@power0080/java%EC%9E%90%EB%B0%94-record%EB%A5%BC-entity%EB%A1%9C)

4. **Custom Exception 객체 활용**
   
   Exception을 각 클래스별로 구현했을 경우 추후 현재 사용하고 있는 Exception이 Deprecated 된다면 클래스별로 수정해야하는 문제가 생깁니다.
   
    이에 Custom Exception으로 예외를 관리하는 객체를 추가하는 것이 좋다고 생각합니다.
   
   하지만 여전히 고민인 부분은 구현되는 기능이 많아 질 수록 Exception의 처리 메서드가 방대해 질 것인데... 이것을 어떻게 처리할 수있을까.. 
      라는 고민도 있습니다.

   혹시 제가 하는 고민에 대한 해결방안을 아시는 분들은 댓글로 달아주시면 감사하겠습니다.^^