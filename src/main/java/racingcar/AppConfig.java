package racingcar;

import racingcar.controller.RacingController;
import racingcar.util.convert.ConverterHolder;
import racingcar.util.convert.StringToCarGarageConverter;
import racingcar.util.convert.StringToTryCountConverter;
import racingcar.service.RacingService;
import racingcar.util.StringFormatter;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class AppConfig {

    public RacingController setRacing() {

        setConverters();

        return new RacingController(inputView(), outputView(), racingService());
    }

    private void setConverters() {
        ConverterHolder.setConverters(List.of(
                new StringToCarGarageConverter(),
                new StringToTryCountConverter()
        ));
    }

    private InputView inputView() {
        return new InputView();
    }

    private OutputView outputView() {
        return new OutputView(new StringFormatter());
    }

    private RacingService racingService() {
        return new RacingService();
    }

    public void endRacing() {
        ConverterHolder.clearHolder();
    }
}
