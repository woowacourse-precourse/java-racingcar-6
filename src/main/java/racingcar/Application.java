package racingcar;

import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        List<Car> cars = new ArrayList<Car>();
        List<String> names = askName();
        for (int i = 0; i < 3; i++) {
            cars.get(i).setName(names.get(i));
        }

        int n = askCount();
        for (int i = 0; i < n; i++) {
            play(cars);
        }

        printResult(cars);
    }
    public static void play(List<Car> cars){
        for (int i = 0; i < 3; i++) {
            cars.get(i).tryToMove();
        }
    }

    public static List<String> askName(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n");

        String[] names = readLine().split(",");
        List<String> ret = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            ret.add(names[i]);
        }
        return ret;
    }
    public static int askCount(){
        System.out.println("시도할 회수는 몇회인가요?\n");
        int n = Integer.parseInt(readLine());
        return n;
    }
    public static void printResult(List<Car> cars){

    }

}
