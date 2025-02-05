public class FUber {
    public static float euclidean(float x1, float y1, float x2, float y2) {
        float dx = x2 - x1;
        float dy = y2 - y1;

        float squaredDifferenceX = dx * dx;
        float squaredDifferenceY = dy * dy;

        float sumOfSquares = squaredDifferenceX + squaredDifferenceY;
        float distance = (float) Math.sqrt(sumOfSquares);
        
        return distance;
    }

    public static float manhattan(float x1, float y1, float x2, float y2) {
        float differenceX = Math.abs(x2 - x1);
        float differenceY = Math.abs(y2 - y1);

        float distance = differenceX + differenceY;

        return distance;
    }

    public interface Queue{
        void enqueue(int item);
        int dequeue();
        int peek();
        boolean isEmpty();
        int size();
    }




    public static void main(String[] args) {
        float x1 = 5;
        float y1 = 4;
        float x2 = 8;
        float y2 = 1;

        float euclideanDistance = euclidean(x1, y1, x2, y2);
        float manhattanDistance = manhattan(x1, y1, x2, y2);

        System.out.println("Euclidean Distance: " + euclideanDistance);
        System.out.println("Manhattan Distance: " + manhattanDistance);
    }
}