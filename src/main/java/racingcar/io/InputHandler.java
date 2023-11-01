package racingcar.io;

import java.util.Scanner;

public class InputHandler {
    private static final Scanner scanner = new Scanner(System.in);

    public static String getCarNames(String message){
        System.out.print(message);
        return scanner.nextLine();
    }


}
