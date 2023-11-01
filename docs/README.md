#  🚗 java-racingcar 🚗
<div align="center">

<p align="center"><img src="https://img.lovepik.com/photo/45015/9307.jpg_wh860.jpg" height="300px" width="400px"></p>


 ### 🚥 racingcar Application 🚦
  <img src="https://img.shields.io/badge/Git-F05032?style=flat-square&logo=git&logoColor=white"/>
 <img src="https://img.shields.io/badge/GitHub-181717?style=flat-square&logo=GitHub&logoColor=white"/>
  <img src="https://img.shields.io/badge/Visual Studio Code-007ACC?style=flat-square&logo=Visual Studio Code&logoColor=white"/>

</div>
<br>

## 🚗 자동차 경주 게임
이 프로젝트는 Java를 사용하여 구현된 자동차 경주 게임입니다. 이 게임은 여러 자동차가 경주를 벌이며, 특정 규칙에 따라 승자를 결정하는 간단한 콘솔 기반 게임입니다.
<br><br>
  
## 🚀 게임 규칙
1. **자동차 이름 부여**
   - 사용자는 경주에 참가할 자동차에 이름을 부여한다.
   - 각 자동차의 이름은 쉼표(,)를 기준으로 구분되며, 이름은 최대 5자까지 허용
2. **이동 횟수 설정**
   - 사용자는 경주할 자동차들이 얼마나 많은 이동을 할지 설정
   - 정수를 입력하고 잘못된 값을 입력할 경우 IllegalArgumentException을 발생 시킨 후 종료
3. **자동차 이동 조건**
   - 각 자동차는 0 에서 9 사이에 무작위 값을 생성
   - 무작위 값이 4 이상인 경우, 자동차 전진
4. **우승자 결정**
   - 게임이 종료된 후, 가장 멀리 나아간 자동차가 우승
   - 거리가 같은 경우, 동시 우승자 발생 가능
5. **잘못된 입력 처리**
   - 사용자가 부적절한 값을 입력할 경우, IllegalArgumentException을 발생 시킨 후 종료
<br/>

## ⚾ 숫자 야구 게임 기능 목록
1. **Car 클래스**
   - <b>Car</b> 클래스는 자동차를 정보를 관리
   - 주요 멤버 변수로 자동차의 이름과 현재 위치를 가짐
   - 생성자를 통해 자동차의 이름 초기화, 위치 0 으로 초기화
   - <b>move</b>메서드는 랜덤한 값에 따라 자동차를 전진시키는 역할
2. **Race 클래스**
   - <b>Race</b> 클래스는 경주를 관리하고 수행하는 역할
   - 생성자를 통해 자동차 목록 초기화
   - <b>runRace</b> 메서드는 입력받은 횟수만큼 경주를 시뮬레이션. 랜덤 값을 생성하여 자동차를 움직이고, 경주 상태 출력
   - <b>getWinners</b> 메서드는 모든 경주가 종료된 후 가장 멀리 나간 자동차를 결정하고 우승자 선정
3. **Utils 클래스**
   - <b>Utils</b> 클래스는 다양한 유틸리티 메서드를 제공
   - <b>parseInput</b> 메서드는 사용자로부터 입력받은 자동차 이름을 쉼표(,)로 구분하여 리스트로 반환
   - <b>formatWinners</b> 메서드는 우승자 목록을 받아 문자열로 형식화
4. **Application 클래스**
   - <b>Application</b> 클래스는 프로그램의 진입점
   - <b>main</b> 메서드는 프로그램 실행의 시작점, 사용자로부터 입력을 받고 경주를 수행, 우승자를 출력
<br/>

## ⚙️ 개발환경 및 언어
  - git 
  - vs code
  - java 언어
