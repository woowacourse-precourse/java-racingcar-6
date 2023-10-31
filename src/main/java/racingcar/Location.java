package racingcar;

public class Location implements Comparable<Location> {
    private PositiveNumber position;

    private Location(String number) {
        this.position = PositiveNumber.fromString(number);
    }

    private Location(Integer number) {
        this.position = PositiveNumber.fromInteger(number);
    }

    public static Location fromString(String number) {
        return new Location(number);
    }

    public static Location fromInteger(Integer number) {
        return new Location(number);
    }

    public Integer getIntegerPosition() {
        return this.position.getNumber();
    }

    public String getStringPosition() {
        if (this.position.isZero()) {
            return RacingCarGameText.RACINGCAR_DOES_NOT_MOVE;
        }
        return RacingCarGameText.RACINGCAR_LOCATION_SYMBOL
                .repeat(this.position.getNumber());
    }

    public PositiveNumber getPositiveNmber() {
        return this.position;
    }

    public void step() {
        this.position.increase();
    }

    @Override
    public int compareTo(Location compareLocation) {
        return this.position.compareTo(compareLocation.getPositiveNmber());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Location other = (Location) obj;
        return this.position.equals(other.getPositiveNmber());
    }
}
