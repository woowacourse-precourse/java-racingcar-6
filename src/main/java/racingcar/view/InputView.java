package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static racingcar.constant.message.ExceptionMessage.INVALID_INPUT_RACING_COUNT_EXCEPTION_MESSAGE;

public class InputView {
    private static final String CAR_NAME_SEPERATOR = ",";
    private static final int RACING_COUNT_MINIMUM = 1;

    public static List<String> inputCarName(){
        //Scanner in = new Scanner(System.in); // Scanner 객체 생성
        //String playerString = in.nextLine();

        String playerString = Console.readLine();

        List<String> inputCarNameList = Stream.of(playerString.split(CAR_NAME_SEPERATOR))
                .map(String::trim).collect(Collectors.toList());

        return inputCarNameList;
    }

    public static Integer inputRacingCount(){
        try{
            //Scanner in = new Scanner(System.in); // Scanner 객체 생성
            //String playerString = in.nextLine();
            
            String playerString = Console.readLine();

            Integer playerNumber = Integer.valueOf(playerString.trim());
            if(playerNumber < RACING_COUNT_MINIMUM){
                throw new NumberFormatException();
            }
            return playerNumber;

        }catch (NumberFormatException e){
            throw new IllegalArgumentException(INVALID_INPUT_RACING_COUNT_EXCEPTION_MESSAGE);
        }

    }

}
