# 자동차 게임 구현 기능 목록

## 시작 문구 출력
  - 게임 시작시 경주할 자동차 이름을 입력하라는 문구 출력

## 자동차 이름 입력
  - 경주할 자동차 이름을 camp.nextstep.edu.missionutils.Console의 readLine()을 사용하여 입력
  - 2대 이상일 경우는 ,(쉼표)를 구분자로 사용하여 입력
  - String 타입으로 입력받은 자동차 이름들을 parser를 사용하여 각각 carNames 라는 이름의 배열에 저장
  - 자동차의 이름은 5자 이하만 가능하며, 값이 없거나 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션을 종료
  - 중복되는 이름을 입력할 경우도 IllegalArgumentException을 발생시킨 후 애플리케이션을 종료

## 시도할 횟수를 묻는 문구 출력
  - 몇 번 이동할 것인지 묻는 문구를 출력

## 시도할 횟수 입력
  - 몇 번 이동할 것인지 camp.nextstep.edu.missionutils.Console의 readLine()을 사용하여 입력
  - 입력받은 String 타입의 시도할 횟수 값을 parser를 사용하여 int 형식으로 변경
  - 값이 없거나, 숫자 이외의 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션을 종료

## 자동차의 전진 기능
  - 입력 받은 시도할 횟수 동안 자동차는 전진하거나 멈춤
  - camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()를 사용하여 0에서 9사이의 random한 값을 구한 후, 그 값이 4 이상이면 전진

## 게임 종료 기능
  - checkTrialEqualsToTrialCount() 메서드로 현재 회차와 입력받은 시도 횟수를 비교
  - 입력 받은 시도한 횟수만큼 게임이 실행되었을 경우 게임을 종료


## 실행 결과 출력
  - 게임의 종료 후 실행 결과를 출력
  - 자동차의 이름과 전진한 거리를 함께 출력
  - 전진한 거리는 -(붙임표) 하나당 한번 이동한 것으로 출력
  - 입력 받은 시도할 횟수만큼 반복하여 출력

## 최종 우승자 선정
거  - 게임 종료 후, getMaxPositionCars() 메서드를 사용하여 가장 많이 전진한 자동차를 최종 우승자로 확정


## 최종 우승자 출력
  - 실행 결과를 출력한 후, 최종 우승자를 출력
  - checkWinAlone() 메서드를 사용하여 복수 우승자 여부를 판별
  - 단독 우승자일 경우, 최종 우승자를 한명만 출력
  - 복수 우승자일 경우, 최종 우승자를 ,(쉼표)를 구분자로 하여 복수 출력
