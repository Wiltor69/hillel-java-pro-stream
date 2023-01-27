package hillel;

import java.time.LocalDateTime;

import java.util.List;

public class Main {
    public static void main(String[] args) throws NotTypeNameException {
        Product pr1 = new Product("Book", 51.50, true, LocalDateTime.of(2022, 11, 21, 13, 44));
        Product pr2 = new Product("Book", 15.37, false, LocalDateTime.of(2019, 07, 11, 10, 00));
        Product pr3 = new Product("Toy", 100.25, false, LocalDateTime.of(2023, 01, 21, 11, 16));
        Product pr4 = new Product("Toy", 326.15, false, LocalDateTime.of(2021, 11, 05, 17, 00));
        Product pr5 = new Product("Pen", 1348.65, true, LocalDateTime.of(2023, 01, 16, 12, 23));
        Product pr6 = new Product("Pen", 786.53, true, LocalDateTime.of(2022, 03, 07, 9, 45));
        Product pr7 = new Product("Book", 323.25, true, LocalDateTime.of(2023, 01, 11, 15, 45));
        Product pr8 = new Product("Book", 176.75, false, LocalDateTime.of(2021, 05, 30, 11, 55));
        Product pr9 = new Product("Toy", 874.16, true, LocalDateTime.of(2022, 11, 05, 18, 15));
        Product pr10 = new Product("Pen", 150.00, true, LocalDateTime.of(2019, 06, 25, 12, 12));

        List<Product> products = List.of(pr1, pr2, pr3, pr4, pr5, pr6, pr7, pr8, pr9, pr10);

        System.out.println(products);

        System.out.println("--------------------------Point 1-----------------------------------------------------------");

        System.out.println(Product.receiptTypeProduct(products, "Book", 250.00));

        System.out.println("---------------------------Point 2----------------------------------------------------------");

        System.out.println(Product.receiptDiscountProduct(products, "Book"));

        System.out.println("----------------------------Point 3---------------------------------------------------------");

        Product.receiptMinPrice(products, "Book");

        System.out.println("----------------------------Point 4---------------------------------------------------------");

        System.out.println(Product.sortedProductYear(products));

        System.out.println("----------------------------Point 5---------------------------------------------------------");

        Product.calculation(products, "Book");

        System.out.println("----------------------------Point 6---------------------------------------------------------");

        Product.sortedMap(products);
    }
}
