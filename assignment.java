import org.json.JSONObject;
import java.util.*;
class Main
{
	public static void main(String[] args) {
	    Scanner sc=new Scanner(System.in);
	    ArrayList<String> al = new ArrayList<String>();
	    String inp="n";
	    do
	    {
	        System.out.println("Options for users");
		    System.out.println("--------------");
		    System.out.println("entercandidate");
		    System.out.println("castvote");
		    System.out.println("countvote");
		    System.out.println("listvote");
		    System.out.println("getwinner");
		    System.out.println("Enter your choice:");
		    String choice=sc.nextLine();
		    switch(choice)
		    {
		        case "entercandidate":
		            al.add(sc.nextLine());
		            break;
		            
		        case "castvote":
		            String vote=sc.nextLine();
		            if(al.contains(vote))
		            {
		                al.add(vote);
		            }
		            else{
		              System.out.println("Invalid candidate");
		            }
		            break;
		            
		        case "countvote":
		            String count=sc.nextLine();
		            if(al.contains(count))
		            {
		                int votecount=Collections.frequency(al, count);
		                System.out.println(votecount-1);
		            }
		            else
		            {
		                System.out.println("Invalid candidate");
		            }
		            break;
		            
		        case "listvote":
		            HashMap<String,Integer> frequencymap = new HashMap<String,Integer>();
                    for(String a : al) {
                        if(frequencymap.containsKey(a)) {
                            frequencymap.put(a, frequencymap.get(a)+1);
                            }
                        else{ frequencymap.put(a, 0); }
                        
                    }   
                    JSONObject json = new JSONObject(frequencymap);
                    System.out.println(json);
		            break;
		            
		        case "getwinner":       	
		            HashMap<String,Integer> maxcount = new HashMap<String,Integer>();
                    for(String a : al) {
                        if(maxcount.containsKey(a)) {
                            maxcount.put(a, maxcount.get(a)+1);
                            }
                        else{ maxcount.put(a, 0); }
                        
                    } 
                    Object maxEntry = Collections.max(maxcount.entrySet(), Map.Entry.comparingByValue()).getKey();      
		            System.out.println(maxEntry);
		            break;
		      
		        default:
		        continue;
		    }
		    System.out.println("Do youn want to continue y/n");
		    inp=sc.nextLine();
	    }while(inp.equals("y"));
	   
	    
		sc.close();
	}
}
