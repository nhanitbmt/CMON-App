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

import com.liferay.portal.kernel.util.Validator;
/** 
 * User ValidatorUtil class
 * 
 * This class contains all utils for validate information
 * 
 * 
 * Version: 1.0
 *  
 * History: 
 *   DATE        AUTHOR      DESCRIPTION 
 *  ------------------------------------------------- 
 *  24-April-2013  Liem.Nham    Create new
 */
public class ValidatorUtil {


/** 
 
 * 
 * This is function validate cmnd 
 * 
 * 
 * Version: 1.0
 *  
 * History: 
 *   DATE        AUTHOR      DESCRIPTION 
 *  ------------------------------------------------- 
 *  24-April-2013  Nam Dinh    Create new
 * @param cmnd need validate
 * @return : true if true
 */
	public static boolean isValidCMND(String cmnd) {
		if (Validator.isNull(cmnd)) return false;
		cmnd = cmnd.trim();
		if (Validator.isNumber(cmnd) && (cmnd.length() == 9 || cmnd.length() == 12)) {
			return true;
		}
		
		return false;
	}
}
