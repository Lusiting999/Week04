package com.test.week04;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    static List<String> ans = new ArrayList<>();
    public static void main(String[] args) {
        System.out.print("result:" + generateParenthesis(3));
    }

    public static List<String> generateParenthesis(int n) {
        //backtrack(ans, new StringBuilder(), 0, 0, n);
        generate(0, 0, n, "");
        return ans;
    }

    /**
     * 深度优先搜索
     * @param left
     * @param right
     * @param n
     * @param str
     */
    public static void generate(int left, int right, int n, String str) {
        // terminator
        if (left == n && right == n) {
            ans.add(str);
        }
        // proccess current logic

        // drill down
        if (left < n) {
            generate(left + 1, right, n, str + "(");
        }
        if (right < left) {
            generate(left, right + 1, n, str + ")");
        }
        // reverse
    }

    /**
     *  回溯算法
     * @param ans
     * @param cur
     * @param left
     * @param right
     * @param max
     */
    public static void backtrack(List<String> ans, StringBuilder cur, int left, int right, int max) {
        if (cur.length() == max * 2) {
            ans.add(cur.toString());
            return;
        }
        if (left < max) {
            cur.append('(');
            backtrack(ans, cur, left + 1, right, max);
            cur.deleteCharAt(cur.length() - 1);
        }

        if (right < left) {
            cur.append(')');
            backtrack(ans, cur, left, right + 1, max);
            cur.deleteCharAt(cur.length() - 1);
        }
    }
}
