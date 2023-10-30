package racingcar;

public class CarField {

    private final StringConverter stringConverter;

    CarField(){
        this.stringConverter = new StringConverter();
    }
    private int round;

    public void run(){
        OutputView.printInitCars();
        stringConverter.stringToCarNames(",");
        OutputView.printRoundSet();
        round = stringConverter.stringToInteger();
    }


}
