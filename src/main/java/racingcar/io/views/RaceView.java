package racingcar.io.views;

import java.util.List;
import racingcar.collaborator.race.Racer;
import racingcar.io.Input;
import racingcar.io.Output;

public class RaceView {

    // TODO : 리터럴 문자열 제거할 것
    public List<Racer> askRacersNames() {
        Output.consoleLine("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

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
            throw new IllegalArgumentException("이름의 길이는 1~5자리여야 합니다.");
        }
    }

    public Integer askRoundNumber() {
        Output.consoleLine("시도할 회수는 몇회인가요?");
        Integer numberOfRound = getInputNumberOfRound();
        Output.consoleLine(); // 입력 후 공백 한 줄이 들어가게 되어있음
        return numberOfRound;
    }

    private static Integer getInputNumberOfRound() {
        int minRound = 1;
        int maxRound = 100;
        Integer numberOfRound = Input.consoleNumber();

        if (numberOfRound < minRound || maxRound < numberOfRound) {
            throw new IllegalArgumentException("진행회수는 1~100회여야 합니다.");
        }
        return numberOfRound;
    }

}
