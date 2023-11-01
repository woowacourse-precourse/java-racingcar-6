package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import racingcar.dto.RacingData;
import racingcar.model.Car;
import racingcar.service.CarService;
import racingcar.view.RacingView;

public class RacingController {

    private final CarService carService = CarService.getInstance();
    private final ArrayList<Car> cars = new ArrayList<>();
    private int count = 0;
    private int currentRound = 1;
    private final RacingView racingView = RacingView.getInstance();

    private RacingController() {
    }

    public static RacingController getInstance() {
        return RacingController.LazyHolder.INSTANCE;
    }

    private static class LazyHolder {
        private static final RacingController INSTANCE = new RacingController();
    }

    public boolean isFinalRound() {
        return currentRound == count;
    }

    public boolean isGameOver() {
        return currentRound > count;
    }

    public void init() {
        RacingData racingData = racingView.initIO();
        String[] carNames = racingData.getNames();
        count = racingData.getCount();

        for (String name : carNames) {
            cars.add(new Car(name, 0));
        }
    }

    public void updateView() {
        if (isGameOver()) {
            return;
        }

        ListIterator<Car> it = cars.listIterator();
        while (it.hasNext()) {
            Car car = it.next();
            boolean isLast = !it.hasNext();
            carService.updateView(car, isLast);
        }

        if (isFinalRound()) {
            List<String> winners = findWinners();
            racingView.printResult(winners);
        }

        currentRound++;
    }

    private List<String> findWinners() {
        int maxDistance = 0;
        ArrayList<String> winners = new ArrayList<>();

        for (Car car : cars) {
            if (maxDistance < car.getDistance()) {
                maxDistance = car.getDistance();
                winners.clear();
                winners.add(car.getName());
            } else if (maxDistance == car.getDistance()) {
                winners.add(car.getName());
            }
        }

        return winners;
    }
}
