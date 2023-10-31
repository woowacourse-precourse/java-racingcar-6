package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;


public class Game {
    String userNumber;
    String nameLine;
    String[] names;
    ArrayList<Car> Cars = new ArrayList<>();

    void getCarsNames() {
        int nameIndex = 0;

        nameLine = Console.readLine();
        Error.isEmptyError(nameLine);
        nameLine = nameLine.trim();
        names = nameLine.split(",");
        for (String name : names) {
            name = name.trim();
            Error.isLengthError(name);
            Cars.add(new Car(name));
        }
    }

    void getNumber() {
        userNumber = Console.readLine();
        userNumber = userNumber.trim();
        Error.isDigitError(userNumber);
    }

    static void whoIsWinner(Car car) {
        String name = car.getName();
        int forwards = car.getForward();
        // key와 value의 pair인 map 자료형을 배우면 좋을 것 같다. 아니면 그냥 linked list로 push pop구현.
    }

    Game() {
        Message.getStartMessage();
        getCarsNames();
        Message.getAttemptNumberMessage();
        getNumber();
        Message.getResultMessage();
        for (Car car : Cars) {
            car.goForward(Integer.parseInt(userNumber));
            whoIsWinner(car);
        }
    }
}
