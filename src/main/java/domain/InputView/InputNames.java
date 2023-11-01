package domain.InputView;

import camp.nextstep.edu.missionutils.Console;
public class InputNames {

    public static String[] carInput(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
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
