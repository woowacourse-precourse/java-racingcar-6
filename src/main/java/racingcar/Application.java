package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.Vector;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNames = Console.readLine();
        String[] carNameList = carNames.split(",");
        Vector<Car> cars = new Vector<Car>();
        try{
            for(String carName:carNameList){
                if(carName.length()>5){
                    throw new IllegalArgumentException();
                }
                Car car = new Car(carName);
                cars.add(car);
            }
            String round = Console.readLine();


















        }catch (IllegalArgumentException e){return;}

    }
}
