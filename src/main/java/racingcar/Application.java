package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Application {
    static Race race;

    public static void main(String[] args) throws IOException {
        LinkedHashMap<String, Integer> racingCars = new LinkedHashMap<String, Integer>();
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        race = new Race(racingCars);
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] cars = in.readLine().split(",");
        race.racingCarInit(cars);
        System.out.println("시도할 회수는 몇회인가요?");
        int gameCount = Integer.parseInt(in.readLine());
        System.out.println("실행 결과");
        race.raceStart(gameCount);
        int max = racingCarsMaxValue();
        String winners = whoWinner(max);
        System.out.println("최종 우승자 : " + winners);
    }

    public static String whoWinner(int max) {
        ArrayList<String> resRacing = new ArrayList<>();
        String winners = "";

        for (Map.Entry<String, Integer> car : race.racingCars.entrySet()) {
            if (max == car.getValue()) {
                resRacing.add(car.getKey());
            }
        }
        winners = String.join(",", resRacing);
        return winners;
    }

    public static int racingCarsMaxValue() {
        int max = Integer.MIN_VALUE;
        for (Map.Entry<String, Integer> car : race.racingCars.entrySet()) {
            max = Math.max(max, car.getValue());
        }
        return max;
    }

    public static int moveCountInit() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
