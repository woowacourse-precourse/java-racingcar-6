package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carsInput = Console.readLine();
        Map<String, String> carList = Arrays.stream(carsInput.split(",")).collect(Collectors.toMap(car -> car, car -> ""));


        for (String car : carList.values()) {
            if (car.length() > 5) throw new IllegalArgumentException("자동차 이름은 5글자 이하로 작성해주세요.");
        }


        System.out.println("시도할 회수는 몇회인가요?");
        String countInput = Console.readLine();
        int count;
        try {
            count = Integer.parseInt(countInput);
            if (count == 0) throw new IllegalArgumentException("0 이외의 숫자를 입력해주세요");

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해주세요.");
        }

        System.out.println("실행 결과");
        for (int i = 0; i < count; i++) {
            for (Map.Entry<String, String> car : carList.entrySet()) {
                int randomNumber = Randoms.pickNumberInRange(0, 9);
                if (randomNumber >= 4) car.setValue(car.getValue() + "-");
                System.out.println(car.getKey() + " : " + car.getValue());
            }
            System.out.println();
        }

        List<String> carNameByKeyDesc = new ArrayList<>(carList.keySet());
        carNameByKeyDesc.sort((value1, value2) -> Integer.compare(carList.get(value2).length(), carList.get(value1).length()));

        System.out.print("최종 우승자 : ");
        String firstWinner = carNameByKeyDesc.get(0);
        int max = carList.get(firstWinner).length();
        System.out.print(firstWinner);

        for (int i = 1; i < carNameByKeyDesc.size(); i++) {
            String carName = carNameByKeyDesc.get(i);
            if (carList.get(carName).length() != max) break;
            System.out.print(", " + carName);
        }
    }
}
