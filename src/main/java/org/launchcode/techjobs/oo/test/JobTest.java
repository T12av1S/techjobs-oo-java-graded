package org.launchcode.techjobs.oo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {
    Job testJob1 = new Job("Product Tester", new Employer("ACME"), new Location("Desert"),
            new PositionType("Quality Control"), new CoreCompetency("Persistence"));
    Job testJob2 = new Job("Product Tester", new Employer("ACME"), new Location("Desert"),
            new PositionType("Quality Control"), new CoreCompetency("Persistence"));

    @Test
    public void testSettingJobId() {
        Job emptyJob1 = new Job();
        Job emptyJob2 = new Job();
        assertNotEquals(emptyJob1, emptyJob2);
    }

    @Test
    public void testJobConstructorSetsAllFields() {


        assertTrue(testJob1.getName() instanceof String);
        assertEquals("Product Tester", testJob1.getName());

        assertTrue(testJob1.getEmployer() instanceof Employer);
        assertEquals("ACME", String.valueOf(testJob1.getEmployer()));

        assertTrue(testJob1.getLocation() instanceof Location);
        assertEquals("Desert", String.valueOf(testJob1.getLocation()));

        assertTrue(testJob1.getPositionType() instanceof PositionType);
        assertEquals("Quality Control", String.valueOf(testJob1.getPositionType()));

        assertTrue(testJob1.getCoreCompetency() instanceof CoreCompetency);
        assertEquals("Persistence", String.valueOf(testJob1.getCoreCompetency()));
    }

    @Test
    public void testJobsForEquality() {
        assertFalse(testJob1.equals(testJob2));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {

        int indexLength = testJob1.toString().length();
        assertEquals(testJob1.toString().charAt(0), '\n');
        assertEquals(testJob1.toString().charAt(indexLength - 1), '\n');
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {

        assertEquals("\nID: 9\nName: Product Tester\nEmployer: ACME\nLocation: Desert\nPosition Type: Quality " +
                "Control\nCore Competency: Persistence\n", testJob1.toString());
    }

    @Test
    public void testToStringHandlesEmptyField() {

        Job emptyJob3 = new Job();
        emptyJob3.setName("Product Tester");
        assertEquals("\nID: 5\nName: Product Tester\nEmployer: Data not available\nLocation: Data not available" +
                "\nPosition Type: Data not available\nCore Competency: Data not available\n", emptyJob3.toString());
    }

    @Test
    public void BonusTest() {

        Job emptyJob4 = new Job();
        assertEquals("OOPS! This job does not seem to exist.", emptyJob4.toString());
    }
}
