package org.launchcode.techjobs_oo.Tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;

import javax.naming.Name;


public class JobTest {
   private Job job1;
   private Job job2;
   @Before
   public void before(){
      job1 = new Job();
      job2 = new Job();
   }
   @Test
   public void testSettingJobId(){
      Job object1 = new Job();
      Assert.assertNotEquals(job1, job2);
      Assert.assertTrue(Math.abs(job2.getId() - job1.getId())==1);
   }
   @Test
   public void testJobConstructorSetsAllFields(){
      Employer employer = new Employer("ACME");
      Location location = new Location("Desert");
      PositionType positionType = new PositionType("Quality control");
      CoreCompetency coreCompetency = new CoreCompetency("Persistence");

      Job tester = new Job("Product tester", employer, location, positionType, coreCompetency);

      Assert.assertTrue(tester.getEmployer() instanceof Employer);
      //Assert.assertTrue(tester.getId() instanceof Integer);
      Assert.assertTrue(tester.getLocation() instanceof Location);
      Assert.assertTrue(tester.getName() instanceof String);
      Assert.assertTrue(tester.getPositionType() instanceof PositionType);
      Assert.assertTrue(tester.getCoreCompetency() instanceof CoreCompetency);

      Assert.assertEquals(tester.getEmployer(), employer);
      Assert.assertEquals(tester.getLocation(), location);
      Assert.assertEquals(tester.getPositionType(), positionType);
      Assert.assertEquals(tester.getCoreCompetency(), coreCompetency);
      Assert.assertEquals(tester.getName(), "Product tester");
   }

   @Test
   public void testJobsForEquality(){
      Employer employer = new Employer("ACME");
      Location location = new Location("Desert");
      PositionType positionType = new PositionType("Quality control");
      CoreCompetency coreCompetency = new CoreCompetency("Persistence");

      Job fakeJob1 = new Job("Product tester", employer, location, positionType, coreCompetency);
      Job fakeJob2 = new Job("Product tester", employer, location, positionType, coreCompetency);

      Assert.assertNotEquals(fakeJob1, fakeJob2);
   }

   @Test
   public void testToString(){
      Employer employer = new Employer("ACME");
      Location location = new Location("Desert");
      PositionType positionType = new PositionType("Quality control");
      CoreCompetency coreCompetency = new CoreCompetency("Persistence");

      Job jobTestToString = new Job("Product tester", employer, location, positionType, coreCompetency);

      String jobString = jobTestToString.toString();
      Assert.assertTrue("starts with a new line", jobString.startsWith("\n"));
      Assert.assertTrue("ends with a new line", jobString.endsWith("\n"));
      Assert.assertTrue(jobString.contains("ID: " + jobTestToString.getId()));
      Assert.assertTrue(jobString.contains("Name: " + jobTestToString.getName()));
      Assert.assertTrue(jobString.contains("Employer: " + jobTestToString.getEmployer()));
      Assert.assertTrue(jobString.contains("Location: " + jobTestToString.getLocation()));
      Assert.assertTrue(jobString.contains("Position Type: " + jobTestToString.getPositionType()));
      Assert.assertTrue(jobString.contains("Core Competency: " + jobTestToString.getCoreCompetency()));
   }

   @Test
   public void testDataPresent(){
      String job1Display = job1.toString();
      Assert.assertTrue(job1Display.contains("Name: Data not available"));
      Assert.assertTrue(job1Display.contains("Employer: Data not available"));
      Assert.assertTrue(job1Display.contains("Location: Data not available"));
      Assert.assertTrue(job1Display.contains("Position Type: Data not available"));
      Assert.assertTrue(job1Display.contains("Core Competency: Data not available"));
   }

   @Test
   public void testBlankString(){
      job1.setName("");
      String job1Display = job1.toString();
      Assert.assertTrue(job1Display.contains("Name: Data not available"));

   }
}
