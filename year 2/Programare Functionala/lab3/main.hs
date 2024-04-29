myZip3::[a]->[b]->[c]->[(a,b,c)]
myZip3 a b [] = []
myZip3 a [] b = []
myZip3 [] a b = []
myZip3 a b c = [(head a, head b, head c)] ++ myZip3 (tail a) (tail b) (tail c)

firstEl :: [(a,b)] -> [a]
firstEl = map (\(x,y) -> x)

sumList :: [[Int]] -> [Int]
sumList a = map (\b -> sum b) a

prel2 :: [Int] -> [Int]
prel2 a = map (\b -> if mod b 2 == 0 then div b 2 else b*2) a

functia8 :: Char -> [String] -> [String]
functia8 a b = filter (\c -> if elem a c then True else False) b

functia9 :: [Int] -> [Int]
functia9 a = map(\b -> b^2) (filter(\b -> if mod b 2 == 0 then False else True) a)

functia10 :: [Int] -> [Int]
functia10 a = map(\(a,b) -> a^2) (filter(\(a,b) -> if mod b 2 == 0 then False else True) (zip a [1..]))

functia11 :: [String] -> [String]
functia11 a = map(\b -> filter(\c -> if elem c ['a','e','i','o','u','A','E','I','O','U'] then True else False) b) a

myMap :: (a -> b) -> [a] -> [b]
myMap f a 
	| length a == 0 = []
	| otherwise = f (head a) : myMap f (tail a)

myFilter :: (a -> Bool) -> [a] -> [a]
myFilter f a
	| length a == 0 = []
	| f (head a) == True = head a : myFilter f (tail a)
	| otherwise = myFilter f (tail a)


