기능 구현 목록(임시)
1. ```
   inputCarName()
     기능: 사용자로부터 자동차 이름 입력 받기
     반환값: List<String> nameList (사용자가 입력한 값)

2.  ```
    inputCountNum()
      기능: 시도 횟수 입력 받기
      반환값: int count (사용자가 입력한 숫자)

3. ``` 
   getRandomNumList(int count)
     기능: 시도 횟수만큼 0 ~ 9 사이의 난수 리스트 생성
     매개변수: count (시도 횟수)
     반환값: List<Integer> ranNumList (0~9사이의 정수로 이뤄진 리스트 )

4. ```
   forwardOrStop(int ranNum)
    기능: 입력된 난수에 따라 전진할지 말지 결정
    매개변수: ranNum (난수)
    반환값: int result (전진하면 1, 정지면 0)

5. ```
   sumAllForward( List<Integer> ranNumList )
     기능: 참가자의 최종 전진 횟수 산출
     매개변수: ranNumList (시도 횟수 만큼 생성된 난수 리스트)
     반환값: int goDistance (참가자의 최종 전진 횟수)

6. ```
   chooseWinner( Map<String, Integer> finalResult)
     기능: 최종 우승자 선정
     매개변수: finalResult
      (참가자 전원의 이름과 최종 이동 거리가 담긴 Map)
     반환값: List<String> winnerList (최종 우승자의 이름이 담긴 리스트)


7. ```
   checkInput(String name)
     기능: 이름의 길이가 5자 이하인지 확인
     매개변수: name (참가자 이름)
   ```
   7-1. 
   ```
   checkInput(int count)
     기능: 사용자가 옳바른 숫자(양의 정수)를 입력했는지 확인
     매개변수: count (시도 횟수)
   ```
8. ```
   playGame()
     기능: 게임을 구동
```