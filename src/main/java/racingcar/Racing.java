package racingcar;

public class Racing {

    private Cars cars;

    public void start() {
        cars = new Cars(View.inputCarNames());
        cars.moveResult(View.inputCount());
        View.printFinalWinner(cars.findFinalWinner());
    }
}
