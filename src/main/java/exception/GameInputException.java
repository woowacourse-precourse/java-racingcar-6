package exception;

import message.GameMessage;

public class GameInputException {

    public GameInputException() {

    }

    public void validateNameLength(String[] names) {
        for(String name : names) {
            if(name.length() > 5) {
                throw new IllegalArgumentException(GameMessage.nameError.getMessage());
            }
        }
    }

    public void validateNumber(String number) {
        if(!number.matches(GameMessage.REGEX.getMessage())) {
            throw new IllegalArgumentException(GameMessage.countError.getMessage());
        }
    }

}
