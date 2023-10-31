package racingcar;


import java.util.List;
import racingcar.controller.Car;
import racingcar.controller.Start;
import racingcar.service.AttemptNumber;
import racingcar.service.CarCreator;
import racingcar.service.CarName;
import racingcar.service.Move;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현


        CarName carName = new CarName();
        List<Car> cars = new CarCreator().createCars(carName.rangeCarList, 0);

        CarCreator carCreator = new CarCreator();
        OutputView outputView = new OutputView();
        Move move = new Move(cars);
        AttemptNumber attemptNumber = new AttemptNumber();


        Start start = new Start(move, carName, carCreator, outputView, attemptNumber);
        start.Game();
    }

}


