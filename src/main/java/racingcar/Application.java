package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        List<String> inputCars = inputCars();
        Map<String, Integer> cars = storeCars(inputCars);
        int N = inputN();
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
}
