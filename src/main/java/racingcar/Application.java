package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        List<String> input_cars = inputCars();
        Map<String, Integer> cars = storeCars(input_cars);

        System.out.println("시도할 횟수는 몇회인가요?");
        int N = inputN();

        System.out.println("\n실행 결과");
        goOrStop(cars, N);

    }
    public static List<String> inputCars() {
        String input = Console.readLine();
        return List.of(input.split(","));
    }
    public static Boolean checkCarNameLength(String car_name) {
        return car_name.length() > 5;
    }
    public static Map<String, Integer> storeCars(List<String> car) {
        Map<String, Integer> cars = new HashMap<>();
        for (String i : car) {
            if (checkCarNameLength(i)) {
                throw new IllegalArgumentException();
            }
            cars.put(i, 0);  //put(키, 값)키, 값 저장, get(키) 값 가져옴, remove(키) 값 삭제
        }
        return cars;
    }
    public static Integer inputN() {
        return Integer.parseInt(Console.readLine());
    }
    public static Integer randomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }
    public static Boolean checkRandomNumber(int randomNumber) {
        return randomNumber > 3;
    }
    public static int addStep(int random_number) {
        if (checkRandomNumber(random_number)) {
            return 1;
        }
        return 0;
    }
    public static void goOrStop(Map<String, Integer> cars,int N) {
        for (int i = 0; i < N; i++) {
            for (String car : cars.keySet()) {
                cars.put(car, cars.get(car) + addStep(randomNumber()));
            }
            printProcess(cars);
        }
    }
    public static void printProcess(Map<String, Integer> cars) {
        String result = "";
        for (String car : cars.keySet()) {
             result += car + " : ";
            for (int i = 0; i < cars.get(car); i++) {
                result += "-";
            }
            System.out.println(result);
            result = "";
        }
        System.out.println();
    }
}
