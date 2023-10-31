package racingcar;

import java.util.ArrayList;
import java.util.Arrays;


public class Player {
    public ArrayList<String> createPlayerCarList(String inputCars) {
        String[] commaSeperatedInputCars = inputCars.replace(" ", "").split(",");
        ArrayList<String> playerCarList = new ArrayList<String>(Arrays.asList(commaSeperatedInputCars));

        return playerCarList;
    }

    public int setLapsOfRace(String inputLaps) {
        Validators validators = new Validators();
        validators.isInteger(inputLaps);
        int lapsOfRace = Integer.parseInt(inputLaps);

        return lapsOfRace;
    }
}
