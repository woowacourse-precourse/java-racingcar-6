package domain;

import static constants.SystemMessage.PLEASE_INPUT_ATTEMPT_NUMBER;
import static constants.SystemMessage.PLEASE_INPUT_CAR_NAME;
import static constants.SystemMessage.RACING_RESULT;
import static constants.SystemMessage.RACING_WINNER;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import validation.CheckingInput;

public class CarRacing {
    int attemptCount;
    List<Car> cars;

    public CarRacing() {
        this.attemptCount = 0;
        this.cars = new ArrayList<Car>();
    }

    void setCars(String[] carNames) {
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
    }

    void setAttemptCount(String count) {
        attemptCount = Integer.parseInt(count);
    }

    void runCarsOnce() {
        for (Car car : cars) {
            car.run();
        }
    }

    void printStepResults() {
        for (int i = 0; i < attemptCount; i++) {
            runCarsOnce();
            printCarsResult();
            System.out.print("\n");
        }
    }

    void printCarsResult() {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getStep()));
        }
    }

    String getWinner() {
        List<String> stepList = new ArrayList<>();

        int max = 0;
        for (Car car : cars) {
            int carStep = car.getStep();
            if (carStep > max) {
                max = carStep;
            }
        }

        for (Car car : cars) {
            int carStep = car.getStep();
            if (carStep == max) {
                stepList.add(car.getName());
            }
        }

        return String.join(", ", stepList);

    }

    public void execute() {
        System.out.println(PLEASE_INPUT_CAR_NAME);

        String[] carNames = (Console.readLine()).split(",");
        CheckingInput.validateCarNames(carNames);
        setCars(carNames);

        System.out.println(PLEASE_INPUT_ATTEMPT_NUMBER);

        String count = Console.readLine();
        CheckingInput.validateAttemptCount((count));
        setAttemptCount(count);

        System.out.println("\n" + RACING_RESULT);
        printStepResults();

        System.out.println(RACING_WINNER + " : " + getWinner());
    }
}
