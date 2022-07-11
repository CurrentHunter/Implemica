package src.com.currenthunter;

import static java.util.Arrays.fill;

//Additional class in order to create graph structure
public class Graph {

    private final int INFINITY = Integer.MAX_VALUE;  //will use this as infinity

    public Graph(int vertices){
        relationMatrix = new int[vertices][vertices];
    }

    //Matrix for costs
    private int[][] relationMatrix;

    //create matrix with number of vertex of the graph


    //set transportation cost between connected cities
    public void setCost(int city, int neighbour, int cost) {
        relationMatrix[city][neighbour] = cost;
    }

    //get cost from matrix
    //if city is same - cost = 0
    //if no cost set - there is no connection between cities (infinity)
    public int getCost(int i, int j){
        if (i == j) {
            return 0;
        }
        if (relationMatrix[i][j] == 0) {
            return INFINITY;
        }
        return relationMatrix[i][j];
    }

    //Method to find minimum transportation cost
    int findMinCost(int sourceIndex, int destinationIndex){

        //array of visited cities
        boolean[] visited = new boolean[relationMatrix.length];

        //table of costs to each city from source city
        //by default all costs will equal to infinity
        //cost to own city equals to 0
        int[] costs = new int[relationMatrix.length];
        fill(costs, INFINITY);
        costs[sourceIndex] = 0;

        while(true){

            int index = -1;

            //loop to pass all cities
            for (int vertex = 0; vertex < relationMatrix.length; vertex++){

                //condition to find closest non-visited city
                if (!visited[vertex] && costs[vertex] < INFINITY && (index == -1 || costs[index] > costs[vertex]))
                    index = vertex;
                }

            // no more cities, break from endless loop
            if (index == -1) break;

            //mark current city as visited
            visited[index] = true;


            for (int vertex = 0; vertex < relationMatrix.length; vertex++){

                //improve transporation cost for all non-visited connected cities
                if (!visited[vertex] && getCost(index, vertex) < INFINITY)
                    costs[vertex] = Math.min(costs[vertex], costs[index] + getCost(index, vertex));
            }
        }
        //take from array cost to the destination
        return costs[destinationIndex];
    }
}
