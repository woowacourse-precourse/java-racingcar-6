package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Cars;

import java.util.List;

public class OutputView {

    private static final String OUTPUT_GAME_RESULT_MESSAGE = "실행 결과";

    private static final String OUTPUT_CAR_POSITION_MESSAGE_FORMAT = "%s : %s";

    private static final String OUTPUT_WINNER_MESSAGE = "최종 우승자 : ";
    private final StringBuilder outputBuilder;

    public OutputView() {
        this.outputBuilder = new StringBuilder();
    }

    public void outputGameResultMessage() {
        System.out.println(OUTPUT_GAME_RESULT_MESSAGE);
    }


    public void outputCarsPosition(Cars cars) {
        for (Car car : cars.getCars()) {
            drawCarPosition(car);
        }
        System.out.print("\n");
    }

    public void outputWinner(List<Car> winners) {
        System.out.print(createWinnerMessage(winners));
        System.out.print("\n");
    }



    private String createWinnerMessage(List<Car> winners) {
        initOutputBuilder();
        outputBuilder.append(OUTPUT_WINNER_MESSAGE);
        for (Car winner : winners) {
            outputBuilder.append(winner.getName()).append(", ");
        }
        outputBuilder.replace(outputBuilder.length()-2, outputBuilder.length(), "");
        return outputBuilder.toString();
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
