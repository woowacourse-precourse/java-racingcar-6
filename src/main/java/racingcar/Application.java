package racingcar;

import racingcar.domain.Car;
import racingcar.util.Game;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        Game game = new Game();
        String cars = inputView.inputCars();
        int number = inputView.inputNumber();

        outputView.gameResult();
        String[] carName = cars.split(", ");
        List<Car> carList = new ArrayList<>();

        for(int i=0;i< carName.length;i++){
            carList.add(new Car(carName[i]));
        }
        for(int i=0;i<number;i++){
            for(int j=0;j<carList.size();j++){
                int move = game.randomNumber();
                if(move>=4){
                    carList.get(j).go();
                }
                System.out.println(carList.get(j).getName() + ":" + "-".repeat(carList.get(j).getLocation()));
            }
            System.out.println();
        }
    }
}