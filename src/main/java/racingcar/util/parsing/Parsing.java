package racingcar.util.parsing;

import racingcar.domain.RacingCar;
import racingcar.util.validate.InputValidate;

import java.util.ArrayList;

import static racingcar.util.validate.InputValidate.*;

public class Parsing {

    public static String[] parsingMembersByComma(String input) {

        return input.split(",");
    }

    public static ArrayList<RacingCar> parsingMembersByRacingCar(String[] input) {
        ArrayList<RacingCar> racingCars = new ArrayList<>();

        for (String username : input) {
            validateNumberLength(username);
            RacingCar racingCar = new RacingCar(username);
            racingCars.add(racingCar);
        }
        return racingCars;
    }
}
