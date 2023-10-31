package racingcar;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class CarStart {

    public int round;
    private final List<Car> cars;

    public CarStart() {
        this.cars = new ArrayList<>();
    }

    public void racingGame() {
        lineUp();

    }

    public void lineUp() {
        String userInput;
        String[] names;
        do {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            userInput = Console.readLine();
            names = userInput.split(",");
        } while (!Valid.checkNames(names));
        for (String name : names) {
            cars.add(new Car(name.trim()));
        }
    }

    public void inputRound() {
        String userInput;
        do {
            System.out.println("시도할 횟수는 몇회인가요?");
            userInput = Console.readLine();
        } while (!Valid.checkRound(userInput));
        this.round = Integer.parseInt(userInput);
    }

}
