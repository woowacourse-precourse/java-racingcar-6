package racingcar.controller;

import racingcar.domain.Participants;
import racingcar.domain.Racing;

public class RacingController {

    private Participants participants;
    private Racing racing;

    public void initializeRacing() {
        prepareParticipant();
        prepareRacing();
        startRacing();
        judgeWinner();
    }

    public void prepareParticipant() {
        participants = new Participants();
        participants.registerParticipant();
    }

    public void prepareRacing() {
        racing = new Racing();
        racing.prepareRacing();
    }

    public void startRacing() {
        racing.race(participants);
        System.out.println(racing.judge());
    }

    public void judgeWinner() {
        racing.judge();
    }

}
