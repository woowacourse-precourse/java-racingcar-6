## 기능 목록

- [] 사용자로부터 자동차의 이름을 입력받는다. Application#Main()
    - [] 자동차 이름은 쉼표(,)를 기준으로 구분한다. Application#Main()
    - [] 자동차의 이름은 5자 이하로 한다. Application#moreThanFiveLetter()
- [] 사용자로부터 몇 번의 이동을 할 것인지 입력 받는다. Application#Main()
- [] 자동차를 전진시킨다. Car#move()
    - [] 0~9사이의 무작위 값을 구한다. Car#move()
    - [] 무작위 값이 4 이상일 경우 전진한다. Car#move()
- [] 우승자를 출력한다. GameService#printWinners()
  - [] 우승자는 한 명 이상일 수 있다. GameService#determineWinner()
  - [] 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다. GameService#determineWinner()