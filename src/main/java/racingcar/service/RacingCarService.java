package racingcar.service;

import racingcar.domain.RacingCar;

import java.util.ArrayList;

import static racingcar.util.constant.ProductConstant.*;
import static racingcar.util.parsing.Parsing.parsingMembersByComma;
import static racingcar.util.parsing.Parsing.parsingMembersByRacingCar;
import static racingcar.util.validate.InputValidate.*;

public class RacingCarService {

    public ArrayList<RacingCar> initRacingCarMembers(String input) {
        validateNameFormat(input);
        String[] strings = parsingMembersByComma(input);
        return parsingMembersByRacingCar(strings);
    }

    public int initNumberOfAttempts(String input) {
        int numberOfAttempts = validateInputNumberFormat(input);
        System.out.println();
        validateInputNumberRange(numberOfAttempts);
        return numberOfAttempts;
    }

    public ArrayList<RacingCar> movingForward(ArrayList<RacingCar> racingCars) {
        for (RacingCar racingCar : racingCars) {
            int pickRandomNumber = racingCar.pickRandomNumber();
            if (racingCar.isMoreThanFour(pickRandomNumber)) {
                racingCar.moveForwardOneSpace();
            }
        }
        return racingCars;
    }

    public void getRaceResult(ArrayList<RacingCar> racingCars) {
        for (RacingCar racingCar : racingCars) {
            printResult(racingCar);
        }
        System.out.println();
    }

    private void printResult(RacingCar racingCar) {
        System.out.println(racingCar.getUsername() + " : " + racingCar.getCurrentLocation());
    }

    public ArrayList<String> getFinalWinner(ArrayList<RacingCar> racingCars) {
        ArrayList<String> finalWinners = new ArrayList<>();

        int maxDistance = findMaxDistance(racingCars);
        return findWinners(racingCars, finalWinners, maxDistance);
    }

    public void printWinners(ArrayList<String> finalWinners) {
        String winners = String.join(", ", finalWinners);
        if(finalWinners.size() > FINAL_WINNER_COUNT) {
            winners = validatePrintWinners(winners);
        }
        System.out.println(FINAL_WINNERS + " : " + winners);
    }

    private ArrayList<String> findWinners(ArrayList<RacingCar> racingCars, ArrayList<String> finalWinners, int maxDistance) {
        for (RacingCar racingCar : racingCars) {
            int racingCarLocation = racingCar.getCurrentLocation().length();
            if (maxDistance == racingCarLocation) {
                finalWinners.add(racingCar.getUsername());
            }
        }
        return finalWinners;
    }

    private int findMaxDistance(ArrayList<RacingCar> racingCars) {
        int maxDistance = START_NUMBER;
        for (RacingCar racingCar : racingCars) {
            int racingCarLocation = racingCar.getCurrentLocation().length();
            if (maxDistance < racingCarLocation) {
                maxDistance = racingCarLocation;
            }
        }
        return maxDistance;
    }

    public int addTime(int start) {
        start += PLUS_TIME;
        return start;
    }
}
