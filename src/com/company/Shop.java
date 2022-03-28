package com.company;

import java.util.HashMap;
import java.util.Map;

public class Shop {
    private Map<Product, Integer> spisok = new HashMap<>();

    public void addProduct(Product product, int col) {
        int[] allId = new int[spisok.size()];
        int count = 0;
        int productId = product.getId();

        for (Product s : spisok.keySet()) {
            allId[count] = s.getId();
            count++;
        }

        for (int i = 0; i < allId.length; i++) {
            if (allId[i] == productId) {
                System.out.println("Товар с таким id существует");
                return;
            }
        }
        spisok.put(product, col);
    }

    public void getSpisok() {
        spisok.keySet().forEach(s -> {
            int id = s.getId();
            String name = s.getName();
            int price = s.getPrice();
            System.out.println(id + "   " + name + " - " + price);
        });
    }

    public void delete(int id) {
        Product buff = null;
        for (Product s : spisok.keySet()) {
            if (id == s.getId()) {
                buff = s;
                System.out.println("Удален товар с ID " + id);
            }
        }
        spisok.remove(buff);
    }

    public void redactProduct(Product product, int price) {
        product.setPrice(price);
    }


}


