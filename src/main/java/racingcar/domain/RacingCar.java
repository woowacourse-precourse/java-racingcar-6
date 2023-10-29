package racingcar.domain;

public class RacingCar {
    private final String username;
    private final String currentLocation;

    public RacingCar(String username) {
        this.username = username;
        this.currentLocation = getStartLocation();
    }

    public String getStartLocation() {
        return "";
    }

    public String getUsername() {
        return username;
    }

    public String getCurrentLocation() {
        return currentLocation;
    }
}

/**
 * List<Integer> computer = new ArrayList<>();
 * while (computer.size() < 3) {
 * int randomNumber = Randoms.pickNumberInRange(0, 9);
 * if (!computer.contains(randomNumber)) {
 * computer.add(randomNumber);
 * }
 * }
 */