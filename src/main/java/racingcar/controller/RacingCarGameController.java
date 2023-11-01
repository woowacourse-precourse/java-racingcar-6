package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import racingcar.domain.RacingCar;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarGameController {
    /** Main properties */
    private static List<String> racingCarNames;
    private static Integer countGame;
    private static final List<RacingCar> racingCars = new ArrayList<>();
    private static final List<String> winnerList = new ArrayList<>();

    /** Contant properties */
    private static final Integer RACING_CAR_NAME_LENGTH = 5;
    private static final Integer START_INCLUSIVE = 0;
    private static final Integer END_INCLUSIVE = 9;
    private static final String ERR_RACING_CAR_NAME_LENGTH = "길이 조건이 맞지 않습니다!";
    private static final String ERR_CONUT_OF_GAME_IS_NUMBER = "시도할 횟수 입력 시 숫자를 입력해주세요!";
    private static final String WINNERS_NAME_SEPARATOR = ", ";


    private RacingCarGameController() {
    }

    private static boolean isCollectLength(String name) {
        return name.length() <= RACING_CAR_NAME_LENGTH;
    }

    private static void validateRacingCarNames() {
        for (String str : racingCarNames) {
            if (!isCollectLength(str)) {
                throw new IllegalArgumentException(ERR_RACING_CAR_NAME_LENGTH);
            }
        }
    }

    public static void parseRacingCarNames(String str) {
        final String[] namesArray = str.split(",");

        racingCarNames = Arrays.asList(namesArray);
        validateRacingCarNames();
    }

    public static void parseCountGame(String str) {
        try {
            countGame = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERR_CONUT_OF_GAME_IS_NUMBER);
        }
    }

    public static void generateRacingCars() {
        for (String name : racingCarNames) {
            RacingCar car = new RacingCar(name);
            racingCars.add(car);
        }
    }

    private static void raceRoad() {
        for (RacingCar car : racingCars) {
            Integer randomNumber = Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);

            car.advance(randomNumber);
            OutputView.printRacingResult(car.getRacingResult());
        }
        System.out.println();
    }

    private static void startRace() {
        OutputView.printMsgResult();
        for (int i = 0; i < countGame; i++) {
            raceRoad();
        }
    }

    private static Integer getWinnerCountAdvance() {
        Integer max = 0;

        for (RacingCar car : racingCars) {
            if (car.getCountAdvance() > max) {
                max = car.getCountAdvance();
            }
        }
        return max;
    }

    private static void saveWinnerName(Integer maxCount) {
        for (RacingCar car : racingCars) {
            if (car.getCountAdvance().equals(maxCount)) {
                winnerList.add(car.getNAME());
            }
        }
    }

    private static String getWinnersNameString() {
        StringBuilder winnersName = new StringBuilder();
        int i = 1;

        for (String name : winnerList) {
            winnersName.append(name);
            if (winnerList.size() != i) {
                winnersName.append(WINNERS_NAME_SEPARATOR);
            }
            i++;
        }
        return winnersName.toString();
    }

    private static String processWinnerString() {
        if (winnerList.size() == 1) {
            return winnerList.get(0);
        }
        return getWinnersNameString();
    }

    private static void endRace() {
        Integer maxCount = getWinnerCountAdvance();

        saveWinnerName(maxCount);

        OutputView.printWinner(processWinnerString());
    }

    public static void startGame() {
        String racingCarNamesString = InputView.enterRacingCarName();
        parseRacingCarNames(racingCarNamesString);

        String countGameString = InputView.enterCountGame();
        parseCountGame(countGameString);

        generateRacingCars();

        startRace();

        endRace();
    }
}
