package Homework_2.Model;

import java.util.concurrent.ThreadLocalRandom;

public class Main {

    /*
     Домашнее задание к семинару №2 JUnit:
     1. Настроить новый проект:
         a). Нужно создать новый проект, со следующей структурой классов (3 отдельных класса):



         b). Настроить тестовую среду
             (создать тестовый класс VehicleTest, пометить папку как Test sources (зеленая папка),
             импортировать необходимые для тестов библиотеки (JUnit, assertJ - все что было на семинаре))
         c). Написать следующие тесты:
             - проверка того, что экземпляр объекта Car также является экземпляром транспортного средства; (instanceof)
             - проверка того, объект Car создается с 4-мя колесами
             - проверка того, объект Motorcycle создается с 2-мя колесами
             - проверка того, объект Car развивает скорость 60 в режиме тестового вождения (testDrive())
             - проверка того, объект Motorcycle развивает скорость 75 в режиме тестового вождения (testDrive())
             - проверить, что в режиме парковки (сначала testDrive, потом park, т.е эмуляция движения транспорта) машина останавливается (speed = 0)
             - проверить, что в режиме парковки (сначала testDrive, потом park  т.е эмуляция движения транспорта) мотоцикл останавливается (speed = 0)
    */

    public static Motorcycle getMotorcycle() {
        String[] compnanies = {"Honda", "Yamaha", "Kawasaki", "Suzuki"};
        String[] models = {"250cc", "600cc", "900cc", "1000cc"};
        int[] years = {2020, 2021, 2022, 2023};
        return new Motorcycle(compnanies[ThreadLocalRandom.current().nextInt(0, compnanies.length)],
                                models[ThreadLocalRandom.current().nextInt(0, models.length)],
                                years[ThreadLocalRandom.current().nextInt(0, years.length)]);
    }

    public static Car getCar() {
        String[] compnanies = {"Honda", "Mitsubishi", "Subaru", "Suzuki"};
        String[] models = {"1200cc", "1600cc", "2400cc", "3600cc"};
        int[] years = {2020, 2021, 2022, 2023};
        return new Car(compnanies[ThreadLocalRandom.current().nextInt(0, compnanies.length)],
                                models[ThreadLocalRandom.current().nextInt(0, models.length)],
                                years[ThreadLocalRandom.current().nextInt(0, years.length)]);
    }
}