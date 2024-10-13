#include <stdlib.h>
#include <stdio.h>
#include <string.h>

char* catAndMouse(int x, int y, int z) {
    // Calculate distances
    int distanceA = abs(x - z);
    int distanceB = abs(y - z);

    // Compare distances and return result
    if (distanceA < distanceB) {
        return "Cat A";
    } else if (distanceB < distanceA) {
        return "Cat B";
    } else {
        return "Mouse C";
    }
}

char* readline() {
    size_t alloc_length = 1024;
    size_t data_length = 0;
    char* data = malloc(alloc_length);

    while (1) {
        char* cursor = data + data_length;
        char* line = fgets(cursor, alloc_length - data_length, stdin);

        if (!line) {
            break;
        }

        data_length += strlen(cursor);

        if (data_length < alloc_length - 1 || data[data_length - 1] == '\n') {
            break;
        }

        size_t new_length = alloc_length << 1;
        data = realloc(data, new_length);

        if (!data) {
            break;
        }

        alloc_length = new_length;
    }

    if (data[data_length - 1] == '\n') {
        data[data_length - 1] = '\0';
    }

    data = realloc(data, data_length);
    return data;
}

char** split_string(char* str) {
    char** splits = NULL;
    char* token = strtok(str, " ");
    int spaces = 0;

    while (token) {
        splits = realloc(splits, sizeof(char*) * ++spaces);
        if (!splits) {
            return splits;
        }
        splits[spaces - 1] = token;
        token = strtok(NULL, " ");
    }
    return splits;
}

int main() {
    FILE* fptr = fopen(getenv("OUTPUT_PATH"), "w");
    char* q_endptr;
    char* q_str = readline();
    int q = strtol(q_str, &q_endptr, 10);

    if (q_endptr == q_str || *q_endptr != '\0') {
        exit(EXIT_FAILURE);
    }

    for (int q_itr = 0; q_itr < q; q_itr++) {
        char** xyz = split_string(readline());
        char* x_endptr;
        char* x_str = xyz[0];
        int x = strtol(x_str, &x_endptr, 10);

        if (x_endptr == x_str || *x_endptr != '\0') {
            exit(EXIT_FAILURE);
        }

        char* y_endptr;
        char* y_str = xyz[1];
        int y = strtol(y_str, &y_endptr, 10);

        if (y_endptr == y_str || *y_endptr != '\0') {
            exit(EXIT_FAILURE);
        }

        char* z_endptr;
        char* z_str = xyz[2];
        int z = strtol(z_str, &z_endptr, 10);

        if (z_endptr == z_str || *z_endptr != '\0') {
            exit(EXIT_FAILURE);
        }

        char* result = catAndMouse(x, y, z);
        fprintf(fptr, "%s\n", result);
    }

    fclose(fptr);
    return 0;
}
