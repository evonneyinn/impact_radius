package com.impact.assignment;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.Test;
import static org.junit.Assert.assertTrue;


/**
 * Unit tests for NumRange class.
 */
public class NumRangeTest 
{
    private static NumRange numRange = new NumRange();
    
    
    @Test
    public void exampleTest()
    {
        String testCase = "1,3,6,7,8,12,13,14,15,21,22,23,24,31";
        String results = numRange.summarizeCollection(numRange.collect(testCase));
        String verify = "1, 3, 6-8, 12-15, 21-24, 31";
    }

    @Test
    public void collectBasicTest()
    {
        String testCase = "1,2,3,4,5";
        ArrayList<Integer> results = (ArrayList<Integer>) numRange.collect(testCase);
        ArrayList<Integer> verify = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));
        assertTrue(results.equals(verify));

    }

    @Test
    public void collectNegTest()
    {
        String testCase = "-1,2,-3,4,-5";
        ArrayList<Integer> results = (ArrayList<Integer>) numRange.collect(testCase);
        ArrayList<Integer> verify = new ArrayList<Integer>(Arrays.asList(-1,2,-3,4,-5));
        assertTrue(results.equals(verify));

    }

    @Test
    public void emptyStringTest()
    {
        String testCase = "";
        ArrayList<Integer> results = (ArrayList<Integer>) numRange.collect(testCase);
        assertTrue(results.size()==0);
    }

    @Test (expected = NumberFormatException.class)
    public void regexTest()
    {
        String testCase = "ab123";
        numRange.collect(testCase);
    }

    @Test
    public void basicSummarizeTest()
    {
        String testCase = "1,2,3,5,4";
        String results = numRange.summarizeCollection(numRange.collect(testCase));
        String verify = "1-3, 5, 4";
        assertTrue(results.equals(verify));
    }

    @Test
    public void duplicateNumSummarizeTest()
    {
        String testCase = "1,1,1,1,1";
        String results = numRange.summarizeCollection(numRange.collect(testCase));
        String verify = "1, 1, 1, 1, 1";
        assertTrue(results.equals(verify));
    }

    @Test
    public void reverseNumSummarizeTest()
    {
        String testCase = "5,4,3,2,1";
        String results = numRange.summarizeCollection(numRange.collect(testCase));
        String verify = "5, 4, 3, 2, 1";
        assertTrue(results.equals(verify));
    }

    @Test
    public void negNumSummarizeTest()
    {
        String testCase = "-5,-6,-3,-2,-1";
        String results = numRange.summarizeCollection(numRange.collect(testCase));
        String verify = "-5, -6, -3--1";
        assertTrue(results.equals(verify));
    }

    @Test
    public void emptySummarizeTest()
    {
        String testCase = "";
        String results = numRange.summarizeCollection(numRange.collect(testCase));
        String verify = "";
        assertTrue(results.equals(verify));
    }

    @Test
    public void singularNumSummarizeTest()
    {
        String testCase = "1";
        String results = numRange.summarizeCollection(numRange.collect(testCase));
        String verify = "1";
        assertTrue(results.equals(verify));
    }
}
