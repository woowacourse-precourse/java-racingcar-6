package racingcar.io;

import java.util.Scanner;
import camp.nextstep.edu.missionutils.Console;
public class InputHandler {
    private static final Scanner scanner = new Scanner(System.in);
    public static String[] getCarNames(String message){
        System.out.print(message);
        return Console.readLine().split(",");
    }
    public static int getTryCount(String message){
        System.out.print(message);
        return Integer.parseInt(Console.readLine());
    }

}
