package com.rd.agergia.util;

/**
 * 字符串相关公共类
 * @author wangxj Create By 2013-7-18 下午2:16:23
 */
public class StringUtil {
  /**
   * 是否为null
   * @param str
   * @return
   */
  public static boolean isEmpty(String str) {
    return str == null || str.length() == 0;
  }

  /**
   * 不为null
   * @param str
   * @return
   */
  public static boolean isNotEmpty(String str) {
    return !StringUtil.isEmpty(str);
  }

  /**
   * 是否为空（包括null）
   * @param str
   * @return
   */
  public static boolean isBlank(String str) {
    int strLen;
    if (str == null || (strLen = str.length()) == 0) {
      return true;
    }
    for (int i = 0; i < strLen; i++) {
      if ((Character.isWhitespace(str.charAt(i)) == false)) {
        return false;
      }
    }
    return true;
  }

  /**
   * 不为空
   * @param str
   * @return
   */
  public static boolean isNotBlank(String str) {
    return !StringUtil.isBlank(str);
  }

  /**
   * 字符串去空
   * @param str
   * @return
   */
  public static String trim(String str) {
    return str == null ? null : str.trim();
  }

  /**
   * 字符串去null
   * @param str
   * @return
   */
  public static String trimToNull(String str) {
    String ts = trim(str);
    return isEmpty(ts) ? null : ts;
  }

  /**
   * 比较字符串
   * @param str1
   * @param str2
   * @return
   */
  public static boolean equals(String str1, String str2) {
    return str1 == null ? str2 == null : str1.equals(str2);
  }

  /**
   * 字符串是否包含
   * @param str
   * @param searchStr
   * @return
   */
  public static boolean contains(String str, String searchStr) {
    if (str == null || searchStr == null) {
      return false;
    }
    return str.indexOf(searchStr) >= 0;
  }
  
  /**
   * 是否是数字
   * @param str
   * @return
   */
  public static boolean isNumeric(String str) {
    if (str == null) {
        return false;
    }
    int sz = str.length();
    for (int i = 0; i < sz; i++) {
        if (Character.isDigit(str.charAt(i)) == false) {
            return false;
        }
    }
    return true;
}
}
