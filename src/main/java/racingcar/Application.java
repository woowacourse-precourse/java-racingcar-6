package racingcar;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static java.util.List.of;

public class Application {

    public static List<String> askRacingCars() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String userInput = readLine();

        List<String> userList = of(userInput.split(","));

        for (String user : userList) {
            if (user.length() > 5) {
                throw new IllegalArgumentException();
            }
        }
        return userList;
    }

    public static int askTrial() {
        System.out.println("시도할 회수는 몇회인가요?");
        return Integer.parseInt(readLine());
    }

    public static void printResult(Game game) {
        System.out.print("최종 우승자 : ");
        System.out.println(String.join(", ", game.findWinners(game.result())));
    }
    public static void main(String[] args) {
        final List<String> racingCarList = askRacingCars();
        final int trial = askTrial();

        Game race = new Game(racingCarList, trial);

        System.out.println("\n실행 결과");
        race.start();

        printResult(race);
    }
}
