package racingcar.view;

import racingcar.validator.InputValidator;

public class RacingCarView {

    private final InputReader inputReader;
    private final MessagePrinter messagePrinter;
    private final String INPUT_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private final String INPUT_ROUND_NUMBERS = "시도할 회수는 몇회인가요?";

    public RacingCarView(InputReader inputReader, MessagePrinter messagePrinter){
        this.inputReader = inputReader;
        this.messagePrinter = messagePrinter;
    }

    public String promptForNames(){
        messagePrinter.print(INPUT_CAR_NAMES);
        return inputReader.readLine();
    }

    public String promptForNumbers(){
        messagePrinter.print(INPUT_ROUND_NUMBERS);
        String inputNumber = inputReader.readLine();
        InputValidator.validateNumbers(inputNumber);
        return inputNumber;
    }
}
