eeny::Integer -> String
eeny a  
    | a `mod` 2 == 1 = "meeny"
    | otherwise = "eeny"

fizzbuzz :: Integer -> String
fizzbuzz a 
    | mod a 3 == 0 && mod a 5 == 0 = "fizzbuzz"
    | mod a 3 == 0 = "Fizz"
    | mod a 5 == 0 = "Buzz"
    | otherwise = ""

fizzbuzz2 :: Integer -> String
fizzbuzz2 a = 
	if(mod a 3 == 0 && mod a 5 == 0)
		then "fizzbuzz"
	else if(mod a 3 == 0)
		then "Fizz"
	else if(mod a 5 == 0)
		then "buzz"
	else ""

tribonacci :: Integer -> Integer
tribonacci n = 
	tribonacci(n-1) + tribonacci(n-2) + tribonacci(n-3)

tribonacci 1 = 1
tribonacci 2 = 1
tribonacci 3 = 2

tribonacci2 :: Integer -> Integer
tribonacci2 n 
	| n == 1 = 1
	| n == 2 = 1
	| n == 3 = 2
	| otherwise = tribonacci2(n-1) + tribonacci2(n-2) + tribonacci2(n-3)


binomiali :: Integer -> Integer -> Integer
binomiali n 0 = 1
binomiali 0 k = 0
binomiali n k =
	binomiali (n-1) k + binomiali (n-1) (k-1)

verifL :: [Int] -> Bool
verifL a 
	| even (length a) = True
	| otherwise = False

takefinal :: [Int] -> Int -> [Int]
takefinal a b = drop (length a - b) a

remove :: [Int] -> Int -> [Int]
remove a b =  
	take (b-1) a ++ drop b a

myreplicate :: Int -> Int -> [Int]
myreplicate 0 v = []
myreplicate n v = 
	myreplicate (n-1) v ++ [v]

sumImp :: [Int] -> Int
sumImp a =
	if(length a == 0)
		then 0
	else if(mod (last a) 2 == 1)
		then last a + sumImp (take (length a - 1) a)
	else
		sumImp (take (length a - 1) a)


totalLen :: [String] -> Int
totalLen a 
	| length a == 0 = 0
	| head (last a) == 'A' = length (last a) + totalLen (take (length a - 1) a)
	| otherwise = totalLen (take (length a - 1) a)












