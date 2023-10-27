package racingcar.domain;

public class Car {

    private static int count = 0; // ID 를 위한 정적 변수 (생성자를 호출할 때 마다, 카운트 증가 → 각각의 차 ID)

    private final int id; // 중복 이름을 고려한, 차 ID
    private final String name;
    private int forwardCount;

    public Car(String name) {
        this.id = count++;
        this.name = name;
        this.forwardCount = 0;
    }

    public String getName() {
        return name;
    }

    public int getForwardCount() {
        return forwardCount;
    }

    public void forward() {
        forwardCount++;
    }

    // 테스트 용 코드
    public static void resetId() {
        count = 0;
    }
}
