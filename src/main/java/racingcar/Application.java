package racingcar;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Comp;
import racingcar.domain.Input;
import racingcar.domain.Output;
import racingcar.domain.Race;

public class Application {
    public static void main(String[] args) {
        List<Car> cars = new ArrayList<>();
        List<Car> winner = new ArrayList<>();
        int gamenum = 0;

        Race race = new Race();
        Comp comp = new Comp();
        Output output = new Output();
        Input input = new Input();

        output.InputCarDes();
        input.InputCarName(cars);

        output.InputGameNumDes();
        gamenum = input.InputGameNum();

        output.CarsResult();
        race.Racing(cars, gamenum);

        comp.CompCars(cars, winner);
        output.WinnerResult(winner);


    }
}
