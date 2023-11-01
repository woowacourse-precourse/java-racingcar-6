package racingcar;

import java.util.Iterator;
import java.util.List;

public class OutputHandler {

    public static void printEachResult(List<Car> carList) {
        for (Car car : carList) {
            System.out.println(car.getName() + Constants.CAR_FIELD_LINK + Constants.BAR.repeat(car.getDistance()));
        }
        System.out.println();
    }

    public static void printFinalResult(List<String> nameList) {
        System.out.print(Constants.FINAL_WINNER_MESSAGE);
        Iterator<String> iterator = nameList.iterator();

        while (iterator.hasNext()) {
            String element = iterator.next();
            System.out.print(element);
            if (iterator.hasNext()) {
                System.out.print(Constants.COMMA+Constants.BLANK);
            }
        }
        System.out.println();
    }
}
