package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import racingcar.controller.CarController;
import racingcar.model.Car;
import racingcar.view.Printer;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        CarController carController = new CarController();
        /* 이름 입력 */
        System.out.println("경주 할 자동차 이름(이름은 쉼표(,) 기준으로 구분)");
        ArrayList<Car> cars = carController.createCars(Console.readLine());

        /* 회차 입력 */
        System.out.println("시도할 회수는 몇회인가요?");
        int count = 0;
        try {
            count = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(e);
        }

        /* 회차만큼 게임 실행 */
        System.out.println("실행 결과");
        while (count > 0) {
            cars.forEach(carController::race);
            Printer.printRace(cars);
            count--;
        }

        /* 우승자 출력 */
        Printer.printWinner(carController.checkWinner(cars));
    }
}
