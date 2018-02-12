package _3_tree_set.sorted_products_task;

public class Product {
    private final String companyName;
    private int price;

    public Product(String companyName, int price) {
        this.companyName = companyName;
        this.price = price;
    }

    public String getCompanyName() {
        return companyName;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "companyName='" + companyName + '\'' +
                ", price=" + price +
                '}' + "\n";
    }
}
