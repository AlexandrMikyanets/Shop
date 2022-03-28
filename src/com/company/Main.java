package com.company;

import java.util.*;
import java.util.stream.Collectors;


public class Main {

    public static void main(String[] args) {
        Shop shop = new Shop();

        Product hleb = new Product(1, "hleb", 6000);
        Product maslo = new Product(2, "maslo", 100);
        Product moloko = new Product(3, "moloco", 1000);
        Product baton = new Product(4, "baton", 9000);

        shop.addProduct(hleb, 5);
        shop.addProduct(maslo, 14);
        shop.addProduct(moloko, 4);
        shop.addProduct(baton, 56);
        shop.getSpisok();

        shop.delete(1);
        shop.getSpisok();

        System.out.println("Изменена цена продукта молоко:");
        shop.redactProduct(moloko, 5000);
        shop.getSpisok();

        System.out.println("Отсортировка по цене:");
        ArrayList<Product> arrayList = new ArrayList<>();
        arrayList.add(baton);
        arrayList.add(hleb);
        arrayList.add(maslo);
        arrayList.add(moloko);

        System.out.println(arrayList.stream().
                sorted(Comparator.comparing(Product::getPrice))
                .collect(Collectors.toList()));
    }
}
