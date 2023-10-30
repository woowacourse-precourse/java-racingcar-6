package racingcar;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

    }
    //경주할 자동차 이름 입력
    public static List<Car> insertCarName(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        String[] carName = input.split(",");
        List<Car> cars = new ArrayList<>();
        for(String name : carName){
            if(name.length() > 5){
                throw new IllegalArgumentException();
            }
            cars.add(new Car(name));
        }
        return cars;
    }
}
