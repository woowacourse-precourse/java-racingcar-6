package racingcar.view;

public class RacingCarView {

    private final InputReader inputReader;
    private final MessagePrinter messagePrinter;
    private final String INPUT_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";

    public RacingCarView(InputReader inputReader, MessagePrinter messagePrinter){
        this.inputReader = inputReader;
        this.messagePrinter = messagePrinter;
    }

    public String promptForNames(){
        messagePrinter.print(INPUT_CAR_NAMES);
        return inputReader.readLine();
    }
}
