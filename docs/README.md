# 자동차 경주 게임

이 프로젝트는 사용자로부터 자동차 이름과 이동 횟수를 입력받아 경주 게임을 진행하고, 최종 우승자를 알려주는 간단한 자바 프로그램입니다.

## 기능

1. 사용자로부터 n 대의 자동차 이름을 입력받음

   - 경주할 자동차 이름을 입력하세요. (이름은 쉼표(,)로 구분) 
   - 자동차의 이름은 5자 이하여야 함 

2. 사용자가 몇 번 이동할 것인지 입력받음

   - 전진하는 조건은 0에서 9 사이에서 랜덤값을 구한 후 4 이상일 경우 전진 
   - 입력값에 따라 자동차가 이동한 결과를 출력 (반복) 

3. 자동차의 이동진행 상황을 출력

4. 제일 멀리 움직인 자동차를 우승자로 출력

## 함수 및 설명

<table>
  <tr>
    <th colspan="2">View</th>
  </tr>
  <tr>
    <td>inputCarName()</td>
    <td>차 이름을 입력으로 받음</td>
  </tr>
  <tr>
    <td>inputMoveCount()</td>
    <td>움직일 횟수를 입력으로 받음</td>
  </tr>
  <tr>
    <td>printResult(CarGroupDto)</td>
    <td>차의 움직임 결과를 출력</td>
  </tr>
  <tr>
    <td>printWinner(WinnerDto)</td>
    <td>최종 우승자를 출력</td>
  </tr>

  <tr>
    <th colspan="2">Validation</th>
  </tr>
  <tr>
    <td>validateCarName(String)</td>
    <td>차 이름이 5자 이하인지 확인</td>
  </tr>
  <tr>
    <td>validateNumber(String)</td>
    <td>입력 값이 0보다 큰 숫자인지 확인</td>
  </tr>

  <tr>
    <th colspan="2">Controller</th>
  </tr>
  <tr>
    <td>gameTask()</td>
    <td>게임의 주요 작업을 수행. 사용자는 차 이름과 라운드 수를 입력하고, 그 후 라운드를 실행하고 최종 우승자를 출력</td>
  </tr>
  <tr>
    <td>runRounds(CarGroup carGroup, int roundNumber)</td>
    <td>라운드를 실행. 입력된 라운드 수만큼 차 그룹을 이동시키고 각 라운드의 결과를 출력</td>
  </tr>
  
  <tr>
    <th colspan="2">Domain</th>
  </tr>
  <tr>
    <td>Car</td>
    <td>차의 이름과 위치를 포함하는 클래스</td>
  </tr>
  <tr>
    <td>CarGroup</td>
    <td>여러 대의 차를 포함하는 클래스</td>
  </tr>

  <tr>
    <th colspan="2">DTO</th>
  </tr>
  <tr>
    <td>InputCarDto</td>
    <td>사용자가 입력한 차 이름과 구분자를 포함하는 클래스</td>
  </tr>
  <tr>
    <td>CarGroupDto</td>
    <td>차 그룹의 이름과 각 차의 위치를 포함하는 클래스</td>
  </tr>
  <tr>
    <td>WinnerDto</td>
    <td>우승한 차의 이름을 포함하는 클래스</td>
  </tr>

  <tr>
    <th colspan="2">Service</th>
  </tr>
  <tr>
    <td>createCarGroup(String carNames, String delimiter)</td>
    <td>차 이름과 구분자를 통해 CarGroup 객체를 만들어 반환하는 클래스</td>
  </tr>
  <tr>
    <td>getRoundNumber(String round)</td>
    <td>사용자가 입력한 라운드 수를 정수로 하는 클래스</td>
  </tr>
  <tr>
    <td>moveCarGroup(CarGroup carGroup)</td>
    <td>차 그룹을 무작위로 앞으로 이동하거나 정지시키는 클래스</td>
  </tr>
  <tr>
    <td>getWinners(CarGroup carGroup)</td>
    <td>현재 차 그룹에서 우승한 차를 결정하고 그 차들의 목록을 반환하는 클래스</td>
  </tr>
</table>


