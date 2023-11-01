package racingcar.view;


import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputView {

    private static final String START_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";

    private static void getStartMessage(){
        System.out.println(START_MESSAGE);
    }

    public static void getInput(){

        getStartMessage();

        try {
            String playersInput = Console.readLine();
            //exception


            List<String> playersList = makePlayersList(playersInput);

        } catch (IllegalArgumentException e){

            throw new IllegalArgumentException(e.getMessage());

        }
    }

    private static List<String> makePlayersList(String playersInput){


        return Arrays.stream(playersInput.split(",")).toList();

    }
}
