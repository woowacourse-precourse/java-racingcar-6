package racingcar;

import java.util.*;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args)
    {
        /* Get car names */
        System.out.print("Name of the racing cars (distinguish by ','): ");
        String input = Console.readLine();

        /* Get number of moves */
        System.out.print("How many times do the cars move?: ");
        input = Console.readLine();
        if (!input.matches("\\d"))
        {
            throw new IllegalArgumentException("숫자를 입력해야 합니다.");
        }
        int moves = Integer.parseInt(input);
    }
}
