package day7;

import java.util.Random;
import java.util.Scanner;

public class n5 {
    public static void main(String[] args) {
        int[] arr = creatNumber();
        System.out.println("===============");
       /* for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }*/
        System.out.println("===================");
        int[] arr1 = userInputNumber();
        int redconunt = 0;
        int rbuleconunt = 0;
        for (int i = 0; i < arr1.length - 1; i++) {
            int redNumber = arr1[i];
            for (int j = 0; j < arr.length - 1; j++) {
                if (redNumber == arr[j]) {
                    redconunt++;
                    break;
                }
            }
        }
        int buleNumber = arr1[arr.length - 1];
        if (buleNumber == arr[arr.length - 1]) {
            rbuleconunt++;
        }
        if (redconunt == 6 && rbuleconunt == 1) {
            System.out.println("一等奖，1000万");
        } else if (redconunt == 6 && rbuleconunt == 0) {
            System.out.println("二等奖，500万");
        }else if (redconunt == 5 && rbuleconunt == 1){
            System.out.println("三等奖，3000元");
        }else if (redconunt == 5 && rbuleconunt == 0||redconunt == 4 && rbuleconunt == 1){
            System.out.println("四等奖，200元");
        }else if (redconunt == 4 && rbuleconunt == 0||redconunt == 3 && rbuleconunt == 1){
            System.out.println("五等奖，10元");
        }else if (redconunt == 2 && rbuleconunt == 1||redconunt == 1 && rbuleconunt == 1||redconunt == 0 && rbuleconunt == 1){
            System.out.println("六等奖，5元");
        }else {
            System.out.println("谢谢惠顾");
        }
    }
    public static int[] creatNumber() {
        Random r = new Random();
        int[] arr = new int[7];
        for (int i = 0; i < 6; ) {
            int number = r.nextInt(33) + 1;
            boolean flag = contains(arr, number);
            if (!flag) {
                arr[i] = number;
                i++;
            }
        }
        arr[6] = r.nextInt(16) + 1;
        return arr;
    }
    public static boolean contains(int[] arr, int number) {
        for (int i = 0; i < arr.length; i++) {
            if (number == arr[i]) {
                return true;
            }
        }
        return false;
    }
    public static int[] userInputNumber() {
        int[] arr = new int[7];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 6; ) {
            System.out.println("请输入第" + (i + 1) + "个红球号码");
            int red = sc.nextInt();
            if (red >= 1 && red <= 33) {
                boolean flag = contains(arr, red);
                if (!flag) {
                    arr[i] = red;
                    i++;
                } else {
                    System.out.println("红球已存在，请重输");
                }
            } else {
                System.out.println("红球不在范围，请重输");
            }
        }
        System.out.println("请输入篮球号码");
        while (true) {
            int bule = sc.nextInt();
            if (bule >= 1 && bule <= 16) {
                arr[arr.length - 1] = bule;
                break;
            } else {
                System.out.println("篮球超出范围，请重输");
            }
        }
    return arr;
    }

}





