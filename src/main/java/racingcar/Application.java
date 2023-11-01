package racingcar;

import racingcar.game.CarList;
import racingcar.game.Simulator;
import racingcar.view.DataIOHandler;

public class Application {
    public static void main(String[] args) {
        String commaSeparatedNames = DataIOHandler.getNameInput();
        Integer tryCount = DataIOHandler.getTryCountInput();

        CarList carList = new CarList(commaSeparatedNames);

        Simulator.simulateSeveralTimes(carList, tryCount);
        System.out.println(carList.getLongestDistanceNames());
    }
}
