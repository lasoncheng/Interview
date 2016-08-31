package javalearn;

import java.util.Scanner;

/**
 * Created by lason on 7/11/16.
 * String:
 * 1  immutable  //不变性指的是 String 对象一旦生成，则不能再对它进行改变。
 * 2  the different between object string and const string.
 * 3  string in constant pool.
 * 4  StringBuilder and StringBuffer.
 */
public class StringDemo {
    public String sortChar(char []str, int n){
        StringBuilder strBuilder = new StringBuilder();
        for(int i = 0; i < n; i++){
            int k = 1;
            int j = 0;
            while(j < n && k < n){
                while(j < n && !isChar(str[j]))
                    j++;
                while((k < n && !isChar(str[k])) || k <= j)
                    k++;
                if(j < n && k < n){
                    if(compare(str[j],str[k]))
                        swap(str, j, k);
                    j++;
                    k++;
                }

            }
        }
        for(int i = 0; i < n; i++)
            strBuilder.append(str[i]);
        return strBuilder.toString();
    }

    public boolean isChar(char a){
        return  (a >= 'A' && a <= 'Z') || (a <= 'z' && a >= 'a');
    }

    public boolean compare(char a, char b){
        if(a <= 'z' && a >= 'a')
             a -= 32;
        if(b <= 'z' && b >= 'a')
             b -= 32;
        return a > b ? true:false;
    }

    public void swap(char []str, int i, int j){
        char tmp = str[i];
        str[i] = str[j];
        str[j] = tmp;
    }

    public static void main(String []args){
        Scanner scan = new Scanner(System.in);
        while(scan.hasNextLine()){
            char []str = scan.nextLine().toCharArray();
            System.out.println(new StringDemo().sortChar(str, str.length));
        }
    }
}
