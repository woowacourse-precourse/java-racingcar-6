package racingcar.view;

public class OutputView {

    private static final OutputView INSTANCE = new OutputView();

    private OutputView() {}

    public OutputView getInstance(){
        return INSTANCE;
    }

    public void printPlayResultMessage(){
        System.out.println("실행 결과");
    }

    public void printCarName(String carName){
        System.out.print(carName + " : ");
    }


}
