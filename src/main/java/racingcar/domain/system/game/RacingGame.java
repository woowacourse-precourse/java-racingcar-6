package racingcar.domain.system.game;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.BiFunction;
import racingcar.domain.core.car.Car;
import racingcar.domain.core.car.CarName;
import racingcar.domain.core.car.OnRaceCar;
import racingcar.domain.system.game.round.RoundResult;
import racingcar.domain.system.game.round.host.Host;
import racingcar.domain.system.manager.car.CarManager;
import racingcar.domain.system.manager.car.SavedCar;
import racingcar.domain.system.manager.position.CarPositionManager;
import racingcar.domain.system.manager.position.SavedCarPosition;
import racingcar.domain.system.reader.CarNameReader;
import racingcar.domain.system.reader.TryCountReader;
import racingcar.domain.system.viewer.Viewer;
import racingcar.initializer.GameFactory;
import racingcar.support.converter.CarConverter;

public class RacingGame extends BasicGame {

    private static final Long INIT_POSITION = 0L;
    private static final int WINNER_IDX = 0;

    private final CarManager carManager;
    private final CarPositionManager carPositionManager;

    public RacingGame(CarNameReader carNameReader, TryCountReader tryCountReader, Viewer viewer,
        Host host, CarManager carManager, CarPositionManager carPositionManager) {
        super(carNameReader, tryCountReader, viewer, host);
        this.carManager = carManager;
        this.carPositionManager = carPositionManager;
    }

    public RacingGame(GameFactory factory, Host host, CarManager carManager,
        CarPositionManager carPositionManager) {
        super(factory, host);
        this.carManager = carManager;
        this.carPositionManager = carPositionManager;
    }

    @Override
    protected List<SavedCar> initializeCars(List<CarName> carCarNames) {
        List<Car> cars = CarConverter.from(carCarNames);
        List<SavedCar> savedCars = carManager.saveAll(cars);
        initialCarPosition(savedCars);
        return savedCars;
    }

    private void initialCarPosition(List<SavedCar> savedCars) {
        savedCars.forEach(savedCar -> carPositionManager.save(savedCar, INIT_POSITION));
    }

    @Override
    protected List<SavedCarPosition> getOnRaceCars(List<SavedCar> cars) {
        Map<CarName, SavedCarPosition> onRaceCars = carPositionManager.findAll(cars);
        return new ArrayList<>(onRaceCars.values());
    }

    @Override
    protected void saveRound(RoundResult result) {
        for (OnRaceCar car : result.getAllCars()) {
            carPositionManager.save(carManager.findByName(car.getCarName()), car.getPosition());
        }
    }

    @Override
    protected List<String> calculateWinners(List<SavedCar> cars) {
        Map<CarName, SavedCarPosition> carPositions = carPositionManager.findAll(cars);
        Map<Long, List<CarName>> results = getResults(carPositions);
        Long winner = getWinner(results);
        return getWinners(results, winner);
    }

    private Map<Long, List<CarName>> getResults(Map<CarName, SavedCarPosition> carPositions) {
        Map<Long, List<CarName>> results = new HashMap<>();
        for (Entry<CarName, SavedCarPosition> carPosition : carPositions.entrySet()) {
            results.merge(carPosition.getValue().getPosition(),
                new ArrayList<>(List.of(carPosition.getKey())), ifExistKey());
        }
        return results;
    }

    private BiFunction<List<CarName>, List<CarName>, List<CarName>> ifExistKey() {
        return (oldCars, newCar) -> {
            oldCars.addAll(newCar);
            return oldCars;
        };
    }

    private Long getWinner(Map<Long, List<CarName>> results) {
        return results.keySet().stream().sorted(Comparator.reverseOrder()).limit(1).toList()
            .get(WINNER_IDX);
    }

    private List<String> getWinners(Map<Long, List<CarName>> results, Long winner) {
        return results.get(winner).stream().map(CarName::getName).toList();
    }
}
