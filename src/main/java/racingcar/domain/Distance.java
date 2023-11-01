package racingcar.domain;

public record Distance(int location) {
    private static final int MOVE_VALUE = 1;

    public Distance increase(){
        return new Distance(location + MOVE_VALUE);
    }

}
