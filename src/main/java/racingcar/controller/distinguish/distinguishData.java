package racingcar.controller.distinguish;

import camp.nextstep.edu.missionutils.Console;

public class distinguishData implements Distinguish {
    @Override
    public String[] distinguishName(String nameList){
        for(String name : nameList.split(",")){
            if(name.length() > 5){
                throw new IllegalArgumentException("이름 중 5글자가 넘어가는 이름이 존재합니다.");
            }
        }
        return nameList.split(",");
    }
    @Override
    public int distinguishNum(String data) {
        try{
            return Integer.parseInt(Console.readLine());
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("제대로 된 숫자가 입력 되지 않았습니다.");
        }
    }
}
