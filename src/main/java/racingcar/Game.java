package racingcar;

import racingcar.domain.Car;
import racingcar.domain.CarList;
import racingcar.view.outputView;

public class Game {
    public static void run(CarList carList,Integer tryNum){

        for(int i = 0; i<tryNum;i++){
            race(carList);
            outputView.printMessage(carList);
            System.out.println();
        }
        outputView.winner(carList);
    }

    private static void race(CarList carList) {
        for (Car car : carList.getCarList()) {
            car.move();
        }
    }


}
