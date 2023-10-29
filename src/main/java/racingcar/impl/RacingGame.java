package racingcar.impl;

import racingcar.Game;
import racingcar.entity.GameInfo;
import racingcar.util.Parser;
import racingcar.RandomNumberProvider;
import racingcar.UserInput;
import racingcar.entity.Participant;

import java.util.ArrayList;
import java.util.List;

public class RacingGame implements Game {
    private final RandomNumberProvider randomNumberProvider;
    private GameInfo gameInfo;

    public RacingGame(RandomNumberProvider randomNumberProvider) {
        this.randomNumberProvider = randomNumberProvider;
    }


    @Override
    public void start() {
        for(int numOfAttempt = 1; numOfAttempt <= gameInfo.getAttemptTime(); numOfAttempt++) {
            startOneTurn();
            printCurrentResults();
        }
    }



    private void startOneTurn() {
        for(Participant participant : gameInfo.getParticipants()) {
            if(isForward()) {
                int forward = participant.getForward();
                participant.setForward(++forward);
            }
        }

    }

    private void printCurrentResults() {
        for(Participant participant : gameInfo.getParticipants()) {
            System.out.print(participant.getName() + " : ");
            for(int numberOfForward = 0; numberOfForward < participant.getForward(); numberOfForward++) {
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }

    private boolean isForward() {
        return randomNumberProvider.getRandomNumber() >= 4;
    }

    @Override
    public void getResult() {
        List<Participant> winner = getWinner();
        System.out.print("최종 우승자 : ");
        for(int indexOfWinner = 0; indexOfWinner < winner.size(); indexOfWinner++) {
            if(indexOfWinner == winner.size() - 1) {
                System.out.println(winner.get(indexOfWinner).getName());
                break;
            }
            System.out.print(winner.get(indexOfWinner).getName() + ",");
        }
    }

    @Override
    public void setGameInfo(GameInfo gameInfo) {
        this.gameInfo = gameInfo;
    }


    private List<Participant> getWinner() {
        List<Participant> winners = new ArrayList<>();
        gameInfo.getParticipants().sort((o1, o2) -> o2.getForward() - o1.getForward());
        Participant first = gameInfo.getParticipants().get(0);
        winners.add(gameInfo.getParticipants().get(0));
        for(int numOfParticipant = 1; numOfParticipant < gameInfo.getAttemptTime(); numOfParticipant++) {
            if(gameInfo.getParticipants().get(numOfParticipant).getForward() < first.getForward()) {
                break;
            }
            winners.add(gameInfo.getParticipants().get(numOfParticipant));
        }
        return winners;
    }
}
