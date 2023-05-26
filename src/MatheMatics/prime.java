   static boolean isPrime(int n){
    //Checking at 1
        if(n==1){
            return false;
        }
      //Checking all 2 and 3 divisor (2,4,3,6,8,9,10,12,14,15,16)
        if(n%2==0||n%3==0){
            return false;
        }
       //Checking all 2 and 3 divisor (5,7,11,13.....)
        for(int i=5;i*i<=n;i=i+6){
            if(n%i==0 ||n%(i+2)==0){
                return false;
            }
        }
        return true;
        
    }

//read me
