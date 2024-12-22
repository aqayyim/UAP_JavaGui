import hospital.model.Patient;
import hospital.service.PatientService;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

public class PatientTest {
    private PatientService patientService;
    private Patient testPatient;

    @Before
    public void setUp() {
        patientService = new PatientService();
        testPatient = new Patient(null, "Umam Sedikit Cabul", "01/01/1990", "Goa China", "1234567890");
    }

    @Test
    public void testPatientCreation() {
        assertNotNull("Patient object should be created", testPatient);
        assertEquals("Umam Sedikit Cabul", testPatient.getName());
    }

    @Test
    public void testPatientID() {
        patientService.addPatient(testPatient);
        assertNotNull("Patient ID should not be null", testPatient.getId());
        assertTrue("Patient ID should start with P", testPatient.getId().startsWith("P"));
    }
}