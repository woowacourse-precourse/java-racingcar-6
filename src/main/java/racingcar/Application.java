package racingcar;

import racingcar.domain.Car;
import racingcar.domain.Race;
import racingcar.domain.Referee;
import racingcar.domain.Registration;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        final Registration registration = new Registration();
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        final List<Car> cars = registration.registerCars();
        System.out.println("시도할 회수는 몇번인가요?");
        final int countOfPlays = registration.enterCountOfPlays();

        System.out.println("\n실행결과");
        final Race race = new Race(cars, countOfPlays);
        final List<Car> carsAfterRace = race.runRace();

        final Referee referee = new Referee();
        System.out.print("최종 우승자 : ");
        String result = referee.declareWinner(carsAfterRace);
        System.out.println(result);

    }
}
