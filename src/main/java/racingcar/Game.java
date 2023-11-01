package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.Car;
import racingcar.model.Player;
import racingcar.view.Input;
import racingcar.view.Output;

import java.util.List;

public class Game {
    private Input input = new Input();
    private Output output = new Output();

    public void start(){
        Player player = new Player(input.askCars(), input.askTimes());

        output.printStart();
        play(player);

        Judge judge = new Judge();
        List<Car> winners = judge.findWinner(player.getCars());
        output.printWinner(winners);
    }

    private void play(Player player){
        List<Car> cars = player.getCars();
        int times = player.getTimes();

        for(int i=0; i<times; i++){
            for (Car car : cars) {
                car.run(getRandomNumber());
                output.printProgress(car.getName(), car.getMove());
            }
            System.out.println(" ");
        }
    }

    private int getRandomNumber(){
        return Randoms.pickNumberInRange(0,9);
    }

}