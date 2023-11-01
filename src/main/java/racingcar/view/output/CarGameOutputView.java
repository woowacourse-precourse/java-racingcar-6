package racingcar.view.output;

import java.util.List;
import racingcar.model.CarPlayerModel;
import util.formatter.CarFormatter;

public class CarGameOutputView {
    private final CarFormatter carFormatter;

    public CarGameOutputView() {
        this.carFormatter = new CarFormatter();
    }

    public void printWinners(List<CarPlayerModel> winners) {
        System.out.print("최종 우승자 : ");
        System.out.println(this.carFormatter.formatListPlayersToString(winners));
        System.out.println();
    }
}
