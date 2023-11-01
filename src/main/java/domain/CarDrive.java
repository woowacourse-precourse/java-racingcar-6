package domain;

import java.util.List;
import validate.ValidateWinner;

public class CarDrive {

    private static Car[] carslist;
    private static int carnumbers;

    public static void getCarNames(List<String> carNames) {
        carnumbers = carNames.size();
        carslist = new Car[carnumbers];
        for (int i = 0; i < carnumbers; i++) {
            carslist[i] = new Car();
            carslist[i].setCarName(carNames.get(i));
        }
    }

    public static void driving(int tries) {
        for (int i = 0; i < tries; i++) {
            outPutCars();
            System.out.println();
        }
    }

    public static void outPutCars() {
        for (int i = 0; i < carnumbers; i++) {
            GameOutput.carNameOutput(carslist[i].getCarName());
            carslist[i].appendDistance();
            GameOutput.carDistance(carslist[i].getDistance());
        }
    }

    public static String Winner() {
        return ValidateWinner.checkJointWinner(carslist, carnumbers);
        //조인트 위너면 걍 , + " " + carnumber 추가
    }

}
