# 프로젝트 구조

```
.
├── main
│   └── java
│       └── racingcar
│           ├── Application.java
│           ├── model
│           ├── view
│           ├── controller
│               
└── test
│     └── java
│         └── racingcar
│           ├── ApplicationTest.java
│           ├── CarTest.java
│           ├── InputViewTest.java
│           ├── OutputViewTest.java
            └── RacingGameTest.java
```

# 기능 요구 사항

---
문제 요구 사항

- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
- 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
- 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
- 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.

---
패키지 별 구현 기능 목록

## model 패키지

- Car
  - 자동차의 이름을 생성자에 입력 
  - 자동차의 초기 위치(position)를 0으로 생성
  - 자동차 position을 증가시키는 move 메소드 구현
- CarList
  - Car의 컬렉션을 다시 클래스로 묶음
  - Car 이름 검증 메소드를 이 클래스에 구현함
- Cars
  - CarList를 담는 객체 
  - 실제 Car 리스트의 생성을 담당함
  - getter 를 통해 Car 의 원시 리스트 배열을 가져옴 

## view 패키지

- InputView
    - 자동차들의 이름을 입력받는 안내 메시지 출력
    - 자동차들의 이름을 입력받음
    - 반복할 라운드 횟수를 입력받는 안내 메시지 출력
    - 반복할 라운드 횟수를 입력받음

- OutputView
    - 하나의 Car 객체의 상태 (name, position) 을 문자열로 출력
    - Cars 를 이용해 여러개의 Car 객체의 상태를 동시에 출력
    - 방금 구현한 메소드들을 통해 라운드 별 , 자동차들의 상태를 출력

## Controller 패키지
- RacingGame
  - 

