package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CarRacing {
    private List<Car> cars;
    private int count;

    public CarRacing() {
        cars = new ArrayList<>();
    }

    public void start() {
        this.settingCar();
        this.settingCount();
        this.raceStart();
        this.raceResult();

    }

    private void settingCar() {
        Printer.settingCar();

        // refactoring
        String input = Console.readLine();
        this.cars = Parser.parse(input);
    }

    private void settingCount() {
        Printer.settingCount();

        String input = Console.readLine();
        Validator.validateCount(input);

        this.count = Integer.parseInt(input);
        System.out.println();
    }

    private void raceStart() {
        Printer.raceStart();

        for(int i = 0; i < count; i++) {
            for (Car car : this.cars) {
                car.go();
                car.location();
            }

            System.out.println();
        }

    }

    private void raceResult() {
        List<String> winner = new ArrayList<>();
        // 내림차순 정렬
        Collections.sort(cars);

        int maxDistance = 0;

        for(Car car : cars) {
            if (car.getDistance() >= maxDistance) {
                winner.add(car.getName());
                maxDistance = car.getDistance();
            }
        }

        Printer.raceResult(winner);
    }
}
