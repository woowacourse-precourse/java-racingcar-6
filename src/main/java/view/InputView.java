package view;

import camp.nextstep.edu.missionutils.Console;
import model.Car;
import model.RacingCar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputView {
    public ArrayList<Car> createCar(){
        System.out.print("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n");
        ArrayList<Car> carArrayList = Stream
                .of(Console.readLine().split(","))
                .map(name -> new RacingCar(name))
                .collect(Collectors.toCollection(() -> new ArrayList<>()));
        return carArrayList;
    }

    public int setLaps(){
        System.out.print("시도할 회수는 몇회인가요?\n");
        int count = Integer.parseInt(Console.readLine());
        return count;
    }
}
