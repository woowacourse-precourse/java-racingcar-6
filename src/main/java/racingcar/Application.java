package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    static String inputCarName(){
        String input =  Console.readLine();
        return input.replaceAll("\\s","");
    }

    static String[] splitCarName(String carString){
        return carString.split(",");
    }

    static boolean isValidate(String[] cars){
        for (String car: cars){
            if (car.length() > 5){
                throw new IllegalArgumentException();
            }
        }
        return true;
    }

    static void createCars(String[] cars, List<Car> carArr){
        for (String car: cars){
            carArr.add(new Car(car));
        }
    }

    static int inputNumber(){
        String numString = Console.readLine();
        return Integer.parseInt(numString);
    }

    public static void main(String[] args) {
        String[] cars = splitCarName(inputCarName());
        List<Car> carArr = new ArrayList<>();
        if(isValidate(cars)){
            createCars(cars, carArr);
        }
        int number = inputNumber();
    }
}
