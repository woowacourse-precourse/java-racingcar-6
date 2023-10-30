package racingcar.model;

import java.util.List;

public class ResultList {
    private static ResultList instance;
    private final List<String> resultList;

    public ResultList(List<String> resultList) {
        this.resultList = resultList;
    }

    public static ResultList getInstance(List<String> resultList){
        if(instance == null){
            instance = new ResultList(resultList);
        }
        return instance;
    }
    public void PrintResult(){
        for(String s : resultList){
            System.out.println("s = " + s);
        }
    }
}
