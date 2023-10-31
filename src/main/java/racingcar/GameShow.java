package racingcar;

import java.util.List;

public class GameShow {

    public final String inputNameMessage = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public final String inputTimeMessage = "시도할 횟수는 몇회인가요?";
    public final String executeMessage = "실행 결과";
    public final String finalWinnerMessage = "최종 우승자";

    private final GameUtil gameUtil = new GameUtil();

    public void show(String message) {
        System.out.println(message);
    }

    public void ProgressShow(List<Car> carList) {
        for(Car car: carList) {
            System.out.println(car.getRacingCar() + " : " + car.getProgress());
        }
    }

    public void gameResult(List<Car> cars) {
        System.out.println(finalWinnerMessage + " : " + gameUtil.getWinner(cars));
    }

}
