package src.com.currenthunter;

import java.io.*;

//Dijkstra's algorithm is used to solve this task
public class Task2 {

    public static void main(String[] args) throws IOException {

        //Location of input file
        BufferedReader br = new BufferedReader(new FileReader("src/resources/input"));

        //Number of tests
        String line = br.readLine();
        int testsNumber = Integer.parseInt(line);

        //Loop for number of tests
        for (int test = 0; test < testsNumber; test++) {

            //Number of cities
            line = br.readLine();
            int citiesNumber = Integer.parseInt(line);
            String[] cities = new String[citiesNumber];
            Graph graph = new Graph(citiesNumber);


            //Loop for number of cities
            for (int city = 0; city < citiesNumber; city++) {

                //City name
                line = br.readLine();
                String cityName = line;
                cities[city] = cityName;

                //Number of neighbours
                line = br.readLine();
                int neighboursNum = Integer.parseInt(line);

                //Loop for neighbours
                for (int neighbour = 0; neighbour < neighboursNum; neighbour++) {

                    //Index of city and cost
                    line = br.readLine();
                    String[] lineToSplit = line.split(" ");

                    int neighbourIndex = Integer.parseInt(lineToSplit[0]);
                    int transportationCost = Integer.parseInt(lineToSplit[1]);

                    graph.setCost(city, neighbourIndex-1, transportationCost);
                }
            }

            //Number of path to find
            line = br.readLine();
            int pathToFind = Integer.parseInt(line);

            for (int route = 0; route < pathToFind; route++) {

                //Source and destination cities
                line = br.readLine();
                String[] cityNames = line.split(" ");
                String source = cityNames[0];
                String destination = cityNames[1];
                int sourceIndex = 0;
                int destinationIndex = 0;

                //Find index of source city
                for (int i = 0; i < cities.length; i++){
                    if(source.equals(cities[i])){
                        sourceIndex = i;
                        break;
                    }
                }

                //Find index of destination city
                for (int i = 0; i < cities.length; i++){
                    if(destination.equals(cities[i])){
                        destinationIndex = i;
                        break;
                    }
                }

                //Output format is the same as in the example
                System.out.println(graph.findMinCost(sourceIndex, destinationIndex));
            }
        }
    }
}