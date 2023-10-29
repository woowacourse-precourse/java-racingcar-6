package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputCars = Console.readLine();
        String[] cars = inputCars.split(",");

        int cnt = (int) Arrays.stream(cars).filter(car -> car.length() >5).count();
        if (cnt > 0){
            throw new IllegalArgumentException();
        }

        System.out.println("시도할 회수는 몇회인가요?");
        int tryCount = Integer.parseInt(Console.readLine());

        Car[] carList = Arrays.stream(cars)
                .map(Car::new)
                .toArray(Car[]::new);

        for (int i = 0; i < tryCount; i++) {
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

