package racingcar.domain;

import racingcar.vo.CarName;

public class Car {

    private static long count = 0L; // ID 를 위한 정적 변수 (생성자를 호출할 때 마다, 카운트 증가 → 각각의 자동차 ID)

    private final long id; // 중복 이름을 고려한, 자동차 ID
    private final CarName name;
    private int position;

    public Car(final String name) {
        this.id = count++;
        this.name = new CarName(name);
        this.position = 0;
    }

    public String getName() {
        return name.toString();
    }

    public int getForwardCount() {
        return position;
    }

    public void forward() {
        position++;
    }

    // 테스트 용 코드
    public static void resetId() {
        count = 0;
    }
}
