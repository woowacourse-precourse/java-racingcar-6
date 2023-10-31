<h2>수행 목표</h2>


1. Model
    > 사용자의 input을 통해 어떠한 일을 수행할 것인지.<br>
    1. 각 자동차의 race를 진행한다.
   2. 어떠한 자동차가 우승했는지 우승자를 선정한다.
2. View
    > 사용자에게 어떤 input을 받고 output을 보여줄지
    1. input: 자동차의 이름, 총 race 횟수
   2. output: race 과정, race 결과
3. Controller
   > 실제 업무를 수행하는 과정

---


<h2>구체적인 과정</h2>

1. 사용자 input 처리
   > UserCar class를 생성 <br>
   > 해당 class에서 유저가 입력하는 자동차의 이름들을 평가하고 저장해주었습니다.
   - List<String> Cars : 유저가 입력한 자동차 이름 저장
   - MAX_NAME_LENGTH_RANGE : 입력 받을 수 있는 이름 최대 길이
   - validateAllCarNameLength() : 모든 차들의 이름 길이 확인 (아래 함수 호출)
   - validateCarNameLength() : 특정 차의 이름 길이 확인
   <br>
   
    
2. 해당 input을 바탕으로 race 시작
   > Race class 생성 <br>
   해당 class에서 입력받은 자동차들이 race를 시도 합니다.
   - Map<String, Integer> CarsNameAndForwardTimes : 유저의 자동차가 이동한 거리 저장
   - forwardInRace() : 유저의 자동차가 이동함 (by 랜덤 값이 4이상인 경우
   - printAllCarAndAdvance() : 모든 차들의 이동 거리를 `-`로 출력
   - printCarAndAdvance() : 특정 차의 이동 거리를 `-`로 출력
   - printDash() : 이동 거리 만큼 `-` dash 출력
     <br>


3. race 결과를 바탕으로 winner 확인
   > Winner class 생성 <br>
   해당 class에서는 결과를 바탕으로 winner들을 찾습니다.
   - List<String> winners : race 우승자들을 저장합니다.
   - findWinner() : 우승자들을 찾는 함수
   - turnaroundOrTie() : 비교를 통해 동점인지 역전인지 확인
   - printWinner() : 우승자를 출력해주는 함수
    

