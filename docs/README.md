<h2>| 초간단 자동차 경주 게임을 구현한다.</h2>
<br>
<h2>문제 상황</h2>
<li>주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.</li>
<li>각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.</li>
<li>자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.</li>
<li>사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.</li>
<li>전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.</li>
<li>자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.</li>
<li>우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.</li>
<li>사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.</li>



<h2>설계</h2>
<h3>| constant/Limits.java <br/></h3>
- int MAX_NAME_SIZE = 5 // 설정 가능한 이름 최대 길이<br/>
- MIN_RUNNING_SIZE = 4 // 전진을 위한 주사위 최소값<br/>
- int MINIMAM_RANDOM_NUM = 0 // 랜덤 결과 최소값<br/>
- int MAXIMUM_RANDOM_NUM = 9 // 랜덤 결과 최대값<br/>

<br/>

  <br/>
<h3> | Model<br/></h3>

1. Class Car<br/>

- name: the Car's name<br/>
- loadState: the Car's current location<br/>

<br/>
<h3> | View<br/></h3>
1. gameStart()<br>

- 자동차 이름과 플레이 횟수를 입력한다->4
- 이름 입력값에 대한 검증을 거친다-> 3
- controller에 넘길 반환값을 설정한다(index-0: 플레이 횟수, index-1,2,...:자동차 이름)<br>
<br>

2. showLoad(List<String> name, List<String> location, int theNumberOfCar)
- 자동차 별 진척 상황을 각각 시각화한다.
<br>
3. nameHandler(String[] car)<br>

- 최대 글자수를 넘기지 않았는지 확인한다.<br>
<br>
4.trialHandler(String numString)<br>

- 플레이 횟수를 정확히 기입했는지 확인한다.<br><br>


<h3> | Controller<br></h3>
1. 생성자<br>
- view 초기화<br><br>
2. gameStart<br>

- 사용할 자동차 객체 생성: View 와 연결로 받은 입력값 기반
- 게임 회전 수 설정
- View 와 연결 시 주의 사항
  - View 로부터 한번에 회전수와 자동차 이름을 받을 수 있다.
  - 이를 위해서 회전수를 String 형으로 받는다
  - 회전수는 정수형으로 변환하여 사용한다.
  - view 로부터 반환한 List의 0번째는 회전수이다.
<br><br>

3. play<br>

- 저장된 자동차 배열 크기를 기반으로 일괄적으로 실행한다
- 한번 회전을 돌 때마다 현재 자동차 위치를 보여준다.
- 결과를 정산하고 최종 우승자를 출력한다.
<br><br>

4. playDices<br>
- 1회전 동안 전체 차량의 위치를 업데이트한다.
- 5.를 불러와 현재 차량 위치를 출력한다.
<br><br>

5. showLoad<br>

- View 와 연결하여 현재 교통 상황을 출력한다
<br><br>

6. getResult<br>
- 최종 carsList를 받아 우승자를 가린다.
- bestRecord=0으로 초기화하여 이보다 클 경우 값을 덮어씌운다.
- 비교값이 bestRecord와 동일하다면 이전에 동일한 위치에 차량이 존재한다.
  - 따라서 , 를 기점으로 차량 이름을 새로 덧붙인다.
- 최종적인 우승자winner를 String 형으로 반환한다.

