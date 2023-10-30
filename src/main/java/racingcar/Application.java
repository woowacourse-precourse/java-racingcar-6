package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    static String inputCarName(){
        return Console.readLine();
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
    public static void main(String[] args) {

    }
}
