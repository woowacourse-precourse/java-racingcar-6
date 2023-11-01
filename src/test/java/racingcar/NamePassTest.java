package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NamePassTest extends NsTest {

    @Test
    void 이름_알파벳_대소문자_검증1() {
        run("TONY,stark", "1");
        assertThat(output()).contains("TONY : ", "stark : ", "최종 우승자 : ");
    }

    @Test
    void 이름_알파벳_대소문자_검증2() {
        run("Tony,Stark", "3");
        assertThat(output()).contains("Tony : ", "Stark : ", "최종 우승자 : ");
    }

    @Test
    void 이름_알파벳_대소문자_검증3() {
        run("iAm,goOd,MAN,a,A", "2");
        assertThat(output()).contains("iAm : ", "goOd : ", "MAN : ", "a : ", "A : ", "최종 우승자 : ");
    }

    @Test
    void 이름_5자_이하_검증1() {
        run("woowa,hello,beast,BOOKS,CoLOr", "4");
        assertThat(output()).contains("woowa : ", "hello : ", "beast : ", "BOOKS : ", "CoLOr : ", "최종 우승자 : ");
    }

    @Test
    void 이름_5자_이하_검증2() {
        run("a,bc,def,ghij,klmno", "4");
        assertThat(output()).contains("a : ", "bc : ", "def : ", "ghij : ", "klmno : ", "최종 우승자 : ");
    }

    @Test
    void 이름_개수_검증1() {
        run("a,b,c,d,e,f,g,h,i,j", "2");
        assertThat(output()).contains("a : ", "b : ", "c : ", "d : ", "e : ", "f : ", "g : ", "h : ", "i : ", "j : ", "최종 우승자 : ");
    }

    @Test
    void 이름_개수_검증2() {
        run("a,b,c,d,e,f,g,h,i", "5");
        assertThat(output()).contains("a : ", "b : ", "c : ", "d : ", "e : ", "f : ", "g : ", "h : ", "i : ", "최종 우승자 : ");
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
