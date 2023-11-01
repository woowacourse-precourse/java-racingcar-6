package racingcar.view.output;

import static racingcar.Constants.MOVE;

import java.util.List;
import java.util.stream.IntStream;
import racingcar.model.CarPlayerModel;

public class CarPlayerOutPutView {
    public void printPlayerPosition(CarPlayerModel racingCarPlayer) {
        System.out.print(racingCarPlayer.getCarName() + " : ");
        IntStream.range(0, racingCarPlayer.getCurrentPosition())
                .forEach(i -> System.out.print(MOVE));
        System.out.println();
    }

    public void printPlayersPosition(List<CarPlayerModel> racingCarPlayers) {
        racingCarPlayers.forEach(this::printPlayerPosition);
        System.out.println();
    }
}
