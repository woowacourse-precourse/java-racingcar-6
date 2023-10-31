package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class InputView {

    private InputView() {}

    private static class InputViewCreater {
        private static final InputView INSTANCE = new InputView();
    }

    public static InputView getInstance() {
        return InputViewCreater.INSTANCE;
    }

    public void startGame() {
        List<String> carNames = getCarNames();
    }

    public List<String> getCarNames() {
        String input = inputCarNames();
        List<String> carNames = parseCarNames(input);
        //TODO: validate carNames
        return carNames;
    }

    public String inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }

    public List<String> parseCarNames(String input) {
        List<String> parsedCarNames = List.of(input.split(","));
        return parsedCarNames;
    }
}
