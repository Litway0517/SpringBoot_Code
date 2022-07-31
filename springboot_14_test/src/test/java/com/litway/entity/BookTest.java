package com.litway.entity;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.regex.Pattern;


/**
 * @date 2022/07/18
 */
class BookTest {

    @Test
    public void test() {
        String s = "图文编号 " + "254345345" + " 已经存在, 请重新操作. ";
        System.out.println(s.contains("254345345"));
    }

    /**
     * 助记符用到的函数
     * @param chinese 中文字符串
     * @return 中文字符串 -> ZWZFC
     */
    public static String ToFirstChar(String chinese){
        String pinyinStr = "";
        char[] newChar = chinese.toCharArray();  //转为单个字符
        HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();
        defaultFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        for (int i = 0; i < newChar.length; i++) {
            if (newChar[i] > 128) {
                try {
                    pinyinStr += PinyinHelper.toHanyuPinyinStringArray(newChar[i], defaultFormat)[0].charAt(0);
                } catch (BadHanyuPinyinOutputFormatCombination e) {
                    e.printStackTrace();
                }
            }else {
                pinyinStr += newChar[i];
            }
        }
        return pinyinStr;
    }

    @Test
    public void testPinyin() {
        System.out.println(ToFirstChar("0125asd测试A12"));
    }

    @Test
    public void testReg() {
        String reg = "^[1-9](\\d{0,4})((\\.\\d{0,6})?)$";
        // 这个BigDecimal不能直接转换成float
        BigDecimal bigDecimal = new BigDecimal("000012345.123456");
        System.out.println(bigDecimal);
        System.out.println(Pattern.matches(reg, bigDecimal.toString()));
    }




}
