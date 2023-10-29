package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Player {
    public List<String> member = new ArrayList<>();
    public String members;

    public Player(){

    }

    public List<String> getMember(String members){
        StringTokenizer st = new StringTokenizer(members, ",");
        while(st.hasMoreTokens()){
            member.add(st.nextToken());
        }
        return member;
    }

    public void printMembers(){
        for (String player : member){
            System.out.println(player);
        }

    }
}
