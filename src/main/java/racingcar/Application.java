package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

class Car {
    String name;
    int number_go;

    Car(String name) {
        this.name = name;
        this.number_go = 0;
    }

    void go() {
        int random_number = Randoms.pickNumberInRange(0,9);
        if(random_number >= 4) {
            number_go++;
        }
    }

    String get_Name() {
        return name;
    }

    int get_go() {
        return number_go;
    }

    void print_go() {
        System.out.print(name + " : ");
        for(int i=0; i<number_go; i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = readLine();
        System.out.println(input);
        List<String> name_list = List.of(input.split(","));
        List<Car> car_list = new java.util.ArrayList<>(List.of());

        for(String name : name_list) {
            car_list.add(new Car(name));
        }

        System.out.println("시도할 회수는 몇회인가요?");
        int count = Integer.parseInt(readLine());
        System.out.println(count);

        System.out.println("\n실행 결과");

        for(int i=0; i<count; i++) {
            for(Car car : car_list) {
                car.go();
                car.print_go();
            }
            System.out.println();
        }
        int number_win = 0;
        for(Car car : car_list) {
            int tmp = car.get_go();
            if(number_win < tmp) {
                number_win = tmp;
            }
        }

        StringBuilder result = new StringBuilder("최종 우승자 : ");
        for(Car car : car_list) {
            if(car.get_go() == number_win) {
                result.append(car.get_Name()).append(", ");
            }
        }
        result.setLength(result.length() - 2);
        System.out.print(result);
    }
}
