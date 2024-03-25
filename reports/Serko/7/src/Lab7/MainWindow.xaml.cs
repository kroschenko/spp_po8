using System;
using System.Windows;
using System.Windows.Shapes;
using System.Windows.Media.Animation;
using System.Windows.Controls;
using System.Windows.Media;
using System.IO;


namespace Lab7
{
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();
            CreateAndAnimateLine();
        }

        private void CreateAndAnimateLine()
        {
            Canvas canvas = new Canvas();
            canvas.Width = 600;
            canvas.Height = 400;
            Content = canvas;

            string[] lines = File.ReadAllLines("parameters.txt");
            double x1 = 0, y1 = 0, x2 = 0, y2 = 0;
            Color startColor = Colors.Black;
            Color endColor = Colors.Black;

            foreach (string line in lines)
            {
                string[] parts = line.Split('=');
                if (parts.Length == 2)
                {
                    string key = parts[0].Trim();
                    string value = parts[1].Trim();
                    switch (key)
                    {
                        case "X1":
                            x1 = double.Parse(value);
                            break;
                        case "Y1":
                            y1 = double.Parse(value);
                            break;
                        case "X2":
                            x2 = double.Parse(value);
                            break;
                        case "Y2":
                            y2 = double.Parse(value);
                            break;
                        case "StartColor":
                            startColor = (Color)ColorConverter.ConvertFromString(value);
                            break;
                        case "EndColor":
                            endColor = (Color)ColorConverter.ConvertFromString(value);
                            break;
                        default:
                            break;
                    }
                }
            }

            Line rotatingLine = new Line();
            rotatingLine.X1 = x1;
            rotatingLine.Y1 = y1;
            rotatingLine.X2 = x2;
            rotatingLine.Y2 = y2;
            rotatingLine.StrokeThickness = 2;

            SolidColorBrush solidColorBrush = new SolidColorBrush(startColor);
            rotatingLine.Stroke = solidColorBrush;

            canvas.Children.Add(rotatingLine);

            RotateTransform rotateTransform = new RotateTransform(0, x1, y1);
            rotatingLine.RenderTransform = rotateTransform;
            DoubleAnimation rotateAnimation = new DoubleAnimation
            {
                From = 0,
                To = 360,
                Duration = TimeSpan.FromSeconds(5),
                RepeatBehavior = RepeatBehavior.Forever
            };
            rotateTransform.BeginAnimation(RotateTransform.AngleProperty, rotateAnimation);

            ColorAnimation colorAnimation = new ColorAnimation
            {
                From = startColor,
                To = endColor,
                Duration = TimeSpan.FromSeconds(5),
                RepeatBehavior = RepeatBehavior.Forever,
                AutoReverse = true
            };
            solidColorBrush.BeginAnimation(SolidColorBrush.ColorProperty, colorAnimation);
        }
    }
}
