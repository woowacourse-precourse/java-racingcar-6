package racingcar;

import racingcar.service.RaceService;
import racingcar.view.UserInputMessage;

public class Controller {

    RaceService raceService = new RaceService();
    public void run(){
        ParticipateRace();
    }

    public void ParticipateRace(){
        UserInputMessage.askParticipants();
        raceService.ParticipateRace();
    }
}
