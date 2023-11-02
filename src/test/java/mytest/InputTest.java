package mytest;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.SimpleTimeZone;
import java.util.StringTokenizer;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import racingcar.Service.RaceService;
import racingcar.controller.RaceController;

public class InputTest {
    @DisplayName("시도 회수를 요청했을 때 숫자를 입력했을 때.")
    @Test
    void requestAttemptTrue(){
        //given
        String input="4";
        //then
        assertThat(Integer.parseInt(input)).isEqualTo(4);
    }
    @DisplayName("시도 회수를 요청했을 때 문자를 입력했을 때")
    @Test
    void requestAttemptFalse(){
        //givne
        String input="a1";
        //then
        assertThrows(IllegalArgumentException.class,()->{Integer.parseInt(input);});
    }
    @DisplayName("차이름 요청 시 잘못된 구분자 사용")
    @Test
    void incorrectDelimiter(){
        StringTokenizer st=new StringTokenizer("aaa,bbb.ccc");
        assertThrows(IllegalArgumentException.class,()->{
            while(st.hasMoreTokens()){
                String carName = st.nextToken();
                String[] token=carName.split("[^a-zA-Z0-9]+");
                if(token.length>1){
                    throw new IllegalArgumentException();
                }
            }
        });
    }
    @DisplayName("차이름 요청 시 차 이름이 중복됐을 떄")
    @Test
    void duplicationCarName(){
        StringTokenizer st=new StringTokenizer("aaa,bbb,aaa",",");
        Set<String> carSet=new HashSet<>();

        assertThrows(IllegalArgumentException.class,()->{
            while(st.hasMoreTokens()){
                if(!carSet.add(st.nextToken())){
                    throw new IllegalArgumentException();
                }
            }
        });
    }

}
