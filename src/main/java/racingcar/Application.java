package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    private final static String INPUT_CARS_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private final static String INPUT_RACING_TIME_MESSAGE = "시도할 회수는 몇회인가요?";
    private final static String RESULT_MESSAGE = "\n실행 결과";
    private final static String WINNER_MESSAGE = "최종 우승자 : ";


    private static void racing(String[] cars, String[] progress) {
        for (int j = 0; j < cars.length; j++) {
            int randomNum = Randoms.pickNumberInRange(0, 9);
            if (randomNum >= 4) {
                progress[j] += "-";
            }
            System.out.println(cars[j] + " : " + progress[j]);
        }
        System.out.println();
    }

    private static List<String> findWinner(String[] distance, String[] cars, int max) {
        List<String> winners = new ArrayList<>();

        for (int i = 0; i < distance.length; i++) {
            if (distance[i].length() == max) {
                winners.add(cars[i]);
            }
        }
        return winners;
    }


    private static int findMaxDistance(String[] distance) {
        int maxDistance = 0;

        for (String d : distance) {
            if (d.length() > maxDistance) {
                maxDistance = d.length();
            }
        }
        return maxDistance;
    }

    private static List<String> gameStart(String[] cars, int time) {
        String[] progress = new String[cars.length];
        Arrays.fill(progress, "");

        for (int i = 0; i < time; i++) {
            racing(cars, progress);
        }
        int maxDistance = findMaxDistance(progress);

        return findWinner(progress, cars, maxDistance);
    }

    private static String[] setRacingCars() {
        System.out.println(INPUT_CARS_MESSAGE);
        String[] racingCars = Console.readLine().split(",");
        for (String car : racingCars) {
            if (car.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하로 작성해주세요.");
            }
        }
        return racingCars;
    }

    private static int setTime() {
        System.out.println(INPUT_RACING_TIME_MESSAGE);

        return Integer.parseInt(Console.readLine());
    }

    public static void main(String[] args) {
        String[] cars = setRacingCars();
        int time = setTime();
        System.out.println(RESULT_MESSAGE);
        List<String> winners = gameStart(cars, time);
        System.out.println(WINNER_MESSAGE + String.join(",", winners));
    }
}
