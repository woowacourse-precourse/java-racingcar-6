package racingcar;

import java.util.HashMap;
import java.util.Iterator;

public class RacingGame {
    static HashMap<String,Integer> carName;
    public void startGame() {
        carName = new HashMap<>();
        InputCarName inputCarName = new InputCarName();
        inputCarName.inputCarName(carName);
        System.out.println(carName);

        InputMovement inputMovement = new InputMovement();
        int movement = inputMovement.inputMovement();
        System.out.println(movement);

        CheckMoveStop checkMoveStop = new CheckMoveStop();
        System.out.println("실행 결과");

        for (int i = 0; i < movement; i++) {
            Iterator<String> iter = carName.keySet().iterator();
            checkMoveStop.checkMoveStop(carName, iter);
        }
        System.out.println(carName);
    }
}
