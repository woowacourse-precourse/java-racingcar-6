package racingcar;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        CreateCar createCar = new CreateCar();
        GenerateRanNum generateRanNum = new GenerateRanNum();

        String[] carList = createCar.getCarList();
        generateRanNum.returnCarMapList(carList,2);
        System.out.println(generateRanNum.carHashMapList);
//        HashMap<String,Integer> carMap = generateRanNum.carHashMap(carList);
//
//        System.out.println(generateRanNum.carMapList(carMap));
//        System.out.println(Arrays.toString(createCar.getCarList()));

    }
}
