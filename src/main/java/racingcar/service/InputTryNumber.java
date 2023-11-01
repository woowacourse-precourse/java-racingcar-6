package racingcar.service;

import camp.nextstep.edu.missionutils.Console;
import racingcar.view.PrintAll;
public class InputTryNumber {

    public int getTryNumber(){
        PrintAll printAll = new PrintAll();

        printAll.inputTryNumberPrint(); //시도할 회수는 몇회인가요?
        String tryNumber = Console.readLine();
        //유효성 검사
        //System.out.println(tryNumber);
        return Integer.parseInt(tryNumber);
    }


    //유효성 검사
    //int로 변환해서 저장

}
