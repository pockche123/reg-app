import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VehicleRegistrationServiceTest {

    private VehicleRegistrationService registrationService;
    private InMemoryVehicleRegistrationRepository repository;

    @BeforeEach
    public void setUp(){
        repository = new InMemoryVehicleRegistrationRepository();
        registrationService = new VehicleRegistrationService(repository);

    }


    @Test
    public void test_findTotalRegistrationNumbers_returnsCount(){

        VehicleRegistration reg1 = new VehicleRegistration("AB01 CDE", 2001, "12345");
        VehicleRegistration reg2 = new VehicleRegistration("FG02 HJK", 2002, "67890");
        repository.save(reg1);
        repository.save(reg2);


        int actual = registrationService.getTotalRegistrationNumbers();

        assertEquals(2, actual);
    }

    @Test
    public void test_givenRegistrationNumberProvided_returnsVehicleId(){
        // Arrange
        VehicleRegistration reg1 = new VehicleRegistration("AB01 CDE", 2001, "12345");
        VehicleRegistration reg2 = new VehicleRegistration();
        reg2.setRegistrationNumber("L33T H4X");
        reg2.setYear(2022);

        repository.save(reg1);
        repository.save(reg2);
        String regNumber = "AB01 CDE";
        String regNumber2 = "L33T H4X";

        // Act
        String actualVehicleId = registrationService.getVehicleId(regNumber);
        String actualVehicleId2 = registrationService.getVehicleId(regNumber2);

        // Assert
        assertEquals("12345", actualVehicleId);
        assertEquals(null, actualVehicleId2 );

    }





}
