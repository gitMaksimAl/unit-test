package test.simple_shopping_cart;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

import Lesson_2.simple_shopping_cart.Cart;
import Lesson_2.simple_shopping_cart.Main;
import Lesson_2.simple_shopping_cart.Shop;

public class LessonTest {
    
    @Test
    public void testCartPrice() {
        Shop shop = new Shop(Main.getStoreItems());
        Cart cart = new Cart(shop);
        cart.addProductToCartByID(1);
        cart.addProductToCartByID(2);
        cart.addProductToCartByID(3);
        assertThat(cart.getTotalPrice()).isEqualTo(620);
    }

    @Test
    public void doublePriceTest() {
        Shop shop = new Shop(Main.getStoreItems());
        Cart cart = new Cart(shop);
        cart.addProductToCartByID(1);
        cart.addProductToCartByID(1);
        assertThat(cart.getTotalPrice()).isEqualTo(340);
    }

    @Test
    public void deleteProductTest() {
        Shop shop = new Shop(Main.getStoreItems());
        Cart cart = new Cart(shop);
        cart.addProductToCartByID(1);
        cart.addProductToCartByID(1);
        cart.removeProductByID(1);
        assertThat(cart.getTotalPrice()).isEqualTo(170f);
    }

    @Test
    public void productCountDecreasesTest() {
        Shop shop = new Shop(Main.getStoreItems());
        Cart cart = new Cart(shop);
        cart.addProductToCartByID(1);
        cart.addProductToCartByID(1);
        assertThat(shop.getProductsShop().get(0).getQuantity()).isEqualTo(8);
    }

    @Test
    public void notAvailableMoreProductTest() {
        Shop shop = new Shop(Main.getStoreItems());
        Cart cart = new Cart(shop);
        cart.addProductToCartByID(1);
        cart.addProductToCartByID(1);
        cart.addProductToCartByID(1);
        cart.addProductToCartByID(1);
        cart.addProductToCartByID(1);
        cart.addProductToCartByID(1);
        cart.addProductToCartByID(1);
        cart.addProductToCartByID(1);
        cart.addProductToCartByID(1);
        cart.addProductToCartByID(1);
        cart.addProductToCartByID(1);
        assertThat(cart.cartItems.get(0).getQuantity()).isEqualTo(10);
        assertThat(shop.getProductsShop().get(0).getQuantity()).isEqualTo(0);
    }

    @Test
    public void productReturnToShopTest() {
        Shop shop = new Shop(Main.getStoreItems());
        Cart cart = new Cart(shop);
        cart.addProductToCartByID(1);
        cart.addProductToCartByID(1);
        cart.addProductToCartByID(1);
        cart.removeProductByID(1);
        assertThat(cart.cartItems.get(0).getQuantity()).isEqualTo(2);
        assertThat(shop.getProductsShop().get(0).getQuantity()).isEqualTo(8);
    }

    @ParameterizedTest
    @ValueSource(ints = {-100, 100, 1250, 555, 0})
    public void notHaveThisIds(int id) {
        Shop shop = new Shop(Main.getStoreItems());
        Cart cart = new Cart(shop);
        assertThatThrownBy(() -> {cart.addProductToCartByID(id);},
            "Have not this id.").isInstanceOf(RuntimeException.class);
    }
}
