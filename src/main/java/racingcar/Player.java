package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Player {

    public List<Car> getCarList(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();

        List<String> cars = splitName(input);
        validateName(cars);

        return strToCar(cars);
    }

    public int getTimes(){
        System.out.println("시도할 회수는 몇회인가요?");
        String times = Console.readLine();
        return strToInt(times);
    }

    public List<String> splitName(String names){
        return Arrays.asList(names.split(","));
    }

    public int strToInt(String str){
        return Integer.parseInt(str);
    }

    public List<Car> strToCar(List<String> cars){
        List<Car> result = new ArrayList<>();
        for(int i=0;i<cars.size();i++){
            Car car = new Car(cars.get(i));
            result.add(car);
        }
        return result;
    }

    public void validateName(List<String> names){

        for(int i=0;i<names.size();i++){
            if(names.get(i).length()>5){
                throw  new IllegalArgumentException("The name must not be more than 5 characters.");
            }
        }

    }

}