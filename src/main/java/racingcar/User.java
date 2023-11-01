package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class User {
    public User() {
    }

    public String[] getCarName(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String nameInput = Console.readLine();
        String[] inputArr = nameInput.split(",");
        checkError(inputArr);
        return inputArr;

    }

    public int getTryNum() {
        System.out.println("시도할 회수는 몇회인가요?");
        return Integer.parseInt(Console.readLine());
    }

    public void checkError(String[] inputArr){
        for(int i = 0; i < inputArr.length; i++){
            if(inputArr[i].length() > 4) throw new IllegalArgumentException();
        }
    }
}
