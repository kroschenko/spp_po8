using System;
using System.Collections.Generic;

public abstract class MenuItem
{
    public string Name { get; protected set; }
    public decimal Price { get; protected set; }

    public MenuItem(string name, decimal price)
    {
        Name = name;
        Price = price;
    }
}

public class Burger : MenuItem
{
    public BurgerCategory Category { get; private set; }

    public Burger(string name, decimal price, BurgerCategory category) : base(name, price)
    {
        Category = category;
    }
}

public class Drink : MenuItem
{
    public DrinkCategory Category { get; private set; }

    public Drink(string name, decimal price, DrinkCategory category) : base(name, price)
    {
        Category = category;
    }
}

public class Order
{
    private List<MenuItem> items = new List<MenuItem>();

    public void AddItem(MenuItem item)
    {
        items.Add(item);
    }

    public decimal CalculateTotal()
    {
        decimal total = 0;
        foreach (var item in items)
        {
            total += item.Price;
        }
        return total;
    }
}

public enum BurgerCategory
{
    Vegan,
    Meat
}

public enum DrinkCategory
{
    Cold,
    Hot
}

class Program
{
    static void Main(string[] args)
    {
        Order order = new Order();
        Burger veganBurger = new Burger("Vegan Burger", 5.99m, BurgerCategory.Vegan);
        Drink coldDrink = new Drink("Cold Drink", 1.99m, DrinkCategory.Cold);
        order.AddItem(veganBurger);
        order.AddItem(coldDrink);
        Console.WriteLine("Total: $" + order.CalculateTotal());
    }
}
