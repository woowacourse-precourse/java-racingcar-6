package racingcar.domain;

import racingcar.view.InputView;

import java.util.List;
import java.util.Set;

import static racingcar.domain.Position.createPositions;

public class Race {
    private static final String RACE_RESULT_START = "실행 결과";
    private static final String LINE_BLANK = "\n";
    private List<Position> position;
    private TryCnt tryCnt;

    private Race(List<Position> position, TryCnt tryCnt) {
        this.position = position;
        this.tryCnt = tryCnt;
    }

    public static Race createRace(List<Position> position, TryCnt tryCnt) {
        return new Race(position, tryCnt);
    }

    public static Race createRaceFromInput() {
        Set<String> carNames = InputView.inputCarNames();
        List<Position> positions = createPositions(carNames);
        TryCnt tryCnt = TryCnt.createTryCnt(InputView.inputTryCnt());
        System.out.println(LINE_BLANK + RACE_RESULT_START);
        return Race.createRace(positions, tryCnt);
    }

    public List<Position> positionValues() {
        return this.position;
    }

    public int tryValue() {
        return this.tryCnt.tryValue();
    }
}
