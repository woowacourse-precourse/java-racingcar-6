package racingcar;

public class CarField {

    private final StringConverter stringConverter;

    CarField(){
        this.stringConverter = new StringConverter();
    }
    private int round;

    public void run(){
        OutputView.printRoundSet();
        round = stringConverter.stringToInteger();

        System.out.println(round + "회");
    }


}
