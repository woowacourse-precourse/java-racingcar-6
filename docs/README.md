## ✔ 기능 체크리스트
+ ### InputView
  - [x] 경주할 자동차 이름의 입력 요청 문구 : printInputCarName
  - [x] 시도할 횟수 입력 요청 문구 : printInputTryNumber
+ ### Validator
  + 자동차 이름 입력
    + **InputValidator**
      - [x] 아무것도 입력하지 않은 경우 : isNullOrIsEmpty
      - [x] 자동차의 이름을 쉼표 외 숫자, 기호로 입력한 경우 : includeNumberOrSymbolExceptComma
      - [x] 구분자 뒤 공백이 있는 경우 : includeSpace
    + **CarValidator**
      - [x] 이름이 대문자인 경우 : checkUpperCase
      - [x] **이름의 글자 수가 5자리를 초과**한 경우 : checkCarNameLength
      - [x] 이름 중복 : checkDuplicateCarName
  + 시도 횟수 입력
    + **InputValidator**
      - [x] : 아무것도 입력하지 않은 경우 : isNullOrIsEmpty 재사용
      - [x] 숫자가 아닌 경우 : isNotDigit
+ ### OutputView
  - [x] "실행 결과" 문구 출력 : printResultMessage
  - [x] 경주에 참여한 자동차 이름 출력 : printCarName
  - [x] 각 자동차 전진 '-'로 출력 : printMove
  - [x] "최종 우승자 : " 문구 출력 : printWinnerMessage
    - [x] 단독 우승자 
    - [x] 공동 우승자
      - [x] 구분자 ',' 사용
      - [x] 구분자 뒤 공백
    - :**CarGame에서 join메소드를 이용하여 결과 문자열을 생성하고 이를 받아 우승자 출력**
+ ### CarGame
  - 경주할 자동차 이름을 받아 저장하는 기능
    - 쉼표(',') 기준으로 이름을 분리하여 저장
      - [x] 쉼표(',') 기준으로 이름을 분리 : splitCarNames
      - [x] 자동차 리스트 만들기 : getCarList
      - [x] 쉼표 유무 판단 (없다면, 자동차 1대) : split메소드를 이용하여 리스트의 원소가 한 개인 경우, 문자열 그대로 반환
    - [x] 입력 받기 : getCarNamesInput
      - [x] 예외처리 : checkCarNamesInput
  - 시도 횟수 받는 기능
    - [x] 입력 받기 : getTryNumberInput
      - [x] 예외 처리 : checkTryNumberInput
  - 전진
    - [x] 0에서 9 사이에서 무작위 값을 구하는 기능 : camp.nextstep.edu.missionutils에서 제공하는 Random API 사용
      - [x] 값이 4 이상이 경우, 각 참여 자동차들의 이동 숫자 증가 : pickNumberAndMove
    - [x] 실행 결과 받기 : showCarScoreResult
      - [x] 전진 결과 받기 : showCarMove
  - 우승자를 가리는 기능 : showWinnerResult
    - [x] 우승자 리스트 받기 : chooseWinner
    - [x] 최고점 받기 : getMoveCountMax