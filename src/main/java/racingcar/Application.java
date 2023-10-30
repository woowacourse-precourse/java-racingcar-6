package racingcar;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        UserInput userInput = new UserInput();
        Grandprix grandprix = new Grandprix();
        List<String> carNames;
        Map<String, Car> racingPlayer = new HashMap<>();

        userInput.labelNameOfCar();
        carNames = userInput.getCarNames();
        userInput.setupNumberOfTry();
        int numberOfTry = userInput.getNumberOfTry();

        for (String name : carNames) {
            racingPlayer.put(name, new CarImpl());
        }



    }

}
