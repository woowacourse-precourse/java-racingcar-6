package racingcar.validation;

import java.util.Arrays;
import java.util.HashSet;

public class Validator {
    private final Integer NAME_LENGTH=5;

    public void lengthValidate(String[] players) {
        Arrays.stream(players)
                .filter(player -> player.length() > NAME_LENGTH)
                .findAny()
                .ifPresent(s->{
                    throw new IllegalArgumentException(ErrorMessage.LENGTH_OVER.getMessage());
                });
    }

    public void duplicatedName(String[] players) {
        HashSet<String> hashSet = new HashSet<>();
        Arrays.stream(players)
                .forEach(player->{
                    hashSet.add(player);
                });

        if (players.length != hashSet.size()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATED_NAME.getMessage());
        }
    }

    public void emptyName(String[] players) {
        Arrays.stream(players)
                .forEach(player->{
                    if(player.trim().isEmpty()){
                        throw new IllegalArgumentException(ErrorMessage.EMPTY_NAME.getMessage());
                    }
                });
    }

    public Integer isNumber(String attempt) {
        try{
            Integer num = Integer.parseInt(attempt);

            if(num<0) throw new IllegalArgumentException(ErrorMessage.NOT_POSITIVE_NUMBER.getMessage());

            return num;
        }catch (NumberFormatException e){
            throw new IllegalArgumentException(ErrorMessage.NOT_NUMBER.getMessage());
        }
    }
}
