using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Task2
{
    
 
    internal class Page
    {
        private List<Line> lines;

        public Page(List<Line> lines)
        {
            this.lines = lines;
        }

        public int LineCount()
        {
            return lines.Count;
        }

        public List<Line> GetLines()
        {
            return lines;
        }

        public void AddLine(Line line)
        {
            lines.Add(line);
        }
    
}
}
