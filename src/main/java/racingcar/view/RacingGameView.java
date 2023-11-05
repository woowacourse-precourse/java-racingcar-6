package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Car;

import java.util.List;

public class RacingGameView {

    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String INPUT_FOR_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_FOR_ATTEMPTS = "시도할 회수는 몇회인가요?";
    private static final String FINAL_WINNERS_MESSAGE = "최종 우승자 : ";

    public String readCarNamesFromConsole() {
        System.out.println(INPUT_FOR_CAR_NAMES);
        return Console.readLine();
    }

    public int convertAttemptsToIntFromConsoleStringInput() {
        System.out.println(INPUT_FOR_ATTEMPTS);
        String input = Console.readLine();
        return Integer.parseInt(input);
    }

    public void printRoundResults(List<Car> cars) {
        RoundResults roundResults = new RoundResults();

        for (Car car : cars) {
            String result = car.getName() + " : " + getPositionString(car);
            roundResults.addResult(result);
        }

        roundResults.printResults();
    }

    public void printWinners(List<Car> winners) {
        System.out.print(FINAL_WINNERS_MESSAGE);
        if (winners.size() == 1) {
            printSingleWinner(winners.get(0));
        } else {
            printMultipleWinners(winners);
        }
    }

    private void printSingleWinner(Car winner) {
        System.out.print(winner.getName());
    }


    private void printMultipleWinners(List<Car> winners) {
        for (int i = 0; i < winners.size(); i++) {
            System.out.print(winners.get(i).getName());
            if (i < winners.size() - 1) {
                System.out.print(", ");
            }
        }
    }

    public void printResultMessage() {
        System.out.println();
        System.out.println(RESULT_MESSAGE);
    }

    private String getPositionString(Car car) {
        return "-".repeat(Math.max(0, car.getPosition()));
    }
}
