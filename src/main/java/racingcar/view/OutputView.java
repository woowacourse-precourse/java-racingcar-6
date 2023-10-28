package racingcar.view;


public class OutputView {


    public void showRacing(String carName, int carSteps) {
        System.out.println(carName + " : " + "-".repeat(carSteps));
    }

}
