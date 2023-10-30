
## 기능 목록
- [ ] 경주할 자동 차 이름을 입력 받는다.
  -  자동차 이름은 쉼표(,)를 기준으로 구분한다.
  - [ ] 자동차 이름이 5자 초과일 경우 예외 처리 (IllegalArgumentException 발생)
  - [ ] 자동차 이름이 중복일 경우 예외 처리 (IllegalArgumentException 발생)

- [ ] 사용자가 시도할 횟수를 입력 받는다.
- [ ] 매 차례 마다 0 ~ 9 사이의 무작위 값을 구해 4 이상일 경우 전진, 3 이하일 경우 멈춘다.

- [ ] 매 차례 마다 자동차의 위치를 시도한 횟수만큼 형식에 맞게 출력한다.
  - 자동차의 위치는 `-`로 출력한다.
  - 각 결과 사이는 enter로 구분한다.
  - 형식은 다음과 같다
    ```text
    pobi : -
    woni :
    jun : -
    ```

- [ ] 경주가 끝난 후 우승자를 출력한다.
  - 우승자는 한 명 이상일 수 있다.
  - 형식은 다음과 같다
    ```text
    최종 우승자 : pobi, jun
    ```

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
  - 현재 위치값을 가지고 있어야 한다.
- Player : 플레이어 객체 

**Policy**
- NumberGeneratePolicy (숫자 생성 정책)


