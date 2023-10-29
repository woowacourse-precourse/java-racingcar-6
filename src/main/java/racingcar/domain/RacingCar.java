package racingcar.domain;

public class RacingCar {
    private String username;
    private String currentLocation;

    public RacingCar(String username, String currentLocation) {
        this.username = username;
        this.currentLocation = currentLocation;
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
 *     int randomNumber = Randoms.pickNumberInRange(1, 9);
 *     if (!computer.contains(randomNumber)) {
 *         computer.add(randomNumber);
 *     }
 * }
 */