package racingcar.controller.subcontroller;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.repository.CarRepository;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class InitializeCarController {
    private final InputView inputView;
    private final OutputView outputView;

    public InitializeCarController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void initializeCar() {
        List<String> names = inputToNameCar(); // 자동차 이름 입력
        for (String name : names) {
            Car car = new Car(name);
            CarRepository.add(car);
        }
    }

    private List<String> inputToNameCar() {
        return inputView.inputToNameCar();
    }
}
