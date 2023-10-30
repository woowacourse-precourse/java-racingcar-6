package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        String inputNames = Console.readLine();
        List<String> carNames = Arrays.asList(inputNames.split(","));
//      List<String> carNames = Arrays.asList(Console.readLine().split(","));

        int tryCount = Integer.parseInt(Console.readLine());

        List<Car> cars = new ArrayList<>();
        for (String carName: carNames) {
            cars.add(new Car(carName));
        }

        Race race = new Race(cars,tryCount);
        race.start();

        List<String> winners = race.getWinners();
        if (winners.size() > 1) {
            System.out.println("최종 우승자 : " + String.join(",",winners));
        } else {
            System.out.println("최종 우승자 : " + winners.get(0));
        }
    }
}
