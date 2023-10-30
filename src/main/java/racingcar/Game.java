package racingcar;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class Game {
    UserInput userInput = new UserInput();
    List<String> winnersResult = new ArrayList<>();
    private final List<Car> cars = new ArrayList<>();

    public void gameStart() {
        String[] inputName = userInput.getInputName();
        inspectInputName(inputName);
        int inputInt = userInput.getInputInt();
        generate(inputName);

        for (int i = 0; i < inputInt; i++) {
            moveCarsBaseOnRandomNumber();
            printGame();
            System.out.println();
        }

        winnersResult = Winners();
        System.out.println("최종 우승자 : " + String.join(",", winnersResult));
    }

    private void inspectInputName(String[] inputName) {
        for (String inspectstr : inputName) {
            if (inspectstr.length() > 5) {
                throw new IllegalArgumentException();
            }
        }
        return;
    }

    private void generate(String[] inputName) {
        for (String name : inputName) {
            cars.add(new Car(name));
        }
    }

    private void moveCarsBaseOnRandomNumber() {
        for (Car car : cars) {
            if (randomNumber() >= 4) {
                car.move();
            }
        }
    }

    private int randomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    private void printGame() {
        for (Car car : cars) {
            System.out.print(car.getName() + " : ");
            for (int i = 0; i < car.getPosition(); i++) {
                System.out.print("-");
            }
            System.out.println();
        }
    }

    private List<String> Winners() {
        int maxPosition = getMaxPosition();
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }
        return winners;
    }

    private int getMaxPosition() {
        int max = 0;
        for (Car car : cars) {
            if (car.getPosition() > max) {
                max = car.getPosition();
            }
        }
        return max;
    }
}
