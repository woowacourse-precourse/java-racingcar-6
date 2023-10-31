package racingcar;

import java.util.List;

public class Output {

    public void carSituation(Car car) {
        System.out.print(car.name);
        System.out.print(" : ");
        System.out.println("-".repeat(car.state));
    }

    public void winner(List<Car> winners) {
        StringBuilder winner = new StringBuilder();
        for (Car car : winners) {
            winner.append(car.name + ", ");
        }
        Extention.modify.removeLastComma(winner);

        System.out.print(winner);
    }
}
