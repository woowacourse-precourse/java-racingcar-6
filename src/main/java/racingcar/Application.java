package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.*;

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
            } else {
                carRace[i] += "";
            }
            System.out.println(cars[i] + ": " +carRace[i]);
        }
    }

    public void showRaceResult(int number, String[] cars) {
        System.out.println("실행 결과");

        for (int i = number; i > 0; i--) {
            System.out.println();
            checkCarEligibility(cars);
        }

        Map<String, Integer> carRaces = new HashMap<>();

        for (String car : cars) {
            carRaces.put(car, carRaces.size());
        }

        int maxValue = Collections.max(carRaces.values());
        List<String> winnerName = new ArrayList<>();

        for(Map.Entry<String, Integer> m : carRaces.entrySet()) {
            if (m.getValue() == maxValue) {
                winnerName.add(m.getKey());
            }
        }

        for(int i = 0; i < winnerName.size(); i++) {
            System.out.print("최종 우승자: ");

            if(winnerName.size() == 1) {
                System.out.print(winnerName.get(i));
            } else {
                System.out.print(", ");
            }
        }
    }

    public void checkCarNameValidation(String[] cars) throws IllegalArgumentException{

        for (String car : cars) {
            if (car.length() > 5) {
                throw new IllegalArgumentException();
            }
        }
    }

    public void run() {
        String[] cars = inputCarNames();
        int number = inputNumber();

        showRaceResult(number, cars);
    }

    public static void main(String[] args) {
        Application application = new Application();
        application.run();
    }
}
