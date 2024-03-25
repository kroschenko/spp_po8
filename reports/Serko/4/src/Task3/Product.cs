using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Task3
{
    internal class Product
    {
        public int Id { get; }
        public string Name { get; }
        public double Price { get; }
        public string Description { get; }

        public Product(int id, string name, double price, string description)
        {
            Id = id;
            Name = name;
            Price = price;
            Description = description;
        }

        public string GetProductInfo()
        {
            return $"ID: {Id}, Name: {Name}, Price: {Price}$, Description: {Description}";
        }
    }

}
