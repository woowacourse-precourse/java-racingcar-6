package racingcar;

import java.util.ArrayList;

public class Input {

    private ArrayList<String> nameList;
    public Input(){
        nameList = new ArrayList<>();
    }

    public ArrayList<String> getNameList(String input){
        String[] strArr = input.split(",");
        for(int i=0; i<strArr.length; i++){
            nameList.add(strArr[i]);
        }
        return nameList;
    }
}
