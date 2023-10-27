package racingcar;

public class Controller {
    private final View view;
    private final RacingGame racingGame;
    private Cars cars;

    public Controller(View view,RacingGame racingGame){
        this.view=view;
        this.racingGame=racingGame;
    }

    public void start(){
        view.printNameInputMessage();
        cars=new Cars(racingGame.inputCarNames());

        view.printAttemptCountInputMessage();
        int attemptCount=racingGame.inputAttemptCount(view.inputConsole());

        view.printAttemptResultMessage();
        for(int count=0;count<attemptCount;count++){
            cars.attemptForward();
            view.printCurrentCarsResult(cars);
        }

        view.printFinalWinnerMessage(racingGame.printCarName(cars.findWiiningCars()));
    }
}
