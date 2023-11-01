package racingcar;

public class RaceController {
    private final InOutputView inOutputView;
    Cars cars;
    int round;

    public RaceController(InOutputView inOutputView) {
        this.inOutputView = inOutputView;
    }

    public void start(){
        cars = new Cars(inOutputView.inputCar());
        round = inOutputView.inputRound();
        inOutputView.printResult();
        while(round-->0){
            cars.run();
            inOutputView.printCarsState(cars);
        }
        inOutputView.printWinner(cars);
    }
}
