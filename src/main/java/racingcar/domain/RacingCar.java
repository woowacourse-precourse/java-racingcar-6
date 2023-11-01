package racingcar.domain;

public class RacingCar {
    private Integer countAdvance = 0;
    private final String NAME;
    private final String ROAD = "-";
    private final String SEPARATOR = " : ";

    public RacingCar(String name) {
        this.NAME = name;
    }

    private boolean isPossibleAdvance(Integer num) {
        return num >= 4 && num <= 9;
    }

    public void advance(Integer num) {
        if (isPossibleAdvance(num)) {
            countAdvance++;
        }
    }

    private String getAdvancedRoad() {
        return ROAD.repeat(Math.max(0, countAdvance));
    }

    public String getRacingResult() {
        return NAME + SEPARATOR + getAdvancedRoad();
    }
}
