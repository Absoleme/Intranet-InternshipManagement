package com.project.util;

import org.junit.jupiter.api.*;

import java.sql.Date;
import java.sql.Timestamp;

/**
 * @author victo
 */
class ValidationTest {

    ValidationTest() {
    }


    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    /**
     * Test of validationTextField method, of class Validation.
     */
    @Test
    @DisplayName("test empty text field")
    void testValidationEmptyTextField() {
        String field = "";
        String fieldName = "commentaryIntern";
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Validation.validationTextField(field, fieldName);
        });
    }

    @Test
    @DisplayName("test valid text field")
    void testValidationTextField() {
        String field = "field";
        String fieldName = "commentaryIntern";
        Assertions.assertDoesNotThrow(() -> {
            Validation.validationTextField(field, fieldName);
        });
    }

    /**
     * Test of validationNumberField method, of class Validation.
     */
    @Test
    @DisplayName("test empty number")
    void testEmptyValidationNumberField() {
        String field = "";
        String fieldName = "companyStreetNumber";
        Assertions.assertThrows(NumberFormatException.class, () -> {
            Validation.validationNumberField(field, fieldName);
        });
    }

    @Test
    @DisplayName("test invalid number")
    void testInvalidValidationNumberField() {
        String field = "-2";
        String fieldName = "companyStreetNumber";
        Assertions.assertThrows(NumberFormatException.class, () -> {
            Validation.validationNumberField(field, fieldName);
        });
    }

    @Test
    @DisplayName("test valid number")
    void testValidationNumberField() {
        String field = "17";
        String fieldName = "companyStreetNumber";
        Assertions.assertDoesNotThrow(() -> {
            Validation.validationNumberField(field, fieldName);
        });
    }

    /**
     * Test of validationFloatField method, of class Validation.
     */
    @Test
    @DisplayName("test empty float field")
    void testEmptyValidationFloatField() {
        String field = "";
        String fieldName = "noteTech";
        Assertions.assertThrows(NullPointerException.class, () -> {
            Validation.validationFloatField(field, fieldName);
        });
    }

    @Test
    @DisplayName("test invalid float field")
    void testInvalidValidationFloatField() {
        System.out.println("validationFloatField");
        String field = "-17.3";
        String fieldName = "noteTech";
        Assertions.assertThrows(NumberFormatException.class, () -> {
            Validation.validationFloatField(field, fieldName);
        });
    }

    @Test
    @DisplayName("test valid float")
    void testValidationFloatField() {
        System.out.println("validationFloatField");
        String field = "17.3";
        String fieldName = "noteTech";
        Assertions.assertDoesNotThrow(() -> {
            Validation.validationFloatField(field, fieldName);
        });
    }

    /**
     * Test of validationTimestamp method, of class Validation.
     */
    @Test
    @DisplayName("empty timestamp field")
    void testEmptyValidationTimestamp() {
        String timestamp = "";
        String fieldName = "midInternshipMeetingDate";
        Assertions.assertThrows(NullPointerException.class, () -> {
            Validation.validationTimestamp(timestamp, fieldName);
        });
    }

    @Test
    @DisplayName("invalid valid timestamp field")
    void testInvalidValidationTimestamp() {
        String timestamp = "2020-11-26 13:44:00";
        String fieldName = "midInternshipMeetingDate";
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Validation.validationTimestamp(timestamp, fieldName);
        });
    }

    @Test
    @DisplayName("valid timestamp field")
    void testValidationTimestamp() {
        String timestamp = "2020-11-26 13:44";
        String fieldName = "midInternshipMeetingDate";
        Assertions.assertDoesNotThrow(() -> {
            Validation.validationTimestamp(timestamp, fieldName);
        });
    }

    /**
     * Test of validationDate method, of class Validation.
     */
    @Test
    @DisplayName("test empty date field")
    void testEmptyValidationDate() {
        String date = "";
        String dateName = "startDate";
        Assertions.assertThrows(NullPointerException.class, () -> {
            Validation.validationDate(date, dateName);
        });
    }

    @Test
    @DisplayName("test valid date field")
    void testValidationDate() {
        String date = "17-10-2020";
        String dateName = "startDate";
        Assertions.assertDoesNotThrow(() -> {
            Validation.validationDate(date, dateName);
        });
    }

    /**
     * Test of validationDates method, of class Validation.
     */
    @Test
    @DisplayName("test invalid dates ")
    void testInvalidValidationDates() {
        Date startDate = Date.valueOf("2019-04-26");
        Date endDate = Date.valueOf("2018-09-24");
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Validation.validationDates(startDate, endDate);
        });
    }

    @Test
    @DisplayName("test valid dates ")
    void testValidationDates() {
        Date startDate = Date.valueOf("2019-04-26");
        Date endDate = Date.valueOf("2019-09-24");
        Assertions.assertDoesNotThrow(() -> {
            Validation.validationDates(startDate, endDate);
        });
    }

    /**
     * Test of validationKeywords method, of class Validation.
     */
    @Test
    @DisplayName("empty keywords field")
    void testEmptyValidationKeywords() throws Exception {
        String keywords = "";
        String fieldName = "missionKeywords";
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Validation.validationKeywords(keywords, fieldName);
        });
    }

    @Test
    @DisplayName("valid keywords field")
    void testValidationKeywords() throws Exception {
        String keywords = "keyword1, keyword2";
        String fieldName = "missionKeywords";
        Assertions.assertDoesNotThrow(() -> {
            Validation.validationKeywords(keywords, fieldName);
        });
    }

    /**
     * Test of validationMidInternship method, of class Validation.
     */
    @Test
    @DisplayName("invalid internship dates (for midinternship field)")
    void validationInvalidDatesMidInternship() {
        Date startDate = Date.valueOf("2019-04-26");
        Date endDate = Date.valueOf("2018-09-24");
        Timestamp midInternship = new Timestamp(Date.valueOf("2019-09-10").getTime());
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Validation.validationMidInternship(startDate, endDate, midInternship);
        });
    }

    @Test
    @DisplayName("invalid midinternship field")
    void validationInvalidMidInternship() {
        Date startDate = Date.valueOf("2019-04-26");
        Date endDate = Date.valueOf("2019-09-24");
        Timestamp midInternship = new Timestamp(Date.valueOf("2019-09-30").getTime());
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Validation.validationMidInternship(startDate, endDate, midInternship);
        });
    }

    @Test
    @DisplayName("valid midinternship field")
    void validationMidInternship() {
        Date startDate = Date.valueOf("2019-04-26");
        Date endDate = Date.valueOf("2019-09-24");
        Timestamp midInternship = new Timestamp(Date.valueOf("2019-09-10").getTime());
        Assertions.assertDoesNotThrow(() -> {
            Validation.validationMidInternship(startDate, endDate, midInternship);
        });
    }

    /**
     * Test of validationEmail method, of class Validation.
     */
    @Test
    @DisplayName("valid empty email field")
    void testEmptyValidationEmail() throws Exception {
        String email = "";
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Validation.validationEmail(email);
        });
    }

    @Test
    @DisplayName("invalid email field")
    void testInvalidValidationEmail() throws Exception {
        String email = "thisIsMyEmail";
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Validation.validationEmail(email);
        });
    }

    @Test
    @DisplayName("valid email field")
    void testValidationEmail() throws Exception {
        String email = "john.smith@efrei.fr";
        Assertions.assertDoesNotThrow(() -> {
            Validation.validationEmail(email);
        });
    }

    /**
     * Test of validationPassword method, of class Validation.
     */
    @Test
    @DisplayName("empty password field")
    void testEmptyValidationPassword() throws Exception {
        String password = "";
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Validation.validationPassword(password);
        });
    }

    @Test
    @DisplayName("too short password field")
    void testInvalidValidationPassword() throws Exception {
        String password = "h";
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Validation.validationPassword(password);
        });
    }

    @Test
    @DisplayName("valid password field")
    void testValidationPassword() throws Exception {
        String password = "Coucoucmoi";
        Assertions.assertDoesNotThrow(() -> {
            Validation.validationPassword(password);
        });
    }
}
