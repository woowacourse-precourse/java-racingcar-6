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
        try {
            validators.isInteger(inputLaps);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }
        int lapsOfRace = Integer.parseInt(inputLaps);

        return lapsOfRace;
    }
}
