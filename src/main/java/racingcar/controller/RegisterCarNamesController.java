package racingcar.controller;

import java.util.Map;
import racingcar.model.RacingCars;
import racingcar.system.converter.StringToRacingCars;
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

        // 변환하는 과정도 controller 에서 진행
        // 변환된 것을 Model에 넣는다고 생각하기 -> InputView의 인터페이스 존폐 여부 결정하기
        String input = (String) inputView.input(model);
        RacingCars racingCars = new RacingCars(StringToRacingCars.convert(input));

        model.put(RACING_CARS_KEY, racingCars);
    }
}
