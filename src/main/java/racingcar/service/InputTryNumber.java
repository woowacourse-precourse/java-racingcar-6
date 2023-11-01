package racingcar.service;

import camp.nextstep.edu.missionutils.Console;
import racingcar.view.PrintAll;
import racingcar.service.Exception;
public class InputTryNumber {

    public int getTryNumber(){
        PrintAll printAll = new PrintAll();
        Exception exception = new Exception();
        printAll.inputTryNumberPrint(); //시도할 회수는 몇회인가요?
        String tryNumber = Console.readLine();
        exception.noInputTryNumberException(tryNumber);
        exception.noDigitTryNumberException(tryNumber);
        return Integer.parseInt(tryNumber);
    }



}
