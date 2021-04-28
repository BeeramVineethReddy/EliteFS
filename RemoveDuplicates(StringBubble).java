import java.util.*;
class Test
{
    
    Stack<Character> tmp = new Stack<Character>();
    // public static String fn(Stack<Character> ch , Stack<Character> f , int k)
    // {
    //     if(f.peek()>k)
    //     {
    //         int t = f.pop();
    //         f.push(t-k);
    //     }
    //     else if(f.peek()==k)
    //     {
    //         f.pop();
    //         ch.pop();
    //     }
    //     else
    //     {
    //         int n = f.pop();
    //     }
    // }
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] s = sc.next().toCharArray();
        int k = sc.nextInt();
        Stack<Integer> f = new Stack<Integer>();
        Stack<Character> c = new Stack<Character>();
        char curr = s[0];
        int ct  = 0;
        for(char z :s)
        {
            if(c.isEmpty())
            {
                c.push(z);
                f.push(1);
            }
            else if(z==c.peek())
            {
                f.push(f.peek()+1);
                c.push(z);
            }
            else
            {
                c.push(z);
                f.push(1);
            }
            if(f.peek()==k)
            {
                for(int i=0;i<k;i++)
                {
                    f.pop();
                    c.pop();
                }
            }
        }
        
        //System.out.println(f+" "+c);
        String ans = "";
        while(!c.isEmpty())
        {
           ans+=c.pop();
        }
        System.out.println(new StringBuilder(ans).reverse().toString());
    }
}