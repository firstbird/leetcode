package com.mzl.string;

public class IsPalindrome {

    public boolean isPalindrome(String s) {
        if (s.equals("")) {
            return true;
        }
        String newStr = s.replaceAll("[^a-zA-Z0-9]","");
        if (newStr.equals("")) {
            return true;
        }
        newStr = newStr.toLowerCase();
        System.out.println(newStr);
        int leftEnd = newStr.length()/2;
        int rightStart = leftEnd;
        if (newStr.length() % 2 != 0) {
            rightStart += 1;
        }
        return new StringBuilder(newStr.substring(0, leftEnd)).reverse().toString().equals(newStr.substring(rightStart, newStr.length()));
    }
}
