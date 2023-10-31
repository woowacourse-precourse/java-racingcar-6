package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Race {
    private static final int MIN = 0;
    private static final int MAX = 9;
    private List<Position> position;
    private TryCnt tryCnt;

    int number = Randoms.pickNumberInRange(MIN,MAX);

    private Race(List<Position> position, TryCnt tryCnt) {
        this.position = position;
        this.tryCnt = tryCnt;
    }

    public static Race createRace(List<Position> position, TryCnt tryCnt) {
        return new Race(position, tryCnt);
    }

    public List<Position> positionList() {
        return position;
    }

    public int tryValue() {
        return tryCnt.tryValue();
    }
}
