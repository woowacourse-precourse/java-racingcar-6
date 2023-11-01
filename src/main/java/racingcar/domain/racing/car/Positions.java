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

    /**
     * 새로운 위치값을 리스트 맨 뒤에 추가합니다.
     *
     * @param num 입력할 위치값
     */
    private void add(int num) {
        positions.add(num);
    }

    /**
     * 현재 객체에 저장된 위치 중 가장 마지막 위치의 인덱스를 계산합니다.
     *
     * @return 가장 마지막 위치의 인덱스
     */
    public int calcLastIndex() {
        return positions.size() - 1;
    }

    /**
     * 현재 객체에 저장된 위치 중 가장 마지막 위치의 값을 계산합니다. 만약 아직 저장된 위치가 하나도 없으면 0을 반환합니다.
     *
     * @return 가장 마지막 위치의 값
     */
    public int calcLastPosition() {
        if (calcLastIndex() == -1) {
            return 0;
        }
        return findPositionAt(calcLastIndex());
    }

    /**
     * 가장 큰 위치값을 계산합니다.
     *
     * @return 가장 큰 위치
     */
    public int calcMaxPosition() {
        return positions.stream()
                .max(Integer::compareTo)
                .orElse(0);
    }

    /**
     * 주어진 턴에 해당하는 위치값을 반환합니다.
     *
     * @param turn 위치을 가져올 턴 인덱스
     * @return 주어진 턴에 해당하는 위치값
     */
    public int findPositionAt(int turn) {
        return positions.get(turn);
    }

    /**
     * 현재 위치값이 주어진 값 이상인지 검증합니다.
     *
     * @param position 최대 위치(Position) 값
     * @return 현재 위치값이 주어진 값 이상이면 참(true), 그렇지 않으면 거짓(false)
     */
    public boolean isCurrPositionSameOrOver(int position) {
        return calcLastPosition() >= position;
    }

    /**
     * 주어진 랜덤 숫자에 기반하여 위치를 추가합니다.
     *
     * @param randomNum 랜덤 숫자
     */
    public void addPositionByRandomNum(int randomNum) {
        int lastPosition = calcLastPosition();

        if (randomNum >= MIN_MOVE_NUMBER) {
            lastPosition++;
        }

        add(lastPosition);
    }
}