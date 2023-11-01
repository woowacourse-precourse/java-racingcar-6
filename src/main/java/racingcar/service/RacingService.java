package racingcar.service;

import java.util.List;
import racingcar.controller.InputResolver;
import racingcar.domain.Car;

public class RacingService {
    private final InputResolver inputResolver;

    public RacingService(InputResolver inputResolver) {
        this.inputResolver = inputResolver;
    }

    public void game(){
        settingGame();
    }

    private void settingGame() {
        List<String> carNameList = inputResolver.preprocessCarName();
        
    }
}
