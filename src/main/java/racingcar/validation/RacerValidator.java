package racingcar.validation;

import racingcar.model.Racer;

import static racingcar.type.PlayType.MIN_PARTICIPANT;

public class RacerValidator implements Validator {
    public static final String SEPERATOR = ",";
    @Override
    public boolean support(Class<?> clazz) {
        return Racer.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target) {
        validateSize((String) target);
    }

    public void validateSize(String value){
        if (value == null || value.split(SEPERATOR).length < MIN_PARTICIPANT.getPlayValue()) {
            throw new IllegalArgumentException("참가자가 없습니다.");
        }
    }
}
