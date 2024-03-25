using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Task3
{

    internal class Sale
    {
        public int Id { get; }
        public DateTime Date { get; }
        public double Amount { get; }
        public List<Product> ProductsSold { get; }

        public Sale(int id, double amount, List<Product> products)
        {
            Id = id;
            Date = DateTime.Now;
            Amount = amount;
            ProductsSold = products;
        }

        public string GetSaleInfo()
        {
            return $"ID: {Id}, Date: {Date}, Amount: {Amount}$";
        }
    }
}
