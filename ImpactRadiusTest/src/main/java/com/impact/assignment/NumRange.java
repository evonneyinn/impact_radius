package com.impact.assignment;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class NumRange implements NumberRangeSummarizer{
     //collect the input
     @Override
     public Collection<Integer> collect(String input){
         ArrayList<Integer> nums = new ArrayList<Integer>();
         // Empty array list if there is empty string
         if (input.length() == 0) {
             return nums;
         }
         // Verify format of input string
         if (!input.matches("^(-?[1-9]\\d*,)*(-?[1-9]\\d*)$")) {
             throw new NumberFormatException();
         }
         //Splits string on comma and convert to integers
         String str[] = input.split(",");
         for (int i=0; i<str.length; i++){
             nums.add(Integer.parseInt(str[i]));
         }
         return nums;
     }

     //get the summarized string
     @Override
     public String summarizeCollection(Collection<Integer> input){
         // Check for an empty list 
         if (input.size() == 0) {
             return "";
         }
         // Iterate the list with pointer to the left and right of the range
         Iterator<Integer> i = input.iterator();
         String results = "";
         int left = i.next();
         int right = left;
         while(i.hasNext()) {
             int cur = i.next();
             // If the next number is not in order, the range has ended
             if (right+1 != cur) {
                 if (left != right) {
                     results += left + "-" + right + ", ";
                 } else {
                     results += left + ", ";
                 }
                 left = cur;
             }
             right = cur;
         }
         // Account for final range
         if (left != right) {
             results += left + "-" + right;
         } else {
             results += left;
         }
         return results;
     }
 
}