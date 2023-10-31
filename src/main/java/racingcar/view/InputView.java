package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputView {
    public List<String> inputCarName(){
        Scanner in = new Scanner(System.in); // Scanner 객체 생성
        String playerString = in.nextLine();

        //String playerString = Console.readLine();
        List<String> inputCarNameList = Stream.of(playerString.split(","))
                .map(String::trim).collect(Collectors.toList());

        return inputCarNameList;
    }
}
