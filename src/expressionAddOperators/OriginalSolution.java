package expressionAddOperators;

import java.util.ArrayList;
import java.util.List;

/**
 * One special case we didn't think of - how to treat a zero.  For example,
 * consider
 * addOperators("105", 5)
 * The test suite wants:
 * ["10-5","1*0+5", "1+0+5"]
 * but not
 * ["10-5","1*0+5", "1+0+5", "1*05"]
 * Not sure I "like" the interpretation given by the tests, but it's certainly valid.
 * 
 * Also, the test case seemed to be a stickler about treating Integer.MAX_VALUE
 * correctly even though in a certain sense this is somewhat arbitrary:
 * 
 * addOperators("21474836471",2147483646) = ["2147483647-1"]
 * but
 * addOperators("21474836481",2147483647) = [""]
 * 
 * but not unreasonable either.
 * 
 * Some possible optimizations:
 * 
 * 1. When checking "products only" space of possible solutions, do so only if the 
 * target >= 0, otherwise this is useless bc we are multiplying non-negative integers.
 * 
 * 2. Stop if product overflows
 * 
 * 3. Stop if the target we are trying to reach is too large - for example, for
 * addOperators("12", 123)
 * 
 * 4. Integer parsing and string building is expensive - use character arrays
 * (got this idea from the discussions).
 * 
 * In any case, this is very much on the slow end of submitted solutions,
 * better than only 1.5% of submissions.  EDIT: see AnotherSolution.java
 * for a significiant improvement using only ideas 1 and 2 above.
 * 
 * @author user
 *
 */
public class OriginalSolution {
    
    public List<String> addOperators(String num, int target) {
        List<String> answers = new ArrayList<String>();
        // Products only
        for (Product p : allProducts(num)) {
            if (p.intValue == target) {
                answers.add(p.strValue);
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
        OriginalSolution s = new OriginalSolution();
        List<String> answers = s.addOperators(num, target);
        for (String a : answers) {
            System.out.println(a);
        }
    }
    
    public static void main(String[] args) {
        tst("105", 5);
        tst("" + Integer.MAX_VALUE, Integer.MAX_VALUE);
        tst("2147483647", Integer.MAX_VALUE);
        tst("21474836471", Integer.MAX_VALUE);
        tst("21474836471", Integer.MAX_VALUE - 1);
        tst("2147483648", Integer.MAX_VALUE);
    }
}