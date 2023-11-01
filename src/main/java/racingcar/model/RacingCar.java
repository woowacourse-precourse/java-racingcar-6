package racingcar.model;

public class RacingCar {

    private final Name name;
    private final Location currentLocation;

    public RacingCar(Name name, Location currentLocation) {
        this.name = name;
        this.currentLocation = currentLocation;
    }

    public static RacingCar init(String carName) {
        return new RacingCar(Name.init(carName), Location.init());
    }

    public RacingCar move() {
        return new RacingCar(name, currentLocation.move());
    }

    public String getName() {
        return name.name();
    }

    public int getCurrentLocation() {
        return currentLocation.location();
    }
}
