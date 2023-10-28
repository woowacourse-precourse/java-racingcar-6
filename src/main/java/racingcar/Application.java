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

    private static List<String> racingGame(String[] cars, int time) {
        List<String> winner = new ArrayList<>();
        String[] progressArray = new String[cars.length];
        Arrays.fill(progressArray, "");
        int progressMax = 0;

        for (int i=0; i<time; i++) {
            for (int j=0; j<cars.length; j++) {
                int randomNum = Randoms.pickNumberInRange(0, 9);
                if (randomNum >= 4) {
                    progressArray[j] += "-";
                }

                System.out.println(cars[j]+" : "+progressArray[j]);
                if (progressArray[j].length() > progressMax) {
                    progressMax = progressArray[j].length();
                }
            }
            System.out.println();
        }

        for (int i=0; i<progressArray.length; i++) {
            if (progressArray[i].length() == progressMax) {
                winner.add(cars[i]);
            }
        }

        return winner;
    }


    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println(INPUT_CARS_MESSAGE);
        String[] cars = Console.readLine().split(",");
        for (String car:cars) {
            if (car.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하로 작성해주세요.");
            }
        }
        System.out.println(INPUT_RACING_TIME_MESSAGE);
        int time = Integer.parseInt(Console.readLine());

        System.out.println(RESULT_MESSAGE);
        List<String> winners = racingGame(cars, time);
        System.out.println(WINNER_MESSAGE + String.join(",", winners));
    }
}
