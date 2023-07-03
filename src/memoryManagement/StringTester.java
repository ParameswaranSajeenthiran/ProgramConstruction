package memoryManagement;

public class StringTester {
    public static void main(String[] args) {
        String s1 = new String ("program"); // creates a String object in heap
        String s4 = new StringBuilder( "program").toString(); // not thread safe
        String s5 = new StringBuffer( "program").toString();// thread safe
        String s2 = "program"; // Checks in String literal pool , if not present creates new and return reference.
        String s3 ="program";
        System.out.println(s3==s4);
    }
}
