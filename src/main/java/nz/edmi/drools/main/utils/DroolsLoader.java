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
package nz.edmi.drools.main.utils;

import java.util.stream.Collectors;

import nz.edmi.drools.main.Utils;
import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.Message;
import org.kie.api.builder.Results;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.StatelessKieSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * // TODO class Javadoc
 *
 * @author simonvandersluis
 */
public class DroolsLoader {

  private static Logger logger = LoggerFactory.getLogger(DroolsLoader.class);

  public static StatelessKieSession load(String drl) {
    long startTime = System.currentTimeMillis();
    KieServices ks = KieServices.Factory.get();
    KieFileSystem kfs = ks.newKieFileSystem();
    // uses maven style resource locations
    kfs.write("src/main/resources/rule.drl", Utils.readRuleFromClassPathResource(drl));

    KieBuilder kieBuilder = ks.newKieBuilder(kfs).buildAll();
    barfIfDroolsBuildError(kieBuilder.getResults());
    KieContainer kc = ks.newKieContainer(ks.getRepository().getDefaultReleaseId());
    long loadTime = System.currentTimeMillis();
    logger.debug("{}ms to load container", loadTime - startTime);

    StatelessKieSession session = kc.newStatelessKieSession();
    long creationTime = System.currentTimeMillis();
    logger.debug("{}ms to create session", creationTime - loadTime);

    return session;
  }


  private static void barfIfDroolsBuildError(Results buildResults) {
    if (buildResults.hasMessages(Message.Level.ERROR)) {
      throw new RuntimeException("Error in drools rule(s): " + buildResults.getMessages().stream()
              .map(Message::toString)
              .collect(Collectors.joining("\n")));
    }
  }

}
