package racingcar;

import camp.nextstep.edu.missionutils.Console;
import org.assertj.core.util.Arrays;

import java.util.ArrayList;
import java.util.List;

public class GameView {
//    입력 : 한 줄로 자동차들 입력, 자동차 리스트에 추가 하기.
    public List<Car> inputCars() throws IllegalArgumentException{
        String inputCars = Console.readLine();
        return makeCarList(inputCars);
    }
//    입력 : 게임 횟수
    public int inputNums() throws IllegalArgumentException{
        int num;
        num = Integer.parseInt(Console.readLine());
        return num;
    }
    public List<Car> makeCarList(String inputCars){
        List<Car> carList = new ArrayList<>();
        String[] splitCars = inputCars.split(",");

        // List를 분리하는 다른 방법
        // List<Object> carNames = Arrays.asList(inputCars.split(","));
        for (String splitCar : splitCars) {
            carList.add(new Car(splitCar));
        }

        return carList;
    }
}
