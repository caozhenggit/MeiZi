package com.caozheng.xfastmvp.kit;

import android.text.TextUtils;

/**
 * @author caozheng
 * @date 2017/10/28
 * <p>
 * describe: 随机
 */

public class RandomKit {

    public static final String NUMBERS_AND_LETTERS = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String NUMBERS = "0123456789";
    public static final String LETTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String CAPITAL_LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String LOWER_CASE_LETTERS = "abcdefghijklmnopqrstuvwxyz";

    /**
     * 随机生成指定长度字符
     * @param length
     * @return
     */
    public static String getRandomNumbersAndLetters(int length) {
        return getRandom(NUMBERS_AND_LETTERS, length);
    }

    /**
     * 随机生成指定长度数字
     * @param length
     * @return
     */
    public static String getRandomNumbers(int length) {
        return getRandom(NUMBERS, length);
    }

    /**
     * 随机生成指定长度大小写字母
     * @param length
     * @return
     */
    public static String getRandomLetters(int length) {
        return getRandom(LETTERS, length);
    }

    /**
     * 随机生成指定长度大写字母
     * @param length
     * @return
     */
    public static String getRandomCapitalLetters(int length) {
        return getRandom(CAPITAL_LETTERS, length);
    }

    /**
     * 随机生成指定长度小写字母
     * @param length
     * @return
     */
    public static String getRandomLowerCaseLetters(int length) {
        return getRandom(LOWER_CASE_LETTERS, length);
    }

    public static String getRandom(String source, int length) {
        return TextUtils.isEmpty(source) ? null : getRandom(source.toCharArray(), length);
    }

    public static String getRandom(char[] sourceChar, int length) {
        if (sourceChar == null || sourceChar.length == 0 || length < 0) {
            return null;
        }

        StringBuilder str = new StringBuilder(length);
        java.util.Random random = new java.util.Random();
        for (int i = 0; i < length; i++) {
            str.append(sourceChar[random.nextInt(sourceChar.length)]);
        }
        return str.toString();
    }

    /**
     * 获取指定随机数
     * @param max
     * @return
     */
    public static int getRandom(int max) {
        return getRandom(0, max);
    }

    /**
     * 获取指定随机数
     * @param min
     * @param max
     * @return
     */
    public static int getRandom(int min, int max) {
        if (min > max) {
            return 0;
        }
        if (min == max) {
            return min;
        }
        return min + new java.util.Random().nextInt(max - min);
    }
}
