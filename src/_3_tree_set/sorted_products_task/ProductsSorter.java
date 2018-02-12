package _3_tree_set.sorted_products_task;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ProductsSorter {
    public static void main(String[] args) {
        List<Product> list = new ArrayList<>();

        list.add(new Product("Aston", 6));
        list.add(new Product("Beta", 17));
        list.add(new Product("Aston", 56));
        list.add(new Product("Ciclum", 70));
        list.add(new Product("Beta", 26));
        list.add(new Product("Ciclum", 56));

        System.out.println(list + "\n");

        Collections.sort(list, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return o1.getPrice() - o2.getPrice();
            }
        });

        Collections.sort(list, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return o1.getCompanyName().compareTo(o2.getCompanyName());
            }
        });

        System.out.println(list);
    }
}
