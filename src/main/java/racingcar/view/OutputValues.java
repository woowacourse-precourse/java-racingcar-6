package racingcar.view;

import racingcar.constant.SystemMessage;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class OutputValues {

    public String carNameOutput(String carName) {
        return carName;
    }

    public String carMovementOutput(int getPosition) {
     String carMovement;
        carMovement = String.join("", carMovementCal(getPosition));
        return carMovement;
    }
    public String[] carMovementCal(int getPosition) {
        final String[] movement = new String[getPosition];

        Arrays.fill(movement, "-");
        return movement;
    }
    public void carRaceWinnerOutput(String winner) {
        System.out.println(SystemMessage.CAR_RACE_WINNER_MESSAGE.getMessage() + winner);
    }

    public void runResultOutput() {
        System.out.println(SystemMessage.RUN_RESULT_MESSAGE.getMessage());
    }
}
