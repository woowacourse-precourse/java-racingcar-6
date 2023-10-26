package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.controller.Race;
import racingcar.model.Car;
import racingcar.view.View;

public class Application {
    public static void main(String[] args) {
        View view = new View();
        Race race = makeRace();

        int number = askNumber();
        System.out.println();

        System.out.println("실행 결과");
        for (int count = 0; count < number; count++) {
            race.phase();
            view.showPhase(race.getCarList());
        }

        System.out.print("최종 우승자 : ");
        view.showResult(race.checkWinner());
    }

    private static int askNumber() {
        System.out.println("시도할 회수는 몇회인가요?");
        String inputNumber = Console.readLine();
        Validation.isNumber(inputNumber);
        return Integer.parseInt(inputNumber);
    }

    private static Race makeRace() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputNames = Console.readLine();
        List<Car> carList = Generator.carList(inputNames);
        return new Race(carList);
    }
}
