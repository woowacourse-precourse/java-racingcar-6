package racingcar;

import java.util.List;
import racingcar.domain.CarCreate;
import racingcar.domain.CarMovement;
import racingcar.domain.TryNumber;

public class Application {
    public static void main(String[] args) {
        CarCreate carCreate = new CarCreate();
        TryNumber tryNumber = new TryNumber();
        CarMovement carMovement = new CarMovement();
        String[] carNames = carCreate.inputCarNames();
        int tryNumer = tryNumber.inputTryNubmers();

        List<Boolean> carMoveResult = carMovement.getCarMoveResult(carNames.length);

    }
}

