package au.com.ns;

import java.math.BigInteger;

/**
 * @author SM
 * Implementation of the problem
 */
public class JavaAlgorithm {

    /**
     *
     * @param n 1 to n (inclusive). e.g. [1,2,3,4,...,n]
     * @param c Preceding c elements
     * @param solutionType - LOOP or RECURSION
     * @return Sum for the given range from 1 to n (inclusive). e.g. [1,2,3,4,...,n] and preceding c elements
     */
    public BigInteger getSum(BigInteger n, BigInteger c, SolutionType solutionType) {

        BigInteger sum = BigInteger.ZERO;
        if(SolutionType.LOOP == solutionType) {
            for (BigInteger i = BigInteger.ZERO; i.compareTo(n) < 0; i = i.add(BigInteger.ONE)) {
                sum = sum.add(calculateProductForLoop(i, c));
            }
        } else if (SolutionType.RECURSION == solutionType) {
            for (BigInteger i = BigInteger.ZERO; i.compareTo(n) < 0; i=i.add(BigInteger.ONE)) {
                sum = sum.add(calculateProductRecursion(i, i.subtract(BigInteger.ONE), c));
            }
        }
        return sum;
    }

    /**
     * Calculates the product using a loop
     * @param i a number in the specified range
     * @param c Preceding c elements
     * @return product for a given value of i and c
     */
    private BigInteger calculateProductForLoop(BigInteger i, BigInteger c){
        BigInteger product = i;
        for(BigInteger num1=c.subtract(BigInteger.ONE), num2=i.subtract(BigInteger.ONE);
            num1.compareTo(BigInteger.ZERO)>0 && num2.compareTo(BigInteger.ZERO)>0;
            num1=num1.subtract(BigInteger.ONE), num2=num2.subtract(BigInteger.ONE)) {
            product = product.multiply(num2);
        }
        return product;
    }

    /**
     * Calculates the product using recursion
     * @param i a number in the specified range
     * @param j calculate from i and used in recursion logic
     * @param c Preceding c elements
     * @return product for a given value of i and c
     */
    private BigInteger calculateProductRecursion(BigInteger i, BigInteger j, BigInteger c) {
        if (j.compareTo(BigInteger.ZERO) < 0) return BigInteger.ZERO;
        if (j.compareTo(BigInteger.ZERO) == 0) return BigInteger.ONE;
        if ((i.subtract(j).compareTo(c)) <= 0){
            return j.add(BigInteger.ONE).multiply(calculateProductRecursion(i, j.subtract(BigInteger.ONE), c));
        } else
            return BigInteger.ONE;
    }
}