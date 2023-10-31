package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Player {
    public List<String> member = new ArrayList<>();

    public Player(){
    }

    public List<String> getMember(String members){
        StringTokenizer st = new StringTokenizer(members, ",");
        while(st.hasMoreTokens()){
            member.add(st.nextToken());
        }
        return member;
    }

    public int getSize(){
        return member.size();
    }

    public String getName(int memberNum){
        return member.get(memberNum);
    }
}
