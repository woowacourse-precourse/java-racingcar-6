package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public String[] inputCarNames() {
        String[] cars = Console.readLine().split(",");
        return cars;
    }

    public int inputNumber() {
        return Integer.parseInt(Console.readLine());
    }

    public void checkCarEligibility(String[] cars) {
        String[] carRace = new String[cars.length];

        for (int i = 0; i < cars.length; i++) {
            int eligibility = Randoms.pickNumberInRange(0, 9);

            if (eligibility > 4) {
                carRace[i] += "-";
            }
            System.out.println(cars[i] + ": " +carRace[i]);
        }
    }
    public static void main(String[] args) {
    }
}
