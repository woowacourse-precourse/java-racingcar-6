package racingcar.model.data;

import static racingcar.util.GameConstants.STANDARD_MOVEMENT;

import java.util.AbstractMap.SimpleEntry;
import java.util.Map;
import racingcar.model.record.Name;

/**
 * 자동차 경주에 참여하는 각각의 자동차를 나타낸다.
 * 각각의 자동차는 unique한 이름과 경주에서 본인의 위치를 가지고 있다.
 */
public class Car {
    private Name name;
    private Position position;

    /**
     * 특정한 이름과 초기 위치를 가지고 있는 자동차를 생성한다.
     *
     * @param name 자동차의 이름
     * @param position 자동차의 초기 위치
     */
    public Car(Name name, Position position) {
        this.name = name;
        this.position = position;
    }

    /**
     * 주어진 값에 따라 자동차를 움직인다.
     * 주어진 값이 기준값 이상일 경우, 자동차의 위치가 증가한다.
     *
     * @param value 자동차의 전진 여부를 결정하는 값
     */
    public void moveOrNot(int value) {
        if (value >= STANDARD_MOVEMENT) {
            position.forward();
        }
    }

    /**
     * 자동차의 이름과 위치를 포함하는 현재 정보를 반환한다.
     *
     * @return 자동차의 이름과 위치를 포함하는 map entry
     */
    public Map.Entry<String, Integer> getStatus() {
        return new SimpleEntry<>(this.name.name(), position.position);
    }
}
