package racingcar;

import java.util.List;

public class OutputHandler {
    private final static int ZERO = 0;
    private final static String LINK = " : ";
    private final static String DISTANCE_UNIT = "-";
    public static void printEachResult(List<Car> carList) {
        for (Car car : carList) {
            System.out.println(car.getName() + LINK + DISTANCE_UNIT.repeat(car.getDistance()));
        }
        System.out.println();
    }

    public static void printFinalResult(List<String> nameList) {
        System.out.print("최종 우승자 : ");
        for (int index = ZERO; index < nameList.size(); index++) {
            System.out.print(nameList.get(index));
            if (index + 1 == nameList.size()) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }
}
