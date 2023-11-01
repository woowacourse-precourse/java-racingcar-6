## 구현할 기능 목록

- [ ] n대의 자동차를 쉼표를 기준으로 구분하여 입력받는다(5자 이하) - CarList#splitCarInput()
    - [ ] 5자 이하가 아닌 경우,  `IllegalArgumentException`을 발생시키고 애플리케이션을 종료한다.
- [ ] 시도할 횟수를 입력받는다. - TryInput#getTryCount()
    - [ ] 숫자가 아닌 경우,  `IllegalArgumentException`을 발생시키고 애플리케이션을 종료한다.
- [ ] 0부터 9까지 무작위 값 1개를 생성한다. - RandomNumberGenerator#generateRandomNumber()
- [ ] 컴퓨터의 수(무작위 값 1개)가 4 이상인지 확인한다. -ComputerNumberChecker#isComputerNumberGreaterThanFour()
    - [ ] 4 이상이면, 전진이다.
    - [ ] 4 이하일 경우, 멈춤이다.
    - [ ] 그 이외의 수일 경우,  `IllegalArgumentException`을 발생시키고 애플리케이션을 종료한다.
- [ ] 매 경기마다의 전진 유무 결과를 출력한다. -RaceProgressPrinter#printRaceResult
    - [ ] "자동차 이름 : "식으로 출력한다.
    - [ ] 전진 횟수만큼 -(언더바)로 표시하고, 전진한 횟수가 없으면 공백으로 표시한다.
- [ ] 최종 결과는 최종 우승자를 출력한다. -WinnersAnnouncer#announceWinners
    - [ ] 여러 명일 경우, 쉼표(,)를 이용해 구분하여 출력한다.

