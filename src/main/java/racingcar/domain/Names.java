package racingcar.domain;

import java.util.Arrays;
import java.util.List;

public class Names {
    String names;
    public Names(String names){
       List<String> nameList= Arrays.asList(names.split(",",-1));
       for(int i=0;i< nameList.size();i++){
           nameList.set(i,nameList.get(i).trim());
       }


       this.names=names;
    }

}
