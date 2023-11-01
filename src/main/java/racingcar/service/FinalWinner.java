package racingcar.service;

import java.util.List;
import racingcar.domain.TotalCar;
import racingcar.view.OutputView;

public class FinalWinner {
    private final OutputView output;

    public FinalWinner(OutputView output) {
        this.output = output;
    }

    public void showCars(TotalCar totalCar) {
        output.showWinnerNotice();
        output.showColon();
        showOneCar(totalCar);
    }

    public void showOneCar(TotalCar totalCar) {
        List<String> winnerList = makeWinnerList(totalCar);
        for (int name = 0; name < winnerList.size(); name++) {
            output.write(winnerList.get(name));
            if (winnerList.size() > name + 1) {
                System.out.print(",");
                System.out.print(" ");
            }
        }

    }

    public List<String> makeWinnerList(TotalCar totalCar) {
        Winner winner = new Winner();
        winner.carCompare(totalCar.distanceList());
        return winner.findWinner(totalCar.nameList(), totalCar.distanceList());
    }
}
