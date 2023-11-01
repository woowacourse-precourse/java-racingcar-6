package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Car;

import java.util.ArrayList;

import static racingcar.utils.Validation.*;
import static racingcar.message.InformationMessage.*;

public class InputView {

    static ArrayList<Car> cars = new ArrayList<>();

    public static String[] InputCarNames() {
        System.out.println(ASK_CAR_NAME_MESSAGE);
        String carsString = Console.readLine();
        validateNoComma(carsString); //쉼표 없으면 오류
        String[] carList = carsString.split(",");
        //1자리수~5자리수 사이로 입력 요청
        validateNameLength(carList);
        return carList;
    }
    public static ArrayList<Car> CarNames(){
        for(String car : InputCarNames()){
            Car c = new Car(car);
            cars.add(c); // Car 형태로 빈 어레이 리스트에 담기
        }
        return cars;
    }

    public static Integer InputPlayTime(){
        System.out.println(ASK_Play_Turn_MESSAGE);
        String inputNumber = Console.readLine();
        validateNaturalNumber(inputNumber);
        return Integer.parseInt(inputNumber);
    }


}
