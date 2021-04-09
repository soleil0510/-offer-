package JianZhiOffer;

import java.util.HashMap;
import java.util.Scanner;


/**
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字是重复的。
 * 也不知道每个数字重复几次。请找出数组中任一一个重复的数字。
 * 例如，如果输入长度为7的数组[2,3,1,0,2,5,3]，那么对应的输出是2或者3。存在不合法的输入的话输出-1
 */
public class JZ50 {

    /**
     * hashmap方法：时间复杂度和空间复杂度都是O（n）
     */
    public int duplicate (int[] numbers) {
        int len = numbers.length;
        if (len<=1)
            return -1;
        HashMap<Integer,Boolean> map = new HashMap<Integer, Boolean>();
        for(int i=0;i<len;i++){
            if(map.containsKey(numbers[i])){
                map.put(numbers[i],true);
                return numbers[i];
            }
            else
                map.put(numbers[i],false);
        }
        return -1;
    }

    /**
     *交换方法：时间复杂度On，空间O1
     */
    public int duplicate1 (int[] numbers){
        int len = numbers.length;
        if (len<=1)
            return -1;

        for(int i=0;i<len;i++){
            while(numbers[i]!=i){
                if(numbers[i]==numbers[numbers[i]])
                    return numbers[i];
                int j = numbers[i];
                numbers[i] = numbers[j];
                numbers[j]=j;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        JZ50 jz50 = new JZ50();
        Scanner reader = new Scanner(System.in);
        int n;
        n = reader.nextInt();
        int[] a=new int[100];
        for(int i=0;i<n;i++){
            a[i] = reader.nextInt();
        }
        System.out.println(jz50.duplicate1(a));
    }
}
