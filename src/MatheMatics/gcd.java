static int gcd(int a,int b){
    if(b==0){
        return a;
    }
    return gcd(b,a%b);
    //gcd(2,8)-->gcd(8,2)-->gcd(2,4)-->gcd(4,2)-->gcd(2,2)-->gcd(2,0)
    
}
