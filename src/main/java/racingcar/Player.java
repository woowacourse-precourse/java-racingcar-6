package racingcar;

import java.util.ArrayList;
import java.util.Arrays;


public class Player {
    public ArrayList<String> createPlayerCarList(String inputPlayer) {
        String[] commaSeperatedInputPlayer = inputPlayer.replace(" ", "").split(",");
        ArrayList<String> playerList = new ArrayList<>(Arrays.asList(commaSeperatedInputPlayer));

        return playerList;
    }

    public int setLapsOfRace(String inputLaps) {
        Validators.isInteger(inputLaps);
        int lapsOfRace = Integer.parseInt(inputLaps);

        return lapsOfRace;
    }
}
