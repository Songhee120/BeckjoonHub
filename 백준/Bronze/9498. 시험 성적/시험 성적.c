#include <stdio.h>

int main()
{
    int score;
    scanf("%d", &score);
    
    if(score < 60) {
        printf("%c", 'F');
    } 
    else if(score < 70) {
        printf("%c", 'D');
    }
    else if(score < 80) {
        printf("%c", 'C');
    }
    else if(score < 90) {
        printf("%c", 'B');
    }
    else {
        printf("%c", 'A');
    }
    
    return 0;
}