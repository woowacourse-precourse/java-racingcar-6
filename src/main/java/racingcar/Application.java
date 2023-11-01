package racingcar;

import racingcar.domain.car.strategy.RandomMoveStrategy;
import racingcar.domain.game.Game;
import racingcar.domain.game.storage.InMemoryCarStorage;

public class Application {

	public static void main(String[] args) {
		Game game = new Game(new InMemoryCarStorage());
		game.start(new RandomMoveStrategy());
	}
}
