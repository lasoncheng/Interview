package javalearn;



import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by lason on 7/30/16.
 */
public class TestDemo {
    public boolean compare(String a, String b){
        int j = 0;
        int k = 0;
        char []s = a.toCharArray();
        char[]t = b.toCharArray();
        for(int i=0; i < t.length; i++){
            for(; j < s.length; j++){
                if(s[j] == t[i]){
                    k++;
                    break;
                }
                else
                    return false;
            }
        }
        if(k == t.length)
            return true;
        else
            return false;

    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        TestDemo main = new TestDemo();
        while (in.hasNextLine()) {//注意while处理多个case
            String  s = in.nextLine();
            String  t = in.nextLine();
            if(main.compare(s, t))
                System.out.println("YES");
            else
                System.out.println("NO");

        }
    }
}
