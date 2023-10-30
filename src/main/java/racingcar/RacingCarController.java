package racingcar;

public class RacingCarController {
    RacingCarView view;
    RacingCarModel model;

    public RacingCarController(RacingCarView view){
        this.view = view;
    }

    public void play(){
        view.displayCarNameSetupMessage();
        String rawCarNames = view.getUserInput();


        view.displayRoundCountSetupMessage();
        String roundCount = view.getUserInput();

    }
}
