
## 기능 요구사항


1. 자동차에 이름을 부여 
   - players => player1, player2, player3
   - Console 입력
   - 예외처리: 플레이어 이름은 5자 이하만 가능하다.
   - "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"
   

2. 이동횟수 (반복 횟수)
   - round
   - Console 입력
   - 예외처리: 1이상의 수
   - "시도할 회수는 몇회인가요?"
   
3. 이동규칙 
   - moveRacingCar(playerName, randomNumber)
   - 0~9 랜덤 값을 추출 (pickNumbers, random 함수)
   - 4이상인 경우에만 이동한다.
   - 4이상인 경우 현재위치(playerLocation)에서 전진하고
     playerName을 반환한다.
   - 예외처리: 0~9사이 숫자만 유효하다. 
   - "실행 결과"
        ...

4. 우승
   - winPlayers
   - 모든 이동이 끝나고 playerLoaction이 높은 player가 우승
   - "최종 우승자 : " + player1, player2