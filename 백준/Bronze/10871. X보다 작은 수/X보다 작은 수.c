#include <stdio.h>

int main() {
    int N;
    int X;
    
    scanf("%d", &N);
    scanf("%d", &X);
    
    for(int i = 0; i < N; i++) {
        int a;
        scanf("%d", &a);
        
        if(a < X) {
            printf("%d ", a);
        }
    }

    return 0;
}