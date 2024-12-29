import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Graph<T> {
    private List<Vertex<T>> vertices = new ArrayList<>();

    public Vertex<T> createVertex(T value) {
        Vertex<T> v = new Vertex<>(value);
        vertices.add(v);
        return v;
    }

    public void createEdge(Vertex<T> a, Vertex<T> b) {
        // добавляем их друг друга в их списки смежности
        // ВАШ КОД
    }

    public boolean isConnected(Vertex<T> a, Vertex<T> b) {
        return dfsFind(a, b, new HashSet<>()); // рекурсивный обход в глубину
    }

    // метод отвечает на вопрос, нашли ли мы обходом из v вершину target с учётом
    // посещённых вершин, которые записаны в visited
    private boolean dfsFind(Vertex<T> v, Vertex<T> target, Set<Vertex<T>> visited) {
        // если вершина в которую зашли (v) это та которую мы искали (target), то поиск закончен
        if (v.equals(target)) {
            return true; // нашли
        }

        visited.add(v); // запоминаем вершину которую посетили

        // перебираем все смежные вершины у v
        for (Vertex<T> neighbor : v.getNeighbors()) {
            // если такую вершину ещё не посещали
            if (!visited.contains(neighbor)) {
                // заходим рекурсивно в неё
                if (dfsFind(neighbor, target, visited)) {
                    return true; // если нашли target, выходим с true
                }
            }
        }

        return false; // ничего не нашли
    }
}

