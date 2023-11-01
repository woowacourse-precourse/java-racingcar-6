/**
 * @Package_name : display
 * @Interface_name : Display
 * <p>
 * Create Date : 2023-10-31
 * Create User : 정은채
 */
package display;

import java.util.Scanner;

import utility.Utility;

public class ConsoleDisplay implements Display {

    /**
     * Description : String 콘솔 입력
     *
     * @Method : input()
     * @return : String
     */
    @Override
    public String input() {
        String result = getConsoleInput();
        return result;
    }

    /**
     * Description : utility 이 입력
     *
     * @Method : getConsoleInput()
     * @return : String
     */
    private String getConsoleInput() {
        String result = Utility.campReadline();
        return result;
    }


    /**
     * Description : String 콘솔 출력
     *
     * @Method : output()
     * @param  : string
     */
    @Override
    public void output(String print) {
        putConsoleOutput(print);

    }

    /**
     * Description : 실제 콘솔 출력
     *
     * @Method : putConsoleOutput()
     * @param  : string
     */
    private void putConsoleOutput(String print) {
        System.out.print(print);

    }

}