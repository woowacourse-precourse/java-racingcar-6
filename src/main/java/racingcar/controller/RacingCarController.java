package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.view.GameView;

public class RacingCarController {
    private final GameView view;

    public RacingCarController(GameView view) {
        this.view = view;
    }

    public String getUserInputForCarNames() {
        view.printCarNameInput();
        String input = Console.readLine();
        validateCarNamesInput(input);
        return input;
    }

    public int getUserInputForRounds() {
        view.printCountInput();
        String input = Console.readLine();
        return validateAndParseRoundsInput(input);
    }

    protected void validateCarNamesInput(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("첫번째 입력이 비어있습니다.");
        }
        if ((!input.matches("^[^\\p{C}\\s]+$"))) {
            throw new IllegalArgumentException("첫번째 입력은 제어문자와 공백문자를 허용하지 않습니다.");
        }
        if (input.contains(",,") || input.endsWith(",") || input.startsWith(",")) {
            throw new IllegalArgumentException("','는 연속해서 나오거나 시작/끝에 위치할 수 없습니다.");
        }
    }

    protected int validateAndParseRoundsInput(String input) {
        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException("회차는 숫자여야 합니다.");
        }
        return Integer.parseInt(input);
    }
}
