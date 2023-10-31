package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.sql.SQLOutput;
import java.util.*;
import java.util.List;

public class Application {

    public String[] inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
        String answer = Console.readLine();
        String[] cars = answer.split(",");
        checkCarNameValidation(cars);
        return cars;
    }

    public int inputNumber() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        return Integer.parseInt(Console.readLine());
    }

    public Map<String, Integer> startCarRace(String[] cars, int number) {

        Integer[] raceList = new Integer[cars.length];
        Arrays.fill(raceList, 0);

        for (int i = 0; i < number; i++) {

            System.out.println("실행 결과");

            for(int j = 0; j < cars.length; j++) {

                System.out.print(cars[j] + " : ");
                int eligibility = Randoms.pickNumberInRange(0, 9);

                if (eligibility > 3) {
                    raceList[j] += 1;
                }
                System.out.println("-".repeat(raceList[j]));
            }
        }
        Map<String, Integer> carRaces = new HashMap<>();

        for (int i = 0; i< cars.length; i++) {
                carRaces.put(cars[i], raceList[i]);
        }

        return carRaces;
    }

    public void showRaceResult(String[] cars, int number) {

        Map<String, Integer> carRaces = startCarRace(cars, number);

        int maxValue = Collections.max(carRaces.values());
        List<String> winnerName = new ArrayList<>();

        for(Map.Entry<String, Integer> m : carRaces.entrySet()) {
            if (m.getValue() == maxValue) {
                winnerName.add(m.getKey());
            }
        }

        System.out.println("최종 우승자 : " );

        if(winnerName.size() == 1) {
            System.out.print(winnerName.get(0));
        } else {
            System.out.print("최종 우승자 : ");

            for(int i = 0; i < winnerName.size()-1; i++) {

                System.out.print(winnerName.get(i));
                System.out.print(", ");
            }
            System.out.println(winnerName.get(winnerName.size()));
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
        showRaceResult(cars,number);
    }

    public static void main(String[] args) {
        Application application = new Application();
        application.run();
    }
}
