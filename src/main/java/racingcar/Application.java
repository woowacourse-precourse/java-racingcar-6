package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {

    public String[] inputCarNames() {
        String[] cars = Console.readLine().split(",");
        return cars;
    }

    public int inputNumber() {
        return Integer.parseInt(Console.readLine());
    }

    public void checkCarEligibility(String[] cars) {
        for(int i = 0; i<cars.length; i++) {
            System.out.print(cars[i] + ": ");
            int eligibility = Randoms.pickNumberInRange(0, 9);

            if (eligibility > 4) {
                System.out.println("-");
            }
        }
    }
    public static void main(String[] args) {
    }
}
