## 

## 🚗 자동차 게임 기능명세서

- ### ⌨️ Input 관련 - Class : InputView, Validator 에서 예외 처리! 
  - [ ] 1 자동차 이름들에 대한 입력을 받는 부분이 있어야 한다! - ## InputView - inputCarName
    - [ ] 자동차 이름 입력 생각해볼 것!
      - [ ] 요구사항에서 자동차의 이름에 대한 다른 제한이 없다!
      - [ ] ,로 구분자를 잡기 때문에 해당 문자는 들어가지 않을 것이다!
      - [ ] 이름은 5자 이하여야 한다!
      - [ ] 오로지 공백인 경우? -> 이건 말이 되나?
  - [ ] 2 이후 게임을 몇 번 진행할 지 입력을 받는다!  - ## InputView - inputGameCount
    - [ ] 게임 횟수 입력 시 생각해 볼 것!
      - [ ] 게임 횟수가 얼마나 될 지 제한이 없다! -> 최대한 범위를 넓게 잡는게 좋을 거 같다!

- ### 🖥️ Output - Class : OutputView
  - [ ] 1 초기 출력문 정의 - ## OutputView - printInitGame
  - [ ] 2 게임 횟수 입력하기 전 출력문 정의 ## OutputView - printBeforeInputGameCount
  - [ ] 3 실행 결과 출력 ## OutputView - printGameResult
  - [ ] 4 최종 우승자 출력 ## OutputView - printWinner

- ### 🤔 Logic - CarGameService, InputService, JudgementService
  - [ ] 자동차 이름 (,) 로 분리하는 작업 진행 - ## InputService - splitName
    - [ ] 여기에서 확인! 자동차 이름의 길이가 5가 넘어가는 경우!
  - [ ] 게임 횟수 만큼 진행될 수 있게 진행 - 🚗 CarGameService
  - [ ] 게임 진행 - ## CarGameService - gameStart
    - [ ] 자동차의 이름마다 숫자 굴리기 - NumberGenerator 
      - [ ] 숫자가 4 이상인 경우 자동차가 전진을 기록한 변수 + 1
    - [ ] 자동차들에 대한 정보를 저장 - 🚗 Car
      - [ ] 이름, 전진 카운트, 현재 출력될 결과 모습 (매번 for 문으로 출력하지 않기 위해!)
  - [ ] 게임이 끝나는 마지막 과정에서 우승자가 누군지 판별하는 곳 필요! - JudgementService




- ### ❌ Error (Case 매번 추가하기!) - Validator 에서 check , IllegalArgumentException 발생시키기!
  - [ ] 자동차 이름의 길이가 5를 넘어가는 경우
  - [ ] 오로지 공백인 경우


---

## 리팩토링 관련 요구사항 처리 
- [ ] indent depth 3 미만으로 진행!
- [ ] 3항 연산자 사용 x
- [ ] 함수가 한 가지 일을 할 수 있도록 정의
- [ ] Junit5 or AssertJ를 활용하여 기능 명세서의 기능에 대한 테스트 진행! 

