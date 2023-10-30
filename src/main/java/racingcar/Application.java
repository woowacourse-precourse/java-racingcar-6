package racingcar;

import racingcar.controller.RacingCarController;

public class Application {
    public static void main(String[] args) {
//        1. [ ] 사용자는 경주할 자동차 이름을 모두 입력한다. - domain.Input#inputCarNames()
//                - 경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분) - view.InputView#printInputCarNamesMessage()
//                - 이름은 5자 이하만 가능하다. `IllegalArgumentException`로 예외 처리 한다. - domain.Input#checkNameLength()
//        2. [ ] 사용자는 시도할 횟숫를 입력한다. - domain.Input#inputNumberOfGame()
//                - 시도할 횟수는 몇회인가요? - view.InputView#printInputNumberOfGameMessage()
//        3. [ ] 각 자동차에 0에서 9 사이에서 무작위 값을 구한다. - domain.Move#generateRandomNumber()
//        4. [ ] 해당 값이 4 이상인 차는 한 칸 전진한다. - domain.Move#moveCar()
//        5. [ ] 실행 결과를 출력한다. - view.OutputView#printResultOfMove()
//                - 차가 전진한 만큼 이름 옆에 '-'를 표시한다. - domain.Output#movingDistance()
//        6. [ ] 시도할 횟수만큼 3~5번 기능을 반복한다. - controller.RacingCarController#playGame()
//        7. [ ] 가장 많이 전진한 최종 우승자를 출력한다. - view.OuptputView#printWinners()
//                - 우승자가 여러명이면 쉼표(, )로 구분한다. - controller.RacingCarController#takeWinners()
        RacingCarController game = new RacingCarController();
        game.startGame();
    }
}
