package racingcar.config;

import racingcar.ioadapter.IoAdapter;
import racingcar.ioadapter.impl.StandardIoAdapter;

public class AppConfig {

    public IoAdapter ioAdapter() {
        return new StandardIoAdapter();
    }
}
