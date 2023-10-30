package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Cars;

import java.util.List;

import static racingcar.util.CharacterUnits.*;

public class OutputView {

    private static final String OUTPUT_GAME_RESULT_MESSAGE = "실행 결과";

    private static final String OUTPUT_CAR_POSITION_MESSAGE_FORMAT = "%s : %s";

    private static final String OUTPUT_WINNER_MESSAGE = "최종 우승자 : ";
    private final StringBuilder outputBuilder;

    public OutputView() {
        this.outputBuilder = new StringBuilder();
    }

    public void outputGameResultMessage() {
        System.out.print(OUTPUT_GAME_RESULT_MESSAGE);
        System.out.print(ENTER.getUnit());
    }


    public void outputCarsPosition(List<Car> carsList) {
        for (Car car : carsList) {
            drawCarPosition(car);
        }
        System.out.print(ENTER.getUnit());
    }

    public void outputWinner(List<Car> winners) {
        System.out.print(createWinnerMessage(winners));
        System.out.print(ENTER.getUnit());
    }



    private String createWinnerMessage(List<Car> winners) {
        initOutputBuilder();
        outputBuilder.append(OUTPUT_WINNER_MESSAGE);
        for (Car winner : winners) {
            outputBuilder.append(winner.getName()).append(COMMA.getUnit()).append(SPACE.getUnit());
        }
        outputBuilder.replace(outputBuilder.length()-2, outputBuilder.length(), BLANK.getUnit());
        return outputBuilder.toString();
    }

    private void drawCarPosition(Car car) {
        System.out.printf(OUTPUT_CAR_POSITION_MESSAGE_FORMAT, car.getName(), createCarGraph(car));
    }

    private String createCarGraph(Car car) {
        initOutputBuilder();
        for (int i=0; i<car.getPosition(); i++) {
            outputBuilder.append(BAR.getUnit());
        }
        outputBuilder.append(ENTER.getUnit());
        return outputBuilder.toString();
    }


    private void initOutputBuilder() {
        outputBuilder.setLength(0);
    }
}
