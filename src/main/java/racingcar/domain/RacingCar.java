package racingcar.domain;

public class RacingCar {
    private final String name;
    private Integer countAdvance = 0;
    private final String ROAD = "-";

    public RacingCar(String name) {
        this.name = name;
    }

    private boolean isPossibleAdvance(Integer num) {
        return num >= 4 && num <= 9;
    }

    public void advance(Integer num) {
        if (isPossibleAdvance(num)) {
            countAdvance++;
        }
    }

    public String getAdvancedRoad() {
        return ROAD.repeat(Math.max(0, countAdvance));
    }
}
