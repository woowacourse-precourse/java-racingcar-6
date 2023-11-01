package racingcar.view;

import racingcar.model.Car;

import java.util.List;

public class OutputView {
    public static void printScore(List<Car> cars){
        for (Car car : cars){
           printResult(car);
        }
        System.out.println();
    }

    public static void printWinner(List<String> carNames){
        System.out.print("최종 우승자 : ");
        System.out.print(carNames.get(0));
        if (carNames.size() > 1) {
            printCarNames(carNames);
        }
        System.out.println();
    }

    private static void printResult(Car car){
        System.out.print(car.getName() + " : ");
        printPosition(car);
        System.out.println();
    }

    private static void printPosition(Car car){
        for (int i = 0; i < car.getPosition(); i++){
            System.out.print("-");
        }
    }

    private static void printCarNames(List<String> carNames){
        for (int i = 1; i < carNames.size(); i++){
            System.out.print(", ");
            System.out.print(carNames.get(i));
        }
    }
}
