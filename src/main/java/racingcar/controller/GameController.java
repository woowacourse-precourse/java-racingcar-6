package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import racingcar.model.Car;
import racingcar.model.RacingGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    private final RacingGame racingGame = new RacingGame();
    List<Car> cars = new ArrayList<>();

    String[] names = inputView.getNames();
    int rounds = inputView.getRounds();

    public void start() {

//        for (int i = 0; i < names.length; i++) {
//            String name = names[i];
//            cars.add(new Car(name, 0));
//        }

          List<Car> cars = racingGame.saveCarsInfo(names);

        System.out.println();
        System.out.println("실행 결과");

        for (int i = 0; i < rounds; i++) {
            racingGame.saveRoundResult(cars);
            outputView.round(cars);
        }

        // roundPosition();
//       int winnerScore = calculateWinningScore(cars);
//        String winner = finalWinner(cars, winnerScore);

        //   System.out.println("최종 우승자 : " + winner);

        int temp = 0;
        for (int m = 0; m < cars.size(); m++) {
            if (temp < cars.get(m).getPosition()) {
                temp = cars.get(m).getPosition();
            }
        }

        String finalWinner = "최종 우승자 : ";
        for (int n = 0; n < cars.size(); n++) {
            if (cars.get(n).getPosition() == temp) {
                finalWinner += cars.get(n).getName();
            }
        }

        System.out.println(finalWinner);

    }




//    public void winningScore(int temp){
//        temp = 0;
//        for(int i = 0; i < cars.size(); i++){
//            if(temp < cars.get(i).getPosition()){
//                temp = cars.get(i).getPosition();
//            }
//        }
//    }


//    public void finalWinner(int temp){
//        String winnerResult = "최종 우승자 : ";
//        for(int i = 0; i < cars.size(); i++){
//            if(cars.get(i).getPosition() == temp) winnerResult += cars.get(i).getName();
//        }
//        System.out.println(winnerResult);
//    }
//
//    public void roundPosition() {
//        for (int i = 0; i < rounds; i++) {
//            for (int j = 0; j < cars.size(); j++) {
//                int randomNumber = Randoms.pickNumberInRange(0, 9);
//                if (randomNumber >= 4) {
//                    cars.get(j).setPosition(cars.get(j).getPosition() + 1);
//                }
//            }
//        }
//        for (Car carResult : cars) {
//            outputView.round(carResult);
//        }
//    }
}
