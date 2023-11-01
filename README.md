
### 🏚️<프리코스 2주차: 새로 알게 된 것과 고민 거리들>
#### 🍎 기능 구현
* [camp.nextstep.edu.missionutils.Console의 readLine()은 어떤 구조로 데이터를 받아올까?](https://github.com/SilverWithA/java-racingcar-6/wiki/camp.nextstep.edu.missionutils.Console%EC%9D%98-readline()%EC%9D%80-%EC%96%B4%EB%96%A4-%EA%B5%AC%EC%A1%B0%EB%A1%9C-%EB%8D%B0%EC%9D%B4%ED%84%B0%EB%A5%BC-%EB%B0%9B%EC%95%84%EC%98%AC%EA%B9%8C%3F)
* [어떤 자료구조를 사용하는 것이 좋을까?:배열? ArrayList? HashMap? 그것이 문제로다](https://re-decor5213.tistory.com/69)
* [static 키워드의 정확한 의미](https://re-decor5213.tistory.com/68)

#### 🍋 단위테스트
* [ApplicationTest는 어떻게 고정된 랜덤값으로 코드를 테스트할까](https://devbasket.tistory.com/m/66)

#### 🍊컨벤션
* [git 커밋 컨벤션: 어떤 커밋 메시지가 좋은 커밋 메시지일까?](https://re-decor5213.tistory.com/67) - [AngularJS Git Commit Message Conventions](https://gist.github.com/stephenparish/9941e89d80e2bc58a153#goals)


### 🎈<프리코스 2주차: 목표>
>  ✅ 각종 컨벤션 지키기!
>  ✅ 기능 별 커밋
>  ✅ 리팩토링
>  ✅ JUnit을 이용한 단위 테스트





***
### 🌳 <기능 목록 & File Tree>
0. _**Application**_
* controller의 매서드를 `readyRace` -> `startRace` -> `prizeWinner` 순서로 실행

1. _**Controller**_


***

기능(1) 입력값을 받는다:`readyRace`
- `readyRace`
  - `RacePreparation`
    - `askCarNames`- 경주차의 이름을 받는다
      - `splitNamesByComma` - 이름을 쉼표 기준으로 분리
      - `isLimitFiveString` - 이름이 5자가 넘지 않는지 확인
    - `askExecuteCount`- 경주 실행 횟수를 받는다 
      - `isInt` - 받은 값이 숫자형인지 확인  


***

기능(2) 레이싱을 시작한다:`startRace`
- `startRace`
  - `RaceLog`
    - `createEmptyRaceLog` - 빈 레이스 로그를 만든다
  - `RaceStart`
    - `createRandomNumbers` - 각 경주차마다 무작위 값을 만든다
    - `updateRaceLog` - 무작위 값에 따라 모든 경주차의 로그 업데이트
      - `RaceLog.isCarAdvance` - 각 경주차가 전진할지 확인
      - `RaceLog.addEachCarsRaceLog` - 각 경주차에 레이스 로그 추가
    - `showRaceLog` - 실행 결과를 출력한다

***

기능(3) 최종 우승자를 정한다:`prizeWinner`
- `prizeWinner`
  - `WinnerCalculator` - 최종 우승자를 계산한다
    - `calculateWinner` - 레이싱 로그의 최댓값과 로그 길이가 같은 경주차 계산 
    - `calculatePathLength` - 각 경주차의 레이싱 로그의 길이를 계산한다

***



