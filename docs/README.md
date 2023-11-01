### 기능 목록

- [x] 자동차 이름 입력 받기
    - [x] 쉼표를 기준으로 구분하기 - Race#getSplit()
      - [x] 이름을 입력하지 않거나 이름이 5자 이상이면, `IllegalArgumentException` 발생 - Race#validate()
- [x] 시도할 횟수 입력 받기
- [x] 자동차 경주 게임 하기 - Race#racing()
    - [x] 무작위 값을 구한 후, 무작위 값이 4 이상일 경우 전진하기 - Race#round
        - [x] 자동차별로 움직인 횟수 카운팅하기 - Car#move()
    - [x] 차수별 실행 결과 출력하기 - Race#printRaceResultByRound()
- [x] 우승자 출력하기, 여러 명일 경우 쉼표로 구분해서 출력하기 - Race#getWinners()
    - [x] 자동차별로 움직인 횟수 중 가장 큰 값 찾기 - Race#findMaxCount()
    - [x] 가장 큰 값을 가진 자동차 이름 반환하기 - Race#getWinnerNames()