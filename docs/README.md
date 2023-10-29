# 구현할 기능 목록

---
#### 자동차 이름 입력받기
````
1. 사용자로부터 자동차 이름을 입력받는다.

2. 주어진 입력을 쉼표(,) 기준으로 구분해서 저장한다.

* 이름은 5자 이하만 가능하다. 5자가 넘을 경우에 IllegalArgumentException을 발생시키고 애플리케이션을 종료한다.

* 사용자가 입력하는 값은 camp.nextstep.edu.missionutils.Console의 readLine()을 활용한다.
````

<br/>

#### 경기 진행 횟수 입력받기
````
1. 사용자로부터 경기 진행 횟수를 입력받는다.

* 숫자 이외에 다른 입력을 받게 되면 IllegalArgumentException을 발생시키고 애플리케이션을 종료한다.

* 사용자가 입력하는 값은 camp.nextstep.edu.missionutils.Console의 readLine()을 활용한다.
````
<br/>

#### 라운드 진행
````
1. 자동차들마다 0에서 9 사이에서 무작위 값을 구한 후, 무작위 값이 4 이상일 경우 해당 자동차를 1칸 전진 시킨다.

2. 모든 자동차들이 차례를 마쳤다면 현재 경기 상황을 출력한다. 

* Random 값 추출은 camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()를 활용한다.

* roundCount 만큼 1~2의 과정을 반복한다.
````
<br/>

#### 우승자 선정
````
1. 가장 많은 거리를 전진한 자동차를 뽑는다. 그러한 자동차가 여러 개이라면 모두 뽑는다.

2. 뽑은 자동차를 출력한다. 만약 여러 개일 경우 쉼표(,)를 이용하여 구분한다.
````