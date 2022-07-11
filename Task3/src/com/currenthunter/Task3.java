package src.com.currenthunter;

import java.math.BigInteger;

public class Task3 {

    public static void main(String[] args) {

        int inputNumber = 100;
        System.out.println("The sum of digits in number 100! is " + calculateSumOfDigits(calculateFactorial(inputNumber)));

    }

    //Method calculates factorial of provided number
    //Result given in BigInteger as Ingeger is not sufficient for 100!
    static BigInteger calculateFactorial(int n){
        BigInteger result = BigInteger.valueOf(1);
        for (int i = 1; i <= n; i++)
            result = result.multiply(BigInteger.valueOf(i));
        return result;
    }

    //Method calculates sum of all digits in provided number
    //Using String to split a number into digits
    static int calculateSumOfDigits(BigInteger number){
        int sum = 0;
        String stringNumber = String.valueOf(number);
        for (int i = 0; i < stringNumber.length(); i++)
            sum += Integer.parseInt(String.valueOf(stringNumber.charAt(i)));
        return sum;
    }
}
