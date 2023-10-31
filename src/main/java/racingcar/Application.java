package racingcar;

import java.util.*;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import org.junit.platform.commons.util.StringUtils;

public class Application {
    public static void main(String[] args)
    {
        /* Get car names */
        System.out.print("Name of the racing cars (distinguish by ','): ");
        String input = Console.readLine();

        /* Parse input (car names) into Arraylist */
        StringTokenizer st1 = new StringTokenizer(input, ",");
        ArrayList<String> cars = new ArrayList<String>();
        while(st1.hasMoreTokens()) cars.add(st1.nextToken());

        System.out.println(cars);

        /* Get number of moves */
        System.out.print("How many times do the cars move?: ");
        input = Console.readLine();
        if (!input.matches("\\d"))
        {
            throw new IllegalArgumentException("숫자를 입력해야 합니다.");
        }
        int moves = Integer.parseInt(input);

        /* Move the cars */
        ArrayList<Integer> moveNum = new ArrayList<Integer>();
        for (int i = 0; i < moves; i++)
        {
            for (int j = 0; j < cars.size(); j++)
            {
                moveNum.add(0);

                /* Move forward if random number is 4 or more */
                if (Randoms.pickNumberInRange(0,9) >= 4)
                {
                    int newValue = moveNum.get(j) + 1;
                    moveNum.set(j, newValue);
                }

                /* Print movement */
                System.out.print(cars.get(j) + " : ");
                for (int k = 0; k < moveNum.get(j); k++)
                {
                    System.out.print("-");
                }
                System.out.println();
            }
            System.out.println();
        }

        /* Print the winner */
        int max = Collections.max(moveNum);
        ArrayList<String> winner = new ArrayList<String>();
        for (int i = 0; i < moveNum.size(); i++)
        {
            if (moveNum.get(i) == max)
            {
                winner.add(cars.get(i));
            }
        }
        System.out.println("The winners: " + String.join(", ",  winner));
    }
}
