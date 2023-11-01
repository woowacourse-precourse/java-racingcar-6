package racingcar.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.List;
import racingcar.domain.Car;

public class GameView {
    public static String getParticipants() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return readLine();
    }

    public static int getRacingTimes() {
        System.out.println("시도할 회수는 몇회인가요?");
        String input = readLine();

        try {
            return Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException("숫자를 입력해주세요. (입력 : " + input + ")");
        }
    }

    public static void printGames(int times, List<Car> participants) {
        System.out.println("\n실행 결과");
        for (int i = 0; i < times; i++) {
            for (Car participant : participants) {
                participant.moveOrStay();
                participant.printSticks();
            }
            System.out.println();
        }
    }

    public static void printWinners(List<String> winners) {
        System.out.print("최종 우승자 : ");
        System.out.println(String.join(", ", winners));
    }
}
