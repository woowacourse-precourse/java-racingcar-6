## 미션 - 자동차 경주

---
### :star: 개발 목표
> ##### 1. 요구사항 분석 및 기능 목록 정리하기
> ##### 2. 의미있는 커밋 메시지 작성하기
> ##### 3. 자바 코드 컨벤션 지키기 
> ##### 4. 객체 지향 설계하기
---
### :pencil2: 기능 목록
- 경주할 자동차 이름 입력
  - 쉼표(,)를 기준으로 이름 구분
  - 이름은 5자 이하로 구성
  - 중복된 이름 안됨
  - 잘못된 값 입력 시, `IllegalArgumentException` 발생

    
- 시도할 횟수 입력
  - 자동차가 이동하는 횟수와 동일
  - 숫자로 구성
  - 잘못된 값 입력 시, `IllegalArgumentException` 발생


- 자동차 전진
  - 0 ~ 9 사이의 무작위 값을 구한 후, 해당 값이 4이상일 경우 전진
  - 입력한 자동차 순서대로 전진 상황 출력
  - 한 칸씩 전진


- 게임 완료
  - 한 명 이상의 우승자 출력
  - 우승자가 여러명일 경우, 쉼표(,)를 기준으로 출력 
---
### :pencil: 주요 기능 명세서
|클래스|분류|상세 기능|메서드|비고|
|:----:|:---:|:-------:|:---:|:----:|
|Game|입력|경주할 자동차 이름 입력|printPhrasesCarName, inputCarName||
|Game|입력|시도할 횟수 입력|printPhraseNumberOfTry, inputNumberOfTry||
|Game|생성|게임에서 사용되는 자동차 객체 생성|makeCarEntity||
|Game|유효성검사|자동차 이름이 중복되는지 검사|checkDuplicationName||
|Car|유효성 검사|자동차 이름 검사|checkValidCarName||
|Car|유효성 검사|입력한 자동차 이름이 0글자이거나 혹은 5글자를 초과하는지 검사|checkLengthOfName||
|Game|생성|시도할 횟수를 가진 라운드 횟수 지정|initRound||
|Game|유효성 검사|입력한 시도 횟수가 숫자인지 확인|checkNumberOfTry||
|Game|생성|게임 시작|startGame||
|Round|생성|라운드 시작|startRound||
|Round|이동|자동차 전진|moveForward||
|Car|이동|랜덤 값에 따라 전진 혹은 그대로|moveForwardOrNot||
|Round|출력|자동차 이동 상태 출력|printMovement||
|Game|출력|게임 우승자 출력|printPhrasesWinner||
|Game|생성|게임 우승자 선별|getWinner||
