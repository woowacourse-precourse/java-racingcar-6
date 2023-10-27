package racingcar;

import racingcar.config.AppConfig;
import racingcar.ioadapter.IoAdapter;
import racingcar.service.InputConvertService;

public class Application {

    private static final AppConfig appConfig = new AppConfig();


    public static void main(String[] args) {
        IoAdapter ioAdapter = appConfig.ioAdapter();
        InputConvertService inputConvertService = appConfig.inputConvertService();
        String inputStream = ioAdapter.inputStream();
        inputConvertService.inputConvertCarPark(inputStream);
    }
}
