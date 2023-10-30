package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputNames = Console.readLine();
        List<String> carNames = Arrays.asList(inputNames.split(","));
//      List<String> carNames = Arrays.asList(Console.readLine().split(","));

        System.out.println("시도할 회수는 몇회인가요?");
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
