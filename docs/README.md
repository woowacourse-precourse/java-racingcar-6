## 기능 구현 목록

- [x] 경주할 자동차 이름 입력
- [x] 시도할 횟수 입력
- [x] 각 차수별 실행 결과
- [x] 우승자 안내 문구
    - [x] 단독 우승자
    - [x] 공동 우승자

### 예외사항 고려

- 입력값의 유효성
    - [x] 이름이 5자 이하
- 게임 횟수의 유효성
    - [x] 숫자만 가능
- RacingCars 리스트 유효성
    - [x] 차가 없을때는 예외 처리

---

## 기능 구현 설계

### 클래스를 총 3개로 나누어 기능을 구현

- 전체 게임을 진행을 담당할 클래스
- 자동차들을 담을 수 있는 클래스
- 자동차 클래스

### 각 클래스

- RacingGame(레이싱 게임 클래스)
    - 게임 횟수

- RacingCars(자동차들 관리 클래스)
    - List로 자동차들 관리

- RacingCar(자동차)
    - 차 이름
    - 전진 횟수

### 리팩토링을 진행하면서 추가된 클래스

- Enum들
- InputView, OutputView

## 리팩토링 과정

1. `InputView와 OutputView를 만들어 View와 도메인(RacingGame)을 분리해보자.`
    - RacingGame이 너무 많은 책임을 지고 있기 때문이다.
2. `역할과 책임을 더 명확히 나눠보자.`
    - 우승자를 찾는 로직은 RacingCars 클래스에서 RacingCar 객체 정보를 빼내와서(getter) 다루기 보단 RacingCar에서 Comparable을 이용해 자체적으로 로직을 처리할 수 있도록
      리팩토링
    - RacingGame은 순전히 차수별로 랜덤값을 생성해주는 역할만 담당해주자.
        - RacingCars의 리스트를 직접 받아와 RacingCar의 메서드를 다룰 수 없게해주자.
    - RacingCars는 랜덤값을 받아 RacingCar에게 전달해주는 역할을 담당시키자.
    - RacingCar 내부에서 랜덤값을 받아 판단하는 책임을 주자.
3. `RacingCars의 리스트는 내부에서만 접근할 수 있도록 완벽한 캡슐화를 시켜주자.`
    - View에서 값을 출력하는 어쩔 수 없이 getter을 사용해야한다면 `Collections.unmodifiableList()`를 사용해 읽기만 가능한 리스트를 반환해주자.
4. `Enum으로 연관된 상수들은 묶어서 관리하자.`
    - IllegalArgumentException 에러 메시지를 Enum으로 관리
    - 게임 안내 문구(Instruction)를 Enum으로 관리