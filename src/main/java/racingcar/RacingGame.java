package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static racingcar.services.WinnerDetector.printAllWinners;

import racingcar.constant.Constant;
import racingcar.services.RaceGameState;
import racingcar.services.RaceRoundSimulator;
import racingcar.validate.Validator;
import racingcar.validate.impls.NumberOfParticipantValidator;

public class RacingGame {
    private RaceGameState state;

    public RacingGame(String listOfParticipants) {
        this.state = new RaceGameState(listOfParticipants);
    }

    public void startRacing(){
        getParticipantNamesFromConsole();
        int numberOfRounds = getNumberOfRoundsFromConsole();
        printEachRoundResult(numberOfRounds);
        printAllWinners(state);
    }

    private void printEachRoundResult(int numberOfRounds){
        System.out.println(Constant.EXECUTE_RESULT);
        for (int i =0 ; i< numberOfRounds;i++){
            RaceRoundSimulator.execute(state);
        }
    }
    private void getParticipantNamesFromConsole(){
        System.out.println(Constant.START_MESSAGE);
        String participantsList = readLine();
        this.state = new RaceGameState(participantsList);
    }

    private int getNumberOfRoundsFromConsole(){
        System.out.println(Constant.ROUND_NUMBER_MESSAGE);
        String numberOfRounds = readLine();
        Validator validator = new NumberOfParticipantValidator();
        validator.validate(numberOfRounds);
        System.out.println();
        return Integer.parseInt(numberOfRounds);
    }
}
