package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Game {
    private static final String START_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final InputValidator inputValidator = new InputValidator();
    private static final String TRIAL_NUMBER_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String RESULT_TITLE_MESSAGE = "실행 결과";
    private static final String WINNER_SEPARATOR = ",";

    private final GameManager gameManager = new GameManager();

    private int trialNumber;

    public void start() {
        printMessage(START_MESSAGE);
        setCarNames();

        printMessage(TRIAL_NUMBER_MESSAGE);
        setTrialNumber();

        printNewLine();
        printMessage(RESULT_TITLE_MESSAGE);
        progress();

        printMessage(gameManager.makeWinnerResult());
    }

    private void progress() {
        while (trialNumber-- > 0) {
            gameManager.moveCars();
            printMessage(gameManager.makeResult());
        }
    }

    private void printMessage(String message) {
        System.out.println(message);
    }

    private void printNewLine() {
        printMessage("");
    }

    private void setCarNames() {
        String input = Console.readLine();
        String[] carNames = input.split(WINNER_SEPARATOR);

        for (String carName : carNames) {
            String trimmedCarName = carName.trim();

            inputValidator.validCarNameLength(trimmedCarName);
            gameManager.addCar(trimmedCarName);
        }
    }

    private void setTrialNumber() {
        String input = Console.readLine();
        inputValidator.validTrialNumber(input);
        trialNumber = Integer.parseInt(input);
    }
}
