package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    static List<String> cars;
    static List<StringBuilder> presentDistance = new ArrayList<>();

    public static void main(String[] args) {

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();

        cars = List.of(input.split(","));

        validateCarName();

        System.out.println("시도할 회수는 몇회인가요?");
        int trial = Integer.parseInt(Console.readLine());

        System.out.println("실행 결과");
        for (int i = 0; i < trial; i++) {
            for (int j = 0; j < cars.size(); j++) {
                pickRandomNumberAndPrintResult(j);
            }
            System.out.println();
        }

        List<String> winners = new ArrayList<>();
        winners = findWinners(winners);

        String result = String.join(", ", winners);
        System.out.printf("최종 우승자 : %s", result);
    }

    private static void validateCarName() {
        for (int i = 0; i < cars.size(); i++) {
            cars.set(i, cars.get(i).trim());

            if (cars.get(i).length() > 5 || cars.get(i).isEmpty())
                throw new IllegalArgumentException();

            presentDistance.add(new StringBuilder());
        }
    }

    private static void pickRandomNumberAndPrintResult(int j) {
        int randomNum = Randoms.pickNumberInRange(0, 9);
        if (randomNum >= 4)
            presentDistance.get(j).append("-");
        System.out.printf("%s : %s\n", cars.get(j), presentDistance.get(j));
    }

    private static List<String> findWinners(List<String> winners) {
        int maxDistance = 0;
        for (int i = 0; i < cars.size(); i++) {
            if (presentDistance.get(i).length() > maxDistance) {
                winners = new ArrayList<>();
                winners.add(cars.get(i));
            }
            else if (presentDistance.get(i).length() == maxDistance) {
                winners.add(cars.get(i));
            }
        }
        return winners;
    }
}
