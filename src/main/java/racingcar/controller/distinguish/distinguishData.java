package racingcar.controller.distinguish;

import camp.nextstep.edu.missionutils.Console;

public class distinguishData implements Distinguish {
    @Override
    public String[] distinguishName(String nameList){
        String[] nameListToArray = nameList.split(",");
        isNameUnderFive(nameListToArray);
        isAllSpace(nameListToArray);
        return nameListToArray;
    }
    @Override
    public int distinguishNum(String data) {
        try{
            return Integer.parseInt(data);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("제대로 된 숫자가 입력 되지 않았습니다.");
        }
    }
    private void isNameUnderFive(String[] nameListToArray) {
        for(String name : nameListToArray){
            if(name.length() > 5){
                throw new IllegalArgumentException("이름 중 5글자가 넘어가는 이름이 존재합니다.");
            }
        }
    }

    private boolean isAllSpace(String[] nameList){
        for(String name : nameList){
            if (isNameSpace(name)) return true;
        }
        throw new IllegalArgumentException("전부 공백으로 이루어져 있습니다.");
    }

    private boolean isNameSpace(String name) {
        for(Character c : name.toCharArray()){
            if(!Character.isWhitespace(c)){
                return true;
            }
        }
        return false;
    }
}
