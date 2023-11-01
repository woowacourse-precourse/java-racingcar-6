package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static racingcar.RaceGame.*;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("경주할 자동차 이름을 입력하세요. : ");
        String inputNames = scanner.nextLine();
        String[] carNames = inputNames.split(",");
        List<Car> cars = new ArrayList<>();

        for (String name : carNames) {
            cars.add(new Car(name.trim()));
        }

        System.out.print("시도할 회수는 몇회인가요? ");
        int tryCount = scanner.nextInt();

        runRace(cars, tryCount);
        printRaceResult(cars);
        determineWinner(cars);

        scanner.close();
    }

}
