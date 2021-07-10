package p3.String;

public class StringMain {
    public static void main(String[] args) {
        String string1 = "Hello";
        String string2 = string1;
        string1 = "World";
        System.out.println(string1);
        System.out.println(string2);

        String s = "Hello World";
        s.toUpperCase();
        s.substring(6, 11);
        System.out.println(s);
    }
}
