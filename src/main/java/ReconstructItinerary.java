import java.util.*;

public class ReconstructItinerary implements ISolution {

    private List<String> findItinerary(List<List<String>> tickets) {
        // build the graph
        Map<String,PriorityQueue<String>> flights = new HashMap<>();
        for(List<String> ticket: tickets){
            String from = ticket.get(0);
            String to = ticket.get(1);
            PriorityQueue<String> arrivals= flights.getOrDefault(from, new PriorityQueue<>());
            arrivals.offer(to);
            flights.put(from,arrivals);
        }

        // Hierholzer’s Algorithm
        LinkedList<String> itinerary = new LinkedList<>();
        dfs("JFK", flights , itinerary);

        // Iterative DFS
//        Stack<String> s = new Stack<>();
//        s.push("JFK");
//        while(!s.isEmpty()){
//            String from = s.pop();
//            PriorityQueue<String> q = flights.getOrDefault(from,new PriorityQueue<>());
//            if(!q.isEmpty()){
//                s.push(from);
//                s.push(q.poll());
//            }
//            else{
//                itinerary.addFirst(from);
//            }
//        }

        return itinerary;
    }

    private void dfs(String departure, Map<String, PriorityQueue<String>> flights, LinkedList<String> itinerary) {
        PriorityQueue<String> arrivals = flights.get(departure);
        while (arrivals != null && !arrivals.isEmpty())
            dfs(arrivals.poll(), flights,itinerary);
        itinerary.addFirst(departure);
    }

    @Override
    public void showProblemDetails() {
        System.out.println("#[332] Reconstruct Itinerary");
        System.out.println("https://leetcode.com/problems/reconstruct-itinerary/");
        System.out.println();
    }

    @Override
    public void execute() {
        List<List<String>> input = new ArrayList<>();
        input.add(Arrays.asList("JFK","KUL"));
        input.add(Arrays.asList("KUL","JFK"));
        input.add(Arrays.asList("JFK","LHR"));
        input.add(Arrays.asList("JFK","NRT"));
        input.add(Arrays.asList("NRT","SFO"));
        input.add(Arrays.asList("SFO","JFK"));

        System.out.println("Input: "+ input);
        List<String> output = findItinerary(input);

        System.out.println("Output: " + output);
    }
}
