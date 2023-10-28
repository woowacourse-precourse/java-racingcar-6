package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingCar {
    String name;
    List<String> block = new ArrayList<>();
    int blockCount = 0;

    public RacingCar(String name) {
        if(name.length()>5){
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
        this.name = name;
    }

    public String move(int number){
        if (number >= 4) {
            block.add("-");
            blockCount++;
        }
        return name + " : " + printBlock();
    }

    private String printBlock(){
        StringBuilder sb = new StringBuilder();
        for (String s : block) {
            sb.append(s);
        }
        return sb.toString();
    }
}
