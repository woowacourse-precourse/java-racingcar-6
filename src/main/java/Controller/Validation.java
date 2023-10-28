package Controller;

import Model.GameData;

public class Validation {

    private static final String ErrorLength = "자동차 이름의 길이가 5자를 초과했습니다.";
    private static final String Duplicate = "중복된 이름입니다.";

    public void validation_check(String name) {
        if(name.length() > 5)
            throw new IllegalArgumentException(ErrorLength);
        else if(duplicate_check(name))
            throw new IllegalArgumentException(Duplicate);

    }

    private boolean duplicate_check(String name) {
        GameData gameData = new GameData();
        if(gameData.ContainsData(name))
            return true;
        return false;
    }
}
