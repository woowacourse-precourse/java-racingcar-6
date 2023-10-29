package racingcar;

import racingcar.model.Car;
import racingcar.model.Player;
import racingcar.view.Input;
import racingcar.view.Output;

import java.util.List;

public class Game {
    Input input = new Input();
    Output output = new Output();

    public void start(){
        List<Car> cars = input.askCarList();
        int times = input.askTimes();

        output.printStart();
        Player player = new Player(cars, times);
        play(player);

        Judge judge = new Judge();
        List<String> winner = judge.findWinner(cars);
        output.printWinner(winner);

    }

    private void play(Player player){
        List<Car> cars = player.getCars();
        int times = player.getTimes();

        for(int i=0; i<times; i++){
            for (Car car : cars) {
                car.run();
                output.printProgress(car.getName(), car.getMove());
            }
            System.out.println(" ");
        }
    }

}