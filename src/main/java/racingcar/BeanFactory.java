package racingcar;

import racingcar.domain.InputService;
import racingcar.infra.ConsoleInputService;

public class BeanFactory {

    private static InputService inputService;

    private BeanFactory() {
    }

    public static InputService inputService() {
        if (inputService == null) {
            return inputService = new ConsoleInputService();
        }
        return inputService;
    }
}
