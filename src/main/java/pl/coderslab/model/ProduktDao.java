package pl.coderslab.model;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProduktDao {
    public static List<Product> getList() {
        List<Product> products = new ArrayList<>();

        Product gruszki = new Product();
        gruszki.setId(1L);
        gruszki.setName("Gruszki");
        gruszki.setPrice(10.21d);
        products.add(gruszki);

        Product jablka = new Product();
        jablka.setId(2L);
        jablka.setName("Jabłka");
        jablka.setPrice(6.21d);
        products.add(jablka);

        Product skarpetki = new Product();
        skarpetki.setId(3L);
        skarpetki.setName("Skarpetki");
        skarpetki.setPrice(10d);
        products.add(skarpetki);

        Product landrynki = new Product();
        landrynki.setId(4L);
        landrynki.setName("Landrynki");
        landrynki.setPrice(1.01d);
        products.add(landrynki);

        return products;
    }
}
