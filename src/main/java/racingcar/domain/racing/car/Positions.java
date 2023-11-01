package racingcar.domain.racing.car;

import static racingcar.domain.Constants.MIN_MOVE_NUMBER;

import java.util.ArrayList;
import java.util.List;

/**
 * 자동차의 위치(Position)를 관리하는 일급 컬렉션 클래스입니다. 턴에 따른 위치 기록을 리스트 형태로 담고 있습니다.
 */
public final class Positions {

    private final List<Integer> positions = new ArrayList<>();

    private Positions() {
    }

    public static Positions create() {
        return new Positions();
    }

    private void add(int num) {
        positions.add(num);
    }

    public int calcLastIndex() {
        return positions.size() - 1;
    }

    public int calcLastPosition() {
        if (calcLastIndex() == -1) {
            return 0;
        }
        return findPositionAt(calcLastIndex());
    }

    public int calcMaxPosition() {
        return positions.stream()
                .max(Integer::compareTo)
                .orElse(0);
    }

    public int findPositionAt(int turn) {
        return positions.get(turn);
    }

    public boolean isCurrPositionSameOrOver(int position) {
        return calcLastPosition() >= position;
    }

    public void addPositionByRandomNum(int randomNum) {
        int lastPosition = calcLastPosition();

        if (randomNum >= MIN_MOVE_NUMBER) {
            lastPosition++;
        }

        add(lastPosition);
    }
}