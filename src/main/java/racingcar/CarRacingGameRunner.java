package racingcar;

import java.util.List;
import java.util.Scanner;

public class CarRacingGameRunner {
    public static void runCarRacingGame() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("자동차 경주 게임을 시작합니다.");

        System.out.print("경주할 자동차 이름을 입력하세요 (이름은 쉼표(,)로 구분): ");
        String carNamesInput = scanner.nextLine();
        List<Car> cars = CarInitialization.initializeCars(carNamesInput); // 사용자 입력을 전달

        System.out.print("이동할 횟수를 입력하세요 (양수): ");
        int numberOfMoves = scanner.nextInt();

        CarRacingGame game = new CarRacingGame(cars);

        try {
            game.playGame(numberOfMoves);
            displayGameResults(game);
        } catch (IllegalArgumentException e) {
            System.err.println("에러: " + e.getMessage());
        }
    }

    public static void displayGameResults(CarRacingGame game) {
        System.out.println("\n실행 결과");
        for (int move = 1; move <= game.getTotalMoves(); move++) {
            System.out.println();
            for (Car car : game.getCars()) {
                String carName = car.getName();
                int distance = car.getDistance();
                String dashes = "-".repeat(distance);
                System.out.println(carName + " : " + dashes);
            }
        }

        List<Car> winners = game.determineWinners();
        if (winners.size() == 1) {
            System.out.println("\n최종 우승자 : " + winners.get(0).getName());
        } else {
            StringBuilder winnerNames = new StringBuilder();
            for (Car winner : winners) {
                if (winnerNames.length() > 0) {
                    winnerNames.append(", ");
                }
                winnerNames.append(winner.getName());
            }
            System.out.println("\n최종 우승자 : " + winnerNames.toString());
        }
    }
}