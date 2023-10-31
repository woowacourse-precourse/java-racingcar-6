package racingcar.View;

import java.util.ArrayList;
import racingcar.Controller.GameController;
import racingcar.Model.CarModel;

public class GameView {

    public void printGetCarNameView(){

        System.out.println("경주 할 자동차 이름(이름은 쉼표(,) 기준으로 구분)");
    }
    public void printGetCoinNumberView(){

        System.out.println("시도할 회수는 몇회인가요?");
    }

    public void printDistance(ArrayList<CarModel> carModelList) {

        int distance;
        String carName;
        StringBuilder sb;

        for (CarModel car : carModelList) {

            sb = new StringBuilder();
            distance = car.getForwardDistance();
            carName = car.getName();

            sb.append(carName).append(" : ");

            for (int i = 0; i < distance; i++) {
                sb.append("-");
            }

            System.out.println(sb);
        }
    }

    public void printWinner(StringBuilder sb){

        System.out.println(sb);
    }
}
