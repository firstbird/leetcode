package com.mzl.string;

public class ReverseString {
    public void reverseString(char[] s) {
        if (s.length == 0) {
            return;
        }
        int i = 0;
        int j = s.length - 1;
        char tmp;
        while (i < j) {
            tmp = s[i];
            s[i] = s[j];
            s[j] = tmp;
            i++;
            j--;
        }
    }
}
