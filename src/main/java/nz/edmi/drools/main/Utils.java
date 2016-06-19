/*
 * Copyright (c) 2016 EDMI NZ
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of EDMI. 
 * ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with EDMI.
 */
package nz.edmi.drools.main;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;

import org.apache.commons.io.IOUtils;

/**
 * // TODO class Javadoc
 *
 * @author simonvandersluis
 */
public class Utils {


  public static String readRuleFromClassPathResource(String resourceName) {
    StringWriter writer = new StringWriter();
    try (InputStream rule = SelectedRules.class.getResourceAsStream(resourceName)) {
      IOUtils.copy(rule, writer, "UTF-8");
    } catch (IOException e) {
      throw new RuntimeException("Unable to read rule", e);
    }
    return writer.toString();
  }

}
