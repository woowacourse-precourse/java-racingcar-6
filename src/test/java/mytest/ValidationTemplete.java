//package mytest;
//
//import java.io.ByteArrayInputStream;
//import java.io.InputStream;
//
//public class ValidationTemplete {
//
//    private static InputStream old = null;
//
//    private ValidationTemplete() {
//    }
//
//    public static void setting(String input)
//    {
//        old = System.in;
//        InputStream in = new ByteArrayInputStream(input.getBytes());
//        System.setIn(in);
//    }
//    public static void after()
//    {
//        System.setIn(old);
//    }
//
//}
