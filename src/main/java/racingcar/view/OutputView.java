package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Cars;

public class OutputView {

    private static final String OUTPUT_GAME_RESULT_MESSAGE = "실행 결과";

    private static final String OUTPUT_CAR_POSITION_MESSAGE_FORMAT = "%s : %s";
    private final StringBuilder outputBuilder;

    public OutputView() {
        this.outputBuilder = new StringBuilder();
    }


    public void outputCarsPosition(Cars cars) {
        for (Car car : cars.getCars()) {
            drawCarPosition(car);
        }
    }

    private void drawCarPosition(Car car) {
        System.out.printf(OUTPUT_CAR_POSITION_MESSAGE_FORMAT, car.getName(), createCarGraph(car));
    }

    private String createCarGraph(Car car) {
        initOutputBuilder();
        for (int i=0; i<car.getPosition(); i++) {
            outputBuilder.append("-");
        }
        outputBuilder.append("\n");
        return outputBuilder.toString();
    }


    private void initOutputBuilder() {
        outputBuilder.setLength(0);
    }
}
