package racingcar;

import racingcar.model.Racing;
import racingcar.view.RacingView;

import java.util.Arrays;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        RacingView view = new RacingView();

        view.printCarListInputMessage();
        String carListInput = view.getCarListInput();
        List<String> carNames = Arrays.asList(carListInput.split(","));

        view.printAttemptInputMessage();
        String attemptInput = view.getAttemptInput();
        validateAttemptInput(attemptInput);
        int attempt = Integer.parseInt(attemptInput);

        Racing model = new Racing(carNames, attempt);

        view.printRacingStartMessage();
        while (!model.isEnd()) {
            model.race();
            view.printProgress(model.getStatus());
        }

        view.printWinners(model.findWinners());
    }

    public static void validateAttemptInput(String input) {
        validatePositiveNumber(input);
    }

    public static void validatePositiveNumber(String input) {
        validateNumber(input);
        if (Integer.parseInt(input) <= 0) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
