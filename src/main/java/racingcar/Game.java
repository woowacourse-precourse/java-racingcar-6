package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;


public class Game {
    String userNumber;
    String nameLine;
    String[] names;
    int maxForwards = 0;
    ArrayList<String> winnerName = new ArrayList<>();
    ArrayList<Car> cars = new ArrayList<>();

    void getCarsNames() {
        int nameIndex = 0;

        nameLine = Console.readLine();
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
        userNumber = Console.readLine();
        userNumber = userNumber.trim();
        Error.isDigitError(userNumber);
        return Integer.parseInt(userNumber);
    }

    void callCarGoForward(){
        for (Car car : cars) {
            car.goForward();
        }
        System.out.printf("%n");
    }
    Game() {
        Message.getStartMessage();
        getCarsNames();
        Message.getAttemptNumberMessage();
        int userNumber = getNumber();
        Message.getProcessMessage();
        for (int i = 0; i < userNumber; i++){
            callCarGoForward();
        }
        for (Car car : cars){
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
