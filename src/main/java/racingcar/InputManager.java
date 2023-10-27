package racingcar;

public class InputManager {

    private final InputView inputView;
    private final InputMapper inputMapper;

    public InputManager() {
        this.inputView = new InputView();
        this.inputMapper = new InputMapper();
    }

    public Cars inputCarNames() {
        String carNames = inputView.inputCarNames();
        return inputMapper.toCars(carNames);
    }

}
