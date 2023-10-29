package racingcar.view;

public class OutputView {

    private static final String CAR_RESULT_MESSAGE = "실행 결과";
    private static final String CAR_NAME_MESSAGE = " : ";
    private static final String CAR_POSITION_MESSAGE = "-";

    public void printResultMessage(){
        System.out.println(CAR_RESULT_MESSAGE);
    }

    public void printCarPositionMessage(String name, int number){
        System.out.println(name + CAR_NAME_MESSAGE + CAR_POSITION_MESSAGE.repeat(number));
    }
}
