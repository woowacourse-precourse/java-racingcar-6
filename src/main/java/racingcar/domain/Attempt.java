package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;

public class Attempt {
    public int attemptNum() {
        System.out.println("시도할 회수는 몇회인가요?");
        int attemptNum;
        String inputNum = Console.readLine();

        attemptNum = checkInt(inputNum);

        return attemptNum;
    }

    public int checkInt(String inputNum) {
        try {
            int num = Integer.parseInt(inputNum);

            checkNatural(num);
            return num;

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    public int checkNatural(int num) {
        try {
            if(num < 1)
                throw new IllegalArgumentException("1이상의 수를 입력해주세요.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            throw e;
        }
        return num;
    }
}
