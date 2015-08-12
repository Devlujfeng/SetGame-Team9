/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nus.iss.SA40.team9.UnitTest;

import javax.inject.Inject;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import nus.iss.SA40.team9.*;
import nus.iss.SA40.team9.EJB.UserBean;
import nus.iss.SA40.team9.Model.*;
import nus.iss.SA40.team9.SetGame.GameList;
/**
 *
 * @author devlu
 */
public class JUnitTest {
    
    

    public JUnitTest() {
    }
    
  @Inject private GameList gl;  
 @Test
 public void HappyTest(){
     gl.GameGenerator();
     gl.GameGenerator();
     gl.GameGenerator();
     gl.GameGenerator();

 }
}
