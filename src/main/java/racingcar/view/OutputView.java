package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Cars;

import java.util.List;

import static racingcar.util.CharacterUnits.*;
import static racingcar.view.OutputViewMessage.*;

public class OutputView {

    private final StringBuilder outputBuilder;

    public OutputView() {
        this.outputBuilder = new StringBuilder();
    }

    public void outputGameResultMessage() {
        System.out.print(ENTER.getUnit());
        System.out.print(OUTPUT_GAME_RESULT_MESSAGE.getMessage());
        System.out.print(ENTER.getUnit());
    }


    public void outputCarsPosition(final List<Car> carsList) {
        for (Car car : carsList) {
            drawCarPosition(car);
        }
        System.out.print(ENTER.getUnit());
    }

    public void outputWinner(final List<Car> winners) {
        System.out.print(createWinnerMessage(winners));
        System.out.print(ENTER.getUnit());
    }


    private String createWinnerMessage(final List<Car> winners) {
        initOutputBuilder();

        outputBuilder.append(OUTPUT_WINNER_MESSAGE.getMessage());
        for (Car winner : winners) {
            outputBuilder.append(winner.getName())
                    .append(COMMA.getUnit())
                    .append(SPACE.getUnit());
        }
        outputBuilder.replace(outputBuilder.length()-2,
                outputBuilder.length(),
                BLANK.getUnit());

        return outputBuilder.toString();
    }

    private void drawCarPosition(final Car car) {
        System.out.printf(OUTPUT_CAR_POSITION_MESSAGE_FORMAT.getMessage(),
                car.getName(),
                createCarGraph(car));
    }

    private String createCarGraph(final Car car) {
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
