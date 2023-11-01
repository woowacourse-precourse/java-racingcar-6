1. 자동차의 이름을 입력 받는 기능
   - 쉼표 (,) 로 5개의 자동차를 구분
   - 5자 이하만 가능
     - 5자 초과 입력 시 IllegalArgumentException 후 종료


2. 1~9 사이의 값을 생성하는 기능
   - pickNumberInRange(1,9) 활용

3. 전진, 스탑을 결정하는 기능
   - 4 이상일 시 전진

4. 이동 시도 횟수 입력 받는 기능
   - 숫자만 가능
   - 숫자 이외의 값 입력 시 IllegalArgumentException 후 종료

5. 입력한 이동 시도 횟수 완료시 우승자를 가려내는 기능
   - 1명 이상의 공동 우승 가능
     - 쉼표 (,)를 이용하여 공동 우승자 구분

6. 우승자를 알려주는 기능
   - "최종 우승자 : username"

7. 경주 method

8. 경주 실행 method

9. ~~주사위 돌리는 (pickNumberInRange(1,9))~~ 

9. Name class 분리

10. Car class 분리

Application -> 애플리케이션 실행
RacingcarGame -> 게임 룰 관리
Car -> 객체 관리
Name -> 이름 관리