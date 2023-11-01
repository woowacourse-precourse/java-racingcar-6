package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class User {
    public User() {
    }

    public String[] getCarName(){
        String nameInput = Console.readLine();
        String[] inputArr = nameInput.split(",");
        checkError(inputArr);
        return inputArr;

    }

    public int getTryNum() {
        return Integer.parseInt(Console.readLine());
    }

    public void checkError(String[] inputArr){
        for(int i = 0; i < inputArr.length; i++){
            if(inputArr[i].length() > 4) throw new IllegalArgumentException();
        }
    }
}
