package racingcar.domain.system.game;

import static racingcar.support.PrintType.DASH;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.core.car.BasicCar;
import racingcar.domain.core.car.CarName;
import racingcar.domain.core.car.OnRaceCars;
import racingcar.domain.system.game.round.Round;
import racingcar.domain.system.game.round.reuslt.RoundResult;
import racingcar.domain.system.host.Host;
import racingcar.domain.system.manager.car.value.SavedCar;
import racingcar.domain.system.manager.position.value.SavedCarPosition;
import racingcar.domain.system.reader.CarNameReader;
import racingcar.domain.system.reader.TryCountReader;
import racingcar.domain.system.viewer.GuideMessage;
import racingcar.domain.system.viewer.Viewer;
import racingcar.initializer.GameFactory;
import racingcar.support.PrintType;
import racingcar.support.converter.OnRaceCarConverter;
import racingcar.support.validator.TryCountValidator;

public abstract class BasicGame implements Game {


    private final CarNameReader carNamesReader;
    private final TryCountReader tryCountReader;
    private final Viewer viewer;
    private final Host host;

    protected BasicGame(CarNameReader carNamesReader, TryCountReader tryCountReader, Viewer viewer,
        Host host) {
        this.carNamesReader = carNamesReader;
        this.tryCountReader = tryCountReader;
        this.viewer = viewer;
        this.host = host;
    }

    protected BasicGame(GameFactory factory, Host host) {
        this(factory.getCarNameReader(), factory.getTryCountReader(), factory.getViewer(), host);
    }

    @Override
    public void start() {
        viewer.print(GuideMessage.INPUT_NAMES);
        List<CarName> carCarNames = getCarNames();

        viewer.print(GuideMessage.INPUT_TRY_COUNT);
        Long roundCount = getTryCount();

        List<SavedCar> enrolledCars = initializeCars(carCarNames);

        for (int i = 0; i < roundCount; i++) {
            List<SavedCarPosition> onRaceCars = getOnRaceCars(enrolledCars);
            List<SavedCarPosition> orderedCars = getOrderedCars(onRaceCars);
            RoundResult results = executeRound(host, orderedCars);
            saveRound(results);
            printRound(results);
        }

        List<CarName> winners = calculateWinners(enrolledCars);
        printWinners(winners);
    }

    /**
     * 현재는 저장 순서 기준과 정렬 기준이 동일하여 단순 반환
     */
    private List<SavedCarPosition> getOrderedCars(List<SavedCarPosition> onRaceCars) {
        return onRaceCars;
    }

    protected abstract List<SavedCar> initializeCars(List<CarName> carCarNames);

    protected abstract List<SavedCarPosition> getOnRaceCars(List<SavedCar> cars);

    protected abstract void saveRound(RoundResult result);

    protected abstract List<CarName> calculateWinners(List<SavedCar> cars);

    private List<CarName> getCarNames() {
        List<String> sources = carNamesReader.read();
        List<CarName> carNames = new ArrayList<>();
        for (String source : sources) {
            carNames.add(new CarName(source));
        }
        return carNames;
    }

    private Long getTryCount() {
        Long count = tryCountReader.read();
        validate(count);
        return count;
    }

    private void validate(Long count) {
        TryCountValidator.validate(count);
    }

    private RoundResult executeRound(Host host, List<SavedCarPosition> cars) {
        OnRaceCars onRaceCars = OnRaceCarConverter.from(cars);
        Round round = Round.start(host, onRaceCars);
        return round.play();
    }

    private void printWinners(List<CarName> winners) {
        viewer.print(winners);
    }

    private void printRound(RoundResult result) {
        for (BasicCar onRaceCar : result.getAllCars()) {
            Long positionResult = result.getPosition(onRaceCar);
            String position = getPositionPrint(DASH, positionResult);
            viewer.print(onRaceCar.getCarName(), position);
        }
    }

    private String getPositionPrint(PrintType printType, Long count) {
        return printType.getType().repeat(count.intValue());
    }
}
