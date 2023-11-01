package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Controller {
    int tryTime;
    Cars cars = new Cars();

    public void startRace() {
        Message.NameInputMsg();
        ArrayList<String> carNameList = splitCarNames(getInput());
        Validation.validateCarNames(carNameList);

        Message.RaceTryTimeInputMsg();
        String tryTimeInput = getInput();
        Validation.validateTrytime(tryTimeInput);
        tryTime = convertStrToInt(tryTimeInput);

        cars.createCars(carNameList);

        for (int idx = 0; idx < tryTime; idx++) {
            String interimResult = cars.doRace();
            Message.raceInterimResultMsg(interimResult);
        }

        Message.finalWinnerMsg(cars.CheckFinalWinner());

    }

    public String getInput() {
        String nameInput = Console.readLine();

        if (nameInput == null) {
            throw new IllegalArgumentException("Input is null");
        }
        return nameInput;
    }

    public ArrayList<String> splitCarNames(String carNames) {

        ArrayList<String> names = new ArrayList<>(Arrays.asList(carNames.split(",", -1)));
        ;
        return names;
    }

    private int convertStrToInt(String time) {
        return Integer.parseInt(time);
    }

}
