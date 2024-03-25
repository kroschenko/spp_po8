namespace sppLab3z1;

public class Rectangle
{
    private double _a;
    private double _b;

    public double A
    {
        get => _a;
        set => _a = value;
    }

    public double B
    {
        get => _b;
        set => _b = value;
    }

    public Rectangle(double a, double b)
    {
        _a = a;
        _b = b;
    }

    public Rectangle()
    {
        _a = 1d;
        _b = 1d;
    }
    public double Square()
    {
        return _a * _b;
    }

    public double Perimeter()
    {
        return 2 * (_a + _b);
    }

    public bool IsSquare()
    {
        if (_a == _b)
        {
            return true;
        }
        return false;
    }

    public override string ToString()
    {
        return $"a: {_a}, b: {_b}";
    }

    public bool Equals(Rectangle rectangle)
    {
        if (_a == rectangle._a && _b == rectangle._b)
        {
            return true;
        }

        return false;
    }
}