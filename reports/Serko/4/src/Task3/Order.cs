using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Task3
{
    internal class Order
    {
        public int Id { get; }
        public List<Product> Products { get; }
        public string Status { get; set; }
        public double TotalAmount { get; set; }

        public Order(int id)
        {
            Id = id;
            Products = new List<Product>();
            Status = "Pending";
            TotalAmount = 0.0;
        }

        public void AddProduct(Product product)
        {
            Products.Add(product);
            TotalAmount += product.Price;
        }
        public void PrintProducts()
        {
            foreach (var product in Products)
            {
                Console.WriteLine($"{product.Name} {product.Description} {product.Price}");

            }
        }

    }
}
