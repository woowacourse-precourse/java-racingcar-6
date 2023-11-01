package racingcar.view.car;

import racingcar.model.CarModel;
import racingcar.model.Observer;
import racingcar.util.style.DistanceStyle;
import racingcar.view.output.OutputView;

public class CarView implements Observer {
    private final OutputView outputView;
    private final CarModel carModel;
    private final DistanceStyle distanceStyle;

    public CarView(final CarModel carModel, final OutputView outputView, final DistanceStyle distanceStyle) {
        this.carModel = carModel;
        carModel.registerObserver(this);

        this.outputView = outputView;

        this.distanceStyle = distanceStyle;
    }

    @Override
    public void update() {
        final String name = carModel.getName();
        final int distance = carModel.getDistance();
        final String distanceString = distanceStyle.getDistanceString(distance);
        outputView.printCarNameAndDistanceString(name, distanceString);
    }
}
