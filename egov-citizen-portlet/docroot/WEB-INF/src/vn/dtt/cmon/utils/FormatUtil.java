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

 * 
 * This is Class convert type of object to other object
 * 
 * 
 * Version: 1.0
 *  
 * History: 
 *   DATE        AUTHOR      DESCRIPTION 
 *  ------------------------------------------------- 
 *  24-April-2013  Nam Dinh    Create new
 * */ 
public class FormatUtil {

	/** 

	 * 
	 * This is function convert String to int
	 * 
	 * 
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  24-April-2013  Nam Dinh    Create new
	 *
	 * @param value need convert
	 * @return value after convert, if exception value equal zero
	 */
	public static int convertToInt(String value) {
		try {
			return Integer.parseInt(value.trim());
		} catch (Exception es) {
		}
		
		return 0;
	}
	
	/** 

	 * 
	 * This is function convert String to long
	 * 
	 * 
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  24-April-2013  Nam Dinh    Create new
	 *
	 * @param value need convert
	 * @return value after convert, if exception value equal zero
	 */
	public static long convertToLong(String value) {
		try {
			return Long.parseLong(value.trim());
		} catch (Exception es) {
		}
		
		return 0;
	}
	
	/** 

	 * 
	 * This is function convert String to Integer
	 * 
	 * 
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  24-April-2013  Nam Dinh    Create new
	 *
	 * @param value need convert
	 * @return value after convert, if exception value equal zero
	 */
	
	public static Integer convertToInteger(String data) {
		try {
			return Integer.parseInt(data.trim());
		} catch (Exception es) {
		}
		return null;
	}
	
	
	
}
