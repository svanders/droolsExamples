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

import java.util.stream.Collectors;

import nz.edmi.drools.domain.Account;
import nz.edmi.drools.main.utils.DroolsLoader;
import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.Message;
import org.kie.api.builder.Results;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.StatelessKieSession;

/**
 * // TODO class Javadoc
 *
 * @author simonvandersluis
 */
public class SaliencePlusActivationGroups {

    public static void main(final String[] args) {

      StatelessKieSession session = DroolsLoader.load("selectiveAccountManipulator.drl");
      session.execute(new Account(10));
      System.out.println("");
      session.execute(new Account(100));
    }


}
