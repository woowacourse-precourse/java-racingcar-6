package racingcar.model;

public class RacingCar {

    private final Name name;
    private final Location location;

    public RacingCar(Name name, Location location) {
        this.name = name;
        this.location = location;
    }

    public static RacingCar init(String carName) {
        return new RacingCar(Name.init(carName), Location.init());
    }

    public RacingCar move() {
        return new RacingCar(name, location.move());
    }

    public String getName() {
        return name.name();
    }

    public int getLocation() {
        return location.location();
    }
}
