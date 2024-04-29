# DoubleLL

- The class doubleLL is a template implemented [double linked list](https://www.geeksforgeeks.org/doubly-linked-list/) 
To implement this class i also created the nod class that is used to store a node in the list and the "nodDublu" that is used for a double node (used inheritance from the simple node) and it also stores a pointer to the previous element.
- The doubleLL class has the following functions implemented:
> 1. operators << and >> 
>> These are used for input and output of the list
>> ```c++
>>       doubleLL<int> t;
>>       cin >> t; // will ask the number of numbers in the list and then ask for all the numbers
>>       cout << t;
> 2. push_back(parameter of the type of the list)
>> This will insert an element at the end of the list
>> ```c++ 
>>       doubleLL<int> t;
>>       int x = 5;
>>       t.push_back(x); 
>>       cout << t; // this will print 5
>>       t.push_back(x);
>>       cout << t; // this will print 5 5
> 3. pop_back()
>> This will remove an element from the end of the list
>> ```c++
>>      doubleLL<int>t;
>>      int x = 5;
>>      t.push_back(x);
>>      t.push_back(6);
>>      cout << t; //this will print 5 6
>>      t.pop_back();
>>      cout << t; //this will print 5
> 4. operator []
>> Similar to how arrays work i have overloaded this operator to return a refference to the i-th element in the list
>>```c++
>>     doubleLL<int>t;
>>     cin >> t; // we'll give it 2 numbers (5 and 6)
>>     t[0] = t[1]
>>     cout << t; //will print 6 6
> 5. operator = 
>> this can be used to make a copy of a list
>>```c++
>>    doubleLL<int>t;
>>    doubleLL<int>t2;    
>>    cin >> t; // we'll give it 2 numbers (5 and 6)
>>    t2 = t;
>>    cout << t2; // this will print 5 6
  
