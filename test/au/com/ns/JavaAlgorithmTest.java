package au.com.ns;

import java.math.BigInteger;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author SM
 * Unit Test Class for the Java Algorithm Implementation
 */
public class JavaAlgorithmTest {

    private JavaAlgorithm javaAlgorithm;

    @Before
    public void setUp(){
        javaAlgorithm = new JavaAlgorithm();
    }

    @Test
    public void testCompareTwoSolutionTypes(){
        BigInteger n = new BigInteger("5");
        BigInteger c = new BigInteger("2");
        BigInteger sumRecursion = javaAlgorithm.getSum(n, c, SolutionType.RECURSION);
        BigInteger sumForLoop = javaAlgorithm.getSum(n, c, SolutionType.LOOP);
        Assert.assertEquals(new BigInteger("21"), sumRecursion);
        Assert.assertEquals(new BigInteger("21"), sumForLoop);
    }

    @Test
    public void with5And2shouldReturn21(){
        BigInteger n = new BigInteger("5");
        BigInteger c = new BigInteger("2");
        BigInteger sum = javaAlgorithm.getSum(n, c, SolutionType.LOOP);
        Assert.assertEquals(new BigInteger("21"), sum);
        printMessage("Sample - With  i=5 and c=2, sum is : ", sum);
    }

    @Test
    public void with100And10(){
        BigInteger n = new BigInteger("100");
        BigInteger c = new BigInteger("10");
        BigInteger sum = javaAlgorithm.getSum(n, c, SolutionType.LOOP);
        Assert.assertEquals(new BigInteger("513946235090696089113"), sum);
        printMessage("Question 1 - With  i=100 and c=10, sum is : ", sum);
    }

    @Test
    public void with1000000And200(){
        BigInteger n = new BigInteger("1000000");
        BigInteger c = new BigInteger("200");
        BigInteger sum = javaAlgorithm.getSum(n, c, SolutionType.LOOP);
        String firstTenDigits = sum.toString().substring(0, 10);
        Assert.assertEquals("4876116127", firstTenDigits);
        printMessage("Question 2 - With  i=1000000 and c=200, first 10 digits are : ", new BigInteger(firstTenDigits));
    }

    private void printMessage(String message, BigInteger num) {
        System.out.println(message + num);
    }
}