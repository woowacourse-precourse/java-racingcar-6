package view;

import domain.Car;
import domain.RaceResult;
import domain.Winners;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    public static void printGetCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public static void printGetTryCount() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public static void printRaceResultIntroduction() {
        System.out.println("실행 결과");
    }

    public static void printRaceResult(RaceResult raceResult) {
        int progress = raceResult.progress();
        String name = raceResult.name();

        System.out.print(name + " : ");
        for (int i = 0; i < progress; i++) {
            System.out.print("-");
        }
    }

    public static void printWinnerIntroduction() {
        System.out.print("최종 우승자 : ");
    }

    public static void printWinner(Winners winners) {
        int winnerCount = winners.winners().size();

        if (winnerCount == 1) {
            printSingleWinner(winners);
        }

        if (winnerCount > 1) {
            printMultipleWinner(winners);
        }
    }

    private static void printMultipleWinner(Winners winners) {
        List<String> multipleWinnerName = winners.winners().stream()
                .map(Car::getName)
                .collect(Collectors.toList());

        String result = String.join(",", multipleWinnerName);
        System.out.print(result);
    }

    private static void printSingleWinner(Winners winners) {
        String SingleWinnerName = winners.winners().get(0).getName();
        System.out.print(SingleWinnerName);
    }
}
