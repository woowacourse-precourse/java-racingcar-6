package racingcar.controller;

import java.util.Map;
import racingcar.model.RacingCars;
import racingcar.system.converter.StringToCarList;
import racingcar.view.inputview.InputView;
import racingcar.view.outputview.OutputView;

public class RegisterCarNamesController extends AbstractController {
    public static final String RACING_CARS_KEY = "racingCars";
    private final OutputView outputView;
    private final InputView inputView;

    public RegisterCarNamesController(final OutputView outputView, final InputView inputView) {
        this.outputView = outputView;
        this.inputView = inputView;
    }

    @Override
    void doProcess(Map<String, Object> model) {
        outputView.print(model);

        String input = (String) inputView.input(model);
        RacingCars racingCars = new RacingCars(StringToCarList.convert(input));

        model.put(RACING_CARS_KEY, racingCars);
    }
}
