package racingcar.controller;

import java.util.List;
import racingcar.domain.TotalCar;
import racingcar.service.Winner;
import racingcar.util.Message;
import racingcar.view.OutputView;

public class FinalWinner {
    private final OutputView output;

    public FinalWinner(OutputView output) {
        this.output = output;
    }

    public void showCars(TotalCar totalCar) {
        output.write(Message.WINNER_MESSAGE);
        output.write(Message.COLON);
        showCarList(totalCar);
    }

    private void showCarList(TotalCar totalCar) {
        List<String> winnerList = makeWinnerList(totalCar);
        for (int name = 0; name < winnerList.size(); name++) {
            output.write(winnerList.get(name));
            if (winnerList.size() > name + 1) {
                output.write(Message.COMMA);
                output.write(Message.SPACE);
            }
        }

    }

    private List<String> makeWinnerList(TotalCar totalCar) {
        Winner winner = new Winner();
        winner.carCompare(totalCar.distanceList());
        return winner.findWinner(totalCar.nameList(), totalCar.distanceList());
    }
}
