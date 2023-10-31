package racingcar.View;

import racingcar.Constants.Prompts;
import racingcar.Car.Car;
import java.util.List;

public class OutputView {

    private static boolean hasPrintedHeader = false;
    public static void printCars(List<Car> cars) {
        if(!hasPrintedHeader){
            System.out.println(Prompts.RACE_RESULT_HEADER);
            hasPrintedHeader= true;
        }
        for (Car car : cars) {
            printCar(car);
        }
        System.out.println();
    }

    private static String generateDashes(int position) {
        return Prompts.DASH.repeat(position);
    }
    private static void printCar(Car car) {
        System.out.println(car.getName() + " : " + generateDashes(car.getCurrentPosition()));
    }

    public static void printWinners(List<Car> winners) {
        System.out.print(Prompts.WINNER_ANNOUNCEMENT);
        for (int i = 0; i < winners.size(); i++) {
            System.out.print(winners.get(i).getName());
            if (i != winners.size() - 1) {
                System.out.print(Prompts.NAME_SEPARATOR);
            }
        }
    }
}
