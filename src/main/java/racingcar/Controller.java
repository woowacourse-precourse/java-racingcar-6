package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Controller {
    public void startRace(){
        ArrayList<String> carNames = getCarsNameInput();
    }
    public ArrayList<String> getCarsNameInput(){
        String nameInput = Console.readLine();

        if (nameInput == null) {
            throw new IllegalArgumentException("Input is null");
        }
        ArrayList<String> names = new ArrayList<>(Arrays.asList(nameInput.split(",", -1))) ;;
        return names;
    }
}
