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
        createCar();
        getRound();

    }

    void createCar() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        String[] names = input.split(",");
        for (String name : names) {
            carRepository.add(new Car(name));
        }
    }

    void getRound() {
        System.out.println("시도할 회수는 몇회인가요?");
        round = Integer.valueOf(Console.readLine());
    }

}
