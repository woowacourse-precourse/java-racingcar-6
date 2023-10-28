package racingcar.view;

public class OutputView {

    private static OutputView instance;

    private OutputView() {
    }

    public static OutputView getInstance() {
        if(instance==null){
         instance= new OutputView();
        }
        return instance;
    }

    public void printInitGame() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n");
    }

    public void printBeforeInputGameCount() {
        System.out.println("시도할 회수는 몇회인가요?");
    }
}
