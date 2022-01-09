#include<iostream>
#include<bits/stdc++.h>
using namespace std;


// keplers question 
int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    int t1, t2, r1, r2;
    int n;
    cin>>n;
    while(n-- > 0)
    {
        cin>>t1>>t2>>r1>>r2;
        float val1 = pow(t1,2)/pow(r1,3);
        float val2 = pow(t2,2)/pow(r2,3);
        if(val1 == val2)
        cout<<"Yes";
        else
        cout<<"No";
    }
}

// covid spread

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    int n;
    int t,d;
    while(n--)
    {
        cin>>t>>d;
        if(d>10)
        {
            int nth1 = d%10;
            long ans1 = 2*(pow(2,9));
            long ans2 = ans1*(pow(nth1-1));
            if(t < ans2)
            printf("int\n",ans2);
            else
            printf("int\n",t);
        }
        else{
             int ans1 = 2*(pow(2,d-1));
             if(t<ans1)
             printf("int\n",ans1);
             else
             printf("int\n",t);
        }
    }
    return 0;
}