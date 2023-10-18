package test;



import org.junit.jupiter.api.*;

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

    @Test
    public void speedLimitsTest() {
        Car car = Main.getCar();
        Motorcycle moto = Main.getMotorcycle();
        car.testDrive();
        assertThat(car.getSpeed()).isEqualTo(60);
        car.park();
        assertThat(car.getSpeed()).isEqualTo(0);
        moto.testDrive();
        assertThat(moto.getSpeed()).isEqualTo(75);
        moto.park();
        assertThat(moto.getSpeed()).isEqualTo(0);
    }
}
