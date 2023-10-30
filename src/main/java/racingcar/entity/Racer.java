package racingcar.entity;

import java.util.HashMap;
import java.util.Map;

public class Racer {
    private static final Map<String,Racer> instance=new HashMap<>();
    private String name;

    private Racer(String name) {
        this.name = name;
    }

    public static Racer getInstance(String name) {
        if (instance.get(name)==null){
            Racer racer = new Racer(name);
            instance.put(name,racer);
            return racer;
        }
        return instance.get(name);
    }

    public String getName() {
        return this.name;
    }
}
