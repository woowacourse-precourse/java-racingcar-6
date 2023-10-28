package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputManager {
    public List<Car> inputCarName(){
        System.out.println(MassageManager.INPUT_CAR_NAME);
        String containComma = Console.readLine();

        List<String> names = Arrays.stream(containComma.split(","))
                .toList();

        List<Car> cars = new ArrayList<Car>();
        for (int i = 0; i <names.size(); i++){
            checkLinitCarName(names.get(i));
            cars.add(new Car(names.get(i)));
        }
        return cars;
    }

    private void checkLinitCarName(String name){
        if (name.length() > 5){
            throw new IllegalStateException();
        }
    }

//    - [] (입력) 시도 횟수를 입력받는다.  InputManager.inputRepeat
    public int inputRepeat(){
        System.out.println(MassageManager.INPUT_REPEAT);
        String readLine = Console.readLine();

        try{
            return Integer.parseInt(readLine);
        }catch (IllegalStateException e){
            throw new IllegalStateException();
        }
    }
}
