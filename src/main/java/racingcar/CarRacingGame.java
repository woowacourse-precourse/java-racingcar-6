package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class CarRacingGame {
    private List<Car> car = new ArrayList<>();
    private int trial;

    void execute() {
        System.out.println("실행 결과");
        for(int i=0; i<trial; i++) {
            for (Car car: car) {
                car.decideMoveForwardOrStop();
            }

            for (Car car: car) {
                System.out.println(car);
            }
            System.out.println();
        }

        rankWinner();
    }

    void rankWinner() {
        List<Car> winner = new ArrayList<>();

        Optional<Car> carWithMaximumDistance = car
                .stream()
                .max(Comparator.comparing(Car::getDistance));

        winner.add(carWithMaximumDistance.get());

        int maximumDistance = carWithMaximumDistance.get().getDistance();

        for (Car car: car) {
            if (car.getDistance() == maximumDistance) {
                winner.add(car);
            }
        }

        List<String> winnerName = new ArrayList<>();

        for(Car car: winner) {
            winnerName.add(car.getName());
        }

        System.out.println("최종 우승자 : " + String.join(", ", winnerName));
    }

    void setCar() throws IllegalArgumentException {
        String input = Console.readLine();
        Console.close();

        if(!(input.contains(","))) {
            throw new IllegalArgumentException();
        }

        List<String> carName = List.of(input.split(","));

        for (String element: carName) {
            if (element.length() > 5) {
                throw new IllegalArgumentException();
            }
        }

        for (String element: carName) {
            car.add(new Car(element));
        }

    }

    void setTrialInput() throws IllegalArgumentException {
        int input = Integer.parseInt(Console.readLine()); // 정수값으로 변환 안될 경우 NumberFormatException 발생
        Console.close();

        if (input <= 0) {
            throw new IllegalArgumentException();
        }

        this.trial = input;
    }

}
