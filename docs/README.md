## 기능 목록

  - [ ] n대의 자동차의 이름 : 쉼표(,) 기준으로 구분하여 받을 수 있어야 한다. 
  - [ ] 이동 횟수 입력 받을 수 있어야 한다.

  - [ ] 횟수만큼 게임을 진행한다. 
  - [ ] 0~9 사이에 무작위 값을 만든다.
  - [ ] 4 이상인지 비교가 가능하다.
    
  - [ ] 4 이상은 이동을 한다.
  - [ ] 입력받은 이동횟수만큼 반복한다.
  - [ ] 매 회 자동차들의 전진 상태를 이름과 함께 출력해줘야 한다.
 
  - [ ] 이동 최댓 값을 찾아야 한다. 
  - [ ] 이동횟수가 최댓값인 자동차는 우승으로 지정한다. 
  - [ ] 게임이 종료될 때 우승자 발표, 중복 시 쉼표로 구분 

## 클래스
- [ ] Application
  - Game.play(String 자동차; int 횟수);
- [ ] NumberGenerator
  - [ ] createRandomNumber()
  - [ ] compare()
- [ ] Car
  - [ ] String name; int location;
  - [ ] move();
- [ ] Game
  - [ ] int playNum;
  - [ ] play();
- [ ] Referee
  - [ ] announceWinner();
  - [ ] reportNow();
