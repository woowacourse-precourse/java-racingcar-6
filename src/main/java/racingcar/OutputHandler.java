package racingcar;

import java.util.List;

public class OutputHandler {

    public static void printEachResult(List<Car> carList) {
        for (Car car : carList) {
            System.out.println(car.getName() + Constants.CAR_FIELD_LINK + Constants.DISTANCE_UNIT_STRING.repeat(car.getDistance()));
        }
        System.out.println();
    }

    public static void printFinalResult(List<String> nameList) {
        System.out.print(Constants.FINAL_WINNER_MESSAGE);
        for (int index = 0; index < nameList.size(); index++) {
            System.out.print(nameList.get(index));
            if (index + 1 < nameList.size()) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }
}
