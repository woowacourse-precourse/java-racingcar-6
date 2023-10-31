package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class CarRacingGame {
    private List<Car> cars = new ArrayList<>();
    private int trial;

    void execute() {
        setCars();
        setTrialInput();

        System.out.println("실행 결과");
        proceedRacing();

        rankWinner();
    }

    private void proceedRacing() {
        for(int i=0; i<trial; i++) {
            for (Car car: cars) {
                car.decideMoveForwardOrStop();
            }

            printCurrentCarStatus();
            System.out.println();
        }
    }

    private void printCurrentCarStatus() {
        for (Car car: cars) {
            System.out.println(car);
        }
    }

    void rankWinner() {
        List<Car> winner = new ArrayList<>();

        Optional<Car> carWithMaximumDistance = cars
                .stream()
                .max(Comparator.comparing(Car::getDistance));

        winner.add(carWithMaximumDistance.get());

        int maximumDistance = carWithMaximumDistance.get().getDistance();
        String maximumDistanceCarName = carWithMaximumDistance.get().getName();

        for (Car car: cars) {
            if ((car.getDistance() == maximumDistance) && !(car.getName().equals(maximumDistanceCarName))) {
                winner.add(car);
            }
        }

        List<String> winnerName = new ArrayList<>();

        for(Car car: winner) {
            winnerName.add(car.getName());
        }

        System.out.println("최종 우승자 : " + String.join(", ", winnerName));
    }

    void setCars() throws IllegalArgumentException {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();

        hasComma(input);

        List<String> carName = List.of(input.split(","));
        isDistinct(carName);
        isElementLengthAbove5(carName);

        for (String element: carName) {
            cars.add(new Car(element));
        }

    }

    private static void hasComma(String string) {
        if(!(string.contains(","))) {
            throw new IllegalArgumentException();
        }
    }

    private static void isDistinct(List<String> stringList) throws IllegalArgumentException {
        List<String> emptyStringList = new ArrayList<>();

        for (String string: stringList) {
            if (emptyStringList.contains(string)) {
                throw new IllegalArgumentException();
            }

            emptyStringList.add(string);
        }
    }

    private static void isElementLengthAbove5(List<String> stringList) {
        for (String string: stringList) {
            if (string.length() > 5) {
                throw new IllegalArgumentException();
            }
        }
    }

    void setTrialInput() throws IllegalArgumentException {
        System.out.println("시도할 회수는 몇회인가요?");
        int input = Integer.parseInt(Console.readLine()); // 정수값으로 변환 안될 경우 NumberFormatException 발생
        System.out.println();

        if (input <= 0) {
            throw new IllegalArgumentException();
        }

        this.trial = input;
    }

}
