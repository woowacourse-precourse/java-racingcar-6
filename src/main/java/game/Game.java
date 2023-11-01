package game;

import camp.nextstep.edu.missionutils.*;
import car.Car;
import util.GamePrinter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Game {

    private List<Car> carList = new ArrayList<>();

    private int count;

    private final GameInput gameInput = new GameInput();


    public void run() {
        input();
        GamePrinter.startMove();
        for (int i = 0; i < count; i++) {
            allMove();
            System.out.println();
        }
        determineWinner();
    }

    private void input() {
        GamePrinter.inputCarNames();

        String inputCarNames = Console.readLine();
        this.carList = gameInput.inputCarNames(inputCarNames);

        GamePrinter.inputCount();

        String inputCount = Console.readLine();
        this.count = gameInput.inputCount(inputCount);
    }


    private void allMove() {

        for (Car car : carList) {
            int random = Randoms.pickNumberInRange(0, 9);
            if (random >= 4) {
                car.move();
            }
            GamePrinter.printCarNamePosition(car);
        }
    }

    private void determineWinner() {

        List<String> winnerCarNames = new ArrayList<>();

        int maxPosition = carList.stream().max(new Comparator<Car>() {
            @Override
            public int compare(Car o1, Car o2) {
                return o1.getPosition() - o2.getPosition();
            }
        }).get().getPosition();

        for (Car car : carList) {
            if (car.getPosition() == maxPosition) {
                winnerCarNames.add(car.getName());
            }
        }


        GamePrinter.determineWinner(winnerCarNames);
    }
}
