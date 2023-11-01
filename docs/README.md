## 기능

- [X] 경주할 자동차 입력
    - 입력 하는 자동차 수는 제한이 없다.
    - 자동차 이름은 5자 이하.
- [X] 사용자가 입력한 자동차를 쉼표를 기준으로 구분.
- [X] 자동차 후보를 저장
- [X] 시도 횟수 입력
- [X] 0-9 사이의 랜덤값 추출
- [X] 현재 전진 횟수 갱신
- [X] 전진 결과 출력
- [X] 최종 우승자 판단
- [X] 최종 우승자 출력

---

## 메서드

- gameStart() : 게임 시작점
- getRacingCarNames() : 경주할 자동차 이름 입력
- splitByComma() : 컴마를 기준으로 string구분
- getAttemptCount() : 시도 횟수 입력
- startRacing() : 경주 시작점
- getRandomNumber() : 랜덤값 추출
- updateRacingStatus() : 경주 현황 갱신
- printRaceStatus() : 경주 현황 출력
- getWinnerNames() : 우승자 판단
- showWinners() : 우승자 출력

---

## MVC

### [Model]

#### class :

- GameModel <br/>
  ㄴ updateRaceStatus() <br/>
  ㄴ getWinnerNames() <br/>
- UtilityModel <br/>
  ㄴ splitByComma() <br/>
  ㄴ getRandomNumber() <br/>
- RacingCarInfo <br/>
- Number <br/>

### [View]

#### class :

- GuideMessageView <br/>
  ㄴ 안내문구
    - 경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)
    - 시도할 회수는 몇회인가요?
    - 실행 결과
    - 최종 우승자 :
- ExceptionMessage <br/>
- RaceStatus <br/>
  ㄴ printRaceStatus() <br/>
- RaceResult <br/>
  ㄴ showWinners() <br/>

### [Controller]

#### class

- UserInput<br/>
  ㄴ getRaceCarNames() <br/>
  ㄴ getAttemptCount() <br/>
- RacingGame <br/>
  ㄴ gameStart() <br/>
  ㄴ startRacing() <br/>
  ㄴ endRacing() <br/>


