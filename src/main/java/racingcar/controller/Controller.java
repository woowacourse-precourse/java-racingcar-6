package racingcar.controller;

import java.util.List;
import racingcar.model.Car;
import racingcar.model.Model;
import racingcar.view.View;

public class Controller {
    public Controller() {
        View view = new View();
        Model model = new Model();

        String[] namesOfCars = view.getNamesOfCars();
        List<Car> carList = model.makeCarList(namesOfCars);

        int times = view.getTimes();

        for(int i = 0 ; i < times ; i++) {
            model.racingForOneTurn(carList);
            view.printResult(carList);
        }

        List<String> winnerList = model.getWinnerList(carList);
        view.printWinner(winnerList);
    }
}
