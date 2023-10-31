package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        List<String> carNames = requestCarNames();
        int rounds = requestRounds();

        Race race = new Race(carNames);

        System.out.println("\n실행 결과");
        for (int i = 0; i < rounds; i++) {
            race.raceRound();
            for (Car car : race.getCars()) {
                System.out.println(car);
            }
            System.out.println();
        }

        List<String> winners = race.getWinners();
        System.out.print("최종 우승자: ");
        System.out.println(String.join(", ", winners));
    }

    private static List<String> requestCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Arrays.stream(Console.readLine().split(",")).map(String::trim).collect(Collectors.toList());
    }

    private static int requestRounds() {
        System.out.println("시도할 회수는 몇회인가요?");
        return Integer.parseInt(Console.readLine());
    }
}
