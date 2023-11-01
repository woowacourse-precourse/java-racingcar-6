package racingcar;

import java.util.List;

import static racingcar.InputHandler.getInteger;
import static racingcar.InputHandler.initCars;

public class CarRacingGame {
    public void run() {
        List<Car> cars = initCars();
        int tryCount = getInteger();
        runningProcess(cars, tryCount);
    }

    protected void runningProcess(List<Car> cars, int tryCount) {
        for (int i = 0; i < tryCount; i++) {
            String tryResult = getProcessResultAsString(cars);
            System.out.println(tryResult);
        }
    }

    protected String getProcessResultAsString(List<Car> cars) {
        StringBuilder processString = new StringBuilder();
        cars.forEach(car -> {
            car.updateScore();
            processStringBuilderWriter(processString, car);
        });
        return processString.toString();
    }

    protected void processStringBuilderWriter(StringBuilder processString, Car car) {
        processString.append(car.getName()).append(" : ");
        processString.append("-".repeat(car.getScore()));
        processString.append("\n");
    }
}
