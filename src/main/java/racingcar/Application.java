package racingcar;

import java.util.LinkedHashMap;
import java.util.List;
import racingcar.controller.InputProcessor;
import racingcar.controller.JudgeMovement;
import racingcar.controller.JudgeWinner;
import racingcar.model.RaceGameStateModel;
import racingcar.view.RaceGameUserInterfaceView;

public class Application {
    public static void main(String[] args) {

        RaceGameUserInterfaceView.displayUserCarInput();
        String userCarInput = RaceGameUserInterfaceView.getInput();
        RaceGameUserInterfaceView.displayTotalRoundInput();
        String totalRoundInput = RaceGameUserInterfaceView.getInput();

        List<String> userCars = InputProcessor.userCarInputProcessor(userCarInput);
        int totalRound = InputProcessor.totalRoundInputProcessor(totalRoundInput);

        RaceGameStateModel raceGameStateModel = new RaceGameStateModel(totalRound, userCars);

        RaceGameUserInterfaceView.raceGameStartMessage();

        for (int i = 0; i < raceGameStateModel.getTotalRound(); i++) {
            for (String userCar : userCars) {
                int randomNumber = JudgeMovement.getRandomNumber(0, 9);
                boolean goFlag = JudgeMovement.goFlag(randomNumber, 4);

                if (goFlag){
                    int curDistance = raceGameStateModel.getUserCarDistance(userCar);
                    raceGameStateModel.updateUserDistance(userCar, curDistance+1);
                }
            }
            LinkedHashMap<String, Integer> userCarDistance = raceGameStateModel.getUserCarDistance();
            RaceGameUserInterfaceView.displayUserCarDistance(userCarDistance);
        }
        LinkedHashMap<String, Integer> userCarDistance = raceGameStateModel.getUserCarDistance();
        List<String> winners = JudgeWinner.judgeWinner(userCarDistance);
        RaceGameUserInterfaceView.displayWinner(winners);

    }
}
