package racingcar;

import java.util.List;
import java.util.Scanner;

public class CarRacingGameRunner {
    public static void runCarRacingGame() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("자동차 경주 게임을 시작합니다.");

        List<Car> cars = CarInitialization.initializeCars(); // 자동차 초기화를 위해 CarInitialization 클래스 사용

        System.out.print("이동할 횟수를 입력하세요 (양수): ");
        int numberOfMoves = scanner.nextInt();

        CarRacingGame game = new CarRacingGame(cars);

        try {
            game.playGame(numberOfMoves);
            List<Car> winners = game.determineWinners();
            displayGameResults(winners);
        } catch (IllegalArgumentException e) {
            System.err.println("에러: " + e.getMessage());
        }
    }
    public static void displayGameResults(List<Car> winners) {
        if (winners.size() == 1) {
            System.out.println("우승자는 " + winners.get(0).getName() + " 차량입니다.");
        } else {
            StringBuilder winnerNames = new StringBuilder();
            for (Car winner : winners) {
                if (winnerNames.length() > 0) {
                    winnerNames.append(", ");
                }
                winnerNames.append(winner.getName());
            }
            System.out.println("공동 우승자는 " + winnerNames.toString() + " 차량입니다.");
        }
    }
    // 이전과 동일한 displayGameResults 메소드 유지
}