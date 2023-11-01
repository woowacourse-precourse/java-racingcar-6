package racingcar;


import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Game game = new Game();
        List<Car> cars = new ArrayList<>();
        System.out.println(game.printStartGameText());
        game.inputCarName();
        List<String> Carnames = new ArrayList<>(List.of(game.getCarNames().split(",")));
        for (String carname : Carnames) {
            if (game.isCarNameLengthFive(carname)) {
                Car car = new Car();
                car.giveNameOfCar(carname);
                cars.add(car);
            } else {
                throw new IllegalArgumentException();
            }
        }
        System.out.println(game.printHowManyCounts());
        if (!game.isCountsInteger() || !game.isCountsPositive()) {
            throw new IllegalArgumentException();
        }
        System.out.println(game.printExecuteText());
        for (int i = 0; i < game.getCounts(); i++) {
            for (Car car :
                    cars) {
                car.carMoveOrStop();
                System.out.println(car.printMovingCarWithCarName());
                car.storeMaxLength();
            }
            System.out.println();
        }
        Winner winner = new Winner();
        List<String> Results = new ArrayList<>(winner.returnWinner(Car.getMaxLength(), cars));
        System.out.print("최종 우승자 : ");
        int printCounts = 0;
        for (int i = 0; i < Results.size(); i++) {
            if (printCounts != 0 && printCounts < Results.size()) {
                System.out.print(", " + Results.get(i));
            } else {
                System.out.print(Results.get(i));
            }
            printCounts++;
        }


    }
}
