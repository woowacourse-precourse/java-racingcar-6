package racingcar.domain.game;

import java.util.List;
import racingcar.domain.car.Car;
import racingcar.domain.car.CarFactory;
import racingcar.domain.car.Cars;
import racingcar.domain.car.strategy.MoveStrategy;
import racingcar.domain.game.round.Round;
import racingcar.support.round.RoundResult;
import racingcar.domain.game.storage.CarStorage;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Game {

	private static final int INITIAL_POSITION = 0;
	private final CarStorage carStorage;
	private Long tryCount;

	public Game(CarStorage carStorage) {
		this.carStorage = carStorage;
	}

	public void start(MoveStrategy moveStrategy) {
		init();
		play(moveStrategy);
		end();
	}

	private void init() {
		OutputView.print(OutputView.REQUEST_CAR_NAME);
		Cars initialCars = new Cars(
				CarFactory.generateCar(InputView.readCarNames(), INITIAL_POSITION));
		carStorage.saveAll(initialCars.getCars());

		OutputView.print(OutputView.REQUEST_TRY_COUNT);
		tryCount = InputView.readTrial();
	}

	private void play(MoveStrategy moveStrategy) {
		OutputView.print(OutputView.RESULT_COMMENT);

		for (int i = 1; i <= tryCount; i++) {
			Cars movedCars = playOneRound(moveStrategy);
			List<Car> savedCars = saveMovedCars(movedCars);
			raceResult(new Cars(savedCars));
		}
	}

	private Cars playOneRound(MoveStrategy moveStrategy) {
		Cars cars = new Cars(carStorage.findAll());
		Round round = new Round(cars);
		return round.play(moveStrategy);
	}

	private List<Car> saveMovedCars(Cars movedCars) {
		return carStorage.saveAll(movedCars.getCars());
	}

	private void raceResult(Cars cars) {
		RoundResult result = RoundResult.generate(cars);
		OutputView.print(result);
	}

	private void end() {
		Cars cars = new Cars(carStorage.findAll());
		Referee referee = new Referee(cars);
		OutputView.print(referee.pickWinners());
	}
}

