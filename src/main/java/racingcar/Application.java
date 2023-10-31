package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        RacingCarGame racingCarGame = new RacingCarGame();
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputText = readLine();
        racingCarGame.setRacingCarNames(inputText);
        System.out.println("시도할 회수는 몇회인가요?");
        racingCarGame.setTryIteration(readLine());
        racingCarGame.gameStart();
        racingCarGame.printWinner();
    }
}
