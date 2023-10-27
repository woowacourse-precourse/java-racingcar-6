package racingcar;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static racingcar.Car.*;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        List<Car> carList = createCarList();

        int repeatCount = inputNumberOfRepetitions();
        StringBuilder result = moveCar(carList , repeatCount);
        System.out.println(result);

        printFinalWinner(carList);
    }

    public static int inputNumberOfRepetitions() {
        System.out.println("시도할 회수는 몇회인가요?");

        try{
            return Integer.parseInt(readLine());
        } catch(NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력하셔야 합니다.");
        }

    }

}
