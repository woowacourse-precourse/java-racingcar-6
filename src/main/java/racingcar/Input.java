package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.Scanner;

public class Input {
    public static String inputCarName(){
//        Scanner scanner = new Scanner(System.in);
//        Console.readLine()
        String carName = Console.readLine();

        ErrorExcept.errorRedundant(carName);
        ErrorExcept.errorExcessLength(carName);


        return carName;
    }

    public static int inputGameCount(){
//        Scanner scanner =  new Scanner(System.in);
        int num = Integer.parseInt(Console.readLine());
        return num;
    }

}
