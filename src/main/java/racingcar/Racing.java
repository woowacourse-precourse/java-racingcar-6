package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Racing {
    public static RCar[] separateCar(String input) {
        String[] carNames = input.split(",");
        RCar[] cars = new RCar[carNames.length];
        for (int i = 0; i < carNames.length; i++) {
            cars[i] = new RCar(carNames[i].trim());
        }
        return cars;
    }
    
    public static int racingCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        String input = Console.readLine();
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("올바른 숫자를 입력하세요.");
        }
    }
}
