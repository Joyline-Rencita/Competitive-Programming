#include <assert.h>
#include <ctype.h>   // Include for isspace
#include <limits.h>
#include <math.h>
#include <stdbool.h> // Include for true/false
#include <stddef.h>
#include <stdint.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

char* readline();
char* ltrim(char* str);
char* rtrim(char* str);
int parse_int(char* str);

/*
 * Complete the 'viralAdvertising' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts INTEGER n as parameter.
 */
int viralAdvertising(int n) {
    int cumulativeLikes = 0;
    int peopleReached = 5; // Initial number of people reached
    
    for (int day = 1; day <= n; day++) {
        // Calculate likes for the day (half of people reached)
        int likesToday = peopleReached / 2;
        cumulativeLikes += likesToday; // Add to cumulative likes
        
        // Calculate new people reached for the next day
        peopleReached = likesToday * 3; // Each person shares with 3 friends
    }
    
    return cumulativeLikes; // Return total likes by day n
}

int main() {
    FILE* fptr = fopen(getenv("OUTPUT_PATH"), "w");

    int n = parse_int(ltrim(rtrim(readline())));

    int result = viralAdvertising(n);

    fprintf(fptr, "%d\n", result);

    fclose(fptr);

    return 0;
}

char* readline() {
    size_t alloc_length = 1024;
    size_t data_length = 0;

    char* data = malloc(alloc_length);

    while (true) { // Using true now
        char* cursor = data + data_length;
        char* line = fgets(cursor, alloc_length - data_length, stdin);

        if (!line) {
            break;
        }

        data_length += strlen(cursor);

        if (data_length < alloc_length - 1 || data[data_length - 1] == '\n') {
            break;
        }

        alloc_length <<= 1;

        data = realloc(data, alloc_length);
    }

    if (data[data_length - 1] == '\n') {
        data[data_length - 1] = '\0';
    }

    data = realloc(data, data_length + 1);

    return data;
}

char* ltrim(char* str) {
    if (!str) {
        return '\0';
    }

    while (*str != '\0' && isspace(*str)) { // isspace should now be defined
        str++;
    }

    return str;
}

char* rtrim(char* str) {
    if (!str) {
        return '\0';
    }

    char* end = str + strlen(str) - 1;

    while (end >= str && isspace(*end)) {
        end--;
    }

    *(end + 1) = '\0';

    return str;
}

int parse_int(char* str) {
    char* endptr;
    int value = strtol(str, &endptr, 10);

    if (endptr == str || *endptr != '\0') {
        exit(EXIT_FAILURE);
    }

    return value;
}
