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
        initialize(names); // 자동차 생성
    }

    private void initialize(List<String> names) {
        for (String name : names) {
            Car car = new Car(name); // Car 객체 생성
            CarRepository.add(car); // 객체를 repository에 저장
        }
    }

    private List<String> inputToNameCar() {
        return inputView.inputToNameCar();
    }
}
