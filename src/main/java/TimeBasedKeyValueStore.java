import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TimeBasedKeyValueStore implements ISolution {

    private Map<String, TreeMap<Integer,String>> map;

    TimeBasedKeyValueStore() {
        map = new HashMap<>();
    }

    private void set(String key, String value, int timestamp) {
        TreeMap<Integer,String> timestampMap = map.getOrDefault(key,new TreeMap<>());
        timestampMap.put(timestamp,value);
        map.put(key,timestampMap);
    }

    private String get(String key, int timestamp) {
        if(map.containsKey(key)){
            TreeMap<Integer,String> timestampMap=map.get(key);
            Integer i = timestampMap.floorKey(timestamp); // find max i when prev_timestamp <= target_timestamp
            if(i!=null){
                return timestampMap.get(i);
            }
        }
        return "";
    }

    @Override
    public void showProblemDetails() {
        System.out.println("#[981] Time Based Key-Value Store");
        System.out.println("https://leetcode.com/problems/time-based-key-value-store/");
        System.out.println();
    }

    @Override
    public void execute() {

        System.out.println("Expected Result: \n" +
                "TimeMap kv;   \n" +
                "kv.set(\"foo\", \"bar\", 1); // store the key \"foo\" and value \"bar\" along with timestamp = 1   \n" +
                "kv.get(\"foo\", 1);  // output \"bar\"   \n" +
                "kv.get(\"foo\", 3); // output \"bar\" since there is no value corresponding to foo at timestamp 3 and timestamp 2, then the only value is at timestamp 1 ie \"bar\"   \n" +
                "kv.set(\"foo\", \"bar2\", 4);   \n" +
                "kv.get(\"foo\", 4); // output \"bar2\"   \n" +
                "kv.get(\"foo\", 5); //output \"bar2\"   ");

        System.out.println("\nActual Result: ");
        this.set("foo", "bar", 1); // store the key "foo" and value "bar" along with timestamp = 1
        System.out.println("kv.set(\"foo\", \"bar\", 1); // store the key \"foo\" and value \"bar\" along with timestamp = 1");

        String v1 = this.get("foo", 1);  // output "bar"
        System.out.println("kv.get(\"foo\", 1);  // output ["+ v1 +"]");

        String v2 = this.get("foo", 3); // output "bar" since there is no value corresponding to foo at timestamp 3 and timestamp 2, then the only value is at timestamp 1 ie "bar"
        System.out.println("kv.get(\"foo\", 3); // output ["+ v2 +"] since there is no value corresponding to foo at timestamp 3 and timestamp 2, then the only value is at timestamp 1 ie "+ v2);

        this.set("foo", "bar2", 4);
        System.out.println("kv.set(\"foo\", \"bar2\", 4);   ");

        String v3 = this.get("foo", 4); // output "bar2"
        System.out.println("kv.get(\"foo\", 4); // output ["+ v3 +"]");

        String v4 = this.get("foo", 5); //output "bar2"
        System.out.println("kv.get(\"foo\", 5); //output ["+ v4 +"]");
    }
}
