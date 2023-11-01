package racingcar.view;

import java.util.Map;

public class View {
    public static void show(Description desc){
        show(desc.str);
    }

    public static void show(String str){
        System.out.println(str);
    }

    public static void showCurrentState(Map<String, StringBuilder> racer){
        for(String key: racer.keySet()){
            System.out.println(key + " : " + racer.get(key).toString());
        }
        System.out.println();

    }


}
