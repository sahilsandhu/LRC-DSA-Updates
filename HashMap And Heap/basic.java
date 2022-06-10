// Find Number of Employees under every Manager

public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int n = Integer.parseInt(scn.nextLine());
    HashMap<String, HashSet<String>> hm = new HashMap<>();
    
    String ceo = "";
    for(int i=0;i<n;i++){
        String[] temp = scn.nextLine().split(" ");
        if(temp[1].equals(temp[0])){
            ceo = temp[1];
            
        }
        else{
            if(hm.containsKey(temp[1])){
                HashSet<String> hs = hm.get(temp[1]);
                hs.add(temp[0]);
             
            }
            else{
                HashSet<String> hs = new HashSet<>();
                hs.add(temp[0]);
                hm.put(temp[1],hs);
            }
        }
    }
    HashMap<String, Integer> ans = new HashMap<>();
    getSize(ceo, hm, ans);
    for(String mp : ans.keySet()){
        System.out.println(mp+" "+ans.get(mp));
    } 
  }
   public static int getSize(String curr, HashMap<String,HashSet<String>> tree, HashMap<String,Integer> ans){
       if(tree.containsKey(curr) == false)
       {
        ans.put(curr,0);
        return 1;
       }
       int sz = 0;
        for(String child : tree.get(curr)){
            int cs = getSize(child,tree,ans);
            sz += cs;
        }
        ans.put(curr, sz);
        return sz+1;
   }

// Find Itinerary From Tickets

public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int noofpairs_src_des = scn.nextInt();
		HashMap<String, String> map = new HashMap<>();
		for (int i = 0; i < noofpairs_src_des; i++) {
			String s1 = scn.next();
			String s2 = scn.next();
			map.put(s1, s2);	
		}
		HashMap<String, Boolean> hm = new HashMap<>();
	    for(String src: map.keySet()){
	        String dest = map.get(src);
	        hm.put(dest, false);
	        if(hm.containsKey(src) == false){
	            hm.put(src,true);
	        }
	    }
	    String src="";
	    for(String itr: hm.keySet()){
	        if(hm.get(itr) == true){
	            src = itr;
	            break;
	        }
	    }
	    while(true){
	        if(map.containsKey(src)){
	            System.out.print(src+" -> ");
	            src = map.get(src);
	        }
	        else{
	            System.out.print(src+".");
	            break;
	        }
	    }
	}

// 