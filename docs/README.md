## 기능 구현
### 1. 화면 입출력
- initGameView() : 게임 시작 문구 출력 및 자동차 이름 입력 []
   ``` 
  - 출력 : "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"
  - 입력 : "pobi,woni,jun" 
   ```  

- getCycleView() : 경주 시도 횟수 문구 입출력 []
   ```
  - 출력 : "시도할 횟수는 몇회인가요?"
  - 입력 : "5"
   ```
- resultView() : 각 시도 횟수에 대한 결과 출력 []
   ```
  - 출력
        "pobi : --"
        "woni : ----"
        "jun : ---"
  
  ```
- winnerView() : 우승자 결과 출력 []
   ```
  - 출력 : "최종 우승자 : pobi, jun"
  ```


### 2. 자동차 클래스
- Car : 자동차에 대한 정보를 저장하는 클래스 []
   ```
   // 멤버 변수
   String name               // 자동차 이름
   Integer position          //현재 자동차 위치

   // 멤버 함수
   String getName()          // name 반환
   Integer getPosition()     // position 반환
   void forword()            // 한 칸 전 진 함수
  ```



### 3. 기능
- inputToCarList : 입력 문자열을 Car 객체 리스트로 변환 함수 []
- isForward : 각 상황에서 Car들의 전진 여부 수행 함후 []
- findWinner : 우승자를 찾는 함수 []

### 4. 예외 처리
- 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능 []
- 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료 []
