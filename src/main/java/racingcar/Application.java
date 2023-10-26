package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<String> cars=inputCars();
    }
    public static List<String> inputCars(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        List<String> cars=new ArrayList<>();

        String car=camp.nextstep.edu.missionutils.Console.readLine();
        String checkCar[]=car.split(",");

        for(int i=0;i<checkCar.length;i++){
            if(checkCar[i].length()<=5)
                cars.add(checkCar[i]);
            else if (checkCar[i].length()>5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능하다");
            }
        }
        return cars;
    }
}
