package service;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class UserInput {

    public static String Input(){
        return Console.readLine();
    }

    public static Cars CarNames(){
        List<String> carNames = Arrays.stream(Input().split(","))
                                    .toList();

        carNames.forEach(Validation::CarNames);

        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }

        return new Cars(cars);

    }

    public static int Times(){
        String times = Input();
        Validation.Times(times);

        return Integer.parseInt(times);
    }

}
