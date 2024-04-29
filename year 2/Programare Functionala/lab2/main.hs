import Data.Char

count :: String -> Int
count a 
	| length a == 0 = 0
	| head a == 'a' = 1 + count (drop 1 a)
	| head a == 'e' = 1 + count (drop 1 a)
	| head a == 'i' = 1 + count (drop 1 a)
	| head a == 'o' = 1 + count (drop 1 a)
	| head a == 'u' = 1 + count (drop 1 a)
	| head a == 'A' = 1 + count (drop 1 a)
	| head a == 'E' = 1 + count (drop 1 a)
	| head a == 'I' = 1 + count (drop 1 a)
	| head a == 'O' = 1 + count (drop 1 a)
	| head a == 'U' = 1 + count (drop 1 a)
	| otherwise = count (drop 1 a)

nrVocale :: [String] -> Int
nrVocale a	
	| length a == 0 = 0
	| head a == reverse (head a) = count (head a) + nrVocale (drop 1 a)
	| otherwise = nrVocale (drop 1 a)


insertNr :: Int -> [Int] -> [Int]
insertNr a [] = []
insertNr a b 
	| mod (head b) 2 == 0 = [head b] ++ [a] ++ insertNr a (drop 1 b)
	| otherwise = [head b] ++ insertNr a (drop 1 b)


divizori :: Int -> [Int]
divizori x = [d | d <- [1 .. x], mod x d == 0]

listadiv :: [Int] -> [[Int]]
listadiv a = [divizori d | d <- a]

inIntervalComp :: Int -> Int -> [Int] -> [Int]
inIntervalComp a b c = [n | n <- c, a <= n && n <= b]

inIntervalRec :: Int -> Int -> [Int] -> [Int]
inIntervalRec a b c
	| length c == 0 = []
	| a <= head c && head c <= b = [head c] ++ inIntervalRec a b (drop 1 c)
	| otherwise = inIntervalRec a b (drop 1 c)

pozitiveComp :: [Int] -> Int
pozitiveComp a = length [d | d <- a, d>0]

pozitiveRec :: [Int] -> Int
pozitiveRec a 
	| length a == 0 = 0
	| head a > 0 = pozitiveRec (drop 1 a) + 1
	| otherwise =  pozitiveRec (drop 1 a)

pozitiiImpareRecAux :: Int -> [Int] -> [Int]
pozitiiImpareRecAux a b	
	| length b == 0 = []
	| mod (head b) 2 == 1 = [a] ++ pozitiiImpareRecAux (a+1) (drop 1 b)
	| otherwise = pozitiiImpareRecAux (a+1) (drop 1 b)


pozitiiImpareRec :: [Int] -> [Int]
pozitiiImpareRec x = pozitiiImpareRecAux 0 x

pozitiiImpareComp :: [Int] -> [Int]
pozitiiImpareComp x = [b | (a,b) <- zip x [0..(length x)], mod a 2 == 1]

multDigitsRec :: String -> Int
multDigitsRec a
	|length a == 0 = 1
	|isDigit (head a) == True = digitToInt (head a) * multDigitsRec (drop 1 a)
	|otherwise = multDigitsRec (drop 1 a) 

produs :: [Int] -> Int
produs [] = 1
produs a = head a * produs (drop 1 a)

multDigitsComp :: String -> Int
multDigitsComp a = produs [digitToInt b | b <- a, isDigit b == True]








