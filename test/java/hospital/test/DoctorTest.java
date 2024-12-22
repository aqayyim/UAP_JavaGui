import hospital.model.Doctor;
import hospital.service.DoctorService;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

public class DoctorTest {
    private DoctorService doctorService;
    private Doctor testDoctor;

    @Before
    public void setUp() {
        doctorService = new DoctorService();
        testDoctor = new Doctor(null, "Dr. Koyim", "Cardiology", "Mon-Fri: 08:00-16:00", "1234567890");
    }

    @Test
    public void testDoctorCreation() {
        assertNotNull("Doctor object should be created", testDoctor);
        assertEquals("Dr. Koyim", testDoctor.getName());
    }

    @Test
    public void testDoctorID() {
        doctorService.addDoctor(testDoctor);
        assertNotNull("Doctor ID should not be null", testDoctor.getId());
        assertTrue("Doctor ID should start with D", testDoctor.getId().startsWith("D"));
    }
}