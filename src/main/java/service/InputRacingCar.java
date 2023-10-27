package service;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import view.ErrorMessage;
import vo.RacingCar;
import vo.RacingCars;

public class InputRacingCar {

    public static RacingCars setInputRacingCars() {
        String input = Console.readLine();
        List<String> racingCarsNames = nameSeparator(input);
        checkLength(racingCarsNames);
        RacingCars racingCars = new RacingCars(racingCarsNames);
        return racingCars;
    }

    public static List<String> nameSeparator(String input) {
        List<String> racingCarsNames = new ArrayList<>();
        racingCarsNames = List.of(input.split(","));
        return racingCarsNames;
    }

    public static void checkLength(List<String> racingCarsNames){
        for(String name:racingCarsNames){
            if(name.length()>5){
                throw new IllegalArgumentException(ErrorMessage.INPUT_LENGTH_EXCEEDED_ERROR);
            }
        }
    }
}
