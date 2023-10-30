package racingcar.validator;

import java.util.ArrayList;

public class Util {
    public static ArrayList<String> toArrayList(String carString){
        ArrayList<String> list = new ArrayList<>();
        String[] carArray = carString.split(",");
        for(int i=0;i<carArray.length;i++){
            list.add(carArray[i]);
        }
        return list;
    }
    public static String getDashString(String dash,int repeat){
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<repeat;i++){
            sb.append(dash);
        }
        return sb.toString();
    }
    public static int maxPosition(){
        return 0;
    }
}
