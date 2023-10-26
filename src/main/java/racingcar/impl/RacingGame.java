package racingcar.impl;

import racingcar.Game;
import racingcar.RandomNumberProvider;
import racingcar.entity.Result;
import racingcar.UserInput;

import java.util.List;

public class RacingGame implements Game {
    private UserInput userInput;
    private RandomNumberProvider randomNumberProvider;
    private List<String> participants;
    private int attemptNum;
    private List<Result> results;

    public RacingGame(UserInput userInput, RandomNumberProvider randomNumberProvider) {
        this.userInput = userInput;
        this.randomNumberProvider = randomNumberProvider;
    }


    @Override
    public void start() {
        setParticipants();
        initResults();
        for(int numOfAttempt = 1; numOfAttempt <= attemptNum; numOfAttempt++) {
            startOneTurn();
        }
    }



    private void startOneTurn() {
        for(String participant : participants) {
            if(isForward()) {

            }
        }
    }

    private boolean isForward() {
        return randomNumberProvider.getRandomNumber() >= 4;
    }

    private void setParticipants() {
        participants = userInput.inputUserNames();
    }

    private void setAttemptNum() {
        attemptNum = userInput.inputAttemptNum();
    }

    private void initResults() {
        for(String participant : participants) {
            results.add(new Result(participant, 0));
        }
    }

    @Override
    public String getResult() {
        return null;
    }
}
