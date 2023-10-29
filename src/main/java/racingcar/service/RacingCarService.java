package racingcar.service;

import racingcar.domain.RacingCar;
import racingcar.util.validate.InputValidate;

import java.util.ArrayList;
import java.util.Arrays;

import static camp.nextstep.edu.missionutils.Console.*;
import static racingcar.util.validate.InputValidate.*;

public class RacingCarService {

    public ArrayList<RacingCar> initRacingCarMembers() {
        String input = readLine();
        String[] strings = parsingMembersByComma(input);
        return parsingMembersByRacingCar(strings);
    }

    private String[] parsingMembersByComma(String input) {
        return input.split(",");
    }

    private ArrayList<RacingCar> parsingMembersByRacingCar(String[] input) {
        ArrayList<RacingCar> racingCars = new ArrayList<>();

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

    public ArrayList<RacingCar> movingForward(ArrayList<RacingCar> racingCars) {
        for (RacingCar racingCar : racingCars) {
            int pickRandomNumber = racingCar.pickRandomNumber();
            if (racingCar.isMoreThanFour(pickRandomNumber)) {
                racingCar.moveForwardOneSpace("-");
            }
        }
        return racingCars;
    }

    public void getRaceResult(ArrayList<RacingCar> racingCars) {
        /**
         * pobi : -
         * woni :
         * jun : -
         */
        for (RacingCar racingCar : racingCars) {
            printResult(racingCar);
        }
        System.out.println();
    }

    private void printResult(RacingCar racingCar) {
        System.out.println(racingCar.getUsername() + " : " + racingCar.getCurrentLocation());
    }

    public int addTime(int start) {
        start += 1;
        return start;
    }
}
