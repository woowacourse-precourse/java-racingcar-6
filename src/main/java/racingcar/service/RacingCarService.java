package racingcar.service;

import racingcar.domain.RacingCar;
import racingcar.util.validate.InputValidate;

import java.util.ArrayList;
import java.util.Arrays;

import static camp.nextstep.edu.missionutils.Console.*;
import static racingcar.util.validate.InputValidate.*;

public class RacingCarService {

    public ArrayList<RacingCar> racingCars = new ArrayList<>();

    public ArrayList<RacingCar> initRacingCarMembers() {
        String input = readLine();
        String[] strings = parsingMembersByComma(input);
        return parsingMembersByRacingCar(strings);
    }

    private String[] parsingMembersByComma(String input) {
        return input.split(" ");
    }

    private ArrayList<RacingCar> parsingMembersByRacingCar(String[] input) {

        for (String player : input) {
            RacingCar racingCar = new RacingCar(player);
            racingCars.add(racingCar);
        }
        return racingCars;
    }

    public int initNumberOfAttempts() {
        int numberOfAttempts = validateInputNumberFormat(readLine());
        validateInputNumberRange(numberOfAttempts);
        return numberOfAttempts;
    }
}
