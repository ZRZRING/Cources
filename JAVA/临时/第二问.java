package Java实验6;

import java.util.LinkedList;
import java.util.Scanner;

public class 第二问 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("输入十个数字");
        LinkedList<Integer> ll1=new LinkedList<>();
        int a;
        for(a=0;a<10;a++){
            int b=sc.nextInt();
            ll1.add(b);
        }
        for(a=ll1.size()-1;a>=0;a--){
            System.out.print(ll1.get(a)+" ");
        }
    }
}
