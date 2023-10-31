package racingcar;

import java.util.Collections;

public class Validation {
    public static final String invalid = "Invalid Argument";
    public Validation(){

    }

    public void inputCheck(Player member){
        numCheck(member);

        for(int i=0;i<member.getSize();i++){
            lengthCheck(member.getName(i));
            dupCheck(member, member.getName(i));
        }
    }

    public void lengthCheck(String name){
        if(name.length()>5){
            throw new IllegalArgumentException(invalid);
        }
    }

    public void dupCheck(Player member, String name){
        if(Collections.frequency(member.getPlayer(), name)>=2){
            throw new IllegalArgumentException(invalid);
        }
    }

    public void numCheck(Player member){
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
