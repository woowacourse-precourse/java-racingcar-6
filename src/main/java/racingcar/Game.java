package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private int round;
    private List<Car> carRepository;

    public Game() {
        carRepository = new ArrayList<>();
    }

    public void run() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        createCar();
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public void createCar() {
        String input = Console.readLine();
        String[] names = input.split(",");
        for (String name : names) {
            carRepository.add(new Car(name));
        }
    }

}
