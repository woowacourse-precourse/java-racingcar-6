package racingcar.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Name {
    public void isValid(List player) {
        for (Object playerName : player){
            if (playerName.toString().length() > 5){
                throw new IllegalArgumentException();
            }
        }
    }
}
