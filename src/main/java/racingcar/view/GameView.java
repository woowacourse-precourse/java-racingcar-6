package racingcar.view;

import racingcar.model.Driver;

import java.util.List;

public class GameView {

    public void driverListInputView() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void tryCountInputView() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public void gameResultView() {
        System.out.println("실행 결과");
    }

    public void gameFinalResultView(List<String> winnerList) {
        System.out.println("최종 우승자 : " + String.join(", ", winnerList));
    }

    public void playProgressView(List<Driver> driverList) {
        for (Driver driver : driverList) {
            driverProgressView(driver);
        }
        System.out.println();
    }

    private void driverProgressView(Driver driver) {
        System.out.println(driver);
    }

}
