# 미션 - 자동차 경주

## 구현 기능 목록

### 자동차 이름  및 게임 실행 횟수 세팅
- readLine()을 사용하여 문자열 입력
- 자동차 이름은 예외 처리와 stringToArrayList 메소드를 통해서 ArrayList 배열에 저장
- 게임 실행 횟수도 예외 처리를 통해서 playNumber에 저장
- 예외 : 자동차 이름 길이가 5자를 넘는 경우
- 예외 : 자동차 이름 길이가 0인 경우
- 예외 : 게임 실행 횟수가 정수로 변환되지 않는 경우 (checkException과 isNumeric 메소드 사용)

### 게임 실행
- gamePlay 메소드를 통해 무작위 값 생성 및 자동차 전진
- playCount 변수에 반복 횟수를 저장하여 종료 조건 작성
- while문을 통해서 반복 출력 및 게임 진행

### 결과 출력
- printWinner 메소드를 통해 우승자가 한 명인지, 여러 명인지에 따라 각각 printWinnerAlone, printWinnerSeveral 호출
- printWinnerAlone 메소드가 호출될 경우, 최종 우승자 문자열과 함께 단일 우승자 출력
- printWinnerSeveral 메소스가 호출 될 경우, 매개변수로 전달받은 우승자의 인덱스값 배열을 사용하여 여러 우승자 출력

