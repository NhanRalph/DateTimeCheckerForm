package main;

import org.junit.Test;
import static org.junit.Assert.*;

public class DateTimeCheckerFormTest {
    
    @Test
    public void testIsValidDate_ValidDate() {
        DateTimeCheckerForm form = new DateTimeCheckerForm();
        
        // Test case 1: Valid Date Input (15/6/2003)
        assertTrue(form.isValidDate(2003, 6, 15));
    }

    @Test
    public void testIsValidDate_InvalidDay() {
        DateTimeCheckerForm form = new DateTimeCheckerForm();
        
        // Test case 2: Invalid Date Input (32/6/2003)
        assertFalse(form.isValidDate(2003, 6, 32));
    }

    @Test
    public void testIsValidDate_ValidLeapYear() {
        DateTimeCheckerForm form = new DateTimeCheckerForm();
        
        // Test case 3: Valid Leap Year (29/2/2020)
        assertTrue(form.isValidDate(2020, 2, 29));
    }

    @Test
    public void testIsValidDate_InvalidLeapYear() {
        DateTimeCheckerForm form = new DateTimeCheckerForm();
        
        // Test case 4: Invalid Leap Year (29/2/2021)
        assertFalse(form.isValidDate(2021, 2, 29));
    }

    @Test
    public void testIsValidDate_InvalidDataType() {
        DateTimeCheckerForm form = new DateTimeCheckerForm();
        
        // Test case 5: Input Data type ("abc", "def", "ghi")
        assertFalse(form.isValidDate(Integer.parseInt("abc"), Integer.parseInt("def"), Integer.parseInt("ghi")));
    }

    @Test
    public void testIsValidDate_DayOutOfRange() {
        DateTimeCheckerForm form = new DateTimeCheckerForm();
        
        // Test case 6: Day is out of Range (0/6/2003)
        assertFalse(form.isValidDate(2003, 6, 0));
    }

    @Test
    public void testIsValidDate_MonthOutOfRange() {
        DateTimeCheckerForm form = new DateTimeCheckerForm();
        
        // Test case 7: Month is out of Range (15/13/2003)
        assertFalse(form.isValidDate(2003, 13, 15));
    }

    @Test
    public void testIsValidDate_YearOutOfRange() {
        DateTimeCheckerForm form = new DateTimeCheckerForm();
        
        // Test case 8: Year is out of Range (15/6/999)
        assertFalse(form.isValidDate(999, 6, 15));
    }

    @Test
    public void testIsValidDate_Month31Days() {
        DateTimeCheckerForm form = new DateTimeCheckerForm();
        
        // Test case 9: Month has 31 days (31/7/2003)
        assertTrue(form.isValidDate(2003, 7, 31));
    }

    @Test
    public void testIsValidDate_Month30Days() {
        DateTimeCheckerForm form = new DateTimeCheckerForm();
        
        // Test case 10: Month has 30 days (30/4/2003)
        assertTrue(form.isValidDate(2003, 4, 30));
    }
}
