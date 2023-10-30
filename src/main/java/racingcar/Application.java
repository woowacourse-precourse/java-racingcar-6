package racingcar;

import java.util.List;
import racingcar.domain.InputService;

public class Application {

    public static void main(String[] args) {
        InputService inputService = BeanFactory.inputService();
        List<String> carNames = inputService.getCarNames();
        int round = inputService.getRound();
    }
}