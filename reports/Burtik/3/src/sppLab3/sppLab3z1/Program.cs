using sppLab3z1;

Rectangle square = new Rectangle(3, 3);
Rectangle rectangle = new Rectangle(10,4);
Rectangle defaultRectangle = new Rectangle();
Console.WriteLine(rectangle);
Console.WriteLine(square.Perimeter());
Console.WriteLine(rectangle.Square());
Console.WriteLine(square.IsSquare());
Console.WriteLine(rectangle.Equals(defaultRectangle));