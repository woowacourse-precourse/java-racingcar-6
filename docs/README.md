# 1. 학습 목표
- TDD 기반으로 프로그래밍하는 경험
- 메소드 분리 + 클래스를 분리하는 리팩토링 경험
- 점진적으로 리팩토링하는 경험

# 2. 객체지향 생활 체조 원칙

- 규칙 1: 한 메서드에 오직 한 단계의 들여쓰기만 한다.
- 규칙 2: else 예약어를 쓰지 않는다.
- **규칙 3: 모든 원시값과 문자열을 포장한다.**
- **규칙 5: 줄여쓰지 않는다(축약 금지).**
- **규칙 8: 일급 콜렉션을 쓴다.**

# 3. 기능 요구사항

## 3-1. Position 클래스
- [x] Position은 위치를 가진다.
- [x] Position은 항상 0부터 시작하지만 of 메소드를 통해 다른 시작점을 가질 수 있다.
- [x] Position은 move 메소드를 통해 이동할 수 있다.
- [x] Position은 이동한 결과를 "-"를 통해 표현한다.
- [x] Position은 서로 다른 위치인지 비교할 수 있다.

## 3-2. Name 클래스
- [x] Name은 이름을 가진다.
- [x] Name은 5글자를 초과할 수 없다.
- [x] Name은 공백을 허용하지 않는다.
- [x] Name은 null을 허용하지 않는다.
- [x] Name은 이름을 표현할 수 있다.

## 3-3. Car 클래스
- [x] Car는 이름과 위치를 가진다.
- [x] Car는 이름과 위치를 표현할 수 있다.
- [x] Car는 of 메소드를 통해 생성할 수 있다.
- [x] Car는 move 메소드를 통해 이동할 수 있다.
- [x] Car는 move 메소드를 통해 4이상의 값이 들어올 경우 이동한다.
- [x] Car는 move 메소드를 통해 4미만의 값이 들어올 경우 이동하지 않는다.
- [x] Car는 MaxPosition 값과 같을 시 승리자로 판단하여 true를 반환한다.
- [x] Car는 MaxPosition 값과 다를 시 false를 반환한다.
- [x] Car는 자동차 이름을 반환할 수 있다.
- [x] Car는 자동차 위치를 반환할 수 있다.

## 3-4. Cars 클래스
- [x] Cars는 자동차들을 가진다.
- [x] Cars는 자동차들을 각각 이름과 위치를 표현할 수 있다.
- [x] Cars는 자동차 이름들을 받아서 자동차들을 생성할 수 있다.
- [x] Cars는 자동차들을 이동시킬 수 있다.
- [x] Cars는 실행 결과에서 우승자를 판단할 수 있다.

## 3-5. RacingGame 클래스
- [x] RacingGame은 자동차들, 시도할 횟수, 실행한 횟수를 가진다.
- [x] RacingGame은 게임을 생성할 수 있다. - 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- [x] RacingGame은 게임을 실행할 수 있다.
- [x] RacingGame은 게임이 끝났는지 판단할 수 있다.

# 4. 클래스 다이어그램
<p align="center">
  <img src="https://www.notion.so/image/https%3A%2F%2Fprod-files-secure.s3.us-west-2.amazonaws.com%2F8f9374ea-d950-4add-878f-648f2923ed06%2Fc5f3af34-9c41-4e09-aa12-47ee37d199da%2FUntitled.png?table=block&id=c7d0bcbb-3bea-43b6-b1c1-4122d16186cb&spaceId=8f9374ea-d950-4add-878f-648f2923ed06&width=1740&userId=2f121881-2289-461c-a96c-58cde2646312&cache=v2" alt="class" width="number" />
</p>