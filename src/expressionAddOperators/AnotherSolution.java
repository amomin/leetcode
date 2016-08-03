package expressionAddOperators;

import java.util.ArrayList;
import java.util.List;

/** Just a few optimizations increases test suite performance dramatically:
 * 
 * * from 720 ms to 103ms
 * * from better than 1.5% of submissions to better than 93% of submission.
 * 
 * Otherwise this solution is identical to the first.
 * 
 * Optimizations:
 * 1. Check that the target value is not too large for the input string
 * e.g. addOperators("123", 1234) will obviously be empty
 * 2. Don't check for product solutions if the target is negative
 * 
 * @author user
 *
 */
public class AnotherSolution {
    
    public List<String> addOperators(String num, int target) {
        List<String> answers = new ArrayList<String>();
        // Products only - only possible if target >= 0 so
        // First optimization - Check that the target value is not too large for the input string
        if (num.length() == 0) return answers;
        if (!tooBigToParse(num)) {
            if (Math.abs(target) > Integer.parseInt(num)) {
                return answers;
            }
        }
        // Second optimization - don't check for product solutions if the target is negative
        if (target >= 0) {
            for (Product p : allProducts(num)) {
                if (p.intValue == target) {
                    answers.add(p.strValue);
                }
            }
        }
        // Split into first half and second half
        // second half is only products
        // expr (+|-) prod = target
        // expr = target (-|+) prod
        for (int i = 1; i < num.length(); i++) {
            String firstExpression = num.substring(0, i);
            String secondExpression = num.substring(i);
            for (Product p : allProducts(secondExpression)) {
                // '+' case:
                for (String s : addOperators(firstExpression, target - p.intValue)) {
                    answers.add(s + "+" + p.strValue);
                }
                // '-' case:
                for (String s : addOperators(firstExpression, target + p.intValue)) {
                    answers.add(s + "-" + p.strValue);
                }
            }
        }
        return answers;
    }
    
    public List<Product> allProducts(String num) {
        int MAXPARSEINT = 10;
        List<Product> answer = new ArrayList<Product>();
        if (num.length() == 0) return answer;
        // SPECIAL CASE - first digit is zero
        if (Integer.parseInt(num.substring(0,1)) == 0) {
            if (num.length() == 1) {
                answer.add(new Product(new int[] {0}));
                return answer;
            }
            for (Product p : allProducts(num.substring(1))) {
                answer.add(new Product(0, p));
            }
            return answer;            
        }
        for (int i  = 1; i < num.length(); i++) {
            if (tooBigToParse(num.substring(0, i))) break;
            int firstNumber = Integer.parseInt(num.substring(0, i));                
            for (Product p : allProducts(num.substring(i))) {
                answer.add(new Product(firstNumber, p));
            }
        }
        if (! tooBigToParse(num)) {
            answer.add(new Product(new int[] {Integer.parseInt(num)}));
        }
        return answer;
    }
    
    public class Product {
        public int intValue;
        public String strValue;

        public Product(int n, Product p) {
            intValue = n * p.intValue;
            strValue = n + "*" + p.strValue;
        }

        public Product(int[] list) {
            intValue = list[0];
            StringBuilder sb = new StringBuilder("" + list[0]);
            for (int i = 1; i < list.length; i++) {
                intValue *= list[i];
                sb.append('*' + list[i]);
            }
            strValue = sb.toString();
        }
    }
    
    private static boolean tooBigToParse(String num) {
        int MAXPARSEINT = 10;
        if (num.length() < MAXPARSEINT) return false;
        if (num.length() > MAXPARSEINT) return true;
        if (num.length() == MAXPARSEINT) {
            if (num.compareTo("" + Integer.MAX_VALUE) > 0) {
                return true;
            }
        }
        return false;
    }

    public static void tst(String num, int target) {
        System.out.println("******* TESTING " + num + ": " + target + " *****************");
        AnotherSolution s = new AnotherSolution();
        List<String> answers = s.addOperators(num, target);
        for (String a : answers) {
            System.out.println(a);
        }
    }
    
    public static void main(String[] args) {
        System.out.println(("" + Integer.MAX_VALUE).length());
        System.out.println("2147483648".compareTo("" + Integer.MAX_VALUE));
        System.out.println("2147483647".compareTo("" + Integer.MAX_VALUE));
        tst("105", 5);
        tst("" + Integer.MAX_VALUE, Integer.MAX_VALUE);
        tst("2147483647", Integer.MAX_VALUE);
        tst("21474836471", Integer.MAX_VALUE);
        tst("21474836471", Integer.MAX_VALUE - 1);
        tst("2147483648", Integer.MAX_VALUE);
    }
}