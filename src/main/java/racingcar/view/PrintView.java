package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.model.Car;

public class PrintView {
    public PrintView() { }

    public String printStartMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String cars = Console.readLine();
        return cars;
    }

    public String printCountMessage() {
        System.out.println("시도할 회수는 몇회인가요?");
        String count = Console.readLine();
        return count;
    }

    public void printFowardCount(List<Car> carList) {
        for (Car car : carList) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPoisiton()));
        }
        System.out.println();
    }

    public void printWinner(List<String> winnerList) {
        String winners = String.join(", ", winnerList);
        System.out.println("최종 우승자 : " + winners);
    }

}
