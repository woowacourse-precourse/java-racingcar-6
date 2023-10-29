package racingcar;

import java.util.List;

public class Game {

    public void play(){
        Player player = new Player();
        List<Car> cars = player.getCarList();
        int times = player.getTimes();

        Print print = new Print();

        System.out.println("\n실행 결과");
        for(int i=0; i<times; i++){
            for (Car car : cars) {
                car.run();
                print.progress(car.getName(), car.getMove());
            }
            System.out.println(" ");
        }

        Judge judge = new Judge();
        List<String> winner = judge.findWinner(cars);
        print.winner(winner);

    }

}