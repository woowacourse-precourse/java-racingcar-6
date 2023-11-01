package racingcar.domain;

import racingcar.vo.CarId;
import racingcar.vo.CarName;

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

    public String getName() {
        return name.toString();
    }

    public int getPosition() {
        return position;
    }

    public void forward(int forwardCount) {
        if (forwardCount < 0) return;
        position += forwardCount;
    }
}
