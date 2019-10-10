package com.mzl.hash;

import java.util.HashMap;
import java.util.Map;

public class TitleToNumber {

    public int titleToNumber(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int res = 0;
        int len = s.length();
        for (int i = 0; i < len; i++) {
           res += (int)(getNumber(s.charAt(i)) * Math.pow(26, len -1 - i));
        }
        return res;
    }
    private int getNumber(char a) {
        return a - 'A' +1;
    }
}
