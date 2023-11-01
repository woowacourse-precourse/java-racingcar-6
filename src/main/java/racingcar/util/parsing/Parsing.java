package racingcar.util.parsing;

import racingcar.model.RacingCar;

import java.util.ArrayList;

import static racingcar.util.validate.InputValidate.validateNumberLength;
import static racingcar.util.validate.InputValidate.validateUsernameStartsWithBlank;

public class Parsing {

    public static String[] parsingMembersByComma(String input) {

        return input.split(",");
    }

    public static ArrayList<RacingCar> parsingMembersByRacingCar(String[] input) {
        ArrayList<RacingCar> racingCars = new ArrayList<>();

        for (String username : input) {
            validateNumberLength(username);
            validateUsernameStartsWithBlank(username);
            RacingCar racingCar = new RacingCar(username);
            racingCars.add(racingCar);
        }
        return racingCars;
    }
}
