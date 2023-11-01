package racingcar;

import java.util.List;

public class Output {

    public String carSituation(Car car) {
        return car.name + " : " + "-".repeat(car.state);
    }

    public StringBuilder winner(List<Car> winners) {
        StringBuilder winner = new StringBuilder();
        for (Car car : winners) {
            winner.append(car.name + ", ");
        }
        Extention.modify.removeLastComma(winner);

        return winner;
    }
}
