package racingcar;

import java.util.ArrayList;
import java.util.List;

public class GameManager {
    private InputView inputView;
    List<RandomCar> randomCars = new ArrayList<>();

    public GameManager(InputView inputView) {
        this.inputView = inputView;
    }

    public void launch() {
        List<String> names = inputView.inputCarNames();
        createRandomCars(names);

        int attemptCount = inputView.inputMoveNumber();
        moveRandomCars(attemptCount);

        printWinnerCars();
    }

    private void createRandomCars(List<String> names) {
        names.forEach(name -> randomCars.add(new RandomCar(name)));
    }

    private void moveRandomCars(int attemptCount) {
        for (int i = 0; i < attemptCount; i++) {
            for (RandomCar randomCar : randomCars) {
                randomCar.move();
                randomCar.printPosition();
            }
            System.out.println();
        }
    }

    private void printWinnerCars() {
        List<String> winners = new ArrayList<>();
        selectWinners(winners);

        String format = String.format("최종 우승자 : ");
        for (String winner : winners) {
            format += winner + ", ";
        }

        format = format.substring(0, format.length() - 2);
        System.out.println(format);
    }

    private void selectWinners(List<String> winnerList) {
        int maxPosition = getMaxPosition();
        for (RandomCar randomCar : randomCars) {
            if (randomCar.getPosition() == maxPosition) {
                winnerList.add(randomCar.getName());
            }
        }
    }

    private int getMaxPosition() {
        int maxPosition = -1;
        for (RandomCar randomCar : randomCars) {
            maxPosition = Math.max(maxPosition, randomCar.getPosition());
        }

        return maxPosition;
    }
}
