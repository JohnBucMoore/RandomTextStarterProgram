
/**
 * Write a description of class MarkovRunner here.
 * 
 * @author Duke Software
 * @version 1.0
 */

import edu.duke.*;

import java.util.ArrayList;

public class MarkovRunner {
    public void runMarkovZero() {
		FileResource fr = new FileResource();
		String st = fr.asString();
		st = st.replace('\n', ' ');
		MarkovZero markov = new MarkovZero();
		markov.setRandom(100);
		markov.setTraining(st);
		for(int k=0; k < 3; k++){
			String text = markov.getRandomText(500);
			printOut(text);
		}
	}

	public void runMarkovOne() {
    	FileResource fr = new FileResource();
    	String st = fr.asString();
    	st = st.replace('\n', ' ');
    	MarkovOne mOne = new MarkovOne();
    	mOne.setRandom(42);
    	mOne.setTraining(st);
    	for (int k = 0; k < 3; k++) {
    		String text = mOne.getRandomText(500);
    		printOut(text);
		}
	}
	
	private void printOut(String s){
		String[] words = s.split("\\s+");
		int psize = 0;
		System.out.println("----------------------------------");
		for(int k=0; k < words.length; k++){
			System.out.print(words[k]+ " ");
			psize += words[k].length() + 1;
			if (psize > 60) {
				System.out.println();
				psize = 0;
			}
		}
		System.out.println("\n----------------------------------");
	}

	public void test() {
    	//runMarkovOne();
    	MarkovOne m = new MarkovOne();
    	m.setTraining("this is a test yes this is a test.");
		ArrayList<String> following = m.getFollows("es");
		for (String s : following) {
			System.out.println(s);
		}
	}

	public static void main(String[] args) {
		MarkovRunner mr = new MarkovRunner();
		mr.test();
	}
}
