package racingcar.service.output;

import java.util.ArrayList;
import java.util.List;

public class ResultList {
    private List<String> results;


    public ResultList() {
        this.results = new ArrayList<>();
    }
    public List<String> getResults(){
        return this.results;
    }
}
