package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class User {

    public String[] initCarList() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carList = Console.readLine();

        String[] carArray = carList.split(",");
        validateCarArray(carArray);

        return carArray;
    }

    public int initCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        String countStr = Console.readLine();
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

    private void validateCarArray(String[] carArray) {
        for (String carName : carArray) {
            int nameLength = carName.length();
            if (nameLength > 5) {
                throw new IllegalArgumentException();
            }
        }
    }

}
