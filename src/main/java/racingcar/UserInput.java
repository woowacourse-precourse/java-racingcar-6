package racingcar;
import camp.nextstep.edu.missionutils.Console;

public class UserInput {
    public String[] inputCarName(){
        String input = Console.readLine();
        String[] carName = input.split(",");
        carName = removeBlank(carName);
        checkName(carName);
        return carName;
    }

    private String[] removeBlank(String[] str){
        for(int i = 0; i < str.length; i++){
            str[i] = str[i].trim();
        }
        return str;
    }

    private void checkLength(String[] strings){
        for(int i = 0; i < strings.length; i++){
            if(strings[i].length() > 5){
                throw new IllegalArgumentException("이름은 5글자 이하여야 합니다.");
            }
        }
    }

    private void checkNull(String[] strings){
        if(strings.length == 1 && strings[0] == ""){
            throw new IllegalArgumentException("하나 이상의 이름을 입력해주세요");
        }
    }

    private void checkBlank(String[] strings){
        for(int i = 0; i < strings.length; i++){
            if(strings[i] == ""){
                throw new IllegalArgumentException("공백은 이름이 될 수 없습니다.");
            }
        }
    }

    private void checkName(String[] str){
        checkLength(str);
        checkNull(str);
        checkBlank(str);
    }

    public int inputCount(){
        String input = Console.readLine();
        int number = -1;
        try{
            number = Integer.parseInt(input);
        }
        catch (NumberFormatException ex){
            ex.printStackTrace();
        }
        return number;
    }
}
