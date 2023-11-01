package racingcar.domain.system.game;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import racingcar.domain.core.car.Car;
import racingcar.domain.core.car.CarName;
import racingcar.domain.core.car.OnRaceCar;
import racingcar.domain.system.game.round.result.RoundResult;
import racingcar.domain.system.host.Host;
import racingcar.domain.system.manager.car.key.CarKey;
import racingcar.domain.system.manager.car.CarManager;
import racingcar.domain.system.manager.car.value.SavedCar;
import racingcar.domain.system.manager.position.CarPositionManager;
import racingcar.domain.system.manager.position.value.SavedCarPosition;
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
        return carPositionManager.findAll(cars);
    }

    @Override
    protected void saveRound(RoundResult result) {
        for (OnRaceCar car : result.getAllCars()) {
            carPositionManager.save(carManager.findByName(car.getCarName()), car.getPosition());
        }
    }

    @Override
    protected List<CarName> calculateWinners(List<SavedCar> cars) {
        List<SavedCarPosition> carPositions = carPositionManager.findAll(cars);
        Map<Long, List<SavedCarPosition>> results = getResults(carPositions);
        Long winner = getWinner(results);
        return getWinners(results, winner);
    }

    private Map<Long, List<SavedCarPosition>> getResults(List<SavedCarPosition> carPositions) {
        Map<Long, List<SavedCarPosition>> results = new HashMap<>();
        for (SavedCarPosition carPosition : carPositions) {
            results.merge(carPosition.getPosition(), new ArrayList<>(List.of(carPosition)),
                ifExistKey());
        }
        return results;
    }

    private BiFunction<List<SavedCarPosition>, List<SavedCarPosition>, List<SavedCarPosition>> ifExistKey() {
        return (oldCars, newCar) -> {
            oldCars.addAll(newCar);
            return oldCars;
        };
    }

    private Long getWinner(Map<Long, List<SavedCarPosition>> results) {
        return results.keySet().stream().sorted(Comparator.reverseOrder()).limit(1).toList()
            .get(WINNER_IDX);
    }

    private List<CarName> getWinners(Map<Long, List<SavedCarPosition>> results, Long winner) {
        List<SavedCarPosition> winnerCars = new ArrayList<>(results.get(winner));
        List<CarKey> keys = winnerCars.stream().map(SavedCarPosition::getSavedCar)
            .map(SavedCar::getKey).collect(Collectors.toList());
        List<SavedCar> winners = carManager.findAll(keys);
        return winners.stream().map(SavedCar::getCarName).toList();
    }
}
