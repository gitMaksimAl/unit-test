package Homework_1.Shop;

public class Product {
    private Integer cost; // Стоимость продукта
    private String title; // Название

    public Product(int cost, String titleString) {
        this.cost = cost;
        this.title = titleString;
    }

    // Геттеры, сеттеры:
    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}