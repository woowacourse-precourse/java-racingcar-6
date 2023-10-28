# 자동차 경주

<br><br>

## 기능 목록

* [x] 0-9사이 랜덤 값을 생성한다. - NumberGenerator#createRandomNumbers()
* [x] 자동차 객체를 생성한다. - CarGenerator#CarGenerator()
* [x] (전진일시)자동차 위치를 기록한다. - Application#racing()
* [x] 제일 멀리간 자동차들이 최종 우승자이다. - Referee#calculateCars()

<br><br>

## 기능 요구 사항

자동차의 전진 여부를 결정해야 한다. (0~9사이의 무작위 값을 구해서 4이상인지 판단)

전진 여부에 따라 자동차 위치를 기록해놔야 한다.

<br>

ex. 자동차 입력 pobi,woni,jun 에 회수 2일 때

1회) 5,2,7 값일 때 : pobi, jun 위치 ++

2회) 4,4,2 값일 때 : pobi,woni 위치 ++

최종 우승자 : pobi