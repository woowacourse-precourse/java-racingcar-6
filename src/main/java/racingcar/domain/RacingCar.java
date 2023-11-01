package racingcar.domain;

public class RacingCar {
    private final String name;
    private Integer countAdvance = 0;
    private final String ROAD = "-";

    public RacingCar(String name) {
        this.name = name;
    }

    public void advance() {
        // 4~9인 숫자여야만 한다.
        countAdvance++;
    }

    public String getAdvancedRoad() {
        return ROAD.repeat(Math.max(0, countAdvance));
    }
}
