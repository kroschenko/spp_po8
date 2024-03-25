using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
namespace Task3
{
    internal class Blacklist
    {
        public List<Customer> Customers { get; }

        public Blacklist()
        {
            Customers = new List<Customer>();
        }

        public void AddToBlacklist(Customer customer)
        {
            Customers.Add(customer);
            Console.WriteLine($"Customer {customer.Name} added to the blacklist.");
        }
    }
}
