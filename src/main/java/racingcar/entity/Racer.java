package racingcar.entity;

import racingcar.property.ValidateType;
import racingcar.validation.ValidateForm;

import java.util.HashMap;
import java.util.Map;

import static racingcar.property.ValidateType.*;
import static racingcar.validation.ValidateForm.*;

public class Racer {
    private static final Map<String,Racer> instance=new HashMap<>();
    private String name;

    private Racer(String name) {
        this.name = name;
    }

    public static Racer getInstance(String name) {
        if (instance.get(name)==null){
            validateRacerName(name);
            return registerRacer(name);
        }
        return instance.get(name);
    }

    public String getName() {
        return this.name;
    }

    private static void validateRacerName(String name){
        validateForValidateType(NAME,name);
    }

    private static Racer registerRacer(String name){
        Racer racer = new Racer(name);
        instance.put(name,racer);
        return racer;
    }
}
