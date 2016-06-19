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
package nz.edmi.drools.domain;

import java.util.Arrays;
import java.util.List;

/**
 * @author simonvandersluis
 */
public class Programmer {

  private final String name;
  private final String favouriteLanguage;
  private boolean clever = false;

  public Programmer(String name, String favouriteLanguage) {
    this.name = name;
    this.favouriteLanguage = favouriteLanguage;
  }

  public static List<Programmer> famousProgrammers() {
    return Arrays.asList(
            new Programmer("Rod Johnson", "scala"),
            new Programmer("Juergen Hoeller", "Java"),
            new Programmer("James Strachan", "groovy"),
            new Programmer("David Heinemeier Hansson", "rails"),
            new Programmer("Claus Ibsen", "Java")
    );
  }

  public void printClever() {
    System.out.println("Is " + this.getName()
            + " (" +  this.getFavouriteLanguage()
            + ") clever? " + this.isClever());
  }


  public String getName() {
    return name;
  }


  public String getFavouriteLanguage() {
    return favouriteLanguage;
  }


  public boolean isClever() {
    return clever;
  }

  public void setClever(boolean clever) {
    this.clever = clever;
  }
}
