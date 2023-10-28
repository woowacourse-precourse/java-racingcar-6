package racingcar.controller.distinguish;

public class distinguishName implements Distinguish {
    @Override
    public void distinguish(String nameList){
        for(String name : nameList.split(",")){
            if(name.length() > 5){
                throw new IllegalArgumentException("이름 중 5글자가 넘어가는 이름이 존재합니다.");
            }
        }
    }
}
