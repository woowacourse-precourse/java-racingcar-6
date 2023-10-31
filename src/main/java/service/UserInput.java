package service;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class UserInput {

    public static String Input(){
        return Console.readLine();
    }

    public static Cars CarNames(String names){
        List<String> carNames = Arrays.stream(names.split(","))
                                    .toList();

        Validation.CheckCarNames(carNames);

        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }

        return new Cars(cars);

    }

    public static int Times(String times){
        Validation.CheckTimes(times);
        return Integer.parseInt(times);
    }

}
