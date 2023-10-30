package racingcar.view;

import java.util.Objects;
import racingcar.dto.CarDto;
import racingcar.dto.RacingResultDto;
import racingcar.view.printer.ConsolePrinter;
import racingcar.view.printer.Printer;

public class OutputView {

    private static final String NEW_LINE = "\n";
    private static final String LOCATION_RESULT_TITLE = String.format("%n실행 결과");
    private static final String CAR_RESULT_FORMAT = "%s : %s".concat(NEW_LINE);
    private static final String POSITION_CHARACTER = "-";

    private final Printer printer;

    OutputView(Printer printer) {
        this.printer = Objects.requireNonNull(printer);
    }

    public static OutputView createConsoleView() {
        return new OutputView(new ConsolePrinter());
    }

    public void printRacingResultTitle() {
        print(LOCATION_RESULT_TITLE);
    }

    public void printRacingResult(RacingResultDto resultDto) {
        resultDto.cars().forEach(this::printCarResult);
        print("\n");
    }

    private void printCarResult(CarDto carDto) {
        String carResult = CAR_RESULT_FORMAT.formatted(carDto.name(), makePositionFormat(carDto.position()));
        print(carResult);
    }

    private String makePositionFormat(int position) {
        return POSITION_CHARACTER.repeat(position);
    }

    private void print(String message) {
        printer.print(message);
    }
}
