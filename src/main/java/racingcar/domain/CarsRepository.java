package racingcar.domain;

public class CarsRepository {

    private static final CarsRepository instance = new CarsRepository();

    private ParticipatingCars storedCars;

    public static CarsRepository getInstance() {
        return instance;
    }

    public void save(final ParticipatingCars participatingCars) {
        storedCars = participatingCars;
    }

    public ParticipatingCars findCars() {
        return storedCars;
    }
}
