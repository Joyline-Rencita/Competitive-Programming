#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'jimOrders' function below.
#
# The function is expected to return an INTEGER_ARRAY.
# The function accepts 2D_INTEGER_ARRAY orders as parameter.
#

def jimOrders(orders):
    # Create a list to store tuples of (customerIndex, serveTime)
    customer_times = []
    
    # Calculate the serve time for each customer
    for i, order in enumerate(orders):
        order_time = order[0]  # Order number
        prep_time = order[1]   # Preparation time
        serve_time = order_time + prep_time
        customer_times.append((i + 1, serve_time))  # Store the customer index (1-based) and serve time
    
    # Sort the list by serve time first, and by customer index if serve times are the same
    customer_times.sort(key=lambda x: (x[1], x[0]))
    
    # Return the sorted customer indices
    return [customer[0] for customer in customer_times]

if __name__ == '__main__':
    # Reading the input values
    n = int(input().strip())
    orders = [list(map(int, input().rstrip().split())) for _ in range(n)]
    
    # Get the result from the jimOrders function
    result = jimOrders(orders)
    
    # Output the result as a space-separated string
    print(' '.join(map(str, result)))
