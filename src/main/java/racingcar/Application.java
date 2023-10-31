package racingcar;

import camp.nextstep.edu.missionutils.*;

public class Application {
    public static String[] inputCars(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        String inputStr = Console.readLine();
        String str = inputStr;

        // 쉼표가 아닌 다른 기호가 들어간 경우
        if(!str.replaceAll(",", "").matches("^[a-zA-Z]*$")){
            throw new IllegalArgumentException();
        }

        String[] carName = inputStr.split(",");

        // 자동차 이름이 5자 이상인 경우 Exception 발생
        for(int i = 0; i<carName.length;i++){
            if(carName[i].length()>=5){
                throw new IllegalArgumentException();
            }
        }
        return carName;
    }

    public static void inputTry(){

    }

    public static void moveForward(){

    }

    public static void printResult(){

    }

    public static void main(String[] args) {
        String[] carName = inputCars();
        for(int i =0; i < carName.length; i++){
            System.out.println(carName[i]);
        }
    }
}
