package racingcar.model;

import org.mockito.internal.configuration.FieldAnnotationProcessor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Name {

    public static final int CAR_NAME_LENGTH = 5;
    public void isValid(List<String> playerNames) {
        for (Object playerName : playerNames){
            if (playerName.toString().length() > CAR_NAME_LENGTH){
                throw new IllegalArgumentException();
            }
        }
    }
}
