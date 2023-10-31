### 목차
패키지 구조
기능 구현 목록
리팩터링 목록
피드백 및 새로운 적용
과제시 고려사항

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
            <td rowspan="4">input</td>
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
            <td rowspan="3">output</td>
            <td>MessageType</td>
            <td>출력과 관련된 메시지를 관리하는 ENUM 클래스입니다.</td>
        </tr>
        <tr>
            <td>OutputCarRace</td>
            <td>출력과 관련된 모든 기능을 담당하는 클래스입니다.</td>
        </tr>
        <tr>
            <td>Winner</td>
            <td>최종 우승자들을 출력하는 기능을 담당하는 클래스입니다.</td>
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

4. 사용자 이동 횟수 입력
```text
   ● 사용자는 n번의 이동 회수를 입력(범위: 1 <= n <= 1,000)
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


### 리팩터링 목록
1. 전체 입력 관리 객체 > 각 기능별 입력 객체 추가
```text
   ● 기존 입력 기능을 한 클래스에서 관리했으나 객체별 구분하는 작업 진행 
   ● 입력 클래스를 Car, CarList, RacingCount로 구분
   ● 입력 메서드는 정적 메서드 팩터리로 설정 
   ● 입력 메서드는 input~ 으로 시작
   ● 입력 후 사용할 메서드는 get~으로 호출하여 사용
```

2. 차량 객체 전진 기능 추가
```text
   ● 4이상일 경우 전진할 수 있도록 기능 추가
```

3. 입력 유효성 검증 객체 추가
```text
   ● 모든 입력에 대한 유효성 검사를 관리
   ● Exception 처리 메서드는 validate~로 시작
   ● boolean 처리 메서드는 is~로 시작
   ● 관련 메서드 static으로 사용
```

4. 출력 기능 객체 간소화
```text
   ● 복잡하거나 중복이 되는 소스를 변경
```

5. 우승자 출력 객체 추가
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
### 새로운 도입 및 피드백
#### 1. README 작성 방식 변경: @h-beeen님 
1차 과제를 진행하며 @h-beeen님의 README가 너무 직관적이고 깔끔했습니다.

그래서 이번 2차 과제를 진행하며 @h-beeen님의 README와 비슷한 구조로 가져왔습니다. 

#### 2. ENUM 메시지 및 Output 기능: @h-beeen님, @wooteco-daram님
##### 1차 과제: 인상적인 기능
@h-beeen님이 **ENUM으로 에러 메시지를 처리**하는 것을 보고 직관적으로 메시지가 정리되었음을 확인했습니다. 

또한 @wooteco-daram님의 **출력 Output 기능** 또한 다양한 출력을 처리함에 있어 같은 구조로 가면 좋은 것 같다는 생각을 했습니다. 

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

INPUT_PRINT는 입력시 보여주는 메시지이고, OUTPUT_PRINT는 출력시 보여주는 메시즈를 말합니다.

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


#### 3. 정적 메서드 사용
##### 1차 과제 피드백: @h-beeen 님
> 멤버변수가 없는 NumberBaseball이라는 클래스는 리턴형이 없는 생성자 사용보다는, static method 사용이 좋아보여요!
```java
    new NumberBaseball().play();
    -> (변경) NumberBaseball.play();
```
1차 과제에 NumberBaseball은 숫자 야구 진행을 담당하던 클래스였습니다.

그리고 주요 기능은 실행밖에 없어 리턴형이 없는 생성자 사용보다는, static 메서드의 사용을 피드백 해주셨습니다.

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



### 과제시 고려사항
1. 
