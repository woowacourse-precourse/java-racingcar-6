package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;
import racingcar.validator.NumValidator;
import racingcar.validator.StringValidator;

import java.util.Arrays;
import java.util.List;

import static racingcar.constant.GameControlMessageConstant.NEED_CAR_NAMES_INPUT_MESSAGE;
import static racingcar.constant.GameControlMessageConstant.NEED_TRY_COUNT_MESSAGE;

public class RacingGame {
    public void play() {

        System.out.println(NEED_CAR_NAMES_INPUT_MESSAGE);
        String namesInput = Console.readLine();
        new StringValidator(namesInput).validate();

        System.out.println(NEED_TRY_COUNT_MESSAGE);
        String countInput = Console.readLine();
        new NumValidator(countInput).validate();

        List<String> nameList = Arrays.asList(namesInput.split(","));
        RaceEntry raceEntry = new RaceEntry(nameList);
        int count = Integer.parseInt(countInput);

        RaceManager raceManager = new RaceManager(raceEntry, count);
        raceManager.doRace();
        System.out.println(raceManager.getRaceResult());

    }
}
