# 자동차경주

> 🔅 전체 기능 순서

- 스트링 입력 받기
- 몇회 입력받기
- 몇회 동안 time 실행
- 최종 판단 후 결과값 출력

## ❗ 기능목록

- [ ] ','로 구분하며 입력한 이름으로 자동차 인스턴스를 생성하기
    - domain#InputView#scan()
    - domain#Create#checkCarsName()
- [ ] 자동차 이름 입력은 5자 이하 인지 확인한다 + ",," 이 연속되지 않나 확인한다 + 같은 이름이 입력되지 않나 확인한다.
    - domain#Judgment#checkCarName()
- [ ] 몇 번의 이동할것인지 입력하기 + 1이상의 자연수만 입력하나 확인한다.
    - domain#InputView#scan()
    - domain#Create#howManyTimesGameStart()
- [ ] 입력된 자동차 인스턴스마다 move를 실행한다. 이때 0~9 임의의 숫자를 생성한다. 임의의 숫자가 4이상일때 전진하게 한다.
    - game#Car#move()
    - domain#Create#generateRandomNumbers()
- [ ] 전진했을때, 각 자동차의 인스턴스의 움직인 거리에 +1 처리한다.
    - game#Game#carsMove()
    - game#Car#move()
- [ ] 모든 시도횟수가 끝나고 우승자를 구한다. 이때 여러명이면 ','로 구분지어서 출력한다.
    - domain#Judgment#finalCarCheck()


- [ ] 에러는 IllegalArgumentException으로 발생시킨다.

## ❓ 패키지 목록

- [ ] domain
    - create : 랜덤 0~9 정수 생성하는 클래스
    - InputView : 문자열을 입력받는 클래스
    - Judgment : 자동차 이름 확인, 가장 많이 달린 자동차 찾기, 모든 인스턴스등의 데이터값을 판단 하는 클래스
    - OutputView : 게임 메세지 출력 및 콘솔메세지를 출력하는 클래스
- [ ] game
    - Car : 자동차 이름, 자동차가 달린거리, 자동차가 달린거리를 표시한 문자열을 가지는 자동차 객체 클래스
    - Gane : 게임 구동부를 구현한 클래스.
        - ``게임 시작 -> 게임 안내 -> 입력 받기 -> 입력값이 올바른지 판단 -> 룰에 따라 게임 진행 -> 마지막 결과값 출력``