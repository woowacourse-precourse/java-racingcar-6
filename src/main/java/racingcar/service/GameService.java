package racingcar.service;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.List;

public class GameService {
    private List<Car> cars;
    private int rounds;

    public void playGame() {
        inputNames();
        inputRounds();

        System.out.println("\n" + "실행 결과");
        for(int round = 0; round < rounds; round++){
            playRound();
            printRoundResult();
        }
    }

    private void inputNames(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        String[] names = input.split(",");

        cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name.trim()));
        }
    }

    private void inputRounds() {
        System.out.println("시도할 회수는 몇회인가요?");
        rounds = Integer.parseInt(Console.readLine());
        if (rounds <= 0) {
            throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
        }
    }

    private void playRound() {
        for (Car car : cars) {
            car.move();
        }
    }

    private void printRoundResult() {
        for (int i = 0; i < cars.size(); i++) {
            System.out.println(cars.get(i).getName() + " : " + "-".repeat(cars.get(i).getPosition()));
        }
        System.out.println("");
    }
}
