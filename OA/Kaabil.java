package OA ;
import java.util.* ;
class Kaabil {
    static class pair{
        int x ;
        int y ; 

        public pair(int x , int y){
            this.x = x ;
            this.y = y ;
        }
    }
    static class Pairs{
        pair a ;
        pair b ;
        public Pairs(pair a , pair b){
            this.a = a ;
            this.b = b ;
        }
        @Override
        public String toString() {
            return "(" + a.x + "," + a.y + ") - (" + b.x + "," + b.y + ")";
        }
    }
    public static double distance(pair A , pair B){
        return Math.sqrt(Math.pow(A.x-B.x , 2) + Math.pow(A.y-B.y , 2)) ;
    }
    public static void Generator(ArrayList<pair> A , ArrayList<pair> B , int m , int n){
        for(int i = 0 ; i < m ; i++){
            A.add(new pair((int)(Math.random()*10), (int)(Math.random()*10)));
        }
        for(int i = 0 ; i < n ; i++){
            B.add(new pair((int)(Math.random()*10), (int)(Math.random()*10)));
        }
    }
    public static void main(String []args){
        ArrayList<pair> A = new ArrayList<>();
        ArrayList<pair> B = new ArrayList<>();
        int m = 100 ;
        int n = 90 ;
        Generator(A , B ,m,n);
        ArrayList<Pairs> ans = new ArrayList<>() ;
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(distance(A.get(i) , B.get(j)) <= 8e-12){
                    ans.add(new Pairs(A.get(i) , B.get(j)));
                }
            }
        }
        for (Pairs p : ans) {
            System.out.println(p.toString());
        }
    }

    

}



//Would your solution work when m and n are large?
// Probably not as it is having time complexity of O(n^2) , thus might give time limit exceeded


//How can you make it work? 
// So , here we can optimize the code by sorting one set let B , based on the euclidian distance between the 
// point in set B and the origin which will be O(nLogn)
// and then we will apply binary search for each point in set A in set B which will be in O(logn) for binary search 
// and O(n) for each pair in set A thus total of O(nlogn)
// so the total time complexity will turn out to be O(2nlogn) === o(nlogn)
// the main goal is to find the point in set A that is equal to the point in set B such that there euclidian distance is less 
// the epsilon value 

//Can you give an approximate number for m and n?
// the can be of the order 10^5 - 10^7 because of O(nlogn)

//Can you make it work for m>>n.
// 

//Any other special situations that you can think of in which you could make it work?
//


