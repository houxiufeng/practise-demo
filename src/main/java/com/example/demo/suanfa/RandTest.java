package com.example.demo.suanfa;

/**
 * https://nilzzzz.github.io/2020/08/random/
 */
public class RandTest {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(rand5());
        }
        System.out.println("=================");

        for (int i = 0; i < 10; i++) {
            System.out.println(rand7());
        }
    }

    public static int rand5(){
        int n=(int)(Math.random()*5+1);
        return n;
    }

    public static int rand7(){
        int n,temp1,temp2;
        while(true){
            temp1=rand5();
            temp2=rand5();
            //n是可以取1~25的随机的数。
            n=(temp1-1)*5+temp2;
            //当n>21重新生成，即扔掉n>21的数，这样n只能取1~21
            if(n>21){
                continue;
            }else{
                break;
            }
        }
        //对7取模就能取1~7之间的随机数
        return 1+n%7;
    }

}
