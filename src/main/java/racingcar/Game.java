package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Game {
    static List<String[]> cars = new ArrayList<>();
    static int gameCount;

    private final InputValidator inputValidator = new InputValidator();
    private final ResultGenerator resultGenerator = new ResultGenerator();
    private final WinnerFinder winnerFinder = new WinnerFinder();

    public void gameStart() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNames = Console.readLine();
        if (inputValidator.carNamesValidate(carNames)) {
            convertInputToList(carNames);
        }

        System.out.println("시도할 회수는 몇회인가요?");
        String temp = Console.readLine();
        if(inputValidator.gameCountValidate(temp)) {
            gameCount = Integer.parseInt(temp);
            gameInProgress();
        }
    }

    private void convertInputToList(String carNames) {
        String[] temp = carNames.split(",");
        for (String car : temp) {
            cars.add(new String[]{car, ""});
        }
    }

    public void gameInProgress() {
        System.out.println();
        System.out.println("실행 결과");
        for (int i = 0; i < gameCount; i ++) {
            resultGenerator.generateResult(cars);
        }
        gameEnd();
    }

    public void gameEnd() {
        winnerFinder.printWinner(cars);
    }
}
