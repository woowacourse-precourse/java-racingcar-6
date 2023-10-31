## 기능 목록

- [o] 자동차 m개의 이름과 n번의 경주 시도 횟수를 입력받을 수 있다. - askCarName(), askRound()
  - [o] 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 종료한다. - checkCarNameAsCommas(), checkCarNameAsLength(), checkRound() 

- [o] n번의 횟수 동안 m개의 자동차는 각각 '-'을 출력하거나 ''을 출력하는 경기를 반복한다.
  - [o] 각각의 자동차는 0부터 9사이의 무작위 값을 생성하여 해당 값이 4이상인 경우 '-', 아닌 경우 ''를 출력한다. - computeTrack()
  - [o] 전 출력값에 이어서 출력해준다. - printTrack()

- [o] 게임을 완료한 후 가장 큰 수를 가진 사람을 우승자로 출력한다. - findMaxTrack(), findWinner()
  - [o] 우승자가 여러 명일 경우 쉼표를 이용하여 구분한다.