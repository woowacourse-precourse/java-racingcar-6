package game;

import domain.Car;
import domain.Race;
import io.Input;
import io.Output;

import java.util.ArrayList;

public class RacingGame {
    private Input userInput = new Input();
    private Output userOutput = new Output();
    private Race race;

    public void run() {
        ArrayList<String> playerList = userInput.receiveCommaSeparatedString();
        ArrayList<Car> carList = new ArrayList<Car>();

        for (String name: playerList) {
            Car car = new Car(name);
            carList.add(car);
        }

        race = new Race(carList);

        int attempt = userInput.receiveInteger();

        userOutput.printRoundResult();
        race.repeatRound(attempt);

        ArrayList<Car> result = race.getWinnerList();
        userOutput.printWinnerList(result);
    }
}
