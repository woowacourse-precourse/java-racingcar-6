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
        setCar();
        setTrialInput();

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
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
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
        System.out.println("시도할 회수는 몇회인가요?");
        int input = Integer.parseInt(Console.readLine()); // 정수값으로 변환 안될 경우 NumberFormatException 발생
        Console.close();
        System.out.println();

        if (input <= 0) {
            throw new IllegalArgumentException();
        }

        this.trial = input;
    }

}
