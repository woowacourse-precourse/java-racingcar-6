package racingcar.view;

import java.util.Map;
import java.util.List;

public class Output {
    public static void show_Mid_Result() {
        System.out.println("\n실행 결과");
    }

    public static void show_Mid_Name(Map<String, Integer> map) {
        for (String key : map.keySet()) {
            System.out.print(key + " : ");
            show_Mid_Status(map, key);
        }
        System.out.println();
    }

    public static void show_Mid_Status(Map<String, Integer> map, String key) {
        for (int i = 0; i < map.get(key); i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public static void show_Final_Result() {
        System.out.print("최종 우승자 : ");
    }

    public static void show_Winners(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
            if (i != list.size() - 1) {
                System.out.print(", ");
            }
        }
    }
}
