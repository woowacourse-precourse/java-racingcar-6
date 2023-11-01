package racingcar.Factory;

import racingcar.Model.CarModel;
import racingcar.Model.CarModelImpl;
import racingcar.Model.GameModel;
import racingcar.Model.GameModelImpl;
import racingcar.Model.RoundModel;
import racingcar.Model.RoundModelImpl;
import racingcar.Validator.CarNameValidator;
import racingcar.Validator.CarNameValidatorImpl;
import racingcar.Validator.RoundValidator;
import racingcar.Validator.RoundValidatorImpl;
import racingcar.View.InputView;
import racingcar.View.InputViewImpl;
import racingcar.View.OutPutView;
import racingcar.View.OutPutViewImpl;

public class Factory {

    public InputView getInputView() {
        return new InputViewImpl();
    }

    public OutPutView getOutPutView() {
        return new OutPutViewImpl();
    }

    public CarModel getCarModel() {
        return new CarModelImpl();
    }

    public RoundModel getRoundModel() {
        return new RoundModelImpl();
    }

    public GameModel getGameModel() {
        return new GameModelImpl();
    }

    public CarNameValidator getCarNameValidator() {
        return new CarNameValidatorImpl();
    }

    public RoundValidator getRoundValidator() {
        return new RoundValidatorImpl();
    }
}
