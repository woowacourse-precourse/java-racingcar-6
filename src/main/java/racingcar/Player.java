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
        boolean result = validators.isInteger(inputLaps);

        if(result) {
           int lapsOfRace = Integer.parseInt(inputLaps);
           return lapsOfRace;
        }
        else {
            return 0;
        }
    }
}
