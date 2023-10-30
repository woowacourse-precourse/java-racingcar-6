package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String inputString = "a,b,c";
        String[] carNames = inputString.split(",");

        for (String carName : carNames) {
            CreateCar createCar = new CreateCar(carName);
            System.out.println(createCar.ReturnCarName());
        }
//        String carNm = Console.readLine();
//        CreateCar createCar = new CreateCar();
//        GenerateRanNum generateRanNum = new GenerateRanNum();
//        MoveCar moveCar = new MoveCar();
//        String[] carList = createCar.getCarList();
//        generateRanNum.returnCarMapList(carList,2);
//        System.out.println(generateRanNum.carHashMapList);
//        moveCar.PrintResult(generateRanNum.carHashMapList);
//        HashMap<String,Integer> carMap = generateRanNum.carHashMap(carList);
//
//        System.out.println(generateRanNum.carMapList(carMap));
//        System.out.println(Arrays.toString(createCar.getCarList()));

    }
}
