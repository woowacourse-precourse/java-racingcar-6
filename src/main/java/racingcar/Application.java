package racingcar;

import java.util.List;
import java.io.IOException;
import java.util.ArrayList;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Application {

    static class Car {
        String name = "";
        int location = 0;

        public void move(int moveDistance) {
            this.location = this.location + moveDistance;
        }
        public String getName() {
            return this.name;
        }
        public int getLocation() {
            return this.location;
        }
    }

    public static Car[] isCarNameValid(String inp) {
        // 입력에 컴마가 없는 경우
        if (!inp.contains(",")) {
            throw new IllegalArgumentException();
        }

        String CarName;
        String[] ArraysInp = inp.split(",");
        Car[] cars = new Car[ArraysInp.length];

        for (int i = 0; i < ArraysInp.length; i++) {
            CarName = ArraysInp[i];

            // 입력이 빈칸인 경우
            if ((CarName.length() > 5) || (CarName == "" )) {
                throw new IllegalArgumentException();
            }

            cars[i] = new Car();
            cars[i].name = CarName;
        }

        return cars;
    }

    public static int isRacingCountValid(String inp) {
        int racingCount;

        // 입력이 숫자가 아닌 경우
        try {
            racingCount = Integer.parseInt(inp);
        }
        catch (NumberFormatException exp){
            throw new IllegalArgumentException();
        }

        // 입력된 숫자가 0보다 작은 경우
        if (racingCount < 0) {
            throw new IllegalArgumentException();
        }

        return racingCount;
    }

    public static int getRandomNumber(){
        int randomNumber;
        do {
            randomNumber = Randoms.pickNumberInRange(0, 9);
        } while (randomNumber < 4);
            
        return randomNumber;
    }

    public static void printCar(Car car) {
        System.out.printf("%s : ", car.getName());
        for (int i = 0; i < car.getLocation(); i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public static Car[] racing(Car[] cars, int racingCount) {
        while (racingCount > 0) {
            for (int i = 0; i < cars.length; i++) {
                cars[i].move(getRandomNumber());
                printCar(cars[i]);
            }
            System.out.println();

            racingCount = racingCount - 1;
        }

        return cars;
    }

    public static String getChampion(Car[] cars) {
        int maxLocation = 0;
        String champions = "";

        for (int i = 0; i < cars.length; i++) {
            if (cars[i].getLocation() > maxLocation) {
                maxLocation = cars[i].getLocation();
            }
        }

        for (int i = 0; i < cars.length; i++) {
            if (cars[i].getLocation() == maxLocation) {
                champions.join(", ", cars[i].getName());
            }
        }

        return champions;
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String inp;
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        inp = camp.nextstep.edu.missionutils.Console.readLine();
        Car[] cars = isCarNameValid(inp);

        System.out.println("시도할 회수는 몇회인가요?");
        inp = camp.nextstep.edu.missionutils.Console.readLine();
        int racingCount = isRacingCountValid(inp);

        System.out.println("\n실행 결과");
        cars = racing(cars, racingCount);

        System.out.printf("최종 우승자 : %s\n", getChampion(cars));
    }
}
