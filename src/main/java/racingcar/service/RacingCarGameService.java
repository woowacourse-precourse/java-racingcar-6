package racingcar.service;

import racingcar.events.racingcargame.EventHandler;

public class RacingCarGameService implements GameService{

    EventHandler eventHandler = new EventHandler();

    public void Start(){
        eventHandler.startPrint();
        eventHandler.inputName();
        eventHandler.inputTryPrint();
        eventHandler.inputTrySave();
    }

    public void Progress(){
        eventHandler.progressPrepare();
        eventHandler.gameProgress();
    }

    public void End(){
        eventHandler.winnerSelect();
        eventHandler.winnerPrint();
    }

}
