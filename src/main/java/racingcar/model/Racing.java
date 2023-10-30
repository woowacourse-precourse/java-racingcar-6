package racingcar.model;

import racingcar.dto.GameResult;

import java.util.List;

public interface Racing {
    List<List<GameResult>> start();
    List<String> getWinners();
}
