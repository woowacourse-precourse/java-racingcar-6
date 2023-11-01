package racingcar;

public class RaceStart {
    RaceManagement raceManagement;

    public RaceStart(){
        Input input = new Input();
        this.raceManagement = new RaceManagement(input.carNameArrayList, Input.inputMoveNumber());

        raceManagement.moveAllRound();
    }





}
