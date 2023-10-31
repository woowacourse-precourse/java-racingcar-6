package racingcar.view;

import racingcar.model.Car;
import racingcar.validator.InputValidator;
import java.util.List;

public class RacingCarView {

    private final InputReader inputReader;
    private final MessagePrinter messagePrinter;
    private final String INPUT_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private final String INPUT_ROUND_NUMBERS = "시도할 회수는 몇회인가요?";
    private final String RACE_START = "\n실행 결과";
    private final String RACE_RESULT = "최종 우승자 : ";

    public RacingCarView(InputReader inputReader, MessagePrinter messagePrinter){
        this.inputReader = inputReader;
        this.messagePrinter = messagePrinter;
    }

    public String promptForNames(){
        messagePrinter.printLine(INPUT_CAR_NAMES);
        return inputReader.readLine();
    }

    public String promptForNumbers(){
        messagePrinter.printLine(INPUT_ROUND_NUMBERS);
        String inputNumber = inputReader.readLine();
        InputValidator.validateNumbers(inputNumber);
        return inputNumber;
    }

    public void printRaceStart() {
        messagePrinter.printLine(RACE_START);
    }

    public void printRoundResult(Car car){
        messagePrinter.printLine(car.getRoundResult());
    }

    public void printEmptyLine() {
        messagePrinter.printLine("");
    }

    public void printRaceWinner(List<String> winners){
        messagePrinter.print(RACE_RESULT);
        for (String carName : winners) {
            messagePrinter.print(carName);
            if (winners.indexOf(carName) < winners.size() - 1) {
                messagePrinter.print(", ");
            }
        }
    }

}
