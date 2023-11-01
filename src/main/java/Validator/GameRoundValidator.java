package Validator;

import Utility.StringModifier;

public class GameRoundValidator {
    private static GameRoundValidator gameRoundValidator = null;

    private GameRoundValidator() {

    }

    public static GameRoundValidator getInstance() {
        if (GameRoundValidator.gameRoundValidator == null) {
            return GameRoundValidator.gameRoundValidator = new GameRoundValidator();
        }
        return GameRoundValidator.gameRoundValidator;
    }

    public int validateGameRoundAndReturn(String gameRound) {
        return StringValidator.getInstance().validateIsNumberAndReturnAsInt(gameRound);
    }

}
