package racingcar.impl;

import racingcar.Game;
import racingcar.Type.GameType;
import racingcar.domain.GameInfo;
import racingcar.RandomNumberProvider;
import racingcar.domain.Participant;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RacingGame implements Game {
    private final RandomNumberProvider randomNumberProvider;
    private GameInfo gameInfo;

    public RacingGame(RandomNumberProvider randomNumberProvider) {
        this.randomNumberProvider = randomNumberProvider;
    }

    @Override
    public void start(GameInfo gameInfo) {
        setGameInfo(gameInfo);
        System.out.println("실행 결과");
        for(int numOfAttempt = 1; numOfAttempt <= gameInfo.getAttemptTime(); numOfAttempt++) {
            startOneTurn();
            printCurrentResults();
        }
    }

    @Override
    public boolean support(GameType gameType) {
        return gameType == GameType.Racing;
    }

    private void startOneTurn() {
        for(Participant participant : gameInfo.getParticipants()) {
            if(isForward()) {
                int forward = participant.getForward();
                participant.setForward(++forward);
            }
        }

    }

    private boolean isForward() {
        return randomNumberProvider.getRandomNumber() >= 4;
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

    private List<Participant> getWinner() {
        return gameInfo.getParticipants().stream()
                .filter(v -> v.getForward() == Collections.max(gameInfo.getParticipants()).getForward())
                .collect(Collectors.toList());
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
            System.out.print(winner.get(indexOfWinner).getName() + ", ");
        }
    }

    public void setGameInfo(GameInfo gameInfo) {
        this.gameInfo = gameInfo;
    }


}
