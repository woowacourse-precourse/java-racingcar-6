package racingcar.model;

public class RacingCar {

    private final Name name;
    private final Location location;
    private final IsWinner isWinner;

    public RacingCar(Name name, Location location, IsWinner isWinner) {
        this.name = name;
        this.location = location;
        this.isWinner = isWinner;
    }

    public static RacingCar init(String carName) {
        return new RacingCar(Name.init(carName), Location.init(), IsWinner.init());
    }

    public RacingCar move() {
        return new RacingCar(name, location.move(), isWinner);
    }

    public RacingCar markAsWinner() {
        return new RacingCar(name, location, new IsWinner(true));
    }

    public String getName() {
        return name.name();
    }

    public int getLocation() {
        return location.location();
    }

    public boolean getIsWinner() {
        return isWinner.isWinner();
    }
}
