package racingcar;

import java.util.ArrayList;

public class Input {

    private ArrayList<String> nameList;
    private Check validation;
    public Input(){
        nameList = new ArrayList<>();
        validation = new Check();
    }

    public ArrayList<String> getNameList(String input){
        validation.checkNameSize(input);
        String[] strArr = input.split(",");
        for(int i=0; i<strArr.length; i++){
            nameList.add(strArr[i]);
        }
        return nameList;
    }
}
