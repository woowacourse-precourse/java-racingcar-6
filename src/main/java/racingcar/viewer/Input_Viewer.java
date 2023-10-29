package racingcar.viewer;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Input_Viewer {
    private static final String SEPARATOR = ",";

    public static List<String> Name_Request(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = readLine();
        List<String> list = new ArrayList<String>(Arrays.asList(input.split(SEPARATOR)));
        List<String> list_deduplication = list.stream().distinct().toList();
        for(String data : list_deduplication){
            Error_Check.Name(data);
        }
        String name_viewer = String.join(SEPARATOR, list_deduplication);
        System.out.println(name_viewer);
        return list_deduplication;
    }

    public static int Number_of_Play_Request(){
        System.out.println("시도할 회수는 몇회인가요?");
        String input = readLine();
        int number_of_play = Error_Check.Number(input);
        System.out.println(number_of_play);
        return number_of_play;
    }
}
