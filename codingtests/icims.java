package sorting;

import java.util.ArrayList;

public class Test {
	public static int time(String E, String L) {
        // write your code in Java SE 8
        String[] start_time = E.split(":");
        String[] stop_time = L.split(":");
        Integer start_hour = Integer.parseInt(start_time[0]);
        int start_minute = Integer.parseInt(start_time[1]);
        int end_hour = Integer.parseInt(stop_time[0]);
        int end_minute = Integer.parseInt(stop_time[1]);
        double start_time_hours = start_hour + (double) start_minute / 60;
        double end_time_hours = end_hour + (double) end_minute / 60;
        double diff = end_time_hours - start_time_hours;
        // System.out.println(end_time_hours - start_time_hours);
        if (end_time_hours <= start_time_hours)
            return 0;
        else if (diff < 1) 
            return 5;
        else {
        	int hasDecimal = 0;
        	//System.out.println(diff);
        	if (diff % 1 != 0) {
        		hasDecimal = 1;
        		//System.out.println("has decimal");
        	} else {
        		//System.out.println("has no decimal");
        	}	
            return 5 + 4 * ((int)(diff) + hasDecimal - 1);
        }
    }
	
	public static int sequence(int N) {
		if (N < 0)
			return -1;
		else if (N == 0)
			return 0;
		else if (N == 1)
			return 1;
		ArrayList<Integer> sequence = new ArrayList<Integer>();
		sequence.add(1);
		int half = N / 2;
		int potentialSequence = 2;
		while (potentialSequence <= half) {
			sequence.add(potentialSequence);
			potentialSequence *= 2;
		}
		while (sequence.get(sequence.size() - 1) != half) {
			potentialSequence = sequence.get(sequence.size() - 1) + 1;
			sequence.add(potentialSequence);
		}
		potentialSequence = sequence.get(sequence.size() - 1) * 2;
		sequence.add(potentialSequence);
		while (sequence.get(sequence.size() - 1) != N) {
			potentialSequence = sequence.get(sequence.size() - 1) + 1;
			sequence.add(potentialSequence);
		}
		System.out.println(sequence.toString());
		return sequence.size();
	}
	
	public static int binShift(int N) {
		int largest = N;
        int shift = 0;
        int temp = 0;
        int maxN = 0x3fffffff;
        for (int i = 1; i < 30; i++) {
            temp = ((N << 30 - i) & maxN | (N >> i) & maxN);
            if (temp > largest) {
                largest = temp;
                shift = i;
            }
        }
        return shift;
    }
	
	public static void main(String[] args) {
		System.out.println(time("13:20", "13:21"));
		//System.out.println(time("09:42", "11:42"));
		//System.out.println(sequence(2));
		//System.out.println(binShift(9736));
	}
}
