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

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import nz.edmi.drools.domain.Programmer;
import nz.edmi.drools.main.utils.DroolsLoader;
import org.kie.api.runtime.StatelessKieSession;

/**
 * // TODO class Javadoc
 *
 * @author simonvandersluis
 */
public class BadUseOfGlobals {

  public static void main(final String[] args) {
    StatelessKieSession session = DroolsLoader.load("collectProgrammers.drl");

    Map<String, List<Programmer>> results = new HashMap<>();
    session.setGlobal("results", results);
    List<Programmer> programmers = Programmer.famousProgrammers();

    System.out.println("Run once");
    session.execute(programmers);
    prettyPrintResults(results);

    System.out.println("\nRun twice");
    session.execute(programmers);
    prettyPrintResults(results);
  }


  private static void prettyPrintResults(Map<String, List<Programmer>> results) {
    results.keySet().forEach(language -> {
      System.out.println(language + ": " + results.get(language).stream().map(Programmer::getName).collect(Collectors.joining (", ")));
    });
  }

}
