package racingcar;
import camp.nextstep.edu.missionutils.Console;
public class Controller {
    public int tryNumber(){
        String tryNumber = Console.readLine();
        numbersizeError(tryNumber);
        return Integer.parseInt(tryNumber);
    }

    public void numbersizeError(String tryNumber) {
        int inputNumber = Integer.parseInt(tryNumber);

        if (inputNumber <= 0) {
            throw new IllegalArgumentException(ExceptionError.numbersizeError);
        }
    }
}




