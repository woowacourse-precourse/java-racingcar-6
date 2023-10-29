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
    private final UserInput userInput;
    private final RandomNumberProvider randomNumberProvider;
    private List<Participant> participants;
    private GameInfo gameInfo;
    private int attemptNum;

    public RacingGame(UserInput userInput, RandomNumberProvider randomNumberProvider) {
        this.userInput = userInput;
        this.randomNumberProvider = randomNumberProvider;
        this.gameInfo = userInput.getGameInfo();
    }


    @Override
    public void start() {
        setParticipants();
        setAttemptNum();
        for(int numOfAttempt = 1; numOfAttempt <= attemptNum; numOfAttempt++) {
            startOneTurn();
            printCurrentResults();
        }
    }



    private void startOneTurn() {
        for(Participant participant : participants) {
            if(isForward()) {
                int forward = participant.getForward();
                participant.setForward(++forward);
            }
        }

    }

    private void printCurrentResults() {
        for(Participant participant : participants) {
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

    private void setParticipants() {
        participants = new ArrayList<>();
        for(String name : gameInfo.getParticipants()) {
            participants.add(new Participant(name, 0));
        }
    }

    private void setAttemptNum() {
        attemptNum = userInput.inputAttemptNum();
    }

    @Override
    public void getResult() {
        List<Participant> winner = getWinner();
        System.out.print("최종 우승자 : ");
        for(Participant participant : winner) {
            System.out.print(participant.getName());
        }
    }

    private List<Participant> getWinner() {
        List<Participant> winners = new ArrayList<>();
        participants.sort((o1, o2) -> o2.getForward() - o1.getForward());
        Participant first = participants.get(0);
        winners.add(participants.get(0));
        for(int numOfParticipant = 1; numOfParticipant < participants.size(); numOfParticipant++) {
            if(participants.get(numOfParticipant).getForward() < first.getForward()) {
                break;
            }
            winners.add(participants.get(numOfParticipant));
        }
        return winners;
    }
}
