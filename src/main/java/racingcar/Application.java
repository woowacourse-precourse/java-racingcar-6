package racingcar;

import java.util.LinkedHashMap;
import java.util.List;
import racingcar.controller.InputProcessor;
import racingcar.controller.JudgeMovement;
import racingcar.controller.JudgeWinner;
import racingcar.model.RaceGameStateModel;
import racingcar.view.RaceGameUserInterfaceView;

/**
 * Controls the model, view, controller
 *
 * @author WorldBestProgrammer
 */
public class Application {

    /**
     * Plays the race game
     */
    public static void main(String[] args) {

        // Input
        RaceGameUserInterfaceView.displayUserCarInput();
        String userCarInput = RaceGameUserInterfaceView.getInput();
        RaceGameUserInterfaceView.displayTotalRoundInput();
        String totalRoundInput = RaceGameUserInterfaceView.getInput();

        // Process Input
        List<String> userCars = InputProcessor.userCarInputProcessor(userCarInput);
        int totalRound = InputProcessor.totalRoundInputProcessor(totalRoundInput);

        // Initialize Model
        RaceGameStateModel raceGameStateModel = new RaceGameStateModel(totalRound, userCars);
        LinkedHashMap<String, Integer> userCarDistance = raceGameStateModel.getUserCarDistance();

        // Display '실행 결과' message
        RaceGameUserInterfaceView.displayRaceGameStartMessage();

        // Progress Game Round and Display Round Result
        for (int i = 0; i < raceGameStateModel.getTotalRound(); i++) {
            updateUserCarDistance(userCars, raceGameStateModel);
            RaceGameUserInterfaceView.displayUserCarDistance(userCarDistance);
        }

        // Judge Winner and Display Winner
        List<String> winners = JudgeWinner.judgeWinner(userCarDistance);
        RaceGameUserInterfaceView.displayWinner(winners);

    }

    /**
     * Updates distance when the car can go
     *
     * @param userCars List of car names
     * @param raceGameStateModel Model storing state of race game
     */
    private static void updateUserCarDistance(List<String> userCars,
            RaceGameStateModel raceGameStateModel) {
        for (String userCar : userCars) {
            int randomNumber = JudgeMovement.getRandomNumber(0, 9);
            boolean goFlag = JudgeMovement.goFlag(randomNumber, 4);

            if (goFlag) {
                int curDistance = raceGameStateModel.getUserCarDistance(userCar);
                raceGameStateModel.updateUserDistance(userCar, curDistance + 1);
            }
        }
    }

}
