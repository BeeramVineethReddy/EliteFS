import java.util.*;
class mostCommonlyUsednWords
{
    public static void main (String[] args) 
    {
		//System.out.println("abc".compareTo("bcd"));
        Scanner sc = new Scanner(System.in);
        LinkedHashMap<String,Integer> h = new LinkedHashMap<String,Integer>();
        String[] input = sc.nextLine().split(",");
		int n = sc.nextInt();
        for(String i:input)
        {
            if(h.containsKey(i))
            {
                h.put(i,h.get(i)+1);
            }
            else
            {
                h.put(i,1);
            }
        }
        System.out.println(h);
		ArrayList<Map.Entry<String,Integer>> list = new ArrayList<Map.Entry<String,Integer>>(h.entrySet());
		System.out.println(list);
		Collections.sort(list,new Comparator<Map.Entry<String,Integer>>()
		{
			 public int compare(Map.Entry<String, Integer> a, Map.Entry<String, Integer> b)
			{
				if(a.getValue()!=b.getValue()) return b.getValue()-a.getValue();
				else return a.getKey().compareTo(b.getKey());
			}
		}
		);
		//System.out.println(list);
		ArrayList<String> ans = new ArrayList<String>();
		for(Map.Entry<String,Integer> e : list)
		{
			if(n==1)
			{
				ans.add(e.getKey());
				break;
			}
			else{
				ans.add(e.getKey());
			}
			n--;
		}
		System.out.println(ans);
    }
}