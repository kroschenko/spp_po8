namespace sppLab5z2;

public class DistInfo
{
    public static Graph g = new Graph();

    public static void Init()
    {
        g.AddVertex("A");
        g.AddVertex("B");
        g.AddVertex("C");
        g.AddVertex("D");
        g.AddVertex("E");
        g.AddVertex("F");


        g.AddEdge("A", "B", 7);
        g.AddEdge("A", "E", 4);
        g.AddEdge("B", "C", 5);
        g.AddEdge("B", "F", 2);
        g.AddEdge("E", "F", 3);
        g.AddEdge("E", "D", 8);
        g.AddEdge("C", "D", 11);
        g.AddEdge("C", "F", 6);
        g.AddEdge("D", "F", 9);
    }

    public static int GetDistance(string start, string end)
    {
        var dijkstra = new Dijkstra(g);
        var path = dijkstra.FindShortestPath(start, end);
        Console.WriteLine(path);
        return path;
    }
}