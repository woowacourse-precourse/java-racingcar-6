package racingcar.playcar;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PlayCars {

    private final Scanner scanner;
    private List<String> cars;
    private int numberOfTry;

    public PlayCars(Scanner scanner) {
        this.scanner = scanner;
    }

    public List<String> getCars() {
        return cars;
    }

    public int getNumberOfTry() {
        return numberOfTry;
    }

    public void input() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        this.cars = Arrays.asList(scanner.next().split(","));
        System.out.println("시도할 회수는 몇회인가요?");
        this.numberOfTry = scanner.nextInt();
        System.out.println();
    }
}
