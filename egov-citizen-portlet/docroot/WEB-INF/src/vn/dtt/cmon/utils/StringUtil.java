/*
 * Copyright (c) 2014 by DTT Technology Joint Stock Company (http://dtt.vn/).
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *  http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package vn.dtt.cmon.utils;

/** 
 * String utility class
 * Use this class to pad n character to an existing string
 * 
 * Version: 1.0
 *  
 * History: 
 *   DATE        AUTHOR      DESCRIPTION 
 *  ------------------------------------------------- 
 *  12-Sept-2012  Nam Dinh    Create new
 */
public class StringUtil {
	public static int TRANG_THAI_YEU_CAU_DK_CONG_DAN_DA_CHUNG_THUC = 2;
	
	/**
	 * Adding a sequence of character to an existing string
	 * 
	 * @param str
	 * @param c
	 * @param length
	 * @param rightSide (true: padding to the right, false: padding to the left)
	 * @return
	 */
	public static String pad(String str, char c, int length, boolean rightSide){
		  
		String retstr = "";

		char[] ca = new char[length];
		
		for (int i = 0; i < ca.length; i++){
			ca[i] = c;
		}
		
		String buff = new String(ca);

		if (rightSide) {
			buff = str + buff;
			retstr = buff.substring(0, length);
		} else {
			buff = buff + str;
			retstr = buff.substring(buff.length() - length);
		}
		
		return retstr;
	}

	 /** 
 	 * This is function return selected of option if value1 equal value2 
	 * 
	 * 
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  24-April-2013  Nam Dinh    Create new
	 * @param value1
	 * @param value2
	 * @return attribute selected of option html
	 */
	public static String checkSelectedValue(String value1, long value2) {
		if ((Long.valueOf(value1).longValue() == value2) && (value1 != null)) {
			return "selected=\"selected\"";
		}
		return "";
	}
}
