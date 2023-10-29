package racingcar;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Racing {
    private RacingInput ri;
    private RacingOutput ro;
    private CarMover cm;

    Racing()
    {
        ri = new RacingInput();
        ro = new RacingOutput();
        cm = new CarMover();
    }

    public void startRacing() throws IOException, IllegalArgumentException {
        ro.putNameInputStatement();
        List<Car> carList = ri.getNameOfCars();
        int n = carList.size();

        ro.putTryInputStatement();
        int tries = ri.getCountOfTries();

        ro.putResultStatement();
        for (int i = 0; i < tries; i++) {
            List<Boolean> whetherMoveOrNot = cm.decideToMoveCars(n);
            cm.moveEveryCar(n, carList, whetherMoveOrNot);
            ro.putResultOfMovement(carList);
        }

        List<String> winnerList = ro.getResultOfWinner(carList);
        ro.putResultOfWinner(winnerList);
    }
}
