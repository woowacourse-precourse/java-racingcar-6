package racingcar;

public class Validation {

    public static final String invalid = "Invalid Argument";
    public Validation(){

    }

    public void inputCheck(Player member){
        numcheck(member);
        for(int i=0;i<member.getSize();i++){
            lengthCheck(member.getName(i));
        }

    }
    public void lengthCheck(String name){
        if(name.length()>5){
            throw new IllegalArgumentException(invalid);
        }
    }

    public void numcheck(Player member){
        if(member.getSize()<=1){
            throw new IllegalArgumentException(invalid);
        }
    }

    public void typeCheck(String game){
        try{
            Integer.parseInt(game);
        }catch(IllegalArgumentException e){
            throw e;
        }
    }
}
