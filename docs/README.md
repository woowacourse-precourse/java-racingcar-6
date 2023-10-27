1 - 프로그램 동작흐름
===
1. 자동차 이름 입력문구 출력


    경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)
&nbsp;
2. 자동차 이름들을 입력 받는다
   1. 아무 내용도 없는지 검증
   2. 선택한 타입의 범위를 넘지 않는지 검증
   3. 사용자 입력의 공백을 제거
   4. 쉼표를 기준으로 배열에 나눠 담는다
   5. 2-iii에서 각 이름이 5자 이하인지 검증
   6. 2-iii에서 이름이 중복되는지 확인

&nbsp;
3. 시도횟수 안내문구 출력


    시도할 회수는 몇회인가요?
&nbsp;
4. 시도횟수를 입력 받는다
    1. 아무 내용도 없는지 검증
    2. 선택한 타입의 범위를 넘지 않는지 검증
    3. 양수인지 검증(0은 거르자)
      - 공백이 있는지 검증 추가

&nbsp;
5. 게임 연산
    1. "실행결과"문구 출력


    실행결과

2. 자동차별 전진횟수를 저장할 변수를 선언 및 초기화
   3. 자동차별 0에서 9 사이에서 무작위 값을 생성후 4 이상일 경우 해당 변수를 +1
   4. 5-iii데이터 기반으로 실행 결과 출력

   - 
         pobi : -
         woni :
         jun : -


5.  사용자가 입력한 시도횟수만큼 5-iii, iv반복

    -

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
6. 최종 우승자 출력
    1. 5번의 데이터를 기반으로 최종 우승자 선별
    2. 6-i데이터 기반으로 최종 우승자 출력


    최종 우승자 : pobi, jun

---

2 - MVC패턴에 의한 기능분류
===

## domain
   __1. Cars__
   - [x] addCars(메소드 분리)
     1) removeSpaces(공백을 모두 제거)
     2) splitByComma(","단위로 분리 후 리스트에 저장)
     3) validateNameLength(자동차 이름 길이를 검증)
     4) validateUniqueNames(이름이 중복되지 않는지 검증)
     5) initializeCars(검증된 데이터를 값(직진 거리)은 0인 해쉬맵으로 저장한다)
      - 자동차 이름을 받아 검증해서 키값(직진 거리)은 0인 해쉬맵으로 저장한다
   - [x] getCars
      - 자동차 데이터를 보내준다
   - [x] setCars
      - 자동차 데이터를 설정해준다

   2. Racing
   - [x] validateAttemptCount
     1) trimSpaces(앞뒤 공백을 제거)
     2) checkForInternalSpaces(안제 공백이 있다면 예외 던짐)
     3) convertToBigInteger(정수가 아닌 다른 문자가 있다면 예외던짐)
     4) validateRange(Long타입 범위에 벗어나지 않는지 확인)
     5) convertToLong(Long타입으로 변환)
     6) validatePositive(자연수가 아니라면 예외던짐)
     - 사용자가 입력한 시도횟수를 받아 검증해서 데이터를 저장한다
   - [x] race
     1) isMovable(랜덤숫자를 생성해 움직일지 결정해준다)
     - 자동차 데이터를 가져와 랜덤 숫자를 생성해서 조건을 충족시키면 한칸 전진시킨다
   - [x] getAttempCount
     - 시도횟수를 보내준다가

## view
   __1. InputView__
   - [x] printCarNameRequest
     - 자동차이름 입력안내문구 출력 후 입력을 받는다

    경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)

   - [x] printAttemptCountRequest
     - 시도횟수 입력안내문구 출력 후 입력을 받는다

    시도할 회수는 몇회인가요?

__2. OutputView__
- [ ] printResultText


    실행 결과

- [ ] printExecutionResult
    - 게임 결과를 출력한다


    pobi : -
    woni :
    jun : -

- [ ] printFinalWinner
    - 데이터를 넘겨받아 최종 우승자를 출력한다


    최종 우승자 : pobi, jun

## util
__1. EmptyValidator__
-  [x] validateEmpty
    - Cars와 Racing에서 공통적으로 사용되는 빈값입력을 검증한다

## controller
__1. RacingController__
- [ ] raceStart
    - 뷰와 도메인 코드를 가져와 게임의 흐름대로 실행한다



