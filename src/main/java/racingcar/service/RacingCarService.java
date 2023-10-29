package racingcar.service;

import racingcar.domain.RacingCar;
import racingcar.util.parsing.Parsing;

import java.util.ArrayList;

import static camp.nextstep.edu.missionutils.Console.*;
import static racingcar.util.parsing.Parsing.*;
import static racingcar.util.validate.InputValidate.*;

public class RacingCarService {

    public ArrayList<RacingCar> initRacingCarMembers() {
        String input = readLine();
        validateNameFormat(input);
        String[] strings = parsingMembersByComma(input);
        return parsingMembersByRacingCar(strings);
    }

    public int initNumberOfAttempts() {
        int numberOfAttempts = validateInputNumberFormat(readLine());
        System.out.println();
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
        for (RacingCar racingCar : racingCars) {
            printResult(racingCar);
        }
        System.out.println();
    }

    private void printResult(RacingCar racingCar) {
        System.out.println(racingCar.getUsername() + " : " + racingCar.getCurrentLocation());
    }

    public void getFinalWinner(ArrayList<RacingCar> racingCars) {
        ArrayList<String> finalWinners = new ArrayList<>();

        int maxDistance = findMaxDistance(racingCars);
        findWinners(racingCars, finalWinners, maxDistance);

        printWinners(finalWinners);
    }

    private void printWinners(ArrayList<String> finalWinners) {
        String winners = String.join(", ", finalWinners);
        System.out.println("최종 우승자 : " + winners);
    }

    private void findWinners(ArrayList<RacingCar> racingCars, ArrayList<String> finalWinners, int maxDistance) {
        for (RacingCar racingCar : racingCars) {
            int racingCarLocation = racingCar.getCurrentLocation().length();
            if (maxDistance == racingCarLocation) {
                finalWinners.add(racingCar.getUsername());
            }
        }
    }

    private int findMaxDistance(ArrayList<RacingCar> racingCars) {
        int maxDistance = 0;
        for (RacingCar racingCar : racingCars) {
            int racingCarLocation = racingCar.getCurrentLocation().length();
            if (maxDistance < racingCarLocation) {
                maxDistance = racingCarLocation;
            }
        }
        return maxDistance;
    }

    public int addTime(int start) {
        start += 1;
        return start;
    }
}
