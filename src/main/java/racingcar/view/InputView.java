package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.Car;

import java.util.ArrayList;

import static racingcar.Validation.*;

public class InputView {

    static ArrayList<Car> cars = new ArrayList<>();

    public static String[] InputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.이름은 쉼표(,) 기준으로 구분한다.");
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
        System.out.println("시도할 회수는 몇회인가요?");
        String inputNumber = Console.readLine();
        validateNaturalNumber(inputNumber);
        return Integer.parseInt(inputNumber);
    }


}
