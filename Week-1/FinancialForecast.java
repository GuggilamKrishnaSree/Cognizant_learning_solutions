//Recursion
//Recursion is a technique where a complex problem is solved by dividing it into smaller instances of itself until a base case is reached, i.e. the problem becomes undivisible.

import java.util.*;

public class FinancialForecast {

    // Recursive method to calculate future value
    public static double forecastValue(double pValue, double rate, int years) {
        if (years == 0) return pValue; // base case
        return (1 + rate) * forecastValue(pValue, rate, years - 1);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        
        double pValue, rate, futureValue;
        int years = 5;

        System.out.print("Enter the present value of the stock: ");
        pValue = sc.nextDouble();
        System.out.print("Enter the growth rate of the stock: ");
        rate = sc.nextDouble();
        System.out.print("Enter the no.of.years, to forecast the stock value: ");
        years = sc.nextInt();

        System.out.println("Predicting future value using normal recursive method");
        futureValue = forecastValue(pValue, rate, years);
        System.out.printf("Future value after %d years: Rs. %.2f\n", years, futureValue);

        System.out.println("Predicting future value using iterative method");
        futureValue = forecastIterative(pValue, rate, years);
        System.out.printf("Future value after %d years: Rs. %.2f\n", years, futureValue);

        System.out.println("Predicting future value using memoization method");
        HashMap<Integer,Double> map = new HashMap<>();
        futureValue = forecastMemo(pValue, rate, years,map);
        System.out.printf("Future value after %d years: Rs. %.2f\n", years, futureValue);
        
        sc.close();
    }
    
    //Optimization Option1: Iterative technique.
    public static double forecastIterative(double pValue, double rate, int years) {
        int i;
        double result = pValue;
        
        for (i = 0; i < years; i++) {
             result *= (1 + rate);
        }

        return result;
    }

    //Optimization Technique2: Memoization(Dynamic Programming)
    public static double forecastMemo(double pValue, double rate, int years,HashMap<Integer,Double> map) {
        if (years == 0) return pValue;
        if (map.containsKey(years)) return map.get(years);

        double result = (1 + rate) * forecastMemo(pValue, rate, years - 1,map);
        map.put(years, result);
        return result;
    }

}

//Time Complexity of the above recursive code:
// T(n) = T(n - 1) + O(1) → O(n)
// ---> One recursive call per year

//Problem with recursion.
// Recursive stack may overflow if the value of n, i.e, years in this case becomes large.
// As the value of n(years) increases, a lot of redundant calls to subproblems are made thus increasing the time and space complexity of the algorithm. 

//Optimization Options:
//1. Use iterative methods
    // ---> Time Complexity: O(n)
    // ---> Space Complexity: O(1) — avoids recursion stack
//2. Use memoization a Dynamic programming technique.
   // ---> Time complexity: O(n) - due to memoization of subproblems
   // ---> Space Complexity: O(2 * n) => O(n) - 'n' for memoization cache and 'n' for recursive stack.