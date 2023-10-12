package Homework_1.Shop;

import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.*;

public class ShopTest {

     /*
    */


    public static void main(String[] args) {
        Shop magazine = new Shop();
        List<Product> productsCart = new ArrayList<>();
        magazine.setProducts(productsCart);

        // region
        Product pivo = new Product(10, "Pivo");
        Product baton = new Product(5, "Baton");
        Product spichki = new Product(2, "Spichki");
        Product moloko = new Product(6, "Moloko");
        Product kartoplja = new Product(8, "Kartoplja");
        Product sosiski = new Product(12, "Sosiski");

        productsCart.add(pivo);
        productsCart.add(baton);
        productsCart.add(spichki);
        productsCart.add(moloko);
        productsCart.add(kartoplja);
        productsCart.add(sosiski);
        // endregion

        // 1. Напишите тесты, чтобы проверить, что магазин хранит верный список продуктов (правильное количество
        // продуктов, верное содержимое корзины).
        Thread productsTests = new Thread(() -> {
            assertThat(magazine.getProducts()).containsAll(productsCart);
            assertThat(magazine.getProducts()).hasSize(productsCart.size());
            assertThat(magazine.getProducts()).allMatch((p) -> p.getCost() > 0);
            assertThat(magazine.getProducts()).allMatch((p) -> !p.getTitle().isEmpty());
        });

        //2. Напишите тесты для проверки корректности работы метода getMostExpensiveProduct.
        Thread mostExpensiveTests = new Thread(() -> {
            assertThat(magazine.getMostExpensiveProduct()).isNotNull();
            assertThat(magazine.getMostExpensiveProduct().getTitle()).isEqualTo("Sosiski");
        });

        // 3. Напишите тесты для проверки корректности работы метода sortProductsByPrice
        // (проверьте правильность сортировки).
        Thread productSortTests = new Thread(() -> {
            // sorting
            magazine.sortProductsByPrice();
            // last product must be most expensive in true order
            assertThat(magazine.getMostExpensiveProduct().equals(magazine.getProducts().get(productsCart.size() - 1)));
        });

        productsTests.start();
        mostExpensiveTests.start();
        productSortTests.start();
    }
}
