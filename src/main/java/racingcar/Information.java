package racingcar;

public class Information {
    private final static int MAX_CAR_NAME = 5;
    private String name;
    private int destination;

    Information(String name) {
        isVaildCarName(name);
        this.name = name;
        destination = 0;
    }

    void update() {
        destination++;
    }

    void print() {
        System.out.println(name + " : " + "-".repeat(destination));
    }

    private void isVaildCarName(String name) throws IllegalArgumentException {
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
        return (destination);
    }
}
