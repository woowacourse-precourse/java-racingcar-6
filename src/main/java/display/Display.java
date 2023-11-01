/**
 * @Package_name : display
 * @Interface_name : Display
 * <p>
 * Create Date : 2023-10-31
 * Create User : 정은채
 */
package display;

public interface Display {
    /**
     * Description : String 입력
     *
     * @return : String
     * @Method : input()
     */
    public String input();

    /**
     * Description : String 출력
     *
     * @param : String print
     * @Method : output()
     */
    public void output(String print);
}