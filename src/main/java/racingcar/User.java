package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class User {

    public String[] initCarList() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carList = Console.readLine();

        String[] carArray = validateCarArray(carList);

        return carArray;
    }

    public int initCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        String countStr = Console.readLine();

        int count = validateCount(countStr);

        return count;
    }

    private String[] validateCarArray(String carList) {
        int lastChar = carList.length() - 1;
        if (lastChar < 0
                || carList.charAt(lastChar) == ','
                || !carList.contains(",")) {
            throw new IllegalArgumentException();
        }

        String[] carArray = carList.split(",");

        for (String carName : carArray) {
            int nameLength = carName.length();
            if (nameLength > 5) {
                throw new IllegalArgumentException();
            }
        }

        return carArray;
    }

    private int validateCount(String countStr) {
        int count = 0;

        try {
            count = Integer.parseInt(countStr);
            if (count < 0) {
                throw new Exception();
            }
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }

        return count;
    }

}
