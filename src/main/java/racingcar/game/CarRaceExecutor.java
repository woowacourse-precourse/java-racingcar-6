package racingcar.game;

import static racingcar.view.OutputView.printRaceResult;

public class CarRaceExecutor {


    public static void updateCarPosition(Race race){
        int trial = race.getTrial();
        while(trial-->0){
            race.playMoveOrStop();
            printRaceResult(race.getCarList());

        }

    }




}
