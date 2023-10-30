package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class Application {
    private static final int WIN_THRESHOLD = 4;
    private static final int RANDOM_MIN = 0;
    private static final int RANDOM_MAX = 9;

    public static void main(String[] args) {
        String[] cars = getInputCarName();
        int numOfAttempts = getNumOfAttempts();
        StringBuilder[] progressList = startRacing(numOfAttempts, cars);
        findWinner(cars, progressList);
    }

    private static String[] getInputCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String car = readLine();

        if (car == null) {
            throw new IllegalArgumentException("입력값이 없습니다.");
        }

        String[] cars = car.split(",");

        for (String carName : cars) {
            if (carName.length() == 0 || carName.length() > 5) {
                throw new IllegalArgumentException("잘못된 자동차 이름 입력입니다.");
            }
        }

        return cars;
    }

    @Test
    void split_메서드로_주어진_값을_구분() {
        String input = "1,2";
        String[] result = input.split(",");

        assertThat(result).contains("2", "1");
        assertThat(result).containsExactly("1", "2");
    }

    private static int getNumOfAttempts() {
        System.out.println("시도할 회수는 몇회인가요?");
        String numOfAttemptsInput = readLine();
        int numOfAttempts = Integer.parseInt(numOfAttemptsInput);

        if (numOfAttempts <= 0) {
            throw new IllegalArgumentException("잘못된 시도 회수 입력입니다.");
        }

        return numOfAttempts;
    }

    private static StringBuilder[] startRacing(int numOfAttempts, String[] cars) {
        StringBuilder[] progressList = new StringBuilder[cars.length];

        for (int i = 0; i < cars.length; i++) {
            progressList[i] = new StringBuilder();
        }

        while (numOfAttempts > 0) {
            numOfAttempts--;
            race(cars, progressList);
            displayResults(cars, progressList);
        }

        return progressList;
    }

    private static void race(String[] cars, StringBuilder[] progressList) {
        for (int i = 0; i < cars.length; i++) {
            int move = Randoms.pickNumberInRange(RANDOM_MIN, RANDOM_MAX);
            if (move >= WIN_THRESHOLD) {
                progressList[i].append("-");
            }
        }
    }

    private static void displayResults(String[] cars, StringBuilder[] progressList) {
        for (int i = 0; i < cars.length; i++) {
            System.out.println(cars[i] + " : " + progressList[i] + " ");
        }
        System.out.println();
    }

    private static void findWinner(String[] cars, StringBuilder[] progressList) {
        int maxProgress = 0;
        int[] progressLengths = new int[cars.length];
        List<String> winners = new ArrayList<>();

        for (int i = 0; i < cars.length; i++) {
            progressLengths[i] = progressList[i].length();
            maxProgress = Math.max(maxProgress, progressLengths[i]);
        }

        for (int i = 0; i < cars.length; i++) {
            if (progressLengths[i] == maxProgress) {
                winners.add(cars[i]);
            }
        }

        System.out.print("최종 우승자 : ");
        System.out.println(String.join(", ", winners));
    }
}
