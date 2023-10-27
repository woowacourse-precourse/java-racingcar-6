package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.Car;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Application {

    public static List<Car> cars;

    public static int makeRandomNum() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public static boolean goOrStop(int num) {
        System.out.println(num);
        if (num < 4) {
            return false;
        }

        return true;
    }

    public static void go(int carIndex) {
        int originLength = cars.get(carIndex).getLength();
        cars.get(carIndex).setLength(originLength+1);
    }

    public static void eachCar() {
        for (int j=0; j<cars.size(); j++) {
            int tmpRandNum = makeRandomNum();
            if (goOrStop(tmpRandNum)) {
                go(j);
            }
        }

    }

    public static void print() {
        for (int j=0; j<cars.size(); j++) {
            System.out.print(cars.get(j).getName() + ": ");
            for (int k=0; k<cars.get(j).getLength(); k++) {
                System.out.print("-");
            }
            System.out.println();
        }
    }

    public static int findMaxResult() {
        int max = 0;
        for (int i=0; i<cars.size(); i++) {
            max = Math.max(max, cars.get(i).getLength());
        }

        return max;
    }
    public static void printResult() {

        Collections.sort(cars);

        int max = findMaxResult();

        System.out.print("최종 유성자 : ");
        for (int i=0; i<cars.size(); i++) {
            if (max == cars.get(i).length) {
                System.out.print(cars.get(i).name + ", ");
            } else {
                break;
            }
        }

    }
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] s = Console.readLine().split(",");
        cars = new ArrayList<>();
        for (int i=0; i<s.length; i++) {
            cars.add(new Car(s[i], 0));
        }

        System.out.println("시도할 회수는 몇회인가요?");
        int num = Integer.parseInt(Console.readLine());

        System.out.println("실행 결과");
        for (int i=0; i<num; i++) {
            eachCar();
            print();
            System.out.println();
        }

        printResult();

    }
}
