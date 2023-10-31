기능 요구 사항
1. 사용자로부터 자동차 이름을 부여받는다.
2. 자동차 이름은 , 를 기준으로 나눠지며, 한 참가자의 이름은 5글자를 넘어서는 안된다.
3. 게임의 시도 횟수를 입력받는다.
4. 한 회차마다 각 참가 차량은 0~9사이의 난수를 구해, 4이상이면 전진, 아니면 멈춰있는다.
5. 한 회차마다 모든 참가자의 움직인 거리가 <이름:---> 형식으로 출력되어야 한다.
6. 가장 많이 전진한 참가자가 우승자다.
7. 우승자는 복수일수 있으며, 복수일 경우 , 를 통해 구분되어야 한다.
8. 입력값이 이상할 경우 IllegalException 을 던지면서 정지해야 한다.
9. 들여쓰기 깊이가 2이하여야 한다. 즉, 이중 for문까지는 가능하나 삼중은 안된다.

-- 기능 구현 목록(3안)
1. ```
   inputCarName()
     기능: 사용자로부터 자동차 이름 입력 받기
     반환값: List<String> nameList (사용자가 입력한 값)

2.  ```
    inputCountNum()
      기능: 시도 횟수 입력 받기
      반환값: int count (사용자가 입력한 숫자)

3. ``` 
   getRandomNum()
     기능: 0 ~ 9 사이의 난수 리스트 생성
     반환값: int randomNum (0~9사이의 정수)

4. ```
   forwardOrStop(int ranNum)
    기능: 입력된 난수에 따라 전진할지 말지 결정
    매개변수: ranNum (난수)
    반환값: int result (전진하면 1, 정지면 0)

5. ```
   getDistanceList(List<String> nameList, List<Integer> distanceList)
   기능: 한 회차가 끝난 이후에 현재까지 이동거리를 구함
   매개변수: nameList, distanceList (참가자 리스트, 이전 회차까지 참가자들의 이동거리 리스트)
   반환값: List<Integer> distanceList (현제 회차까지의 각 참가자별 이동거리 리스트)

6. ```
   runAllCycle(List<String> nameList, int count)
     기능: 시도 횟수만큼 runOneCycle를 실행시킴
     매개변수: nameList, count (참가자 리스트, 시도 횟수)
     반환값: List<Integer> distanceList (최종적으로 참가자들이 움직인 거리 리스트)

7. ```
   findMax(List<Integer> distanceList)
     기능: 리스트의 내용물중 최대값을 구한다.
      매개변수: distanceList (전체 참가자의 이동거리가 담긴 리스트)
      반환값: int max (최대값)
   
8. ```
   chooseWinner(List<String> nameList, List<Integer> distanceList )
     기능: 최종 우승자 선정
     매개변수: nameList, distanceList (참가자 이름 리스트, 최종 참가자들의 이동거리 리스트)
     반환값: List<String> winnerList (최종 우승자의 이름이 담긴 리스트)
   
9. ```
   getWinnerNameString(List<String> nameList, List<Integer> distanceList)
     기능: 전체 이동거리 리스트를 토대로 최종 우승자를 구한다.
     매개변수: nameList, distanceList (참가자 이름 리스트, 최종 이동거리 리스트)
     반환값: String winnerStr (문자열 형태의 우승자들 이름)
10. ```
    runGame()
    기능: 모든 기능들을 총집합하여 게임을 구동한다.
    
11. ```
    checkInput(String name)
      기능: 이름의 길이가 5자 이하인지 확인
      매개변수: name (참가자 이름)
   11-2.
   ```
   checkInput(int count)
     기능: 사용자가 옳바른 숫자(양의 정수)를 입력했는지 확인
     매개변수: count (시도 횟수)
   ```
