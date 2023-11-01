package racingcar;
import camp.nextstep.edu.missionutils.Console;
public class Controller {
    public int tryNumber(){
        String tryNumber = Console.readLine();
        numbersizeError(tryNumber);
        numberFormatError(tryNumber);
        return Integer.parseInt(tryNumber);
    }

    public void numbersizeError(String tryNumber) {  //0이하의 숫자일 떄 오류
        int inputNumber = Integer.parseInt(tryNumber);

        if (inputNumber <= 0) {
            throw new IllegalArgumentException(ExceptionError.numbersizeError);
        }
    }

    public void numberFormatError(String tryNumber) {  //숫자가 아닐떄 오류
        try {
            int inputNumber = Integer.parseInt(tryNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionError.numberFormatError);
        }
    }
}




