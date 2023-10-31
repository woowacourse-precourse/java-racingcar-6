package Controller;

import Model.GameData;

import java.util.List;

public class Validation {

    public void validationName_check(String name) {
        if(name.replaceAll(" ", "").length() == 0)
            throw new IllegalArgumentException("공백을 이름으로 입력할 수 없습니다.");
        else if(name.length() > 5)
            throw new IllegalArgumentException("자동차 이름의 길이가 5자를 초과했습니다.");
        else if(duplicate_check(name))
            throw new IllegalArgumentException("중복된 이름입니다.");
    }

    public void validationGame_check(String num) {
        if(num.length() == 0)
            throw new IllegalArgumentException("횟수를 입력해야 합니다.");
        else if (!num.matches("-?\\d+")) {
            throw new IllegalArgumentException("유효한 정수가 아닌 문자열을 입력했습니다.");
        }
        else if (Integer.parseInt(num) <= 0) {
            throw new IllegalArgumentException("음수 또는 0은 유효하지 않은 값입니다.");
        }
    }

    public void validation_isEmpty(List<String> carlist) {
        if(carlist.size() == 0)
            throw new IllegalArgumentException("자동차 이름을 입력해야 합니다.");
    }

    private boolean duplicate_check(String name) {
        GameData gameData = new GameData();
        if(gameData.ContainsData(name))
            return true;
        return false;
    }
}
