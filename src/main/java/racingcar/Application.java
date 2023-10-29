package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    private static final String INPUT_CARNAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_TRYTIME_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String WINNER_MESSAGE = "최종 우승자 : ";

    public static void main(String[] args) {
        // 자동차 이름 입력 처리
        System.out.println(INPUT_CARNAME_MESSAGE);
        String inputNames = Console.readLine();
        List<String> carNames = Arrays.asList(inputNames.split(","));

        if (!isNotEmpty(carNames)) {
            throw new IllegalArgumentException();
        }

        if (!isUnderSixDigit(carNames)) {
            throw new IllegalArgumentException();
        }

        // 경주 회수 입력 처리
        System.out.println(INPUT_TRYTIME_MESSAGE);
        String inputTime = Console.readLine();
        if (!isNumberInteger(inputTime)) {
            throw new IllegalArgumentException();
        }

        int tryTime = Integer.parseInt(inputTime);
        if (!isNumberOverZero(tryTime)) {
            throw new IllegalArgumentException();
        }

        // 자동차 목록 생성
        Car[] cars = new Car[carNames.size()];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(carNames.get(i));
        }

        // 실행 결과 처리
        System.out.println();
        System.out.println(RESULT_MESSAGE);

        for (int i = 0; i < tryTime; i++) {
            for (int j = 0; j < cars.length; j++) {
                cars[j].forward(setForwardStep());
                cars[j].printForwardState();
            }
            System.out.println();

        }

        // 우승 자동차 판정 처리
        List<String> winners = findWinner(cars);

        // 우승자 출력 처리
        System.out.print(WINNER_MESSAGE);
        printWinner(winners);
    }

    public static boolean isNumberInteger(String input) {
        String regularExpression = "^[0-9]+$";
        return input.matches(regularExpression);

    }

    public static boolean isUnderSixDigit(List<String> inputs) {
        for (String input : inputs) {
            if (input.length() > 5) {
                return false;
            }
        }
        return true;
    }

    public static boolean isNotEmpty(List<String> inputs) {
        for (String input : inputs) {
            if (input.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    public static boolean isNumberOverZero(int input) {
        return input > 0;
    }

    public static int setForwardStep() {
        if(Randoms.pickNumberInRange(0,9) >= 4) {
            return 1;
        }
        return 0;
    }

    public static List<String> findWinner(Car[] cars) {
        List<String> winners = new ArrayList<>();

        Arrays.sort(cars, (c1, c2) -> {
            return Integer.compare(c1.getForwardCount(), c2.getForwardCount());
        });

        int max = cars[cars.length-1].getForwardCount();

        for (int i = 0; i < cars.length; i++) {
            if (cars[i].getForwardCount() == max) {
                winners.add(cars[i].getName());
            }
        }
        return winners;
    }

    public static void printWinner(List<String> winners) {
        String result = String.join(", ", winners);
        System.out.println(result);
    }
}
