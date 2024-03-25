using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Task3
{
    internal class Customer
    {
        public int Id { get; }
        public string Name { get; }
        public string Address { get; }
        public string Email { get; }
        public List<Order> Orders { get; }

        public Customer(int id, string name, string address, string email)
        {
            Id = id;
            Name = name;
            Address = address;
            Email = email;
            Orders = new List<Order>();
        }

        public void PlaceOrder(Order order)
        {
            Orders.Add(order);
            Console.WriteLine($"Order {order.Id} has been placed by customer {Name}.");
        }

        public void Pay(Order order)
        {
            order.Status = "Paid";
            Console.WriteLine($"Order {order.Id} has been paid by customer {Name}.");
        }
    }


}
