package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;


public class Game {
    private int maxForwards = 0;
    private ArrayList<String> winnerName = new ArrayList<>();
    private final ArrayList<Car> cars = new ArrayList<>();
    private final static int START_NUMBER = 0;
    private final static int END_NUMBER = 9;

    void getCarsNames() {
        int nameIndex = 0;
        String[] names;
        String nameLine = Console.readLine();
        Error.isEmptyError(nameLine);
        nameLine = nameLine.trim();
        names = nameLine.split(",");
        for (String name : names) {
            name = name.trim();
            Error.isLengthError(name);
            cars.add(new Car(name));
        }
    }

    int getNumber() {
        String userNumber = Console.readLine();
        userNumber = userNumber.trim();
        Error.isDigitError(userNumber);
        return Integer.parseInt(userNumber);
    }

    void callCarGoForward() {
        for (Car car : cars) {
            int randomNumber = Randoms.pickNumberInRange(START_NUMBER, END_NUMBER);
            car.goForward(randomNumber);
        }
        System.out.printf("%n");
    }

    Game() {
        Message.getStartMessage();
        getCarsNames();
        Message.getAttemptNumberMessage();
        int userNumber = getNumber();
        Message.getProcessMessage();
        for (int i = 0; i < userNumber; i++) {
            callCarGoForward();
        }
        for (Car car : cars) {
            whoIsWinner(car);
        }
        Message.getResultMessage(winnerName);
    }

    void whoIsWinner(Car car) {
        String name = car.getName();
        int forwards = car.getForward();
        if (maxForwards == forwards)
            winnerName.add(name);
        if (maxForwards < forwards) {
            maxForwards = forwards;
            winnerName = new ArrayList<>();
            winnerName.add(name);
        }
    }
}
