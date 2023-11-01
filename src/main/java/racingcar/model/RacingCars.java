    package racingcar.model;

    import java.util.ArrayList;
    import java.util.Comparator;
    import java.util.List;
    import java.util.stream.Collectors;

    public class RacingCars {
        private final List<Car> racingCars;

        public RacingCars() {
            this.racingCars = new ArrayList<>();
        }

        public void addCar(Car car) {
            racingCars.add(car);
        }

        public List<Car> getRacingCars() {
            return racingCars;
        }

        public List<Car> findWinners() {
            int maxDistance = racingCars.stream()
                .max(Comparator.comparingInt(Car::getMove))
                .map(Car::getMove)
                .orElse(0);

            return racingCars.stream()
                .filter(car -> car.getMove() == maxDistance)
                .collect(Collectors.toList());
        }

        public List<String> getCarNames() {
            return racingCars.stream()
                .map(Car::getName)
                .collect(Collectors.toList());
        }
    }
