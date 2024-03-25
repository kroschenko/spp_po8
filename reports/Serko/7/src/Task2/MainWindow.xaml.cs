using System.Drawing;
using System.Text;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;

namespace Task2
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        private int depth = 10; 
        private double angle = Math.PI / 4;

        public MainWindow()
        {
            InitializeComponent();
        }
        public class VectorF
        {
            public float X, Y;

            public VectorF(float x, float y)
            {
                X = x;
                Y = y;
            }
            public VectorF(VectorF v)
            {
                X = v.X;
                Y = v.Y;
            }

            public static VectorF operator +(VectorF v1, VectorF v2)
            {
                return new VectorF(v1.X + v2.X, v1.Y + v2.Y);
            }

            public static VectorF operator -(VectorF v1, VectorF v2)
            {
                return new VectorF(v1.X - v2.X, v1.Y - v2.Y);
            }

            public static VectorF operator -(VectorF vector)
            {
                return new VectorF(-vector.X, -vector.Y);
            }

            public static VectorF operator *(VectorF vector, float scale)
            {
                return new VectorF(vector.X * scale, vector.Y * scale);
            }
            public static VectorF operator *(float scale, VectorF vector)
            {
                return vector * scale;
            }

            public static VectorF operator /(VectorF vector, float scale)
            {
                return new VectorF(vector.X / scale, vector.Y / scale);
            }

            public float Length
            {
                get
                {
                    return (float)Math.Sqrt(X * X + Y * Y);
                }
                set
                {
                    float scale = value / Length;
                    X *= scale;
                    Y *= scale;
                }
            }

            public VectorF Scale(float scale)
            {
                return this * scale / Length;
            }

            public void Normalize()
            {
                Length = 1;
            }

   
            public VectorF PerpendicularCCW()
            {
                return new VectorF(Y, -X);
            }

            public VectorF PerpendicularCW()
            {
                return new VectorF(-Y, X);
            }
        }


        private void DrawBranch(Canvas canvas, SolidColorBrush penBrush, SolidColorBrush fillBrush,
       int depth, PointF llCorner, VectorF vBase, double alpha)
        {
            VectorF vHeight = vBase.PerpendicularCCW();
            VectorF startPoint = new VectorF(llCorner.X, llCorner.Y); 
            VectorF[] points =
            {
        startPoint,
        startPoint + vBase,
        startPoint + vBase + vHeight,
        startPoint + vHeight,
    };

            var polygon = new Polygon
            {
                Points = new PointCollection(points.Select(p => new System.Windows.Point(p.X, p.Y))),
                Stroke = penBrush,
                Fill = fillBrush
            };
            canvas.Children.Add(polygon);

            if (depth > 0)
            {
                double w1 = vBase.Length * Math.Cos(alpha);
                float wb1 = (float)(w1 * Math.Cos(alpha));
                float wh1 = (float)(w1 * Math.Sin(alpha));
                VectorF vBase1 = vBase.Scale(wb1) + vHeight.Scale(wh1);
                PointF llCorner1 = new PointF(llCorner.X + vHeight.X, llCorner.Y + vHeight.Y); 
                DrawBranch(canvas, penBrush, fillBrush, depth - 1, llCorner1, vBase1, alpha);

                double beta = Math.PI / 2.0 - alpha;
                double w2 = vBase.Length * Math.Sin(alpha);
                float wb2 = (float)(w2 * Math.Cos(beta));
                float wh2 = (float)(w2 * Math.Sin(beta));
                VectorF vBase2 = vBase.Scale(wb2) - vHeight.Scale(wh2);
                PointF llCorner2 = new PointF(llCorner1.X + vBase1.X, llCorner1.Y + vBase1.Y);
                DrawBranch(canvas, penBrush, fillBrush, depth - 1, llCorner2, vBase2, alpha);
            }
        }
        private void DrawTree(object sender, RoutedEventArgs e)
        {
            canvas.Children.Clear();

            try
            {
                int depth = (int)sliderDepth.Value;
                int length = (int)sliderLength.Value;
                float alpha = (float)((double)sliderAlpha.Value * Math.PI / 180.0);
                double rootX = canvas.ActualWidth / 2;
                double rootY = canvas.ActualHeight * 0.9;
                VectorF vBase = new VectorF(length, 0);
                PointF llCorner = new PointF((float)(rootX - vBase.X / 2), (float)(rootY - vBase.Y / 2));

                System.Windows.Media.SolidColorBrush brush = null;
                if (chkFill.IsChecked == true) brush = Brushes.Green;

                DrawBranch(canvas, Brushes.Black, brush, depth, llCorner, vBase, alpha);
            }
            catch (Exception ex)
            {
                MessageBox.Show($"An error occurred: {ex.Message}");
            }
        }

       
    }
}