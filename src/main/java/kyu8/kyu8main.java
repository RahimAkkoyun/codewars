package kyu8;

public class kyu8main
{
    public static void main(String[] args) {
        kyu8exercises utility = new kyu8exercises();
        String s = "I love arrays they are my favorite";
        String[] sAry = kyu8exercises.stringToArray(s);
        for(String sc : sAry)
        {
            System.out.println(sc);
        }
    }
}