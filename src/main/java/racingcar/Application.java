package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        String inputName = Console.readLine();
        Car car = new Car(inputName);

        List<Car> cars = Arrays.asList(car);
        String result =  cars.stream().map(Car::getName).collect(Collectors.joining(","));
        System.out.println(result);

    }
}
