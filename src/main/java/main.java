
import java.io.*;

import java.math.BigInteger;
import java.util.Collection;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class main {





    public static void main(String[] args) throws IOException {


        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int countTask = Integer.parseInt(tokenizer.nextToken());
        long widthStep = Long.parseLong(tokenizer.nextToken());
        long countTry = Long.parseLong(tokenizer.nextToken());
        StringTokenizer tokenizer2 = new StringTokenizer(reader.readLine());


        long[] arr = new long[countTask];
        long min = 10000000000L;

        for (int i = 0; i < countTask; i++) {
               long ll = Long.parseLong(tokenizer2.nextToken());
               if(ll < min )
                   min = ll;

               arr[i] = ll;
       }

        long maxValRich =  min + ( countTry * widthStep);

        PriorityQueue<Long> minHeap = new PriorityQueue();

       for(int k = 0; k < arr.length ;k++){

           if(arr[k] != 0 && arr[k] < maxValRich && !minHeap.contains(arr[k]))
               minHeap.add(arr[k]);
       }


        for(int j = 1; j < countTry ; j++) {

            long first = minHeap.poll();

            while(minHeap.size() > 0 && minHeap.peek() == first)
                minHeap.remove();

            minHeap.add(first + widthStep);
        }

        BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
        writer.append(String.valueOf(minHeap.peek()));
        writer.close();

    }

}