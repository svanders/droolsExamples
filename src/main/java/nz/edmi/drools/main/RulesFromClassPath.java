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

import nz.edmi.drools.domain.Programmer;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.StatelessKieSession;

public class RulesFromClassPath {

  public static void main(final String[] args) {
    KieServices ks = KieServices.Factory.get();
    KieContainer kc = ks.getKieClasspathContainer();

    StatelessKieSession session = kc.newStatelessKieSession();
    Programmer simon = new Programmer("Simon", "java");
    session.execute(simon);
    simon.printClever();

    List<Programmer> programmers = Programmer.famousProgrammers();
    session.execute(programmers);
    programmers.forEach(Programmer::printClever);
  }


}
