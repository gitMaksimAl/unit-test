package Homework_1.Shop;

import java.util.Comparator;
import java.util.List;


public class Shop implements Comparator<Product>{
    private List<Product> products;
    private boolean isSorted = false;

    // Геттеры, сеттеры:
    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    // Метод должен вернуть отсортированный по возрастанию по цене список продуктов
    public List<Product> sortProductsByPrice() {
        this.products.sort(Comparator.comparing((obj -> obj.getCost())));
        this.isSorted = true;
        return this.products;
    }

    // Метод должен вернуть самый дорогой продукт
    public Product getMostExpensiveProduct() {
        if (this.isSorted || this.products.size() == 1) return this.products.get(this.products.size() - 1);
        Product mostExpensive = products.get(0);
        mostExpensive = products.stream().max((x, y) -> Integer.compare(x.getCost(), y.getCost())).get();
        return mostExpensive;
    }

    @Override
    public int compare(Product arg0, Product arg1) {
        return Integer.compare(arg0.getCost(), arg1.getCost());
    }

    @Override
    public String toString() {
        if (this.products.isEmpty()) return "Shop is empty.";
        StringBuilder builder = new StringBuilder();
        for (Product product : products) {
            builder.append(String.format("%s: %d\n", product.getTitle(), product.getCost()));
        }
        return builder.toString();
    }
}