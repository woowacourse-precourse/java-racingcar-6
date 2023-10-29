package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
public class Application {
    public static void main(String[] args) {


        String inputCars = View.inputCarName();
        String[] cars = InputValidator.splitCarName(inputCars);
        InputValidator.checkNameLength(cars);
        InputValidator.checkNameNull(cars);


        int gameRound = Integer.parseInt(View.inputRound());

        Car[] carList = Arrays.stream(cars)
                .map(Car::new)
                .toArray(Car[]::new);

        for (int i = 0; i < gameRound; i++) {
            for (Car car : carList) {
                if (decideMove()) {
                    car.moveForward();
                }
                System.out.println(car.toString());
            }
            System.out.println();
        }

        int max = 0;
        for (Car car : carList){
            max = Math.max(car.getCnt(), max);
        }

        int finalMax = max;
        String result = Arrays.stream(carList)
                .filter(car -> car.isMax(finalMax))
                .map(Car::getName)
                .collect(Collectors.joining(", "));

        System.out.println("최종 우승자 : " + result);

    }

    public static int getRandomNumber(){
        return Randoms.pickNumberInRange(0,9);
    }

    public static boolean decideMove(){
        int num = getRandomNumber();
        if (9>= num && num>=4){
            return true;
        } else if (3 >= num && num >= 0) {
            return false;
        }else {
            throw new IllegalArgumentException("랜덤 값 오류");
        }
    }
}

