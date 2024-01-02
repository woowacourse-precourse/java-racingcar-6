package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Car;
import java.util.ArrayList;
import java.util.Arrays;

public class UserConsole {
    public ArrayList<Car> makingCarList(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carName = Console.readLine();
        if(carName.equals("")){
            throw new IllegalArgumentException();
        }
        ArrayList<String> carNames = new ArrayList<String>(Arrays.asList(carName.split(",")));
        ArrayList<Car> carList = new ArrayList<>();
        if(carNames.size() < 1){
            throw new IllegalArgumentException();
        }
        for(int i=0; i<carNames.size(); i++){
            if(carNames.get(i).length() > 5){
                throw new IllegalArgumentException();
            }
            Car car = new Car(carNames.get(i));
            carList.add(car);
        }
        return carList;
    }

    public int askRounds(){
        System.out.println("시도할 횟수는 몇회인가요?");
        String input = Console.readLine();
        int rounds = Integer.parseInt(input);
        return rounds;
    }

    public static void printRaceStatus(String status){
        System.out.println(status);
    }
}
