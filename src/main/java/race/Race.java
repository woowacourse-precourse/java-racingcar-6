package race;

import java.util.List;
import java.util.Map;

public class Race {

    DiceNumber diceNumber;

    public Race(DiceNumber diceNumber) {
        this.diceNumber = diceNumber;
    }

    public void result(List<String> carNames, int numberOfAttempts) {
        while (numberOfAttempts > 0) {
            diceNumber.creation(carNames);
            carMoveCheck();
            System.out.println();

            numberOfAttempts--;


        }
    }

    private void carMoveCheck() {
        for (Map.Entry<String, String> map : diceNumber.carMoveCheck.entrySet()) {
            System.out.printf("%s : %s\n", map.getKey(), map.getValue());
        }
    }

}
