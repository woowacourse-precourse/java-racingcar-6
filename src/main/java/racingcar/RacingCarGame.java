package racingcar;

import java.util.List;

public class RacingCarGame implements Game {
    private final View view = new View();
    private final Controller controller = new Controller();

    public void start() {
        System.out.print(view.renderAskCarNames());
        List<Car> carList = controller.getStringList()
                .stream()
                .map(Car::new)
                .toList();

        System.out.print(view.renderAskRounds());
        Integer nRounds = controller.getInteger();

        Race race = new Race(carList);
        for (int round = 0; round < nRounds; round++) {
            race.moveAll();
            System.out.print(view.renderAllCars(race.getCarList()));
        }

        System.out.print(view.renderFinalWinners(race.getFarthestCarList()));
    }
}
