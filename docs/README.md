# 레이싱경주
## 기능요구사항
- 입력사항 -- Input
  - [ ] N명의 자동차를 입력으로 player로 한다. -- inputPlayer
  - [ ] 이때 쉼표로 이름을 구분으로 저장한다. -- setPlayerName
  - [ ] 이름은 5자 이하로만 가능하다(Exception체크) -- validateName
  - [ ] 몇번 이동할지 입력한다 -- inputRound
  - [ ] 총 round수를 저장한다 -- setRound
  - [ ] 변수 : round(int), player(arrayList)
- 경주 -- Racing
  - [ ] 랜덤으로 0~9사이의 숫자를 뽑는다 -- selectNumber
  - [ ] 값이 4이상인지 확인후 전진하는지 확인한다 -- verifyNumber
  - [ ] 플레이어들을 출발선에 세운다(변수를 0으로 선언한다) -- setPlayerResult
  - [ ] 전진한다면 출발선에 세운 플레이어들을 한칸씩 전진시킨다 -- movePlayer
  - [ ] 변수 : recentRound(int), playerResult(arrayList<Integer>)
- 결과출력 -- Output
  - [ ] 실행결과는 매 라운드마다 유저이름 : 경기결과를 (-)의 개수로 출력한다 -- printRound
  - [ ] 모든 라운드가 종료된 이후 최종 우승자를 출력한다 -- printGaolPlayer
  - [ ] 변수 : goalPlayer(arrayList)

## 추가요구사항
- indent(인덴트, 들여쓰기) depth를 2까지만 구현해야한다. 
    - ex) while문 안에 if문이 있으면 들여쓰기는 2이다.
- 3항연산자를 쓰지않는다.
- 함수를 한가지 기능만 하도록 만든다.

### 느낀점
- 프로그래밍을 하는 시간보다 설계를 하는시간에 많은시간을 투자할수록 소모한 시간보다 훨씬 빠르게 프로그래밍이 가능해진다
- 