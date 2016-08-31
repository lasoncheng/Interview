package onlinecoding;

/**
 * Created by lason on 8/5/16.
 */
public class KMPDemo {
    /**
     *
     * @param s target string.
     * @param p pattern string.
     * @return
     * Time Complexity: O(M*N)
     */
    public boolean comMatch(char []s, char []p){
        int sLen = s.length;
        int pLen = p.length;
        if(pLen > sLen)
            return false;
        int i = 0;
        int j = 0;
        while(i  < sLen){
            while(j < pLen && i < sLen){
                if(s[i] != p[j]){
                    //back.
                    i = i - j + 1;
                    j = 0;
                    break;
                }
                i++;
                j++;
            }
            if(j == pLen)
                return true;
        }
        return false;
    }
    /**
     *
     * @param s  source string.
     * @param p  pattern string.
     * @return whether s contains p.
     * time complexity:O(M+N)
     */
    public boolean kmpMatch(char []s, char []p){
        int sLen = s.length;
        int pLen = p.length;
        int  []next = new int[pLen];
        computeNext(p, next);
        int i = 0;
        int j = 0;
        while(i < sLen){
            //occur not match, set j = next[j]
            //j == -1 means the first char not match;
            if(j == -1 || s[i] == p[j]){
                i++;
                j++;
            }
            //occur not match, set j = next[j]
            else
                j = next[j];
            if(j == pLen)
                return true;
        }
        return false;
    }

    /**
     *
     * @param p pattern string.
     * @param next
     */
    public void computeNext(char []p, int []next){
        int pLen = p.length;
        next[0] = -1;
        int k = -1;
        int j = 0;
        while(j < pLen - 1){
            //k == next[j - 1]
            // k == -1 init status
            if(k == -1 || p[j] == p[k]){
                k++;
                j++;
                next[j] = k;
            }
            else{
                k = next[k];
            }
        }
    }

    public void reOrderArray(int [] array) {
        if(array == null)
            return;
        int oddNum = 0;
        int []tmp = new int[array.length];
        for(int i = 0; i < array.length; i++){
            if(array[i] % 2 != 0)
                oddNum++;
        }
        int k = 0;
        for(int i = 0; i < array.length; i++){
            if(array[i] % 2 != 0)
                tmp[k++] = array[i];
            else
                tmp[oddNum++] = array[i];
        }
        array = tmp;
    }

    public static void main(String []args){
        KMPDemo kmpDemo = new KMPDemo();
//        Scanner scan = new Scanner(System.in);
//        while(scan.hasNextLine()){
//            char []s = scan.nextLine().toCharArray();
//            char []p = scan.nextLine().toCharArray();
//            int []next = new int[p.length];
//            kmpDemo.computeNext(p, next);
//            for(int e: next)
//                System.out.println(e);
//            System.out.println(new KMPDemo().kmpMatch(s,p));
//        }p
       int []arr = {1,2,3,4,5,6,7};
        kmpDemo.reOrderArray(arr);
        for(int e: arr)
            System.out.println(e);
        double a = 1.4300000000;
        double b = 1.4300000001;
        System.out.println(a == b);
    }
}
