package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        List<String> input_cars = inputCars(); //쉼표 구분 경주할 자동차 이름 입력
        Map<String, Integer> cars = storeCars(input_cars); //입력 값 검증 후 저장

        System.out.println("시도할 횟수는 몇회인가요?");
        int N = inputN(); //시도할 횟수

        System.out.println("\n실행 결과");
        racing(cars, N); //자동차 경주

        printWinners(cars); //가장 많은 거리를 간 자동차 출력
    }

    public static List<String> inputCars() {
        String input = Console.readLine();
        return List.of(input.split(",")); //쉼표 기준으로 분할한 자동차 이름 리스트
    }

    public static Boolean checkCarNameLength(String car_name) {
        return car_name.length() > 5; //자동차 이름 5글자 초과 체크
    }

    public static Boolean checkCarDuplication(Map<String, Integer> cars, String car) {
        return cars.containsKey(car); //자동차 중복 체크
    }

    public static Map<String, Integer> storeCars(List<String> input_cars) {
        Map<String, Integer> cars = new HashMap<>();
        for (String car : input_cars) {
            //자동차 이름이 5글자 이하가 아니거나 중복된다면 IllegalArgumentException
            if (checkCarNameLength(car) || checkCarDuplication(cars, car)) {
                throw new IllegalArgumentException();
            }
            //put(키, 값)키, 값 저장, get(키) 값 가져옴, remove(키) 값 삭제
            cars.put(car, 0); //자동차와 거리 초기 값 0 저장
        }
        return cars; // (자동차, 0)으로 맵핑된 map
    }

    public static Boolean checkN(String N) {
        //N이 숫자로만 이루어져 있다면 true
        if (N.chars().allMatch(Character::isDigit)) {
            return true;
        }
        return false; //아니라면 false
    }

    public static Integer inputN() {
        String N = Console.readLine();
        if (checkN(N)) {
            return Integer.parseInt(N); //정수 N
        }
        throw new IllegalArgumentException(); //정수가 아닐 경우 IllegalArgumentException
    }

    public static Integer randomNumber() {
        return Randoms.pickNumberInRange(0, 9); //0에서 9사이 수 랜덤 생성
    }

    public static Boolean checkRandomNumber(int randomNumber) {
        return randomNumber >= 4; //랜덤 값 4 이상 체크
    }

    public static int addStep(int random_number) {
        //랜덤 값이 4 이상이면 1
        if (checkRandomNumber(random_number)) {
            return 1;
        }
        //랜덤 값이 4 미만이면 0
        return 0;
    }

    public static void racing(Map<String, Integer> cars, int N) {
        for (int i = 0; i < N; i++) { //경주 N번 반복
            for (String car : cars.keySet()) {
                //경주 동안 각 자동차 전진 또는 멈춤
                cars.put(car, cars.get(car) + addStep(randomNumber()));
            }
            printRacing(cars); //경주 결과 출력
        }
    }

    public static void printRacing(Map<String, Integer> cars) {
        String result = "";
        for (String car : cars.keySet()) {
            result += car + " : "; //자동차 이름
            for (int i = 0; i < cars.get(car); i++) {
                result += "-"; //자동차가 이동한 거리를 '-'로 출력
            }
            System.out.println(result); //자동차 이름과 거리 출력
            result = "";
        }
        System.out.println();
    }

    public static void printWinners(Map<String, Integer> cars) {
        int maxCar = Collections.max(cars.values()); //거리 중 가장 큰 값
        List<String> maxCars = new ArrayList<>();
        for (String car : cars.keySet()) {
            if (cars.get(car) == maxCar) {
                maxCars.add(car); //가장 많은 거리를 간 자동차 이름을 리스트에 추가
            }
        }
        //가장 많은 거리를 간 자동차 출력
        System.out.println("최종 우승자 : " + String.join(", ", maxCars));
    }
}