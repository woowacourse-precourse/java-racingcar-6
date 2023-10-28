package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Application {
    public static LinkedHashMap<String, Integer> racingCars;

    public static void main(String[] args) throws IOException {
        racingCars = new LinkedHashMap<String, Integer>();
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] cars = in.readLine().split(",");
        racingCarInit(cars);

        System.out.println("시도할 회수는 몇회인가요?");
        int gameCount = Integer.parseInt(in.readLine());

        System.out.println("실행 결과");
        raceStart(gameCount);

        int max = racingCarsMaxValue();
        String winners = whoWinner(max);
        System.out.println("최종 우승자 : " + winners);
    }

    public static void racingCarInit(String[] cars) {
        for (int i = 0; i < cars.length; i++) {
            racingCars.put(cars[i], 0);
        }
    }

    public static void raceStart(int gameCount) {
        while (gameCount-- > 0) {
            for (Map.Entry<String, Integer> car : racingCars.entrySet()) {
                int moveCount = moveCountInit();
                String move = concatMove("-", moveCount);
                System.out.println(String.format("%s : %s", car.getKey(), move));
                car.setValue(car.getValue() + moveCount);
            }
            System.out.println();
        }
    }

    public static String whoWinner(int max) {
        ArrayList<String> resRacing = new ArrayList<>();
        String winners = "";
        for (Map.Entry<String, Integer> car : racingCars.entrySet()) {
            if (max == car.getValue()) {

                resRacing.add(car.getKey());
            }

        }
        winners = String.join(",", resRacing);
        return winners;
    }

    public static int racingCarsMaxValue() {
        int max = Integer.MIN_VALUE;
        for (Map.Entry<String, Integer> car : racingCars.entrySet()) {
            max = Math.max(max, car.getValue());
        }
        return max;
    }

    public static int moveCountInit() {
        return Randoms.pickNumberInRange(0,9);
    }

    public static String concatMove(String move, int moveCount) {
        StringBuilder sb = new StringBuilder(move.length() * moveCount);

        for (int i = 1; i <= moveCount; i++) {
            sb.append(move);
        }
        return sb.toString();
    }
}
