package race;

import java.util.List;
import java.util.Map.Entry;

public class Race {

    private final DiceNumber diceNumber;

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
        for (Entry<String, String> map : diceNumber.getCarMoveCheck().entrySet()) {
            System.out.printf("%s : %s\n", map.getKey(), map.getValue());
        }
    }

}
