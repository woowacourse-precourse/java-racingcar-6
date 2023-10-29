1 - 프로그램 동작흐름
===
1. 자동차 이름 입력문구 출력
```
경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)
```
&nbsp;
2. 자동차 이름들을 입력 받는다
   1) 아무 내용도 없는지 검증
   2) 사용자 입력의 공백을 제거
   3) 쉼표를 기준으로 배열에 나눠 담는다
   4) 2-iii에서 각 이름이 5자 이하인지 검증
   5) 2-iii에서 이름이 중복되는지 확인

&nbsp;
3. 시도횟수 안내문구 출력 

```
시도할 회수는 몇회인가요?
```

4. 시도횟수를 입력 받는다
   1) 아무 내용도 없는지 검증
   2) 선택한 타입의 범위를 넘지 않는지 검증
   3) 양수인지 검증

&nbsp;
5. 게임 연산
   1) "실행결과"문구 출력
       ```
        실행결과
       ```
   2) 자동차별 전진횟수를 저장할 변수를 선언 및 초기화
      - 자동차별 0에서 9 사이에서 무작위 값을 생성후 4 이상일 경우 해당 변수를 +1
      - 5-iii데이터 기반으로 실행 결과 출력
        ```
        pobi : -
        woni :
        jun : -
        ```
   3) 사용자가 입력한 시도횟수만큼 5-iii, iv반복

    
    pobi : --
    woni : -
    jun : --
    
    pobi : ---
    woni : --
    jun : ---
    
    pobi : ----
    woni : ---
    jun : ----
    
    pobi : -----
    woni : ----
    jun : -----
    

&nbsp;
4. 최종우승자 출력
   1) 5번의 데이터를 기반으로 최종 우승자 선별
   2) 6-i데이터 기반으로 최종 우승자 출력
      ```
      최종 우승자 : pobi, jun
      ```
---

2 - MVC패턴에 의한 기능분류
===

## domain
   __1. CarNameManager__
   - [x] processCarNames
     - [x] processInput
       1) removeSpaces
       - 공백을 모두 제거
       2) splitByComma
       - ","단위로 분리 후 리스트에 저장
     - [x] validateCarNames
        1) validateNameLength
         - 자동차 이름 길이를 검증
        2) validateUniqueNames
         - 이름이 중복되지 않는지 검증
     
   __2. Cars__
   - [x] addCars
     - 자동차 리스트를 받아옴
   - [x] initializeCars
     - 해쉬맵을 사용하여 <자동차이름, 이동거리> 세팅
   - [x] getCar
     - 자동차 데이터(해쉬맵) 게터
   - [x] moveCar
     - 해당 자동차 이동거리 +1
   - [x] determineFinalWinner(자동차 데이터를 기반으로 우승자 선별)
        1. getHighestPosition
        - 가장 높은 값을 찾음
        2. getWinners
       - 위의 메소드 값과 같은 값의 자동차 이름을 추출

__3. Racing__
- [x] race
    - [x] pickRandomNumber
      - 0-9 랜덤 정수 반환
    - [x] isMovable
      - 4이상이면 true
    - [x] getAttempCount
      - 시도횟수 게터

    
__4. AttemptCountValidator__
- [x] validateAttemptCount
    - [x] trimSpaces
      - 앞뒤 공백을 제거
    - [x] ensureNoInternalSpaces
      - 숫자 안에 공백이 있다면 예외 던짐
    - [x] convertToInt(int타입의 범위에 맞는 수인지 검증)
        1) convertToBigInteger
        - BigInteger로 변환하는 과정중에 정수 외의 타입이 있는지 확인
        2) isNaturalNumber
      - 자연수인지 검증

## view
   __1. InputView__
   - [x] printCarNameRequest
     - 자동차이름 입력안내문구 출력 후 입력을 받는다
     ```
     경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)
     ```

   - [x] printAttemptCountRequest
     - 시도횟수 입력안내문구 출력 후 입력을 받는다 
     ```
     시도할 회수는 몇회인가요?
     ```
__2. OutputView__
- [x] printResultText
```
실행 결과
```
- [x] printExecutionResult
    - 게임결과를 출력한다

```
pobi : -
woni :
jun : -
```
    

- [x] printFinalWinner
    - 데이터를 넘겨받아 최종 우승자를 출력한다

```
최종 우승자 : pobi, jun
```

## util
__1. BlankValidator__
-  [x] isEmpty
    - Cars와 Racing에서 공통적으로 사용되는 빈값입력을 검증한다
-  [x] RandomNumberGenerator
    - moveCarIfMovable메서드를 테스트하기 위해 랜덤숫자제공 인터페이스 생성

## controller
__1. RacingController__
- [x] raceStart(경주게임 시작)
    - [x] setUpRace(경주 세팅)
      1) addCarsToRace
        - 사용자에게 자동차 이름 입력받음
      2) setAttemptCountForRace
        - 사용자에게 시도횟수 입력받음
- [x] runRace
    - 시도횟수만큼 경주실행 후 결과 출력
- [x] printRaceResults
    - 우승자 출력



