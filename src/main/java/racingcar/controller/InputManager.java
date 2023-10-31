package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputManager {
    public List<Car> inputCarName(){
        System.out.println(MassageManager.INPUT_CAR_NAME);
        String readLine = Console.readLine();

        List<String> names = separateNames(readLine);

        List<Car> cars = new ArrayList<Car>();
        for (int i = 0; i <names.size(); i++){
            checkLimitCarName(names.get(i));
            cars.add(new Car(names.get(i)));
        }
        return cars;
    }

    protected List<String> separateNames(String readLine){
        return Arrays.stream(readLine.split(","))
                .toList();
    }

    protected void checkLimitCarName(String name){
        if (name.length() > 5){
            throw new IllegalArgumentException();
        }
    }

    public int inputRepeat(){
        System.out.println(MassageManager.INPUT_REPEAT);
        String readLine = Console.readLine();

        return checkRepeatCondition(readLine);
    }

    protected Integer checkRepeatCondition(String readLine){
        try{
            return Integer.parseInt(readLine);
        }catch (IllegalStateException e){
            throw new IllegalStateException();
        }
    }
}
