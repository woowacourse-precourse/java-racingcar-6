Message.java
- 안내 문구 생성
  - namingCarMessage = "경주할 자동차 이름을 입력하세요 ~~"
  - getCountsMessage = "시도할 회수는 ~~"
  - printGamingMessage = "실행 결과"
  - printWinnerMessage = "최종 우승자 : "

BoundaryValue.java
- 경계값 지정
  - goCondition
  - minRandomNumber
  - maxRandomNumber

GetInput.java
- 사용자 입력 받기
  - 경주할 자동차 이름
  - 시도할 회수

Application.java
- 전반적인 게임 진행 개요
    - 시작 문구 출력 - Stationary의 namingCarMessage
    - 경주 자동차 이름 입력
    - 시도할 횟수 문구 출력 - Stationary의 getCountsMessage
    - 시도할 횟수 입력
    - 실행 결과 문구 출력 - Stationary의 printGamingMessage
    - 실행 결과 출력
    - 최종 우승자 출력

Validation.java
- 경주할 자동차 이름 검사
    - 쉼표 다음 바로 쉼표가 나오거나 아무것도 입력하지 안으면 오류 출력
    - 이름을 입력하지 않으면 오류 출력
- 시도할 횟수 검사

Car.java
- 자동차 객체 생성
    - 이름: String
    - 점수: Int


CarSet.java
- 경주할 자동차 이름 추출
    - 쉼표를 기준으로 문자열을 구분하여 ArrayList형태에 담아 반환
- 경주할 자동차 이름 ArrayList를 가져와서 각각의 Car 객체 생성하여 반환

Ramdom.java
- 0~9 사이의 난수를 생성하여 값이 4 이상일 경우 true 반환

Game.java
- 실행 횟수만큼 게임 실행
    - 난수 반환 값이 true면 점수 1 증가
    - 1회가 끝나면 결과 출력
    - 모두 끝나면 최종 결과 출력

- 진행 결과 출력
    - player들의 점수를 출력

- 최종 결과 출력