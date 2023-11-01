package racingcar.view;

import org.junit.jupiter.api.Test;
import racingcar.domain.CarPlayer;

import java.util.ArrayList;
import java.util.List;

public class GameViewTest {

    private final OutputView outputView = new OutputView();

    @Test
    void 게임_진행_상황_출력(){
        CarPlayer carPlayer = new CarPlayer(0,"1번차");
        carPlayer.setScore();
        List<CarPlayer> carPlayerList = new ArrayList<>();
        carPlayerList.add(carPlayer);
        outputView.outputRaceProgress(carPlayerList);
    }

}
