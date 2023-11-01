package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class Application {

    static LinkedHashMap<String, String> generateCar(String[] name) {

        LinkedHashMap<String, String> car = new LinkedHashMap<>();

        // 자동차 이름을 key 값으로, 공백을 value 값으로 할당
        for (int i = 0; i < name.length; i++) {
            car.put(name[i], "");
        }

        return car;
    }

    static LinkedHashMap<String, String> goStop(LinkedHashMap<String, String> car, List<String> carName) {

        // 자동차 수만큼 순회하면서, 4 이상의 수가 뽑히면 key(자동차 이름) 에 해당하는 value 에 '-' 를 더해줌
        for (int i = 0; i < car.size(); i++) {
            int randomNumber = Randoms.pickNumberInRange(0, 9);
            if (randomNumber >= 4) {
                car.put(carName.get(i), car.get(carName.get(i)) + "-");
            }
            System.out.println(carName.get(i) + " : " + car.get(carName.get(i)));
        }

        return car;
    }

    static List<String> findMaxValueCar(LinkedHashMap<String, String> car, List<String> carName) {

        List<String> winner = new ArrayList<>();
        String maxDistance = "";

        // 자동차 수만큼 순회하면서, '-' 가 가장 많이 더해진 value 에 해당하는 key(자동차 이름) 들을 리턴
        for (int i = 0; i < car.size(); i++) {
            String distance = car.get(carName.get(i));
            if (distance.length() > maxDistance.length()) {
                maxDistance = distance;
                winner.clear();
                winner.add(carName.get(i));
            } else if (distance.length() == maxDistance.length()) {
                winner.add(carName.get(i));
            }
        }

        return winner;
    }

    public static void main(String[] args) {

        String[] name;
        int round;
        LinkedHashMap<String, String> car = new LinkedHashMap<>();

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        name = Console.readLine().split(",");

        // 자동차 이름은 5자 이하만 가능
        for (int i = 0; i < name.length; i++) {
            if (name[i].length() > 5) {
                throw new IllegalArgumentException();
            }
        }

        car = generateCar(name);
        List<String> carName = new ArrayList<>(car.keySet());

        System.out.println("시도할 회수는 몇회인가요?");

        try {
            round = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }

        System.out.println("\n실행 결과");

        for (int i = 0; i < round; i++) {
            car = goStop(car, carName);
            System.out.println();
        }

        List<String> winner = findMaxValueCar(car, carName);

        System.out.print("최종 우승자 : ");

        for (int i = 0; i < winner.size(); i++) {
            System.out.print(winner.get(i));
            if (i < winner.size() - 1) {
                System.out.print(", ");
            }
        }
    }
}
