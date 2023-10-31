package racingcar.view;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Vehicle;

public class OutputView {

    private OutputView() {}

    public static void outputExecuteResult() {
        System.out.println(OutputMessages.EXECUTE_RESULT.getMessage());
    }

    public static void outputDistanceResult(List<Vehicle> registeredCars) {
        registeredCars.stream().forEach(vehicle -> {
            Car car = (Car)vehicle;
            car.printName();
            car.printDistance();
        });
        System.out.println();
    }

    public static void outputFinalWinner(List<String> winnerString) {
        System.out.println(OutputMessages.FINAL_WINNER.getMessage() + String.join(", ", winnerString));
    }
}
