package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class GameManager {
    private static final String GAME_START_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String TRY_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";
    public static int tryCount;
    public static List<String> racingCarNames;
    public static List<RacingCar> racingCars;

    public GameManager() {

    }

    private static void printGameStartMessage() {
        System.out.println(GAME_START_MESSAGE);
    }

    private static void printGameTryCountMessage() {
        System.out.println(TRY_COUNT_MESSAGE);
    }

    private static String readUserInput() {
        return Console.readLine();
    }


    public static boolean validateRacingCarName(String racingCarName) {
        if (racingCarName == null || racingCarName.isEmpty()) {
            throw new IllegalArgumentException("racingcar 이름이 null이거나 비어있습니다.");
        }
        if (racingCarName.length() > 5) {
            throw new IllegalArgumentException("racingcar 이름이 5자를 초과합니다.");
        }

        return true;
    }


    public static boolean validateUserInput(String userInput) {
        if (userInput == null || userInput.isEmpty()) {
            throw new IllegalArgumentException("유저 입력값이 null이거나 비어있습니다.");
        }
        racingCarNames = List.of(userInput.split(","));
        // if there is the same racingcar name, throw exception
        if (racingCarNames.stream().distinct().count() != racingCarNames.size()) {
            throw new IllegalArgumentException("중복된 racingcar 이름이 있습니다.");
        }

        for (String racingcarName : racingCarNames) {
            validateRacingCarName(racingcarName);
        }

        return true;
    }

    public static boolean validateUserInputForTryCount(String userInput) {
        if (userInput == null || userInput.isEmpty()) {
            throw new IllegalArgumentException("유저 입력값이 null이거나 비어있습니다.");
        }
        try {
            tryCount = Integer.parseInt(userInput);
            if (tryCount < 1) {
                throw new IllegalArgumentException("유저 입력값이 1보다 작습니다.");
            }
            return true;

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("유저 입력값이 정수가 아닙니다.");
        }

    }

    public static void printRacingCarsPosition() {
        for (RacingCar racingCar : racingCars) {
            System.out.print(racingCar.name + " : ");
            for (int i = 0; i < racingCar.position; i++) {
                System.out.print("-");
            }
            System.out.println("");
        }
    }


    public static List<RacingCar> instantiateRacingCars() {
        racingCars = new ArrayList<RacingCar>();
        for (String racingCarName : racingCarNames) {
            racingCars.add(new RacingCar(racingCarName));
        }
        return racingCars;
    }

    public static void makeRacingCarsMove() {
        for (int i = 0; i < tryCount; i++) {
            for (RacingCar racingCar : racingCars) {
                racingCar.tryMove();
            }
            printRacingCarsPosition();
            System.out.println();
        }
    }

    public static List<String> judgeWinners() {
        List<String> winners = new ArrayList<String>();
        int maxPosition = 0;
        for (RacingCar racingCar : racingCars) {
            if (racingCar.position > maxPosition) {
                maxPosition = racingCar.position;
            }
        }
        for (RacingCar racingCar : racingCars) {
            if (racingCar.position == maxPosition) {
                winners.add(racingCar.name);
            }
        }
        return winners;
    }

    public static void printWinners(List<String> winners) {
        if (winners.size() == 1) {
            System.out.print("최종 우승자 : ");
            System.out.print(winners.get(0));
            System.out.println();
            return;
        }

        System.out.print("최종 우승자 : ");
        for (int i = 0; i < winners.size(); i++) {
            System.out.print(winners.get(i));
            if (i != winners.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }

    public static void runGame() {

        printGameStartMessage();
        String userInput = readUserInput();
        validateUserInput(userInput);
        printGameTryCountMessage();
        userInput = readUserInput();
        validateUserInputForTryCount(userInput);
        instantiateRacingCars();
        makeRacingCarsMove();
        printWinners(judgeWinners());
    }
}
