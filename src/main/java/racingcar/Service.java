package racingcar;
import racingcar.view.Input;
public class Service {
    Input inputView = new Input();
    public void userInput() {
        getCarNames();
        //getAttemptNumber();
    }

    private void getCarNames(){
        String carNames = inputView.getCarInput();
        System.out.println(carNames);
    }

}
