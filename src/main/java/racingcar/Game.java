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
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        userNumber = Console.readLine();
        userNumber = userNumber.trim();
        Error.isDigitError(userNumber);

    }

    Game() {
        getCarsNames();
        getNumber();

    }
}
