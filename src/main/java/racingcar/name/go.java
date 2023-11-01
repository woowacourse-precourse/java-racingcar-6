package racingcar.name;

import java.util.Random;
import java.util.Scanner;
import static camp.nextstep.edu.missionutils.Randoms;

import racingcar.name.Name;

public class go {
    public int WhatIsNumber() {
        int number = Randoms.pickNumberInRange(0,9);
        return number;
    }

    public int getRepeat() {
        System.out.println("시도할 회수는 몇회인가요?");
        Scanner scanner = new Scanner(System.in);
        String repeatNumber = scanner.nextLine();
        System.out.println(repeatNumber);
        int check = 0;
        try {
            check = Integer.parseInt(repeatNumber);
        }
        catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 회수를 잘못 입력하셨습니다.");
        }
        return check;
    }
}
