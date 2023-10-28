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
        int number = inputView.inputCount();

        outputView.gameResult();
        String[] carName = cars.split(",");
        List<Car> carList = new ArrayList<>();

        for(int i=0;i< carName.length;i++){
            carList.add(new Car(carName[i]));
        }

        int max = 0;
        for(int i=0;i<number;i++){
            for(int j=0;j<carList.size();j++) {
                int move = game.randomNumber();
                if (move >= 4) {
                    carList.get(j).go();
                }
                System.out.println(carList.get(j).getName() + " : " + "-".repeat(carList.get(j).getLocation()));
                if(carList.get(j).getLocation()>max){
                    max = carList.get(j).getLocation();
                }
            }
            System.out.println();
        }

        List<String> winnerList = new ArrayList<>();
        for(int i=0;i<carList.size();i++){
            if(carList.get(i).getLocation()==max){
                winnerList.add(carList.get(i).getName());
            }
        }
        String winner = String.join(", ", winnerList);
        System.out.println("최종 우승자 : " + winner);
    }
}