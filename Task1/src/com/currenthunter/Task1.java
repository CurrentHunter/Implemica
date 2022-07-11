package src.com.currenthunter;

import java.util.Scanner;

public class Task1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);    // To get input

        while(true) {                           // To keep program constantly running
            System.out.println("Enter number of brackets:");
            int num = sc.nextInt();

            if (num < 0)
                System.out.println("Please enter not negative integer number");
            else
                System.out.println("Number of regular bracket's sequence is " + getCatalanNumber(num) +"\n");
        }
    }


//    This task is to find Catalan numbers which satisfy the recurrence relations:
//    C(0) = 1
//    C(n) = sum of C(i) * C(n - 1 - i), where i = 0...(n - 1)

    public static int getCatalanNumber(int number){

        int result = 0;

        if(number == 0) return 1;

        for (int i = 0; i < number; i++) {
            result += getCatalanNumber(i) * getCatalanNumber((number - 1) - i);
        }
        return result;
    }
}
