package hillel;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import java.util.stream.Collectors;


import static java.lang.Math.min;

public class Product {
    private String type;
    private double price;
    private boolean discount;
    private LocalDateTime time;

    public Product(String type, double price, boolean discount, LocalDateTime time) {
        this.type = type;
        this.price = price;
        this.discount = discount;
        this.time = time;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isDiscount() {
        return discount;
    }

    public void setDiscount(boolean discount) {
        this.discount = discount;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(product.price, price) == 0 && discount == product.discount && Objects.equals(type, product.type) && Objects.equals(time, product.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, price, discount, time);
    }

    @Override
    public String toString() {
        return "Product{" +
                "type='" + type + '\'' +
                ", price=" + price +
                ", discount=" + discount +
                ", time=" + time +
                '}';
    }

    // Method about point 1

    public static List<Product> receiptTypeProduct(List<Product> list, String typeName, double costet) {
        List<Product> productList = list.stream().filter(s -> s.getType().equals(typeName) && s.getPrice() > costet)
                .collect(Collectors.toList());

        return productList;
    }
    // Method about point 2

    public static List<Product> receiptDiscountProduct(List<Product> list, String typeName) {
        double discount = 10;
        List<Product> productList = list.stream()
                .filter(s -> s.getType().equals(typeName))
                .filter(Product::isDiscount)
                .map(s -> new Product(s.getType(), s.getPrice() * (1 - discount / 100), s.isDiscount(), s.getTime()))
                .collect(Collectors.toList());
        return productList;
    }

    // Method about point 3

    public static void receiptMinPrice(List<Product> list, String typeName) throws NotTypeNameException {
        if (typeName != "Book")
            throw new NotTypeNameException("Type " + typeName + " not founded");
        try {
            Product minProduct = list.stream()
                    .filter(s -> s.getType().equals(typeName))
                    .min((x, y) -> (int) (x.getPrice() - y.getPrice())).get();


            System.out.println(minProduct);
        } catch (Exception e) {
            new NotTypeNameException("Type " + typeName + " not founded");
        }
    }


    // Method about point 4

    public static List<Product> sortedProductYear(List<Product> list) {
        List<Product> productList = list.stream()
                .sorted((x, y) -> x.getTime().compareTo(y.getTime()))
                .skip(7)
                .collect(Collectors.toList());

        return productList;
    }

    // Method about point 5

    public static void calculation(List<Product> list, String typeName) {

        Integer totalPrice = list.stream()
                .filter(s -> s.getType().equals(typeName) && s.getPrice() <= 75)
                .reduce(0, (a, e) -> (int) (a + e.getPrice()), (c1, c2) -> c1 + c2);

        System.out.println("Total price: " + totalPrice);


    }

    // Method about point 6

    public static void sortedMap(List<Product> list) {
        Map<String, List<Product>> productMap = list.stream()
                .collect(Collectors.groupingBy((Product::getType), Collectors.toList()));
        System.out.println(productMap);

    }
}









