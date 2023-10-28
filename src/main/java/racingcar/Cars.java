package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Cars {
    ArrayList<Car> cars;

    public Cars() {
        cars = new ArrayList<>();
    }

    public void settingNames() {
        String names = Console.readLine();
        for(String name : names.split(",")) {
            cars.add(new Car(name));
        }
    }

    public void settingLogBoard(int tryChance) {
        for(Car car : cars) {
            car.settingLog(tryChance);
        }
    }

    public void play(int round) {
        System.out.println();
        for(Car car : cars) {
            int number = Randoms.pickNumberInRange(0, 9);
            if(number >= 4) {
                car.meter++;
            }
            car.movingLog.put(round, car.meter);
            System.out.println(car.printResult(round));
        }
    }

    public int findMaxScore() {
        int max = Integer.MIN_VALUE;
        for(Car car : cars) {
            max = Math.max(car.meter, max);
        }
        return max;
    }

    public String findWinners(int maxScore) {
        return cars.stream()
            .filter(car -> car.meter == maxScore)
            .map(car -> car.name)
            .collect(Collectors.joining(", "));
    }
}
