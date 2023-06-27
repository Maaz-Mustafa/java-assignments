package q1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Occurrences {

    public static void countOccurrences(String sentence){
        Map<String,Integer> countMap=new HashMap<String,Integer>();
        String[] wordsArray=sentence.split(" ");
        Arrays.stream(wordsArray).forEach(word->{

            
            else{
                countMap.put(word,1);
            }

        });

        for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
    public static void main(String[] args) {
    countOccurrences("people love to love people");
    }
}
