package racingcar.model.data;

import static racingcar.util.GameConstants.INITIAL_POSITION;

/**
 * 자동차 경주에 참여하는 자동차의 위치를 캡슐화한다.
 */
public class Position {
    int position;

    /**
     * 미리 정해진 값으로 위치를 초기화한다.
     */
    public Position() {
        this.position = INITIAL_POSITION;
    }

    /**
     * 위치 값을 증가시켜 한 단위씩 앞으로 이동시킨다.
     */
    public void forward() {
        ++this.position;
    }
}
