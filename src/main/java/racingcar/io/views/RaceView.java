package racingcar.io.views;

import java.util.List;
import racingcar.collaborator.race.Racer;
import racingcar.io.Input;
import racingcar.io.Output;
import racingcar.io.enums.RaceViewMessage;

public class RaceView {

    public List<Racer> askRacersNames() {
        Output.consoleLine(RaceViewMessage.ASK_RACERS_NAMES.get());

        return Input.consoleStrings(",").stream()
                .map(String::strip)
                .map(RaceView::toRacer)
                .toList();
    }

    private static Racer toRacer(String name) {
        validateWrongLength(name);
        return new Racer(name);
    }

    private static void validateWrongLength(String name) {
        int maxLength = 5;
        int minLength = 1;
        int nameLength = name.length();

        if (nameLength < minLength || maxLength < nameLength) {
            throw new IllegalArgumentException(RaceViewMessage.EXCEPTION_WRONG_NAME_LENGTH.get());
        }
    }

    public Integer askRoundNumber() {
        Output.consoleLine(RaceViewMessage.ASK_ROUND_NUMBER.get());
        Integer numberOfRound = getInputNumberOfRound();
        Output.consoleLine(); // 입력 후 공백 한 줄이 들어가게 되어있음
        return numberOfRound;
    }

    private static Integer getInputNumberOfRound() {
        int minRound = 1;
        int maxRound = 100;
        Integer numberOfRound = Input.consoleNumber();

        if (numberOfRound < minRound || maxRound < numberOfRound) {
            throw new IllegalArgumentException(RaceViewMessage.EXCEPTION_WRONG_ROUND_NUMBER.get());
        }
        return numberOfRound;
    }

}
