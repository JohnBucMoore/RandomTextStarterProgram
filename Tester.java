import edu.duke.FileResource;

import java.util.ArrayList;

public class Tester {
    public void testGetFollows() {
        MarkovOne m = new MarkovOne();
        m.setTraining("this is a test yes this is a test.");
        ArrayList<String> follows = m.getFollows("t");
        System.out.println(follows.toString());
        System.out.println(follows.size());
    }

    public void testGetFollowsWithFile() {
        FileResource fr = new FileResource();
        MarkovOne m = new MarkovOne();
        m.setTraining(fr.asString());
        ArrayList<String> follows = m.getFollows("t");
        System.out.println(follows.size());
    }

    public static void main(String[] args) {
        Tester t = new Tester();
        t.testGetFollowsWithFile();
    }
}
