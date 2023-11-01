package domain.InputView;

import camp.nextstep.edu.missionutils.Console;

import static message.NoticeMessages.*;

public class InputNames {

    public static String[] carInput(){
        System.out.println(INPUT_NAME_MESSAGE);
        String cars= Console.readLine();

        return ParsingInput(cars);
    }

    private static String[] ParsingInput(String cars){
        NameValidiator check= new NameValidiator(cars);
        String[] InputCarNamesArray= cars.split(",");

        check.checkDuplicate(InputCarNamesArray);
        check.checkEmptyorLongNames(InputCarNamesArray);

        return InputCarNamesArray;

    }

}
