package racingcar.service;

import camp.nextstep.edu.missionutils.Console;
import racingcar.view.PrintAll;
public class InputTryNumber {
    PrintAll printAll = new PrintAll();

    public int getTryNumber(){
        printAll.inputTryNumberPrint();
        String tryNumber = Console.readLine();
        //유효성 검사
        return Integer.parseInt(tryNumber);
    }


    //유효성 검사
    //int로 변환해서 저장

}
