# 🚘 자동차 게임 /  기능 목록 작성
![badge1](https://img.shields.io/badge/woowacourse-backend-red.svg)
![badge1](https://img.shields.io/badge/precourse-week2-blue.svg)
---
## 🛠️ 기능 목록
- ### Model
  - [ ] Car
    - [ ] 자동차에 이름을 부여할 수 있다. - setCarName(), getCarName()
    - [ ] 자동차는 전진한 정도 읽을 수 있다. - getStep()
    - [ ] 자동차는 전진할 수 있다. - increaseStep()
    
- ### Viewer
  - [ ] 경주할 자동차 이름과 시도할 횟수에 대해서 물어본다. - printAskCarNames, printAskTheNumberOfTry
  - [ ] 현재 자동차들의 전진 상태값을 출력한다. - printRaceState()
  - [ ] 최종 우승자를 출력한다. - printWinners
  
- ### Controller
  - [ ] 사용자로부터 자동차의 이름과 시도할 횟수에 대해서 입력받는다. - readCarNames(), readTheNumberOfTry()
    - [ ] 입력 받은 자동차들 이름을 tokenize하여 자동차 클래스를 만든다.
  - [ ] 시도할 횟수 만큼 게임을 진행한다.
    - [ ] 각각의 차마다 랜덤 숫자를 생성하고, 특정 조건에 맞춰 차량을 전진시킨다. - canProgress()
    - [ ] 시도가 끝나면, 최종 우수자를 선별한다. - findWinners()

---
## 🚀 기능 요구 사항
초간단 자동차 경주 게임을 구현한다.

- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
- 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
- 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
- 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.