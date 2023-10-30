package racingcar.domain;

import racingcar.vo.CarId;
import racingcar.vo.CarName;

/**
 * 경주를 하는 자동차들.
 * name, position 을 가지고 있고, name 이 겹칠 경우를 고려한 CarId 를 가지고 있다.
 * 현재는 앞으로 전진하는 forward(int forwardCount) 기능 만 가지고 있다.
 */

public class Car {

    private static long idAutoIncrement = 0L; // ID 를 위한 정적 변수 (생성자를 호출할 때 마다, 카운트 증가 → 각각의 자동차 ID)

    private final CarId id; // 중복 이름을 고려한, 자동차 ID
    private final CarName name;
    private int position;

    public Car(final String name) {
        this.id = new CarId(idAutoIncrement++);
        this.name = new CarName(name);
        this.position = 0;
    }

    public long getId() {
        return id.value();
    }

    public String getName() {
        return name.toString();
    }

    public int getPosition() {
        return position;
    }

    public void forward(int frowardCount) {
        if (frowardCount < 0) return;
        position += frowardCount;
    }
}
