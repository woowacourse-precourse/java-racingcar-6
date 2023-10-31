# 우아한테크코스 java-racingcar-6

미션 - 자동차 경주

![](../header.png)

## 🔍기능 요구

초간단 자동차 경주 게임을 구현한다.

- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
- 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
- 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
- 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.


![](../header.png)

## 📃흐름도

- "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)”을 출력한다.
    - 사용자는 자동차 이름을 입력한다.(개수는 상관없음, 이름은 5자 이하)
      - 자동차 이름의 유효성을 검사한다.
- “시도할 회수는 몇회인가요?"를 출력한다.
    - 사용자는 회수를 출력한다.
      - 회수의 유효성을 검사한다.
- “실행 결과”를 출력한다.
- 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우 자동차를 전진한다.
- 모든 차의 전진 여부를 확인한다.
- 이를 지정 횟수만큼 반복한다.
- 우승자를 출력한다.

  ![](../header.png)

## 🎯기능 목록

- View
  - output
    - [x] "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)”를 출력하는 기능
    - [x] “시도할 회수는 몇회인가요?"를 출력하는 기능
    - [x] “실행 결과”를 출력하는 기능
    - [x] 각 실행 결과 출력하는 기능
    - [x] 최종 우승자 출력하는 기능
    - [x] 줄바꿈을 출력하는 기능
    - [x] "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."를 출력하는 기능
  - input
    - [x] 사용자가 값을 입력 하는 기능
- Validator
  - 자동차 이름 값 유효성 검사
    - [x] 빈 문자열(" " != "") -> Exception
    - [x] null -> Exception
    - [x] 5 초과 -> Exception
  - 회수 값 유호성 검사
    - [x] 1 ~ 9 사이 값 외 -> Exception
  - 진행 상태 값 유효성 검사
    - [x] 1 ~ 2 사이 값 외 -> Exception
- Service
  - [x] 각 자동차마다 RaceCar 객체를 생성하는 기능
  - [x] 0 ~ 9 사이의 랜덤값을 뽑는 기능
  - [x] 4 이상이면 전진하는 기능
  - [x] 최종 우승자를 구하는 기능

  ![](../header.png)

## ⚙️Test
- RacingcarTest
  - [x] run_자동차_객체_생성_테스트
      - input: "pobi,songe,rose"
      - contains(“pobi", "songe", "rose”)
  - [x] run_전진_확인
      - input: “pobi,songe,rose”
      - contains(“pobi", "songe", "rose”)
      - contains(0, 2, 0)
  - [x] run_최종_우승자_두명_이상일_경우_출력
      - input: "pobi,songe,rose"
      - isEqualTo(“최종 우승자 : pobi, songe”)
- Validator
    - NameTest
      - [x] name_자동차_이름이_빈_문자열_예외_처리
          - input: “pobi,,songe”
          - isInstanceOf(IllegalArgumentException)
          - hasMessageContaining("자동차 이름의 길이가 1 미만!")
      - [x] name_자동차_이름이_5_초과_예외_처리
          - input: “pobi,songyi”
          - isInstanceOf(IllegalArgumentException)
          - hasMessageContaining("자동차 이름의 길이가 5 초과!")
      - [x] name_자동차_이름이_null_예외_처리
          - input: null
          - isInstanceOf(IllegalArgumentException)
          - hasMessageContaining("자동차 이름이 Null!")
      - [x] name_이름에_공백이_있을_경우_공백도_출력
          - input: "po bi,songe, rose"
          - contains("po bi", "songe", " rose")
      - [x] name_구분자가_포함되지_않은_경우_값을_그대로_출력
          - input: “pobi"
          - contains("pobi")
    - statusTest
      - [x] status_상태값이_1_or_2_외면_예외_처리
          - input: "k"
          - isInstanceOf(IllegalArgumentException)
          - hasMessageContaining("1, 2 외의 값 입력!")
    - TryNumberTest
      - [x] trynumber_횟수가_1_이상의_숫자_외_예외_처리
          - input: "k"
          - isInstanceOf(IllegalArgumentException)
          - hasMessageContaining("시도 횟수를 잘못 입력!")
- View
  - OutputViewTest
      - [x] print_자동차_이름을_입력하세요
          - "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"
      - [x] print_회수를_입력하세요
          - "시도할 회수는 몇회인가요?"
      - [x] print_실행_결과_문구
          - "실행 결과"
      - [x] print_실행_결과
          - output: "pobi : ---"
      - [x] print_최종_우승자
          - "최종 우승자 : pobi"

  ![](../header.png)
  
## 개발 환경 설정

java 17

gradle 8.1.1
