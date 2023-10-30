package service;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import vo.Car;
import vo.Cars;


public class UserInput {

    public static String input(){
        return Console.readLine();
    }

    public static Cars CarNames(){
        List<String> carNames = Arrays.stream(input().split(","))
                                    .toList();

        carNames.forEach(Validation::CarNames);

        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName, 0));
        }

        return new Cars(cars);

    }

}
