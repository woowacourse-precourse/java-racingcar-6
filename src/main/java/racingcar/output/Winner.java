package racingcar.output;

import java.util.List;
import java.util.StringJoiner;
import racingcar.input.Car;

public class Winner {
    private List<Car> cars;
    private int maxDistance;

    public static Winner inputWinner(List<Car> cars, int maxDistance){
        return new Winner(cars, maxDistance);
    }

    private Winner(List<Car> cars, int maxDistance){
        this.cars = cars;
        this.maxDistance = maxDistance;
    }

    public void printWinner() {
        StringJoiner winnerNames = new StringJoiner(", ");

        writeWinners(winnerNames);

        OutputCarRace.printf(MessageType.OUTPUT_WINNERS_PRINT, winnerNames.toString());
    }

    private void writeWinners(StringJoiner winnerNames) {
        for (Car car : this.cars) {
            String carName = car.getCarName();
            StringBuilder driving = car.getDriving();

            if (this.maxDistance == driving.length()) {
                winnerNames.add(carName);
            }
        }
    }
}
