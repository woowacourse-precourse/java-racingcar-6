package racingcar;

public class Information {
    private final static int MAX_CAR_NAME = 5;
    private final String name;
    private int Distance;

    Information(String name) {
        isValidCarName(name);
        this.name = name;
        Distance = 0;
    }

    void update() {
        Distance++;
    }

    void print() {
        System.out.println(name + " : " + "-".repeat(Distance));
    }

    private void isValidCarName(String name) throws IllegalArgumentException {
        if (name.isBlank()) {
            throw new IllegalArgumentException("Error : 자동차 이름이 없습니다 최소 한글자 이상 적어주세요");
        }
        if (name.length() > MAX_CAR_NAME) {
            throw new IllegalArgumentException("Error : 자동차 이름이 너무 깁니다 이름 최대 길이 " + MAX_CAR_NAME);
        }
    }

    String getName() {
        return (name);
    }

    int getDestination() {
        return (Distance);
    }
}
