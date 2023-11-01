package racingcar.model;

public class Location {

    private static final String INIT_LOCATION = "";
    private static final String ONE_STEP = "-";
    private final RacingNumber numberGenerator;
    private String location;

    public Location(RacingNumber numberGenerator) {
        this.numberGenerator = numberGenerator;
        this.location = INIT_LOCATION;
    }

    public Location() {
        this.numberGenerator = new RandomNumber();
        this.location = INIT_LOCATION;
    }

    public void stopOrMove() {
        int number = numberGenerator.generate();
        if (number >= 4) {
            location += ONE_STEP;
        }
    }

    public String getLocation() {
        return location;
    }

    public Integer getLocationLength() {
        return location.length();
    }
}
