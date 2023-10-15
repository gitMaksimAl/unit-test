package test;



import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import Homework_2.Model.Car;
import Homework_2.Model.Main;
import Homework_2.Model.Motorcycle;
import Homework_2.Model.Vehicle;

import static org.assertj.core.api.Assertions.*;


public class VehiclesTest {

    @Test
    public void isVehicles() {
        assertThat(Main.getMotorcycle()).isInstanceOf(Vehicle.class);
        assertThat(Main.getCar()).isInstanceOf(Vehicle.class);
    }

    @Test
    public void haveCorrectWheels() {
        assertThat(Main.getCar().getNumWheels()).isEqualTo(4);
        assertThat(Main.getMotorcycle().getNumWheels()).isEqualTo(2);
    }

    // TODO: not ended
    @ParameterizedTest
    @ValueSource(ints = {60, 75})
    public void testDriveSpeedTest(int a, int b) {
        Car car = Main.getCar();
        Motorcycle moto = Main.getMotorcycle();
        car.testDrive();
        moto.testDrive();
        assertThat(car.getSpeed()).isEqualTo(a);
        assertThat(moto.getSpeed()).isEqualTo(b);
    }

    @Test
    public void parkSpeedTest() {
        Car car = Main.getCar();
        Motorcycle moto = Main.getMotorcycle();
        car.park();
        moto.park();
        assertThat(car.getSpeed()).isEqualTo(0);
        assertThat(moto.getSpeed()).isEqualTo(0);
    }
}
