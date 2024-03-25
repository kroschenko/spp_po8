using System.IO;
using System.Windows;
using System.Windows.Media;
using System.Windows.Media.Animation;
using Microsoft.Win32;


namespace sppLab7z1;

public partial class MainWindow : Window
{
    public MainWindow()
    {
        InitializeComponent();
        this.RegisterName("Path", MyPath);
        
        
        
        x.From = 0;
        x.To = 360;
        x.Duration = TimeSpan.FromSeconds(1);
        x.RepeatBehavior = RepeatBehavior.Forever;
        Storyboard.SetTargetName(x, "Path");
        Storyboard.SetTargetProperty(x, new PropertyPath($"(Path.RenderTransform).(RotateTransform.Angle)"));
        storyboard.Children.Add(x);
    }

    Storyboard storyboard = new Storyboard();
    DoubleAnimation x = new DoubleAnimation();
    private bool checker = true;
    

    private void Button1_OnClick(object sender, RoutedEventArgs e)
    {
        if (checker)
        {
            checker = !checker;
            storyboard.Begin(MyPath, true);
        }
        
        
        storyboard.Resume(MyPath);
    }

    private void Button2_OnClick(object sender, RoutedEventArgs e)
    {
        storyboard.Pause(MyPath);
    }

    private void Button3_OnClick(object sender, RoutedEventArgs e)
    {
        OpenFileDialog openFileDialog = new OpenFileDialog();
        if (openFileDialog.ShowDialog() == true)
        {
            string[] data = new string[6];
            using (StreamReader reader = new StreamReader(openFileDialog.FileName))
            {
                data = reader.ReadToEnd().Trim().Split(" ");
            }

            int x1 = Convert.ToInt32(data[0]);
            int y1 = Convert.ToInt32(data[1]);
            int x2 = Convert.ToInt32(data[2]);
            int y2 = Convert.ToInt32(data[3]);
            int x3 = Convert.ToInt32(data[4]);
            int y3 = Convert.ToInt32(data[5]);
            MyFigure.StartPoint = new Point(x1, y1);
            MyFigure.Segments.Add(new LineSegment(new Point(x2,y2),true));
            MyFigure.Segments.Add(new LineSegment(new Point(x3,y3),true));
            TriangleRotateTransform.CenterX = (x1 + x2 + x3) / 3;
            TriangleRotateTransform.CenterY = (y1 + y2 + y3) / 3;
        }
        
    }
}