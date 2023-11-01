# 구현할 기능 목록

## 진행 순서

1. 경주할 자동차 이름을 입력 받는다.(이름은 COMMA(쉼표)(COMMA.getSymbol()(,)) 기준으로 구분한다.)
   - 잘못된 값을 입력 시 예외 처리(`IllegalArgumentException`)
2. 시도할 횟수를 입력 받는다.(MIN_COUNT(2) 이상의 숫자만 입력 받는다.)
   - 잘못된 값을 입력 시 예외 처리(`IllegalArgumentException`)
3. 입력 받은 횟수만큼 게임을 진행한다.
   1. 자동차의 이름만큼 자동차 객체를 생성한다.
      - 각 자동차는 이름과 위치 정보를 가지고 있다.
   2. 모든 자동차는 각자 무작위 값 생성기를 이용하여 무작위 값을 생성한다.
   3. 무작위 값이 FORWARD_CONDITION(4) 이상일 경우 전진한다(position++).
      - FORWARD_CONDITION(4) 미만일 경우 정지한다.
4. 각 자동차의 위치(position)를 비교하여 최종 우승자를 가린다. (시작 위치(START_POSITION) : 0)
   - 우승자는 한 명 이상일 수 있다.
5. 우승자를 출력한다.
   - 한 명 이상일 경우 COMMA(쉼표)(COMMA.getSymbol()(,))로 구분한다.

## 기능 및 역할

- 자동차(Car)
  + `구성` : 이름(name), 위치(position)
  + `책임` : 값이 FORWARD_CONDITION(4) 이상일 경우 전진, 아닐 경우 정지

- 경주에 참가하는 자동차들(RacingCars)
  + `구성` : 자동차 타입의 배열(List<Car> cars)
  + `책임` : 입력 받은 문자열 타입의 자동차 이름 배열의 검증 후 자동차 타입의 배열로 변환해 `cars`에 저장
  + 자동차의 최소 개수보다 적은 회수가 입력 되었으면 예외 처리(`IllegalArgumentException`)
  + 자동차의 이름 양식(영문 알파벳만으로 구성)에 맞지 않으면 예외 처리(`IllegalArgumentException`)
  + 자동차의 이름 최대 길이보다 길면 예외 처리(`IllegalArgumentException`)
  + 자동차의 이름이 중복되면 예외 처리(`IllegalArgumentException`)

- 무작위 값 생성기(RandomValueGenerator)
  + `책임` : RANDOM_NUMBER_START_INCLUSIVE(0)에서 RANDOM_NUMBER_END_INCLUSIVE(9) 사이 무작위 값 생성

- 입력뷰(InputView)
  + `책임` : 입력 화면 담당 및 간단한 유효성 검사
  + 경주 할 자동차 이름 입력
    + null 입력 시 예외 처리(`IllegalArgumentException`)
  + 시도할 횟수 입력
    + null 입력 시 예외 처리(`IllegalArgumentException`)
    + 숫자가 아닌 값을 입력할 경우 예외 처리(`IllegalArgumentException`)
    + 0을 입력할 경우 예외 처리(`IllegalArgumentException`)

- 출력뷰(OutputView)
  + `책임` : 실행 결과 출력
  + 위치값만큼 자동차의 실행 결과에 "-" 출력
  + 최종 우승자 출력

- 자동차 경주 컨트롤러(RacingCarController)
  + `책임` : 뷰와 도메인 연결
  + 입력 받은 자동차 이름의 개수만큼 자동차 생성
  + 입력 받은 횟수만큼 게임 진행
  + 위치를 비교하여 우승자 선정
  + 출력뷰를 통해 우승자 출력

---

# 요구 사항

## 기능 요구 사항

- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차의 이름을 같이 출력한다.
- 자동차의 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
- 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
- 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
- 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료되어야 한다.

## 추가된 요구 사항

- indent(인덴트, 들여쓰기) depth는 2까지만 허용한다.
- 3항 연산자를 쓰지 않는다.
- 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.
- Junit 5와 AssertJ를 이용하여 본인이 정리한 기능 목록이 정상 동작함을 테스트 코드로 확인한다.

## 라이브러리
- `camp.nextstep.edu.missionutils`에서 제공하는 `Randoms` 및 `Console` API를 사용하여 구현해야 한다.
    - Random 값 추출: `Randoms.pickNumberInRange()` 활용
    - 사용자가 입력하는 값 `Console.readLine()` 활용

## 입출력 예시

### 입력

##### 경주할 자동차 이름(이름은 쉼표(,) 기준으로 구분)
```
pobi, woni, jun
```

##### 시도할 횟수
```
3
```

### 출력

##### 각 차수별 실행 결과
```
pobi : --
woni : ----
jun : ---
```

##### 단독 우승자 안내 문구
```
최종 우승자 : pobi
```

##### 공동 우승자 안내 문구
```
최종 우승자 : pobi, jun
```

### 실행 결과 예시
```
경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)
pobi,woni,jun
시도할 회수는 몇회인가요?
5

실행 결과
pobi : -
woni : 
jun : -

pobi : --
woni : -
jun : --

pobi : ---
woni : --
jun : ---

pobi : ----
woni : ---
jun : ----

pobi : -----
woni : ----
jun : -----

최종 우승자 : pobi, jun
```


