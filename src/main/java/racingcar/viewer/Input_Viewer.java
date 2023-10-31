package racingcar.viewer;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Input_Viewer {
    private static final String SEPARATOR = ",";

    public static List<String> Name_Request(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = readLine();
        List<String> name = Name_Input_Error_Check(input);
        Name_Viewer(name);
        return name;
    }

    private static List<String> Name_Separator(String input){
        return new ArrayList<>(Arrays.asList(input.split(SEPARATOR)));
    }

    private static List<String> Name_Deduplication(List<String> input){
        return input.stream().distinct().toList();
    }

    private static List<String> Name_Input_Error_Check(String input){
        List<String> list  = Name_Separator(input);
        List<String> name_list = Name_Deduplication(list);
        for(String data : name_list){
            Error_Check.Name(data);
        }
        return name_list;
    }

    private static void Name_Viewer(List<String> name){
        String name_viewer = String.join(SEPARATOR, name);
        System.out.println(name_viewer);
    }

    public static int Number_of_Play_Request(){
        System.out.println("시도할 회수는 몇회인가요?");
        String input = readLine();
        int number_of_play = Error_Check.Number(input);
        System.out.println(number_of_play);
        return number_of_play;
    }
}
