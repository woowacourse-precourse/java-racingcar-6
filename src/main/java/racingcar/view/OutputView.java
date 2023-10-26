package racingcar.view;


import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;
import racingcar.domain.Cars;
import racingcar.dto.CarDto;
import racingcar.dto.CarsDto;

public class OutputView {

    private static final String RUN_RESULT = "실행 결과";
    private static final String CAR_POSITION_FORMAT = "%d : ";
    private static final String POSITION_SIGNAL = "-";
    private static final String NEWLINE = "\n";
    private static final String FINAL_WINNER_FORMAT = "최종 우승자 : %s\n";
    private static final String NAME_JOIN_SIGNAL = ", ";

    public void printRunResult() {
        System.out.println(RUN_RESULT);
    }

    public void printCarsResults(CarsDto carsDto) {
        carsDto.getCarDtos()
                .forEach(this::printCarResult);

        System.out.printf(NEWLINE);
    }

    private void printCarResult(CarDto carDto) {
        String name = carDto.getName();
        Integer position = carDto.getPosition();

        String format = CAR_POSITION_FORMAT + POSITION_SIGNAL.repeat(position) + NEWLINE;

        System.out.printf(format, name);
    }

    public void printWinners(List<String> winnerNames) {
        System.out.printf(FINAL_WINNER_FORMAT, String.join(NAME_JOIN_SIGNAL, winnerNames));
    }
}
