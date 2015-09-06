// Copy paste this Java Template and save it as "BabyNames.java"
import java.util.*;
import java.io.*;

// write your matric number here: A0103516U
// write your name here: Akshat Dubey
// write list of collaborators here: Suranjana Sengupta
// year 2015 hash code: JESg5svjYpIsmHmIjabX (do NOT delete this line)

class BabyNames {
  // if needed, declare a private data structure here that
  // is accessible to all methods in this class

  // --------------------------------------------
  TreeSet<String> BoyBabies;
  TreeSet<String> GirlBabies;
  // --------------------------------------------

  public BabyNames() {
    // Write necessary code during construction;
    //
    // write your answer here

    // --------------------------------------------

	  BoyBabies = new TreeSet<String>();
	  GirlBabies = new TreeSet<String>();

    // --------------------------------------------
  }

  void AddSuggestion(String babyName, int genderSuitability) {
    // You have to insert the information (babyName, genderSuitability)
    // into your chosen data structure
    //
    // write your answer here

    // --------------------------------------------
	  if(genderSuitability == 1)
      BoyBabies.add(babyName);
    else
      GirlBabies.add(babyName);

    // --------------------------------------------
  }

  void RemoveSuggestion(String babyName) {
    // You have to remove the babyName from your chosen data structure
    //
    // write your answer here

    // --------------------------------------------

	BoyBabies.remove(babyName);
    GirlBabies.remove(babyName);

    // --------------------------------------------
  }

  int Query(String START, String END, int genderPreference) {
    int ans = 0;

    // You have to answer how many baby name starts
    // with prefix that is inside query interval [START..END)
    //
    // write your answer here

    // --------------------------------------------
    TreeSet<String> tempBoys = new TreeSet<String>();
    TreeSet<String> tempGirls = new TreeSet<String>();
    if(genderPreference == 0){
      tempBoys = (TreeSet<String>)BoyBabies.subSet(START, true, END, false);
      tempGirls = (TreeSet<String>)GirlBabies.subSet(START, true, END, false);
    }else if(genderPreference == 1){
      tempBoys = (TreeSet<String>)BoyBabies.subSet(START, true, END, false);
    }else if(genderPreference == 2){
      tempGirls = (TreeSet<String>)GirlBabies.subSet(START, true, END, false);
    }
    
    ans = tempBoys.size() + tempGirls.size();

    // --------------------------------------------

    return ans;
  }

  void run() throws Exception {
    // do not alter this method to avoid unnecessary errors with the automated judging
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    while (true) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int command = Integer.parseInt(st.nextToken());
      if (command == 0) // end of input
        break;
      else if (command == 1) // AddSuggestion
        AddSuggestion(st.nextToken(), Integer.parseInt(st.nextToken()));
      else if (command == 2) // RemoveSuggestion
        RemoveSuggestion(st.nextToken());
      else // if (command == 3) // Query
        pr.println(Query(st.nextToken(), // START
                         st.nextToken(), // END
                         Integer.parseInt(st.nextToken()))); // GENDER
    }
    pr.close();
  }

  public static void main(String[] args) throws Exception {
    // do not alter this method to avoid unnecessary errors with the automated judging
    BabyNames ps2 = new BabyNames();
    ps2.run();
  }
}