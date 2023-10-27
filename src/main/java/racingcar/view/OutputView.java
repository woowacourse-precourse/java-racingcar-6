package racingcar.view;


import java.util.List;
import racingcar.dto.CarDto;
import racingcar.dto.CarsDto;

public class OutputView {

    private static final String RUN_RESULT = "%n실행 결과";
    private static final String CAR_POSITION_FORMAT = "%s : ";
    private static final String POSITION_SIGNAL = "-";
    private static final String NEWLINE = "%n";
    private static final String FINAL_WINNER_FORMAT = "최종 우승자 : %s%n";
    private static final String NAME_JOIN_SIGNAL = ", ";

    public void printRunResult() {
        System.out.println(RUN_RESULT);
    }

    public void printCarsResults(final CarsDto carsDto) {
        carsDto.carDtos()
                .forEach(this::printCarResult);

        System.out.printf(NEWLINE);
    }

    private void printCarResult(CarDto carDto) {
        String name = carDto.name();
        Integer position = carDto.position();

        String format = CAR_POSITION_FORMAT + POSITION_SIGNAL.repeat(position) + NEWLINE;

        System.out.printf(format, name);
    }

    public void printWinners(final List<String> winnerNames) {
        System.out.printf(FINAL_WINNER_FORMAT, String.join(NAME_JOIN_SIGNAL, winnerNames));
    }

}
