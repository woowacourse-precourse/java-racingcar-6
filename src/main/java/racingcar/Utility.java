package racingcar;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Vector;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;



public class Utility {
    public static Vector<String> resultName = new Vector<>();
    public static Integer race_number;
    public static Map<String, Integer> nameHash = new LinkedHashMap<String, Integer>();
    public static void get_name(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String names = Console.readLine();
        String[] name_Arr = names.split(",");
        for(String name : name_Arr){
            //System.out.println(name);
            if(name.length() > 5) throw new IllegalArgumentException("이름의 길이가 깁니다.");
            //if(nameHash.containsKey(name.trim())) throw new IllegalArgumentException("중복되는 이름입니다.");
            nameHash.put(name.trim(), 0);
        }
    }
    public static void get_number(){
        System.out.println("시도할 회수는 몇회인가요?");
        try{
            race_number = Integer.parseInt(Console.readLine());
        } catch(NumberFormatException e){
            throw new IllegalArgumentException("유효하지 않은 값입니다. ");
        }

    }
    public static void process_race() {
        for(int i = 0; i < race_number; i++) {
            moveCars();
            printCarPositions();
        }
    }

    private static void moveCars() {
        for (Map.Entry<String, Integer> entry : nameHash.entrySet()) {
            int R = Randoms.pickNumberInRange(0, 9);
            if (R >= 4) {
                Integer v = entry.getValue();
                nameHash.put(entry.getKey(), v + 1);
            }
        }
    }

    private static void printCarPositions() {
        for (Map.Entry<String, Integer> entry : nameHash.entrySet()) {
            System.out.print(entry.getKey() + " : ");
            for (int i = 0; i < entry.getValue(); i++) {
                System.out.print("-");
            }
            System.out.print("\n");
        }
        System.out.print("\n");
    }
    public static void printResult(){
        Integer Max = 0;
        for(Map.Entry<String, Integer> entry : nameHash.entrySet()){
            if(entry.getValue() > Max){
                resultName.clear();
                resultName.add(entry.getKey());
            }
            else if(entry.getValue().equals(Max)){
                resultName.add(entry.getKey());
            }
        }
        String joinedNames = String.join(", ", resultName);
        System.out.println("최종 우승자 : " + joinedNames);
    }
}
