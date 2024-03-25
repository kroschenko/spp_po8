using System;
using System.Collections.Generic;
using Task3;
class Program
{
    static void Main(string[] args)
    {
        Product product1 = new Product(1, "Laptop", 999.99, "Chuwi Gemibook Pro");
        Product product2 = new Product(2, "Phone", 499.99, "Xiaomi redmi Note 10");

        Order order1 = new Order(1);
        order1.AddProduct(product1);
        order1.AddProduct(product2);

        Customer customer1 = new Customer(1, "Alexandra", "ul. Moskocskaya 68", "alexa@gmail.com");
        customer1.PlaceOrder(order1);
        Sale sale1 = new Sale(1, order1.TotalAmount, order1.Products);

        Admin admin = new Admin(1, "Admin");
        order1.PrintProducts();
        customer1.Pay(order1);

        admin.RegisterSale(sale1);

        if (!(admin.checkOrderStatus(order1, customer1)))
        {
            admin.AddToBlacklist(customer1);
        }
       
    }
}
