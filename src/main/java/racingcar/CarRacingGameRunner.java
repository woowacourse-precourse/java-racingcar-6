package racingcar;

import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Console;

public class CarRacingGameRunner {
    public static void runCarRacingGame() {
        System.out.println("자동차 경주 게임을 시작합니다.");

        String carNamesInput = readCarNames();
        List<Car> cars = CarInitialization.initializeCars(carNamesInput);

        int numberOfMoves = readNumberOfMoves();
        CarRacingGame game = new CarRacingGame(cars);

        try {
            game.playGame(numberOfMoves);
            displayGameResults(game);
        } catch (IllegalArgumentException e) {
            System.err.println("에러: " + e.getMessage());
        }
    }

    private static String readCarNames() {
        System.out.print("경주할 자동차 이름을 입력하세요 (이름은 쉼표(,)로 구분): ");
        return Console.readLine();
    }

    private static int readNumberOfMoves() {
        System.out.print("이동할 횟수를 입력하세요 (양수): ");
        return Integer.parseInt(Console.readLine());
    }

    public static void displayGameResults(CarRacingGame game) {
        System.out.println("\n실행 결과");
        displayMoveResults(game);
        displayWinners(game);
    }

    private static void displayMoveResults(CarRacingGame game) {
        for (int move = 1; move <= game.getTotalMoves(); move++) {
            System.out.println();
            for (Car car : game.getCars()) {
                displayCarProgress(car);
            }
        }
    }

    private static void displayCarProgress(Car car) {
        String carName = car.getName();
        int distance = car.getDistance();
        String dashes = "-".repeat(distance);
        System.out.println(carName + " : " + dashes);
    }

    private static void displayWinners(CarRacingGame game) {
        List<Car> winners = game.determineWinners();
        if (winners.size() == 1) {
            System.out.println("\n최종 우승자 : " + winners.get(0).getName());
        } else {
            String winnerNames = winners.stream()
                    .map(Car::getName)
                    .collect(Collectors.joining(", "));
            System.out.println("\n최종 우승자 : " + winnerNames);
        }
    }
}