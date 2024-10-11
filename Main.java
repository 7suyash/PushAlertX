 import java.util.*;
import java.util.Vector;
public class Main {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Vector<String> vec=new Vector<>();
		String list[][]={{"Idea of you","Fall guy","After"},{"Tag","10","Bhool bhulaiya"},{"Alien","Mad max","Predator"},{"Tumbbad","Alone","No exit"}};
		String genre[]={"Drama","Comedy","thriller","action"};
		int ans;
		do{
		    System.out.println("Enter the genre 1. Drama 2.Comdey 3.thriller 4. action 5. exit");
		    ans=sc.nextInt();
		    if(ans!=5){
		    vec.add(genre[ans-1]);
		    }
		}while(ans!=5);
//System.out.println(vec.size());
	   String answer;
	   System.out.println("Movies recommend are:");
	   System.out.println();
	   
	 for(int i=0;i<vec.size();i++){
	    answer=vec.get(i);
	   switch(answer){
	       case "Drama": System.out.  println("Drama");
	       for(int j=0;j<3;j++){
	           System.out.println(list[0][j]);
	       }
	       System.out.println();
	       break;
	       case "Comedy": System.out.println("Comedy");
	       for(int j=0;j<3;j++){
	           System.out.println(list[1][j]);
	       }
	       System.out.println();
	     break;  
	       case "thriller": System.out.println("thriller");
	       for(int j=0;j<3;j++){
	           System.out.println(list[2][j]);
	       }
	       System.out.println();
	       break;
	       case "action": System.out.println("action");
	       for(int j=0;j<3;j++){
	           System.out.println(list[3][j]);
	       }
	       System.out.println();
	       break;
	       default: System.out.println("Invalid input");
	}
	}
}
}