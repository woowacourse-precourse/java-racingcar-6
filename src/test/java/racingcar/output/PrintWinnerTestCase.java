package racingcar.output;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;
import racingcar.Car;

public class PrintWinnerTestCase {

    public static Stream<Arguments> getArgumentsStream() {
        List<Arguments> argumentsList = new ArrayList<>();

        List<Car> carList1 = List.of(
                createTestCar("DY1", 1),
                createTestCar("DY2", 2),
                createTestCar("DY3", 3),
                createTestCar("DY4", 4),
                createTestCar("DY5", 5)
        );
        String result1 = "최종 우승자 : DY5";
        argumentsList.add(Arguments.of(carList1, result1));

        List<Car> carList2 = List.of(
                createTestCar("DY1", 5),
                createTestCar("DY2", 4),
                createTestCar("DY3", 3),
                createTestCar("DY4", 2),
                createTestCar("DY5", 1)
        );
        String result2 = "최종 우승자 : DY1";
        argumentsList.add(Arguments.of(carList2, result2));

        List<Car> carList3 = List.of(
                createTestCar("DY1", 0),
                createTestCar("DY2", 0),
                createTestCar("DY3", 0),
                createTestCar("DY4", 0),
                createTestCar("DY5", 0)
        );
        String result3 = "최종 우승자 : DY1, DY2, DY3, DY4, DY5";
        argumentsList.add(Arguments.of(carList3, result3));

        List<Car> carList4 = List.of(
                createTestCar("DY1", 5),
                createTestCar("DY2", 5),
                createTestCar("DY3", 5),
                createTestCar("DY4", 5),
                createTestCar("DY5", 5)
        );
        String result4 = "최종 우승자 : DY1, DY2, DY3, DY4, DY5";
        argumentsList.add(Arguments.of(carList4, result4));

        List<Car> carList5 = List.of(
                createTestCar("DY1", 2),
                createTestCar("DY2", 3),
                createTestCar("DY3", 1),
                createTestCar("DY4", 4),
                createTestCar("DY5", 5)
        );
        String result5 = "최종 우승자 : DY5";
        argumentsList.add(Arguments.of(carList5, result5));

        List<Car> carList6 = List.of(
                createTestCar("DY1", 7),
                createTestCar("DY2", 4),
                createTestCar("DY3", 9),
                createTestCar("DY4", 1),
                createTestCar("DY5", 5)
        );
        String result6 = "최종 우승자 : DY3";
        argumentsList.add(Arguments.of(carList6, result6));

        List<Car> carList7 = List.of(
                createTestCar("DY1", 1),
                createTestCar("DY2", 3),
                createTestCar("DY3", 5),
                createTestCar("DY4", 7),
                createTestCar("DY5", 9)
        );
        String result7 = "최종 우승자 : DY5";
        argumentsList.add(Arguments.of(carList7, result7));

        return argumentsList.stream();
    }

    private static Car createTestCar(String name, int distance) {
        Car car = new Car(name);
        try {
            Field field = Car.class.getDeclaredField("distance");
            field.setAccessible(true);
            field.set(car, distance);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return car;
    }
}
