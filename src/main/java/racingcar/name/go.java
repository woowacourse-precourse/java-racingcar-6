package racingcar.name;

import java.util.Random;
import java.util.Scanner;

public class go {
    public int WhatIsNumber() {
        Random random = new Random();
        int number = random.nextInt(10);
        return number;
    }
    public int getRepeat() throws IllegalArgumentException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("시도할 회수는 몇회인가요?");
        String repeat = scanner.next().trim();
        int check = 0;
        try {
            int number = Integer.parseInt(repeat);
            check = 1;
        }
        catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 회수를 잘못 입력하셨습니다.");
        }
        return check;
    }
}
