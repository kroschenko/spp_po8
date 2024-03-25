using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Task3
{
    internal class Admin
    {
        public int Id { get; }
        public string Name { get; }
        public List<Sale> Sales { get; }
        public List<Customer> Blacklist { get; }

        public Admin(int id, string name)
        {
            Id = id;
            Name = name;
            Sales = new List<Sale>();
            Blacklist = new List<Customer>();
        }

        public void AddProductInfo(Product product)
        {
            Console.WriteLine($"Product added: {product.GetProductInfo()}");
        }

        public void RegisterSale(Sale sale)
        {
            Sales.Add(sale);
            Console.WriteLine($"Sale registered: {sale.GetSaleInfo()}");
        }

        public void AddToBlacklist(Customer customer)
        {
            Blacklist.Add(customer);
            Console.WriteLine($"Customer {customer.Name} added to the blacklist.");
        }
        public bool checkOrderStatus(Order order, Customer customer)
        {
            if (order.Status != "Paid")
            {
                return false;

            }
            return true;

        }
    }
}
