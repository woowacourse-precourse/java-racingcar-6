package racingcar.view;


import racingcar.domain.Cars;
import racingcar.dto.CarDto;
import racingcar.dto.CarsDto;

public class OutputView {

    private static final String RUN_RESULT = "실행 결과";
    private static final String CAR_POSITION_FORMAT = "%d : ";
    private static final String POSITION_SIGNAL = "-";
    private static final String NEWLINE = "\n";

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
}
