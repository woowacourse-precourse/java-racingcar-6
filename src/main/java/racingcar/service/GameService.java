package racingcar.service;

import racingcar.dto.GameDto;
import racingcar.repository.GameRepository;

public class GameService {
	private final GameRepository gameRepository;

	public GameService() {
		gameRepository = new GameRepository();
	}

	public void createGame(GameDto gameDto) {
		gameRepository.saveGame(gameDto);
	}
}
