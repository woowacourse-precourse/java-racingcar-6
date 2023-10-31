
## 기능 목록
- [x] 경주할 자동차 이름을 입력 받는다.
  -  자동차 이름은 쉼표(,)를 기준으로 구분한다.
  - [x] 자동차 개수가 2대 미만일 경우 예외 처리 (IllegalArgumentException 발생)
  - [x] 자동차 이름이 5자 초과일 경우 예외 처리 (IllegalArgumentException 발생)
  - [x] 자동차 이름이 중복일 경우 예외 처리 (IllegalArgumentException 발생)
  - [x] 자동차 이름이 blank일 경우 예외 처리 (IllegalArgumentException 발생)

- [x] 사용자가 시도할 횟수를 입력 받는다.
  - [x] 횟수가 숫자가 아닐 경우 예외 처리 (IllegalArgumentException 발생)
  - [x] 횟수가 0 이하일 경우 예외 처리 (IllegalArgumentException 발생

- [x] 입력이 null일 경우 예외 처리 (IllegalArgumentException 발생)

- [x] 매 차례 마다 0 ~ 9 사이의 무작위 값을 구해 4 이상일 경우 전진, 3 이하일 경우 멈춘다.
  - [x] 생성한 숫자가 4이상이면 위차가 1 증가한다
  - [x] 생성한 숫자가 3이하이면 위치가 그대로 유지된다.

- [x] 게임을 시도 횟수만큼 진행하여 각 자동차의 위치를 계산하여 이름과 함께 반환한다

- [x] 매 차례 마다 자동차의 위치를 시도한 횟수만큼 형식에 맞게 출력한다.
  - 자동차의 위치는 `-`로 출력한다.
  - 각 결과 사이는 enter로 구분한다.
  - 형식은 다음과 같다
    ```text
    pobi : -
    woni :
    jun : -
    ```

- [x] 경주가 끝난 후 우승자를 출력한다.
  - [x] 자동차의 위치를 비교해 가장 위치값이 높은 자동차를 우승자로 
  - [x] 우승자가 한 명 이상일 경우 쉼표(,)로 구분해 아래 형식과 같이 출력한다.
    - 우승자는 한 명 이상일 수 있다.
    - 형식은 다음과 같다
      ```text
      최종 우승자 : pobi, jun
      ```
### Refactor
- [x] position을 값 객체로 분리해 불변을 유지한다


## 전체적인 구조
**View**
- Output : 출력 인터페이스
- PrintStreamOutput : output 구현체. 명확히 출력 역할

- Input : 입력 인터페이스
- MissionUtilsInput : input 구현체, 해당 라이브러리 사용해 구현

**Controller**
- RacingCarGame : view와 domain을 연결해준다

**Domain**
- Car : 자동차 객체
  - 자동차는 이름과 위치를 가지고 있다.
  - 한 round가 끝날때 정책 조건에 맞다면 위치를 1 증가시킨다.
- Position : 자동차 위치를 가지고 있어야 한다.
- CarName : 자동차 이름을 가지고 있어야 한다.
- Player : 플레이어 객체 

**Policy**
- NumberGeneratePolicy (숫자 생성 정책)
- MovePolicy (이동 정책)

## 프로그래밍 요구사항 및 점검 사항
- [ ] indent 2까지만 허용 (while문 안 if 까지가 indent 2)
- [ ] 3항 연산자 사용 x
- [ ] 메서드 한가지 일만 하도록 최대한 작게 만들기
- [ ] 제공하는 Randoms 랜덤값 추출하기 (`Randoms.pickNumberInRange(0,9);`)
- [ ] 제공하는 Console 클래스로 입력값 받기 (`Console.readLine();`)
- [ ] clean -> test / clean -> test 확인 하기
