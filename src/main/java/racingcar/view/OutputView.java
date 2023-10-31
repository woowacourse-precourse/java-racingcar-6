package racingcar.view;

import static racingcar.view.OutputMessageType.COMMAS;
import static racingcar.view.OutputMessageType.FINAL_RESULT_MESSAGE;
import static racingcar.view.OutputMessageType.PROGRESS_EMOJI;
import static racingcar.view.OutputMessageType.RESULT_MESSAGE;
import static racingcar.view.OutputMessageType.SEPARATOR;

import java.util.List;
import racingcar.model.car.Car;

public class OutputView {

    private OutputView() {}

    private static class OutputViewInstance{
        private static final OutputView INSTANCE = new OutputView();
    }

    public static OutputView getInstance() {
        return OutputViewInstance.INSTANCE;
    }

    public void printResultMessage() {
        System.out.println("\n" + RESULT_MESSAGE.getMessage());
    }

    public void printSingleRaceResult(final List<Car> cars) {
        cars.stream()
                .map(car -> car.getName()
                        + SEPARATOR.getMessage()
                        + PROGRESS_EMOJI.getMessage().repeat(car.getProgress()))
                .forEach(System.out::println);
        System.out.println();
    }

    public void printFinalRaceResult(final List<Car> cars) {
        System.out.println(FINAL_RESULT_MESSAGE.getMessage()
                + SEPARATOR.getMessage()
                + String.join(COMMAS.getMessage(), cars.stream().map(Car::getName).toList()));
    }
}
