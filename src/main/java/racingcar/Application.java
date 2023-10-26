package racingcar;

import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        CreateCar createCar = new CreateCar();
        System.out.println(Arrays.toString(createCar.getCarList()));
    }
}
