package racingcar.service;

import racingcar.domain.RacingCar;

import java.util.ArrayList;
import java.util.List;

import static racingcar.util.constant.ProductConstant.*;
import static racingcar.util.parsing.Parsing.parsingMembersByComma;
import static racingcar.util.parsing.Parsing.parsingMembersByRacingCar;
import static racingcar.util.validate.InputValidate.*;

public class RacingCarService {

    public List<RacingCar> initRacingCarMembers(String input) {
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

    public List<RacingCar> movingForward(List<RacingCar> racingCars) {
        for (RacingCar racingCar : racingCars) {
            int pickRandomNumber = racingCar.pickRandomNumber();
            if (racingCar.isMoreThanFour(pickRandomNumber)) {
                racingCar.moveForwardOneSpace();
            }
        }
        return racingCars;
    }

    public void getRaceResult(List<RacingCar> racingCars) {
        for (RacingCar racingCar : racingCars) {
            printResult(racingCar);
        }
        System.out.println();
    }

    private void printResult(RacingCar racingCar) {
        System.out.println(racingCar.getUsername() + " : " + racingCar.getCurrentLocation());
    }

    public List<String> getFinalWinner(List<RacingCar> racingCars) {
        List<String> finalWinners = new ArrayList<>();

        int maxDistance = findMaxDistance(racingCars);
        return findWinners(racingCars, finalWinners, maxDistance);
    }

    public void printWinners(List<String> finalWinners) {
        String winners = String.join(", ", finalWinners);
        if(finalWinners.size() > FINAL_WINNER_COUNT) {
            winners = validatePrintWinners(winners);
        }
        System.out.println(FINAL_WINNERS + " : " + winners);
    }

    public List<String> findWinners(List<RacingCar> racingCars, List<String> finalWinners, int maxDistance) {
        for (RacingCar racingCar : racingCars) {
            int racingCarLocation = racingCar.getCurrentLocation().length();
            if (maxDistance == racingCarLocation) {
                finalWinners.add(racingCar.getUsername());
            }
        }
        return finalWinners;
    }

    public int findMaxDistance(List<RacingCar> racingCars) {
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
