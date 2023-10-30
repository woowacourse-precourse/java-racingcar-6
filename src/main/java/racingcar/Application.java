package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {

    public String[] inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
        String[] cars = Console.readLine().split(",");
        checkCarNameValidation(cars);
        return cars;
    }

    public int inputNumber() {
        System.out.println("시도할 횟수는 몇 회인가요?");
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

    public void showRaceResult(int number, String[] cars) {
        number =  inputNumber();
        cars = inputCarNames();
        System.out.println("실행 결과");

        for (int i = number; i>0; i--) {
            System.out.println();
            checkCarEligibility(cars);
        }
    }

    public void checkCarNameValidation(String[] cars) {

        try {
            for(int i = 0; i < cars.length; i++) {
                if (cars[i].length() > 5) {
                    throw new IllegalArgumentException();
                }
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Application application = new Application();
        application.checkCarEligibility(args);
    }
}
