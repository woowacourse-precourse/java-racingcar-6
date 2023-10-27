package service;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import vo.RacingCar;
import vo.RacingCars;

public class InputRacingCar {

    public static RacingCars setInputRacingCars() {
        String input = Console.readLine();
        List<String> racingCarsNames = nameSeparator(input);
        RacingCars racingCars = new RacingCars(racingCarsNames);
        return racingCars;
    }

    public static List<String> nameSeparator(String input) {
        List<String> racingCarsNames = new ArrayList<>();
        racingCarsNames = List.of(input.split(","));
        return racingCarsNames;
    }
}
