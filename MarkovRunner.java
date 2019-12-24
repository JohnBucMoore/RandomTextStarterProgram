
/**
 * Write a description of class MarkovRunner here.
 * 
 * @author Duke Software
 * @version 1.0
 */

import edu.duke.*;

import java.io.File;
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

	public void runMarkovFour() {
		FileResource fr = new FileResource();
		String st = fr.asString();
		st = st.replace('\n', ' ');
		MarkovFour m = new MarkovFour();
		m.setRandom(25);
		m.setTraining(st);
		for (int k = 0; k < 3; k++) {
			String text = m.getRandomText(500);
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
		runMarkovFour();
	}

	public static void main(String[] args) {
		MarkovRunner mr = new MarkovRunner();
		mr.test();
	}
}
