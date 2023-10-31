package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import racingcar.model.Car;
import racingcar.model.Player;
import racingcar.view.InputView;

public class Game {
    private static final int FIRST_BOUND = 0;
    private static final int LAST_BOUND = 9;
    private static final int MOVE_LEAST_BOUND = 4;
    private final Player player = new Player();
    private final InputView inputView = new InputView();
    private List<Car> cars;

    public Game(){
       player.setCarName(inputView.askCarName());
       player.setAttemptNumber(inputView.askAttemptNumber());
    }

    public void setCars(){
        player.getCarName()
                .forEach(name -> cars.add(new Car(name)));
    }

    public boolean canMove(){
        return Randoms.pickNumberInRange(FIRST_BOUND, LAST_BOUND) >= MOVE_LEAST_BOUND;
    }
}