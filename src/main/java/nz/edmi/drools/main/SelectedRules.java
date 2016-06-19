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

import java.util.List;
import java.util.stream.Collectors;

import nz.edmi.drools.domain.Programmer;
import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.Message;
import org.kie.api.builder.Results;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.StatelessKieSession;

public class SelectedRules {

  public static void main(final String[] args) {
    KieServices ks = KieServices.Factory.get();
    KieFileSystem kfs = ks.newKieFileSystem();
    // uses maven style resource locations
    kfs.write("src/main/resources/rule.drl", Utils.readRuleFromClassPathResource("java-scala.drl"));

    KieBuilder kieBuilder = ks.newKieBuilder(kfs).buildAll();
    Results results = kieBuilder.getResults();
    if (results.hasMessages(Message.Level.ERROR)) {
      throw new RuntimeException("Error in drools rule(s): " + results.getMessages().stream()
              .map(Message::toString)
              .collect(Collectors.joining("\n")));
    }

    KieContainer kc = ks.newKieContainer(ks.getRepository().getDefaultReleaseId());
    StatelessKieSession session = kc.newStatelessKieSession();

    List<Programmer> programmers = Programmer.famousProgrammers();
    session.execute(programmers);
    programmers.forEach(Programmer::printClever);
  }

}
